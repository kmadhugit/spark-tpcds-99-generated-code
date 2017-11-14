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
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 032 */   private UnsafeRow scan_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 036 */   private UnsafeRow filter_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 039 */   private UnsafeRow project_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 042 */
/* 043 */   public GeneratedIterator(Object[] references) {
/* 044 */     this.references = references;
/* 045 */   }
/* 046 */
/* 047 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 048 */     partitionIndex = index;
/* 049 */     this.inputs = inputs;
/* 050 */     wholestagecodegen_init_0();
/* 051 */     wholestagecodegen_init_1();
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */   private void wholestagecodegen_init_0() {
/* 056 */     scan_input = inputs[0];
/* 057 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 058 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 059 */     scan_scanTime1 = 0;
/* 060 */     scan_batch = null;
/* 061 */     scan_batchIdx = 0;
/* 062 */     scan_colInstance0 = null;
/* 063 */     scan_colInstance1 = null;
/* 064 */     scan_colInstance2 = null;
/* 065 */     scan_colInstance3 = null;
/* 066 */     scan_colInstance4 = null;
/* 067 */     scan_colInstance5 = null;
/* 068 */     scan_colInstance6 = null;
/* 069 */     scan_colInstance7 = null;
/* 070 */     scan_colInstance8 = null;
/* 071 */     scan_colInstance9 = null;
/* 072 */     scan_colInstance10 = null;
/* 073 */     scan_colInstance11 = null;
/* 074 */     scan_colInstance12 = null;
/* 075 */     scan_colInstance13 = null;
/* 076 */     scan_colInstance14 = null;
/* 077 */     scan_colInstance15 = null;
/* 078 */     scan_colInstance16 = null;
/* 079 */     scan_colInstance17 = null;
/* 080 */     scan_result = new UnsafeRow(18);
/* 081 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 288);
/* 082 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 18);
/* 083 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   private void scan_nextBatch() throws java.io.IOException {
/* 088 */     long getBatchStart = System.nanoTime();
/* 089 */     if (scan_input.hasNext()) {
/* 090 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 091 */       scan_numOutputRows.add(scan_batch.numRows());
/* 092 */       scan_batchIdx = 0;
/* 093 */       scan_colInstance0 = scan_batch.column(0);
/* 094 */       scan_colInstance1 = scan_batch.column(1);
/* 095 */       scan_colInstance2 = scan_batch.column(2);
/* 096 */       scan_colInstance3 = scan_batch.column(3);
/* 097 */       scan_colInstance4 = scan_batch.column(4);
/* 098 */       scan_colInstance5 = scan_batch.column(5);
/* 099 */       scan_colInstance6 = scan_batch.column(6);
/* 100 */       scan_colInstance7 = scan_batch.column(7);
/* 101 */       scan_colInstance8 = scan_batch.column(8);
/* 102 */       scan_colInstance9 = scan_batch.column(9);
/* 103 */       scan_colInstance10 = scan_batch.column(10);
/* 104 */       scan_colInstance11 = scan_batch.column(11);
/* 105 */       scan_colInstance12 = scan_batch.column(12);
/* 106 */       scan_colInstance13 = scan_batch.column(13);
/* 107 */       scan_colInstance14 = scan_batch.column(14);
/* 108 */       scan_colInstance15 = scan_batch.column(15);
/* 109 */       scan_colInstance16 = scan_batch.column(16);
/* 110 */       scan_colInstance17 = scan_batch.column(17);
/* 111 */
/* 112 */     }
/* 113 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 114 */   }
/* 115 */
/* 116 */   private void wholestagecodegen_init_1() {
/* 117 */     filter_result = new UnsafeRow(18);
/* 118 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 288);
/* 119 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 18);
/* 120 */     project_result = new UnsafeRow(18);
/* 121 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 288);
/* 122 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 18);
/* 123 */
/* 124 */   }
/* 125 */
/* 126 */   protected void processNext() throws java.io.IOException {
/* 127 */     if (scan_batch == null) {
/* 128 */       scan_nextBatch();
/* 129 */     }
/* 130 */     while (scan_batch != null) {
/* 131 */       int scan_numRows = scan_batch.numRows();
/* 132 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 133 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 134 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 135 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 136 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 137 */
/* 138 */         if (!(!(scan_isNull4))) continue;
/* 139 */
/* 140 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 141 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 142 */
/* 143 */         if (!(!(scan_isNull2))) continue;
/* 144 */
/* 145 */         filter_numOutputRows.add(1);
/* 146 */
/* 147 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 148 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 149 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 150 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 151 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 152 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 153 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 154 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 155 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 156 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 157 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 158 */         UTF8String scan_value7 = scan_isNull7 ? null : (scan_colInstance7.getUTF8String(scan_rowIdx));
/* 159 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 160 */         UTF8String scan_value8 = scan_isNull8 ? null : (scan_colInstance8.getUTF8String(scan_rowIdx));
/* 161 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 162 */         UTF8String scan_value9 = scan_isNull9 ? null : (scan_colInstance9.getUTF8String(scan_rowIdx));
/* 163 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 164 */         UTF8String scan_value10 = scan_isNull10 ? null : (scan_colInstance10.getUTF8String(scan_rowIdx));
/* 165 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 166 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 167 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 168 */         int scan_value12 = scan_isNull12 ? -1 : (scan_colInstance12.getInt(scan_rowIdx));
/* 169 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 170 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 171 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 172 */         UTF8String scan_value14 = scan_isNull14 ? null : (scan_colInstance14.getUTF8String(scan_rowIdx));
/* 173 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 174 */         UTF8String scan_value15 = scan_isNull15 ? null : (scan_colInstance15.getUTF8String(scan_rowIdx));
/* 175 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 176 */         UTF8String scan_value16 = scan_isNull16 ? null : (scan_colInstance16.getUTF8String(scan_rowIdx));
/* 177 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 178 */         UTF8String scan_value17 = scan_isNull17 ? null : (scan_colInstance17.getUTF8String(scan_rowIdx));
/* 179 */         project_holder.reset();
/* 180 */
/* 181 */         project_rowWriter.zeroOutNullBytes();
/* 182 */
/* 183 */         if (scan_isNull) {
/* 184 */           project_rowWriter.setNullAt(0);
/* 185 */         } else {
/* 186 */           project_rowWriter.write(0, scan_value);
/* 187 */         }
/* 188 */
/* 189 */         if (scan_isNull1) {
/* 190 */           project_rowWriter.setNullAt(1);
/* 191 */         } else {
/* 192 */           project_rowWriter.write(1, scan_value1);
/* 193 */         }
/* 194 */
/* 195 */         project_rowWriter.write(2, scan_value2);
/* 196 */
/* 197 */         if (scan_isNull3) {
/* 198 */           project_rowWriter.setNullAt(3);
/* 199 */         } else {
/* 200 */           project_rowWriter.write(3, scan_value3);
/* 201 */         }
/* 202 */
/* 203 */         project_rowWriter.write(4, scan_value4);
/* 204 */
/* 205 */         if (scan_isNull5) {
/* 206 */           project_rowWriter.setNullAt(5);
/* 207 */         } else {
/* 208 */           project_rowWriter.write(5, scan_value5);
/* 209 */         }
/* 210 */
/* 211 */         if (scan_isNull6) {
/* 212 */           project_rowWriter.setNullAt(6);
/* 213 */         } else {
/* 214 */           project_rowWriter.write(6, scan_value6);
/* 215 */         }
/* 216 */
/* 217 */         if (scan_isNull7) {
/* 218 */           project_rowWriter.setNullAt(7);
/* 219 */         } else {
/* 220 */           project_rowWriter.write(7, scan_value7);
/* 221 */         }
/* 222 */
/* 223 */         if (scan_isNull8) {
/* 224 */           project_rowWriter.setNullAt(8);
/* 225 */         } else {
/* 226 */           project_rowWriter.write(8, scan_value8);
/* 227 */         }
/* 228 */
/* 229 */         if (scan_isNull9) {
/* 230 */           project_rowWriter.setNullAt(9);
/* 231 */         } else {
/* 232 */           project_rowWriter.write(9, scan_value9);
/* 233 */         }
/* 234 */
/* 235 */         if (scan_isNull10) {
/* 236 */           project_rowWriter.setNullAt(10);
/* 237 */         } else {
/* 238 */           project_rowWriter.write(10, scan_value10);
/* 239 */         }
/* 240 */
/* 241 */         if (scan_isNull11) {
/* 242 */           project_rowWriter.setNullAt(11);
/* 243 */         } else {
/* 244 */           project_rowWriter.write(11, scan_value11);
/* 245 */         }
/* 246 */
/* 247 */         if (scan_isNull12) {
/* 248 */           project_rowWriter.setNullAt(12);
/* 249 */         } else {
/* 250 */           project_rowWriter.write(12, scan_value12);
/* 251 */         }
/* 252 */
/* 253 */         if (scan_isNull13) {
/* 254 */           project_rowWriter.setNullAt(13);
/* 255 */         } else {
/* 256 */           project_rowWriter.write(13, scan_value13);
/* 257 */         }
/* 258 */
/* 259 */         if (scan_isNull14) {
/* 260 */           project_rowWriter.setNullAt(14);
/* 261 */         } else {
/* 262 */           project_rowWriter.write(14, scan_value14);
/* 263 */         }
/* 264 */
/* 265 */         if (scan_isNull15) {
/* 266 */           project_rowWriter.setNullAt(15);
/* 267 */         } else {
/* 268 */           project_rowWriter.write(15, scan_value15);
/* 269 */         }
/* 270 */
/* 271 */         if (scan_isNull16) {
/* 272 */           project_rowWriter.setNullAt(16);
/* 273 */         } else {
/* 274 */           project_rowWriter.write(16, scan_value16);
/* 275 */         }
/* 276 */
/* 277 */         if (scan_isNull17) {
/* 278 */           project_rowWriter.setNullAt(17);
/* 279 */         } else {
/* 280 */           project_rowWriter.write(17, scan_value17);
/* 281 */         }
/* 282 */         project_result.setTotalSize(project_holder.totalSize());
/* 283 */         append(project_result);
/* 284 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 285 */       }
/* 286 */       scan_batchIdx = scan_numRows;
/* 287 */       scan_batch = null;
/* 288 */       scan_nextBatch();
/* 289 */     }
/* 290 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 291 */     scan_scanTime1 = 0;
/* 292 */   }
/* 293 */ }
