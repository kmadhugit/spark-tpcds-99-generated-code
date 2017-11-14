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
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private UnsafeRow scan_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 019 */   private UnsafeRow project_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 022 */
/* 023 */   public GeneratedIterator(Object[] references) {
/* 024 */     this.references = references;
/* 025 */   }
/* 026 */
/* 027 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 028 */     partitionIndex = index;
/* 029 */     this.inputs = inputs;
/* 030 */     scan_input = inputs[0];
/* 031 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 032 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 033 */     scan_scanTime1 = 0;
/* 034 */     scan_batch = null;
/* 035 */     scan_batchIdx = 0;
/* 036 */     scan_colInstance0 = null;
/* 037 */     scan_colInstance1 = null;
/* 038 */     scan_result = new UnsafeRow(2);
/* 039 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 040 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 041 */     project_result = new UnsafeRow(2);
/* 042 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 043 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */   private void scan_nextBatch() throws java.io.IOException {
/* 048 */     long getBatchStart = System.nanoTime();
/* 049 */     if (scan_input.hasNext()) {
/* 050 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 051 */       scan_numOutputRows.add(scan_batch.numRows());
/* 052 */       scan_batchIdx = 0;
/* 053 */       scan_colInstance0 = scan_batch.column(0);
/* 054 */       scan_colInstance1 = scan_batch.column(1);
/* 055 */
/* 056 */     }
/* 057 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 058 */   }
/* 059 */
/* 060 */   protected void processNext() throws java.io.IOException {
/* 061 */     if (scan_batch == null) {
/* 062 */       scan_nextBatch();
/* 063 */     }
/* 064 */     while (scan_batch != null) {
/* 065 */       int scan_numRows = scan_batch.numRows();
/* 066 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 067 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 068 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 069 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 070 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 071 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 072 */         double scan_value = scan_isNull ? -1.0 : (scan_colInstance0.getDouble(scan_rowIdx));
/* 073 */         project_rowWriter.zeroOutNullBytes();
/* 074 */
/* 075 */         if (scan_isNull1) {
/* 076 */           project_rowWriter.setNullAt(0);
/* 077 */         } else {
/* 078 */           project_rowWriter.write(0, scan_value1);
/* 079 */         }
/* 080 */
/* 081 */         if (scan_isNull) {
/* 082 */           project_rowWriter.setNullAt(1);
/* 083 */         } else {
/* 084 */           project_rowWriter.write(1, scan_value);
/* 085 */         }
/* 086 */         append(project_result);
/* 087 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 088 */       }
/* 089 */       scan_batchIdx = scan_numRows;
/* 090 */       scan_batch = null;
/* 091 */       scan_nextBatch();
/* 092 */     }
/* 093 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 094 */     scan_scanTime1 = 0;
/* 095 */   }
/* 096 */ }
