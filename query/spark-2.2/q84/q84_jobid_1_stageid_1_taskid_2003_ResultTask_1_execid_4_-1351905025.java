/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private UnsafeRow scan_result;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 019 */   private UnsafeRow filter_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 022 */   private UnsafeRow project_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     scan_input = inputs[0];
/* 034 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 035 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 036 */     scan_scanTime1 = 0;
/* 037 */     scan_batch = null;
/* 038 */     scan_batchIdx = 0;
/* 039 */     scan_colInstance0 = null;
/* 040 */     scan_result = new UnsafeRow(1);
/* 041 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 042 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 1);
/* 043 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 044 */     filter_result = new UnsafeRow(1);
/* 045 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 046 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 1);
/* 047 */     project_result = new UnsafeRow(1);
/* 048 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 049 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private void scan_nextBatch() throws java.io.IOException {
/* 054 */     long getBatchStart = System.nanoTime();
/* 055 */     if (scan_input.hasNext()) {
/* 056 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 057 */       scan_numOutputRows.add(scan_batch.numRows());
/* 058 */       scan_batchIdx = 0;
/* 059 */       scan_colInstance0 = scan_batch.column(0);
/* 060 */
/* 061 */     }
/* 062 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 063 */   }
/* 064 */
/* 065 */   protected void processNext() throws java.io.IOException {
/* 066 */     if (scan_batch == null) {
/* 067 */       scan_nextBatch();
/* 068 */     }
/* 069 */     while (scan_batch != null) {
/* 070 */       int scan_numRows = scan_batch.numRows();
/* 071 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 072 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 073 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 074 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 075 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 076 */
/* 077 */         if (!(!(scan_isNull))) continue;
/* 078 */
/* 079 */         filter_numOutputRows.add(1);
/* 080 */
/* 081 */         project_rowWriter.write(0, scan_value);
/* 082 */         append(project_result);
/* 083 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 084 */       }
/* 085 */       scan_batchIdx = scan_numRows;
/* 086 */       scan_batch = null;
/* 087 */       scan_nextBatch();
/* 088 */     }
/* 089 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 090 */     scan_scanTime1 = 0;
/* 091 */   }
/* 092 */ }
