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
/* 018 */
/* 019 */   public GeneratedIterator(Object[] references) {
/* 020 */     this.references = references;
/* 021 */   }
/* 022 */
/* 023 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 024 */     partitionIndex = index;
/* 025 */     this.inputs = inputs;
/* 026 */     scan_input = inputs[0];
/* 027 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 028 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 029 */     scan_scanTime1 = 0;
/* 030 */     scan_batch = null;
/* 031 */     scan_batchIdx = 0;
/* 032 */     scan_colInstance0 = null;
/* 033 */     scan_result = new UnsafeRow(1);
/* 034 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 035 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 1);
/* 036 */
/* 037 */   }
/* 038 */
/* 039 */   private void scan_nextBatch() throws java.io.IOException {
/* 040 */     long getBatchStart = System.nanoTime();
/* 041 */     if (scan_input.hasNext()) {
/* 042 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 043 */       scan_numOutputRows.add(scan_batch.numRows());
/* 044 */       scan_batchIdx = 0;
/* 045 */       scan_colInstance0 = scan_batch.column(0);
/* 046 */
/* 047 */     }
/* 048 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 049 */   }
/* 050 */
/* 051 */   protected void processNext() throws java.io.IOException {
/* 052 */     if (scan_batch == null) {
/* 053 */       scan_nextBatch();
/* 054 */     }
/* 055 */     while (scan_batch != null) {
/* 056 */       int numRows = scan_batch.numRows();
/* 057 */       while (scan_batchIdx < numRows) {
/* 058 */         int scan_rowIdx = scan_batchIdx++;
/* 059 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 060 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 061 */         scan_rowWriter.zeroOutNullBytes();
/* 062 */
/* 063 */         if (scan_isNull) {
/* 064 */           scan_rowWriter.setNullAt(0);
/* 065 */         } else {
/* 066 */           scan_rowWriter.write(0, scan_value);
/* 067 */         }
/* 068 */         append(scan_result);
/* 069 */         if (shouldStop()) return;
/* 070 */       }
/* 071 */       scan_batch = null;
/* 072 */       scan_nextBatch();
/* 073 */     }
/* 074 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 075 */     scan_scanTime1 = 0;
/* 076 */   }
/* 077 */ }
