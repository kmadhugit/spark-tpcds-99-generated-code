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
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 023 */   private UnsafeRow filter_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     wholestagecodegen_init_0();
/* 038 */     wholestagecodegen_init_1();
/* 039 */
/* 040 */   }
/* 041 */
/* 042 */   private void wholestagecodegen_init_0() {
/* 043 */     scan_input = inputs[0];
/* 044 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 045 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     scan_scanTime1 = 0;
/* 047 */     scan_batch = null;
/* 048 */     scan_batchIdx = 0;
/* 049 */     scan_colInstance0 = null;
/* 050 */     scan_colInstance1 = null;
/* 051 */     scan_colInstance2 = null;
/* 052 */     scan_colInstance3 = null;
/* 053 */     scan_colInstance4 = null;
/* 054 */     scan_result = new UnsafeRow(5);
/* 055 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 056 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 057 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 058 */     filter_result = new UnsafeRow(5);
/* 059 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 060 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 061 */     project_result = new UnsafeRow(4);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void scan_nextBatch() throws java.io.IOException {
/* 067 */     long getBatchStart = System.nanoTime();
/* 068 */     if (scan_input.hasNext()) {
/* 069 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 070 */       scan_numOutputRows.add(scan_batch.numRows());
/* 071 */       scan_batchIdx = 0;
/* 072 */       scan_colInstance0 = scan_batch.column(0);
/* 073 */       scan_colInstance1 = scan_batch.column(1);
/* 074 */       scan_colInstance2 = scan_batch.column(2);
/* 075 */       scan_colInstance3 = scan_batch.column(3);
/* 076 */       scan_colInstance4 = scan_batch.column(4);
/* 077 */
/* 078 */     }
/* 079 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 080 */   }
/* 081 */
/* 082 */   private void wholestagecodegen_init_1() {
/* 083 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   protected void processNext() throws java.io.IOException {
/* 088 */     if (scan_batch == null) {
/* 089 */       scan_nextBatch();
/* 090 */     }
/* 091 */     while (scan_batch != null) {
/* 092 */       int scan_numRows = scan_batch.numRows();
/* 093 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 094 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 095 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 096 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 097 */         long scan_value1 = scan_isNull1 ? -1L : (scan_colInstance1.getLong(scan_rowIdx));
/* 098 */
/* 099 */         if (!(!(scan_isNull1))) continue;
/* 100 */
/* 101 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 102 */         long scan_value = scan_isNull ? -1L : (scan_colInstance0.getLong(scan_rowIdx));
/* 103 */
/* 104 */         if (!(!(scan_isNull))) continue;
/* 105 */
/* 106 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 107 */         long scan_value2 = scan_isNull2 ? -1L : (scan_colInstance2.getLong(scan_rowIdx));
/* 108 */
/* 109 */         if (!(!(scan_isNull2))) continue;
/* 110 */
/* 111 */         filter_numOutputRows.add(1);
/* 112 */
/* 113 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 114 */         long scan_value3 = scan_isNull3 ? -1L : (scan_colInstance3.getLong(scan_rowIdx));
/* 115 */         project_rowWriter.zeroOutNullBytes();
/* 116 */
/* 117 */         project_rowWriter.write(0, scan_value);
/* 118 */
/* 119 */         project_rowWriter.write(1, scan_value1);
/* 120 */
/* 121 */         project_rowWriter.write(2, scan_value2);
/* 122 */
/* 123 */         if (scan_isNull3) {
/* 124 */           project_rowWriter.setNullAt(3);
/* 125 */         } else {
/* 126 */           project_rowWriter.write(3, scan_value3);
/* 127 */         }
/* 128 */         append(project_result);
/* 129 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 130 */       }
/* 131 */       scan_batchIdx = scan_numRows;
/* 132 */       scan_batch = null;
/* 133 */       scan_nextBatch();
/* 134 */     }
/* 135 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 136 */     scan_scanTime1 = 0;
/* 137 */   }
/* 138 */ }
