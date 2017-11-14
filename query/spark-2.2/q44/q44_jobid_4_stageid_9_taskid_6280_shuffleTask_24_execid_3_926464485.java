/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean sort_needToSort;
/* 009 */   private org.apache.spark.sql.execution.SortExec sort_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeExternalRowSorter sort_sorter;
/* 011 */   private org.apache.spark.executor.TaskMetrics sort_metrics;
/* 012 */   private scala.collection.Iterator<UnsafeRow> sort_sortedIter;
/* 013 */   private scala.collection.Iterator inputadapter_input;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 015 */   private UnsafeRow filter_result;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 018 */   private UnsafeRow project_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 024 */
/* 025 */   public GeneratedIterator(Object[] references) {
/* 026 */     this.references = references;
/* 027 */   }
/* 028 */
/* 029 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 030 */     partitionIndex = index;
/* 031 */     this.inputs = inputs;
/* 032 */     sort_needToSort = true;
/* 033 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 034 */     sort_sorter = sort_plan.createSorter();
/* 035 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 036 */
/* 037 */     inputadapter_input = inputs[0];
/* 038 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 039 */     filter_result = new UnsafeRow(3);
/* 040 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 041 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 042 */     project_result = new UnsafeRow(2);
/* 043 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 044 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 045 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 046 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 047 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void sort_addToSorter() throws java.io.IOException {
/* 052 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 053 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 054 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 055 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 056 */
/* 057 */       if (!(!(inputadapter_isNull2))) continue;
/* 058 */
/* 059 */       boolean filter_isNull2 = false;
/* 060 */
/* 061 */       boolean filter_value2 = false;
/* 062 */       filter_value2 = inputadapter_value2 < 11;
/* 063 */       if (!filter_value2) continue;
/* 064 */
/* 065 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 066 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 067 */
/* 068 */       if (!(!(inputadapter_isNull))) continue;
/* 069 */
/* 070 */       filter_numOutputRows.add(1);
/* 071 */
/* 072 */       project_rowWriter.write(0, inputadapter_value);
/* 073 */
/* 074 */       project_rowWriter.write(1, inputadapter_value2);
/* 075 */       sort_sorter.insertRow((UnsafeRow)project_result);
/* 076 */       if (shouldStop()) return;
/* 077 */     }
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   protected void processNext() throws java.io.IOException {
/* 082 */     if (sort_needToSort) {
/* 083 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 084 */       sort_addToSorter();
/* 085 */       sort_sortedIter = sort_sorter.sort();
/* 086 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 087 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 088 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 089 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 090 */       sort_needToSort = false;
/* 091 */     }
/* 092 */
/* 093 */     while (sort_sortedIter.hasNext()) {
/* 094 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 095 */
/* 096 */       append(sort_outputRow);
/* 097 */
/* 098 */       if (shouldStop()) return;
/* 099 */     }
/* 100 */   }
/* 101 */ }
