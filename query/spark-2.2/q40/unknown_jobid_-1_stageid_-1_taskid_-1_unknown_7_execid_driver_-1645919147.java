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
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private UnsafeRow scan_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 021 */   private UnsafeRow project_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 024 */
/* 025 */   public GeneratedIterator(Object[] references) {
/* 026 */     this.references = references;
/* 027 */   }
/* 028 */
/* 029 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 030 */     partitionIndex = index;
/* 031 */     this.inputs = inputs;
/* 032 */     scan_input = inputs[0];
/* 033 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 034 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 035 */     scan_scanTime1 = 0;
/* 036 */     scan_batch = null;
/* 037 */     scan_batchIdx = 0;
/* 038 */     scan_colInstance0 = null;
/* 039 */     scan_colInstance1 = null;
/* 040 */     scan_colInstance2 = null;
/* 041 */     scan_colInstance3 = null;
/* 042 */     scan_result = new UnsafeRow(4);
/* 043 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 044 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 045 */     project_result = new UnsafeRow(3);
/* 046 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 047 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void scan_nextBatch() throws java.io.IOException {
/* 052 */     long getBatchStart = System.nanoTime();
/* 053 */     if (scan_input.hasNext()) {
/* 054 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 055 */       scan_numOutputRows.add(scan_batch.numRows());
/* 056 */       scan_batchIdx = 0;
/* 057 */       scan_colInstance0 = scan_batch.column(0);
/* 058 */       scan_colInstance1 = scan_batch.column(1);
/* 059 */       scan_colInstance2 = scan_batch.column(2);
/* 060 */       scan_colInstance3 = scan_batch.column(3);
/* 061 */
/* 062 */     }
/* 063 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 064 */   }
/* 065 */
/* 066 */   protected void processNext() throws java.io.IOException {
/* 067 */     if (scan_batch == null) {
/* 068 */       scan_nextBatch();
/* 069 */     }
/* 070 */     while (scan_batch != null) {
/* 071 */       int scan_numRows = scan_batch.numRows();
/* 072 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 073 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 074 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 075 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 076 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 077 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 078 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 079 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 080 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 081 */         project_rowWriter.zeroOutNullBytes();
/* 082 */
/* 083 */         if (scan_isNull) {
/* 084 */           project_rowWriter.setNullAt(0);
/* 085 */         } else {
/* 086 */           project_rowWriter.write(0, scan_value);
/* 087 */         }
/* 088 */
/* 089 */         if (scan_isNull1) {
/* 090 */           project_rowWriter.setNullAt(1);
/* 091 */         } else {
/* 092 */           project_rowWriter.write(1, scan_value1);
/* 093 */         }
/* 094 */
/* 095 */         if (scan_isNull2) {
/* 096 */           project_rowWriter.setNullAt(2);
/* 097 */         } else {
/* 098 */           project_rowWriter.write(2, scan_value2);
/* 099 */         }
/* 100 */         append(project_result);
/* 101 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 102 */       }
/* 103 */       scan_batchIdx = scan_numRows;
/* 104 */       scan_batch = null;
/* 105 */       scan_nextBatch();
/* 106 */     }
/* 107 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 108 */     scan_scanTime1 = 0;
/* 109 */   }
/* 110 */ }
