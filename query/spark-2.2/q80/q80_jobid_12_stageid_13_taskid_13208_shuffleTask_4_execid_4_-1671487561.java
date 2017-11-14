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
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private UnsafeRow scan_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
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
/* 040 */     scan_colInstance1 = null;
/* 041 */     scan_colInstance2 = null;
/* 042 */     scan_colInstance3 = null;
/* 043 */     scan_colInstance4 = null;
/* 044 */     scan_result = new UnsafeRow(5);
/* 045 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 046 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 047 */     project_result = new UnsafeRow(4);
/* 048 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 049 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
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
/* 060 */       scan_colInstance1 = scan_batch.column(1);
/* 061 */       scan_colInstance2 = scan_batch.column(2);
/* 062 */       scan_colInstance3 = scan_batch.column(3);
/* 063 */       scan_colInstance4 = scan_batch.column(4);
/* 064 */
/* 065 */     }
/* 066 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 067 */   }
/* 068 */
/* 069 */   protected void processNext() throws java.io.IOException {
/* 070 */     if (scan_batch == null) {
/* 071 */       scan_nextBatch();
/* 072 */     }
/* 073 */     while (scan_batch != null) {
/* 074 */       int scan_numRows = scan_batch.numRows();
/* 075 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 076 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 077 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 078 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 079 */         long scan_value = scan_isNull ? -1L : (scan_colInstance0.getLong(scan_rowIdx));
/* 080 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 081 */         long scan_value1 = scan_isNull1 ? -1L : (scan_colInstance1.getLong(scan_rowIdx));
/* 082 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 083 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 084 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 085 */         double scan_value3 = scan_isNull3 ? -1.0 : (scan_colInstance3.getDouble(scan_rowIdx));
/* 086 */         project_rowWriter.zeroOutNullBytes();
/* 087 */
/* 088 */         if (scan_isNull) {
/* 089 */           project_rowWriter.setNullAt(0);
/* 090 */         } else {
/* 091 */           project_rowWriter.write(0, scan_value);
/* 092 */         }
/* 093 */
/* 094 */         if (scan_isNull1) {
/* 095 */           project_rowWriter.setNullAt(1);
/* 096 */         } else {
/* 097 */           project_rowWriter.write(1, scan_value1);
/* 098 */         }
/* 099 */
/* 100 */         if (scan_isNull2) {
/* 101 */           project_rowWriter.setNullAt(2);
/* 102 */         } else {
/* 103 */           project_rowWriter.write(2, scan_value2);
/* 104 */         }
/* 105 */
/* 106 */         if (scan_isNull3) {
/* 107 */           project_rowWriter.setNullAt(3);
/* 108 */         } else {
/* 109 */           project_rowWriter.write(3, scan_value3);
/* 110 */         }
/* 111 */         append(project_result);
/* 112 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 113 */       }
/* 114 */       scan_batchIdx = scan_numRows;
/* 115 */       scan_batch = null;
/* 116 */       scan_nextBatch();
/* 117 */     }
/* 118 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 119 */     scan_scanTime1 = 0;
/* 120 */   }
/* 121 */ }
