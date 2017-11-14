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
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private UnsafeRow scan_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 030 */   private UnsafeRow filter_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 033 */   private UnsafeRow project_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 036 */
/* 037 */   public GeneratedIterator(Object[] references) {
/* 038 */     this.references = references;
/* 039 */   }
/* 040 */
/* 041 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 042 */     partitionIndex = index;
/* 043 */     this.inputs = inputs;
/* 044 */     wholestagecodegen_init_0();
/* 045 */     wholestagecodegen_init_1();
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private void wholestagecodegen_init_0() {
/* 050 */     scan_input = inputs[0];
/* 051 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 052 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 053 */     scan_scanTime1 = 0;
/* 054 */     scan_batch = null;
/* 055 */     scan_batchIdx = 0;
/* 056 */     scan_colInstance0 = null;
/* 057 */     scan_colInstance1 = null;
/* 058 */     scan_colInstance2 = null;
/* 059 */     scan_colInstance3 = null;
/* 060 */     scan_colInstance4 = null;
/* 061 */     scan_colInstance5 = null;
/* 062 */     scan_colInstance6 = null;
/* 063 */     scan_colInstance7 = null;
/* 064 */     scan_colInstance8 = null;
/* 065 */     scan_colInstance9 = null;
/* 066 */     scan_colInstance10 = null;
/* 067 */     scan_colInstance11 = null;
/* 068 */     scan_result = new UnsafeRow(12);
/* 069 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 070 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 12);
/* 071 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 072 */     filter_result = new UnsafeRow(12);
/* 073 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */   private void scan_nextBatch() throws java.io.IOException {
/* 078 */     long getBatchStart = System.nanoTime();
/* 079 */     if (scan_input.hasNext()) {
/* 080 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 081 */       scan_numOutputRows.add(scan_batch.numRows());
/* 082 */       scan_batchIdx = 0;
/* 083 */       scan_colInstance0 = scan_batch.column(0);
/* 084 */       scan_colInstance1 = scan_batch.column(1);
/* 085 */       scan_colInstance2 = scan_batch.column(2);
/* 086 */       scan_colInstance3 = scan_batch.column(3);
/* 087 */       scan_colInstance4 = scan_batch.column(4);
/* 088 */       scan_colInstance5 = scan_batch.column(5);
/* 089 */       scan_colInstance6 = scan_batch.column(6);
/* 090 */       scan_colInstance7 = scan_batch.column(7);
/* 091 */       scan_colInstance8 = scan_batch.column(8);
/* 092 */       scan_colInstance9 = scan_batch.column(9);
/* 093 */       scan_colInstance10 = scan_batch.column(10);
/* 094 */       scan_colInstance11 = scan_batch.column(11);
/* 095 */
/* 096 */     }
/* 097 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 098 */   }
/* 099 */
/* 100 */   private void wholestagecodegen_init_1() {
/* 101 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 12);
/* 102 */     project_result = new UnsafeRow(12);
/* 103 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 104 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 12);
/* 105 */
/* 106 */   }
/* 107 */
/* 108 */   protected void processNext() throws java.io.IOException {
/* 109 */     if (scan_batch == null) {
/* 110 */       scan_nextBatch();
/* 111 */     }
/* 112 */     while (scan_batch != null) {
/* 113 */       int scan_numRows = scan_batch.numRows();
/* 114 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 115 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 116 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 117 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 118 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 119 */
/* 120 */         if (!(!(scan_isNull))) continue;
/* 121 */
/* 122 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 123 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 124 */
/* 125 */         if (!(!(scan_isNull7))) continue;
/* 126 */
/* 127 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 128 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 129 */
/* 130 */         if (!(!(scan_isNull5))) continue;
/* 131 */
/* 132 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 133 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 134 */
/* 135 */         if (!(!(scan_isNull1))) continue;
/* 136 */
/* 137 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 138 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 139 */
/* 140 */         if (!(!(scan_isNull2))) continue;
/* 141 */
/* 142 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 143 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 144 */
/* 145 */         if (!(!(scan_isNull6))) continue;
/* 146 */
/* 147 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 148 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 149 */
/* 150 */         if (!(!(scan_isNull3))) continue;
/* 151 */
/* 152 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 153 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 154 */
/* 155 */         if (!(!(scan_isNull4))) continue;
/* 156 */
/* 157 */         filter_numOutputRows.add(1);
/* 158 */
/* 159 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 160 */         double scan_value8 = scan_isNull8 ? -1.0 : (scan_colInstance8.getDouble(scan_rowIdx));
/* 161 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 162 */         double scan_value9 = scan_isNull9 ? -1.0 : (scan_colInstance9.getDouble(scan_rowIdx));
/* 163 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 164 */         double scan_value10 = scan_isNull10 ? -1.0 : (scan_colInstance10.getDouble(scan_rowIdx));
/* 165 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 166 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 167 */         project_rowWriter.zeroOutNullBytes();
/* 168 */
/* 169 */         project_rowWriter.write(0, scan_value);
/* 170 */
/* 171 */         project_rowWriter.write(1, scan_value1);
/* 172 */
/* 173 */         project_rowWriter.write(2, scan_value2);
/* 174 */
/* 175 */         project_rowWriter.write(3, scan_value3);
/* 176 */
/* 177 */         project_rowWriter.write(4, scan_value4);
/* 178 */
/* 179 */         project_rowWriter.write(5, scan_value5);
/* 180 */
/* 181 */         project_rowWriter.write(6, scan_value6);
/* 182 */
/* 183 */         project_rowWriter.write(7, scan_value7);
/* 184 */
/* 185 */         if (scan_isNull8) {
/* 186 */           project_rowWriter.setNullAt(8);
/* 187 */         } else {
/* 188 */           project_rowWriter.write(8, scan_value8);
/* 189 */         }
/* 190 */
/* 191 */         if (scan_isNull9) {
/* 192 */           project_rowWriter.setNullAt(9);
/* 193 */         } else {
/* 194 */           project_rowWriter.write(9, scan_value9);
/* 195 */         }
/* 196 */
/* 197 */         if (scan_isNull10) {
/* 198 */           project_rowWriter.setNullAt(10);
/* 199 */         } else {
/* 200 */           project_rowWriter.write(10, scan_value10);
/* 201 */         }
/* 202 */
/* 203 */         if (scan_isNull11) {
/* 204 */           project_rowWriter.setNullAt(11);
/* 205 */         } else {
/* 206 */           project_rowWriter.write(11, scan_value11);
/* 207 */         }
/* 208 */         append(project_result);
/* 209 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 210 */       }
/* 211 */       scan_batchIdx = scan_numRows;
/* 212 */       scan_batch = null;
/* 213 */       scan_nextBatch();
/* 214 */     }
/* 215 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 216 */     scan_scanTime1 = 0;
/* 217 */   }
/* 218 */ }
