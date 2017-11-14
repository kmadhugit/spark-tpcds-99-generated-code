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
/* 014 */   private UnsafeRow project_result;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 020 */
/* 021 */   public GeneratedIterator(Object[] references) {
/* 022 */     this.references = references;
/* 023 */   }
/* 024 */
/* 025 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 026 */     partitionIndex = index;
/* 027 */     this.inputs = inputs;
/* 028 */     sort_needToSort = true;
/* 029 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 030 */     sort_sorter = sort_plan.createSorter();
/* 031 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 032 */
/* 033 */     inputadapter_input = inputs[0];
/* 034 */     project_result = new UnsafeRow(3);
/* 035 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 036 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 037 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 038 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 039 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 040 */
/* 041 */   }
/* 042 */
/* 043 */   private void sort_addToSorter() throws java.io.IOException {
/* 044 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 045 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 046 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 047 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 048 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 049 */       Decimal inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getDecimal(1, 35, 20));
/* 050 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 051 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 052 */       project_holder.reset();
/* 053 */
/* 054 */       project_rowWriter.zeroOutNullBytes();
/* 055 */
/* 056 */       if (inputadapter_isNull) {
/* 057 */         project_rowWriter.setNullAt(0);
/* 058 */       } else {
/* 059 */         project_rowWriter.write(0, inputadapter_value);
/* 060 */       }
/* 061 */
/* 062 */       if (inputadapter_isNull1) {
/* 063 */         project_rowWriter.write(1, (Decimal) null, 35, 20);
/* 064 */       } else {
/* 065 */         project_rowWriter.write(1, inputadapter_value1, 35, 20);
/* 066 */       }
/* 067 */
/* 068 */       if (inputadapter_isNull3) {
/* 069 */         project_rowWriter.setNullAt(2);
/* 070 */       } else {
/* 071 */         project_rowWriter.write(2, inputadapter_value3);
/* 072 */       }
/* 073 */       project_result.setTotalSize(project_holder.totalSize());
/* 074 */       sort_sorter.insertRow((UnsafeRow)project_result);
/* 075 */       if (shouldStop()) return;
/* 076 */     }
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */   protected void processNext() throws java.io.IOException {
/* 081 */     if (sort_needToSort) {
/* 082 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 083 */       sort_addToSorter();
/* 084 */       sort_sortedIter = sort_sorter.sort();
/* 085 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 086 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 087 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 088 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 089 */       sort_needToSort = false;
/* 090 */     }
/* 091 */
/* 092 */     while (sort_sortedIter.hasNext()) {
/* 093 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 094 */
/* 095 */       append(sort_outputRow);
/* 096 */
/* 097 */       if (shouldStop()) return;
/* 098 */     }
/* 099 */   }
/* 100 */ }
