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
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance18;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance19;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance20;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance21;
/* 036 */   private UnsafeRow scan_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 040 */   private UnsafeRow filter_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 043 */   private UnsafeRow project_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 046 */
/* 047 */   public GeneratedIterator(Object[] references) {
/* 048 */     this.references = references;
/* 049 */   }
/* 050 */
/* 051 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 052 */     partitionIndex = index;
/* 053 */     this.inputs = inputs;
/* 054 */     wholestagecodegen_init_0();
/* 055 */     wholestagecodegen_init_1();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     scan_input = inputs[0];
/* 061 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 062 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 063 */     scan_scanTime1 = 0;
/* 064 */     scan_batch = null;
/* 065 */     scan_batchIdx = 0;
/* 066 */     scan_colInstance0 = null;
/* 067 */     scan_colInstance1 = null;
/* 068 */     scan_colInstance2 = null;
/* 069 */     scan_colInstance3 = null;
/* 070 */     scan_colInstance4 = null;
/* 071 */     scan_colInstance5 = null;
/* 072 */     scan_colInstance6 = null;
/* 073 */     scan_colInstance7 = null;
/* 074 */     scan_colInstance8 = null;
/* 075 */     scan_colInstance9 = null;
/* 076 */     scan_colInstance10 = null;
/* 077 */     scan_colInstance11 = null;
/* 078 */     scan_colInstance12 = null;
/* 079 */     scan_colInstance13 = null;
/* 080 */     scan_colInstance14 = null;
/* 081 */     scan_colInstance15 = null;
/* 082 */     scan_colInstance16 = null;
/* 083 */     scan_colInstance17 = null;
/* 084 */     scan_colInstance18 = null;
/* 085 */     scan_colInstance19 = null;
/* 086 */     scan_colInstance20 = null;
/* 087 */     scan_colInstance21 = null;
/* 088 */     scan_result = new UnsafeRow(22);
/* 089 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 448);
/* 090 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 22);
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */   private void scan_nextBatch() throws java.io.IOException {
/* 095 */     long getBatchStart = System.nanoTime();
/* 096 */     if (scan_input.hasNext()) {
/* 097 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 098 */       scan_numOutputRows.add(scan_batch.numRows());
/* 099 */       scan_batchIdx = 0;
/* 100 */       scan_colInstance0 = scan_batch.column(0);
/* 101 */       scan_colInstance1 = scan_batch.column(1);
/* 102 */       scan_colInstance2 = scan_batch.column(2);
/* 103 */       scan_colInstance3 = scan_batch.column(3);
/* 104 */       scan_colInstance4 = scan_batch.column(4);
/* 105 */       scan_colInstance5 = scan_batch.column(5);
/* 106 */       scan_colInstance6 = scan_batch.column(6);
/* 107 */       scan_colInstance7 = scan_batch.column(7);
/* 108 */       scan_colInstance8 = scan_batch.column(8);
/* 109 */       scan_colInstance9 = scan_batch.column(9);
/* 110 */       scan_colInstance10 = scan_batch.column(10);
/* 111 */       scan_colInstance11 = scan_batch.column(11);
/* 112 */       scan_colInstance12 = scan_batch.column(12);
/* 113 */       scan_colInstance13 = scan_batch.column(13);
/* 114 */       scan_colInstance14 = scan_batch.column(14);
/* 115 */       scan_colInstance15 = scan_batch.column(15);
/* 116 */       scan_colInstance16 = scan_batch.column(16);
/* 117 */       scan_colInstance17 = scan_batch.column(17);
/* 118 */       scan_colInstance18 = scan_batch.column(18);
/* 119 */       scan_colInstance19 = scan_batch.column(19);
/* 120 */       scan_colInstance20 = scan_batch.column(20);
/* 121 */       scan_colInstance21 = scan_batch.column(21);
/* 122 */
/* 123 */     }
/* 124 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 125 */   }
/* 126 */
/* 127 */   private void wholestagecodegen_init_1() {
/* 128 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 129 */     filter_result = new UnsafeRow(22);
/* 130 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 448);
/* 131 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 22);
/* 132 */     project_result = new UnsafeRow(22);
/* 133 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 448);
/* 134 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 22);
/* 135 */
/* 136 */   }
/* 137 */
/* 138 */   protected void processNext() throws java.io.IOException {
/* 139 */     if (scan_batch == null) {
/* 140 */       scan_nextBatch();
/* 141 */     }
/* 142 */     while (scan_batch != null) {
/* 143 */       int scan_numRows = scan_batch.numRows();
/* 144 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 145 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 146 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 147 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 148 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 149 */
/* 150 */         if (!(!(scan_isNull))) continue;
/* 151 */
/* 152 */         filter_numOutputRows.add(1);
/* 153 */
/* 154 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 155 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 156 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 157 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 158 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 159 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 160 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 161 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 162 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 163 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 164 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 165 */         double scan_value6 = scan_isNull6 ? -1.0 : (scan_colInstance6.getDouble(scan_rowIdx));
/* 166 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 167 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 168 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 169 */         UTF8String scan_value8 = scan_isNull8 ? null : (scan_colInstance8.getUTF8String(scan_rowIdx));
/* 170 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 171 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 172 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 173 */         UTF8String scan_value10 = scan_isNull10 ? null : (scan_colInstance10.getUTF8String(scan_rowIdx));
/* 174 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 175 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 176 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 177 */         UTF8String scan_value12 = scan_isNull12 ? null : (scan_colInstance12.getUTF8String(scan_rowIdx));
/* 178 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 179 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 180 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 181 */         UTF8String scan_value14 = scan_isNull14 ? null : (scan_colInstance14.getUTF8String(scan_rowIdx));
/* 182 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 183 */         UTF8String scan_value15 = scan_isNull15 ? null : (scan_colInstance15.getUTF8String(scan_rowIdx));
/* 184 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 185 */         UTF8String scan_value16 = scan_isNull16 ? null : (scan_colInstance16.getUTF8String(scan_rowIdx));
/* 186 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 187 */         UTF8String scan_value17 = scan_isNull17 ? null : (scan_colInstance17.getUTF8String(scan_rowIdx));
/* 188 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 189 */         UTF8String scan_value18 = scan_isNull18 ? null : (scan_colInstance18.getUTF8String(scan_rowIdx));
/* 190 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 191 */         UTF8String scan_value19 = scan_isNull19 ? null : (scan_colInstance19.getUTF8String(scan_rowIdx));
/* 192 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 193 */         int scan_value20 = scan_isNull20 ? -1 : (scan_colInstance20.getInt(scan_rowIdx));
/* 194 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 195 */         UTF8String scan_value21 = scan_isNull21 ? null : (scan_colInstance21.getUTF8String(scan_rowIdx));
/* 196 */         project_holder.reset();
/* 197 */
/* 198 */         project_rowWriter.zeroOutNullBytes();
/* 199 */
/* 200 */         project_rowWriter.write(0, scan_value);
/* 201 */
/* 202 */         if (scan_isNull1) {
/* 203 */           project_rowWriter.setNullAt(1);
/* 204 */         } else {
/* 205 */           project_rowWriter.write(1, scan_value1);
/* 206 */         }
/* 207 */
/* 208 */         if (scan_isNull2) {
/* 209 */           project_rowWriter.setNullAt(2);
/* 210 */         } else {
/* 211 */           project_rowWriter.write(2, scan_value2);
/* 212 */         }
/* 213 */
/* 214 */         if (scan_isNull3) {
/* 215 */           project_rowWriter.setNullAt(3);
/* 216 */         } else {
/* 217 */           project_rowWriter.write(3, scan_value3);
/* 218 */         }
/* 219 */
/* 220 */         if (scan_isNull4) {
/* 221 */           project_rowWriter.setNullAt(4);
/* 222 */         } else {
/* 223 */           project_rowWriter.write(4, scan_value4);
/* 224 */         }
/* 225 */
/* 226 */         if (scan_isNull5) {
/* 227 */           project_rowWriter.setNullAt(5);
/* 228 */         } else {
/* 229 */           project_rowWriter.write(5, scan_value5);
/* 230 */         }
/* 231 */
/* 232 */         if (scan_isNull6) {
/* 233 */           project_rowWriter.setNullAt(6);
/* 234 */         } else {
/* 235 */           project_rowWriter.write(6, scan_value6);
/* 236 */         }
/* 237 */
/* 238 */         if (scan_isNull7) {
/* 239 */           project_rowWriter.setNullAt(7);
/* 240 */         } else {
/* 241 */           project_rowWriter.write(7, scan_value7);
/* 242 */         }
/* 243 */
/* 244 */         if (scan_isNull8) {
/* 245 */           project_rowWriter.setNullAt(8);
/* 246 */         } else {
/* 247 */           project_rowWriter.write(8, scan_value8);
/* 248 */         }
/* 249 */
/* 250 */         if (scan_isNull9) {
/* 251 */           project_rowWriter.setNullAt(9);
/* 252 */         } else {
/* 253 */           project_rowWriter.write(9, scan_value9);
/* 254 */         }
/* 255 */
/* 256 */         if (scan_isNull10) {
/* 257 */           project_rowWriter.setNullAt(10);
/* 258 */         } else {
/* 259 */           project_rowWriter.write(10, scan_value10);
/* 260 */         }
/* 261 */
/* 262 */         if (scan_isNull11) {
/* 263 */           project_rowWriter.setNullAt(11);
/* 264 */         } else {
/* 265 */           project_rowWriter.write(11, scan_value11);
/* 266 */         }
/* 267 */
/* 268 */         if (scan_isNull12) {
/* 269 */           project_rowWriter.setNullAt(12);
/* 270 */         } else {
/* 271 */           project_rowWriter.write(12, scan_value12);
/* 272 */         }
/* 273 */
/* 274 */         if (scan_isNull13) {
/* 275 */           project_rowWriter.setNullAt(13);
/* 276 */         } else {
/* 277 */           project_rowWriter.write(13, scan_value13);
/* 278 */         }
/* 279 */
/* 280 */         if (scan_isNull14) {
/* 281 */           project_rowWriter.setNullAt(14);
/* 282 */         } else {
/* 283 */           project_rowWriter.write(14, scan_value14);
/* 284 */         }
/* 285 */
/* 286 */         if (scan_isNull15) {
/* 287 */           project_rowWriter.setNullAt(15);
/* 288 */         } else {
/* 289 */           project_rowWriter.write(15, scan_value15);
/* 290 */         }
/* 291 */
/* 292 */         if (scan_isNull16) {
/* 293 */           project_rowWriter.setNullAt(16);
/* 294 */         } else {
/* 295 */           project_rowWriter.write(16, scan_value16);
/* 296 */         }
/* 297 */
/* 298 */         if (scan_isNull17) {
/* 299 */           project_rowWriter.setNullAt(17);
/* 300 */         } else {
/* 301 */           project_rowWriter.write(17, scan_value17);
/* 302 */         }
/* 303 */
/* 304 */         if (scan_isNull18) {
/* 305 */           project_rowWriter.setNullAt(18);
/* 306 */         } else {
/* 307 */           project_rowWriter.write(18, scan_value18);
/* 308 */         }
/* 309 */
/* 310 */         if (scan_isNull19) {
/* 311 */           project_rowWriter.setNullAt(19);
/* 312 */         } else {
/* 313 */           project_rowWriter.write(19, scan_value19);
/* 314 */         }
/* 315 */
/* 316 */         if (scan_isNull20) {
/* 317 */           project_rowWriter.setNullAt(20);
/* 318 */         } else {
/* 319 */           project_rowWriter.write(20, scan_value20);
/* 320 */         }
/* 321 */
/* 322 */         if (scan_isNull21) {
/* 323 */           project_rowWriter.setNullAt(21);
/* 324 */         } else {
/* 325 */           project_rowWriter.write(21, scan_value21);
/* 326 */         }
/* 327 */         project_result.setTotalSize(project_holder.totalSize());
/* 328 */         append(project_result);
/* 329 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 330 */       }
/* 331 */       scan_batchIdx = scan_numRows;
/* 332 */       scan_batch = null;
/* 333 */       scan_nextBatch();
/* 334 */     }
/* 335 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 336 */     scan_scanTime1 = 0;
/* 337 */   }
/* 338 */ }
