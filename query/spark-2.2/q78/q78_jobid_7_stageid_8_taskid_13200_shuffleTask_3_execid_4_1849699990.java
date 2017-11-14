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
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private UnsafeRow project_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 023 */
/* 024 */   public GeneratedIterator(Object[] references) {
/* 025 */     this.references = references;
/* 026 */   }
/* 027 */
/* 028 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 029 */     partitionIndex = index;
/* 030 */     this.inputs = inputs;
/* 031 */     scan_input = inputs[0];
/* 032 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 033 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 034 */     scan_scanTime1 = 0;
/* 035 */     scan_batch = null;
/* 036 */     scan_batchIdx = 0;
/* 037 */     scan_colInstance0 = null;
/* 038 */     scan_colInstance1 = null;
/* 039 */     scan_colInstance2 = null;
/* 040 */     scan_result = new UnsafeRow(3);
/* 041 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 042 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 043 */     project_result = new UnsafeRow(2);
/* 044 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 045 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private void scan_nextBatch() throws java.io.IOException {
/* 050 */     long getBatchStart = System.nanoTime();
/* 051 */     if (scan_input.hasNext()) {
/* 052 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 053 */       scan_numOutputRows.add(scan_batch.numRows());
/* 054 */       scan_batchIdx = 0;
/* 055 */       scan_colInstance0 = scan_batch.column(0);
/* 056 */       scan_colInstance1 = scan_batch.column(1);
/* 057 */       scan_colInstance2 = scan_batch.column(2);
/* 058 */
/* 059 */     }
/* 060 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 061 */   }
/* 062 */
/* 063 */   protected void processNext() throws java.io.IOException {
/* 064 */     if (scan_batch == null) {
/* 065 */       scan_nextBatch();
/* 066 */     }
/* 067 */     while (scan_batch != null) {
/* 068 */       int scan_numRows = scan_batch.numRows();
/* 069 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 070 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 071 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 072 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 073 */         long scan_value = scan_isNull ? -1L : (scan_colInstance0.getLong(scan_rowIdx));
/* 074 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 075 */         long scan_value1 = scan_isNull1 ? -1L : (scan_colInstance1.getLong(scan_rowIdx));
/* 076 */         project_rowWriter.zeroOutNullBytes();
/* 077 */
/* 078 */         if (scan_isNull) {
/* 079 */           project_rowWriter.setNullAt(0);
/* 080 */         } else {
/* 081 */           project_rowWriter.write(0, scan_value);
/* 082 */         }
/* 083 */
/* 084 */         if (scan_isNull1) {
/* 085 */           project_rowWriter.setNullAt(1);
/* 086 */         } else {
/* 087 */           project_rowWriter.write(1, scan_value1);
/* 088 */         }
/* 089 */         append(project_result);
/* 090 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 091 */       }
/* 092 */       scan_batchIdx = scan_numRows;
/* 093 */       scan_batch = null;
/* 094 */       scan_nextBatch();
/* 095 */     }
/* 096 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 097 */     scan_scanTime1 = 0;
/* 098 */   }
/* 099 */ }
