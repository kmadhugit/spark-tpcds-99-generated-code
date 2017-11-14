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
/* 017 */
/* 018 */   public GeneratedIterator(Object[] references) {
/* 019 */     this.references = references;
/* 020 */   }
/* 021 */
/* 022 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 023 */     partitionIndex = index;
/* 024 */     this.inputs = inputs;
/* 025 */     sort_needToSort = true;
/* 026 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 027 */     sort_sorter = sort_plan.createSorter();
/* 028 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 029 */
/* 030 */     inputadapter_input = inputs[0];
/* 031 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 032 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 033 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 034 */
/* 035 */   }
/* 036 */
/* 037 */   private void sort_addToSorter() throws java.io.IOException {
/* 038 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 039 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 040 */       sort_sorter.insertRow((UnsafeRow)inputadapter_row);
/* 041 */       if (shouldStop()) return;
/* 042 */     }
/* 043 */
/* 044 */   }
/* 045 */
/* 046 */   protected void processNext() throws java.io.IOException {
/* 047 */     if (sort_needToSort) {
/* 048 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 049 */       sort_addToSorter();
/* 050 */       sort_sortedIter = sort_sorter.sort();
/* 051 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 052 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 053 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 054 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 055 */       sort_needToSort = false;
/* 056 */     }
/* 057 */
/* 058 */     while (sort_sortedIter.hasNext()) {
/* 059 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 060 */
/* 061 */       append(sort_outputRow);
/* 062 */
/* 063 */       if (shouldStop()) return;
/* 064 */     }
/* 065 */   }
/* 066 */ }
