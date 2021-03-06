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
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private UnsafeRow scan_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private UnsafeRow project_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 032 */
/* 033 */   public GeneratedIterator(Object[] references) {
/* 034 */     this.references = references;
/* 035 */   }
/* 036 */
/* 037 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 038 */     partitionIndex = index;
/* 039 */     this.inputs = inputs;
/* 040 */     wholestagecodegen_init_0();
/* 041 */     wholestagecodegen_init_1();
/* 042 */
/* 043 */   }
/* 044 */
/* 045 */   private void wholestagecodegen_init_0() {
/* 046 */     scan_input = inputs[0];
/* 047 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 048 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 049 */     scan_scanTime1 = 0;
/* 050 */     scan_batch = null;
/* 051 */     scan_batchIdx = 0;
/* 052 */     scan_colInstance0 = null;
/* 053 */     scan_colInstance1 = null;
/* 054 */     scan_colInstance2 = null;
/* 055 */     scan_colInstance3 = null;
/* 056 */     scan_colInstance4 = null;
/* 057 */     scan_colInstance5 = null;
/* 058 */     scan_colInstance6 = null;
/* 059 */     scan_colInstance7 = null;
/* 060 */     scan_result = new UnsafeRow(8);
/* 061 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 062 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 8);
/* 063 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 064 */     filter_result = new UnsafeRow(8);
/* 065 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 066 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 8);
/* 067 */
/* 068 */   }
/* 069 */
/* 070 */   private void scan_nextBatch() throws java.io.IOException {
/* 071 */     long getBatchStart = System.nanoTime();
/* 072 */     if (scan_input.hasNext()) {
/* 073 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 074 */       scan_numOutputRows.add(scan_batch.numRows());
/* 075 */       scan_batchIdx = 0;
/* 076 */       scan_colInstance0 = scan_batch.column(0);
/* 077 */       scan_colInstance1 = scan_batch.column(1);
/* 078 */       scan_colInstance2 = scan_batch.column(2);
/* 079 */       scan_colInstance3 = scan_batch.column(3);
/* 080 */       scan_colInstance4 = scan_batch.column(4);
/* 081 */       scan_colInstance5 = scan_batch.column(5);
/* 082 */       scan_colInstance6 = scan_batch.column(6);
/* 083 */       scan_colInstance7 = scan_batch.column(7);
/* 084 */
/* 085 */     }
/* 086 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 087 */   }
/* 088 */
/* 089 */   private void wholestagecodegen_init_1() {
/* 090 */     project_result = new UnsafeRow(8);
/* 091 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 092 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 093 */
/* 094 */   }
/* 095 */
/* 096 */   protected void processNext() throws java.io.IOException {
/* 097 */     if (scan_batch == null) {
/* 098 */       scan_nextBatch();
/* 099 */     }
/* 100 */     while (scan_batch != null) {
/* 101 */       int scan_numRows = scan_batch.numRows();
/* 102 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 103 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 104 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 105 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 106 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 107 */
/* 108 */         if (!(!(scan_isNull6))) continue;
/* 109 */
/* 110 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 111 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 112 */
/* 113 */         if (!(!(scan_isNull3))) continue;
/* 114 */
/* 115 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 116 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 117 */
/* 118 */         if (!(!(scan_isNull1))) continue;
/* 119 */
/* 120 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 121 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 122 */
/* 123 */         if (!(!(scan_isNull2))) continue;
/* 124 */
/* 125 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 126 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 127 */
/* 128 */         if (!(!(scan_isNull))) continue;
/* 129 */
/* 130 */         filter_numOutputRows.add(1);
/* 131 */
/* 132 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 133 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 134 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 135 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 136 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 137 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 138 */         project_rowWriter.zeroOutNullBytes();
/* 139 */
/* 140 */         project_rowWriter.write(0, scan_value);
/* 141 */
/* 142 */         project_rowWriter.write(1, scan_value1);
/* 143 */
/* 144 */         project_rowWriter.write(2, scan_value2);
/* 145 */
/* 146 */         project_rowWriter.write(3, scan_value3);
/* 147 */
/* 148 */         if (scan_isNull4) {
/* 149 */           project_rowWriter.setNullAt(4);
/* 150 */         } else {
/* 151 */           project_rowWriter.write(4, scan_value4);
/* 152 */         }
/* 153 */
/* 154 */         if (scan_isNull5) {
/* 155 */           project_rowWriter.setNullAt(5);
/* 156 */         } else {
/* 157 */           project_rowWriter.write(5, scan_value5);
/* 158 */         }
/* 159 */
/* 160 */         project_rowWriter.write(6, scan_value6);
/* 161 */
/* 162 */         if (scan_isNull7) {
/* 163 */           project_rowWriter.setNullAt(7);
/* 164 */         } else {
/* 165 */           project_rowWriter.write(7, scan_value7);
/* 166 */         }
/* 167 */         append(project_result);
/* 168 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 169 */       }
/* 170 */       scan_batchIdx = scan_numRows;
/* 171 */       scan_batch = null;
/* 172 */       scan_nextBatch();
/* 173 */     }
/* 174 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 175 */     scan_scanTime1 = 0;
/* 176 */   }
/* 177 */ }
