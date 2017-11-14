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
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 017 */   private UnsafeRow project_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
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
/* 034 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 035 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 036 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 037 */     project_result = new UnsafeRow(6);
/* 038 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 039 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 040 */
/* 041 */   }
/* 042 */
/* 043 */   private void sort_addToSorter() throws java.io.IOException {
/* 044 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 045 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 046 */       sort_sorter.insertRow((UnsafeRow)inputadapter_row);
/* 047 */       if (shouldStop()) return;
/* 048 */     }
/* 049 */
/* 050 */   }
/* 051 */
/* 052 */   protected void processNext() throws java.io.IOException {
/* 053 */     if (sort_needToSort) {
/* 054 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 055 */       sort_addToSorter();
/* 056 */       sort_sortedIter = sort_sorter.sort();
/* 057 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 058 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 059 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 060 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 061 */       sort_needToSort = false;
/* 062 */     }
/* 063 */
/* 064 */     while (sort_sortedIter.hasNext()) {
/* 065 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 066 */
/* 067 */       boolean sort_isNull = sort_outputRow.isNullAt(0);
/* 068 */       UTF8String sort_value = sort_isNull ? null : (sort_outputRow.getUTF8String(0));
/* 069 */       boolean sort_isNull1 = sort_outputRow.isNullAt(1);
/* 070 */       UTF8String sort_value1 = sort_isNull1 ? null : (sort_outputRow.getUTF8String(1));
/* 071 */       boolean sort_isNull2 = sort_outputRow.isNullAt(2);
/* 072 */       UTF8String sort_value2 = sort_isNull2 ? null : (sort_outputRow.getUTF8String(2));
/* 073 */       boolean sort_isNull3 = sort_outputRow.isNullAt(3);
/* 074 */       double sort_value3 = sort_isNull3 ? -1.0 : (sort_outputRow.getDouble(3));
/* 075 */       boolean sort_isNull4 = sort_outputRow.isNullAt(4);
/* 076 */       double sort_value4 = sort_isNull4 ? -1.0 : (sort_outputRow.getDouble(4));
/* 077 */       boolean sort_isNull5 = sort_outputRow.isNullAt(5);
/* 078 */       double sort_value5 = sort_isNull5 ? -1.0 : (sort_outputRow.getDouble(5));
/* 079 */       project_holder.reset();
/* 080 */
/* 081 */       project_rowWriter.zeroOutNullBytes();
/* 082 */
/* 083 */       if (sort_isNull) {
/* 084 */         project_rowWriter.setNullAt(0);
/* 085 */       } else {
/* 086 */         project_rowWriter.write(0, sort_value);
/* 087 */       }
/* 088 */
/* 089 */       if (sort_isNull1) {
/* 090 */         project_rowWriter.setNullAt(1);
/* 091 */       } else {
/* 092 */         project_rowWriter.write(1, sort_value1);
/* 093 */       }
/* 094 */
/* 095 */       if (sort_isNull2) {
/* 096 */         project_rowWriter.setNullAt(2);
/* 097 */       } else {
/* 098 */         project_rowWriter.write(2, sort_value2);
/* 099 */       }
/* 100 */
/* 101 */       if (sort_isNull3) {
/* 102 */         project_rowWriter.setNullAt(3);
/* 103 */       } else {
/* 104 */         project_rowWriter.write(3, sort_value3);
/* 105 */       }
/* 106 */
/* 107 */       if (sort_isNull4) {
/* 108 */         project_rowWriter.setNullAt(4);
/* 109 */       } else {
/* 110 */         project_rowWriter.write(4, sort_value4);
/* 111 */       }
/* 112 */
/* 113 */       if (sort_isNull5) {
/* 114 */         project_rowWriter.setNullAt(5);
/* 115 */       } else {
/* 116 */         project_rowWriter.write(5, sort_value5);
/* 117 */       }
/* 118 */       project_result.setTotalSize(project_holder.totalSize());
/* 119 */       append(project_result);
/* 120 */
/* 121 */       if (shouldStop()) return;
/* 122 */     }
/* 123 */   }
/* 124 */ }
