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
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance22;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance23;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance24;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance25;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance26;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance27;
/* 042 */   private UnsafeRow scan_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 046 */   private UnsafeRow filter_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 049 */   private UnsafeRow project_result;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 052 */
/* 053 */   public GeneratedIterator(Object[] references) {
/* 054 */     this.references = references;
/* 055 */   }
/* 056 */
/* 057 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 058 */     partitionIndex = index;
/* 059 */     this.inputs = inputs;
/* 060 */     wholestagecodegen_init_0();
/* 061 */     wholestagecodegen_init_1();
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void wholestagecodegen_init_0() {
/* 066 */     scan_input = inputs[0];
/* 067 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 068 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 069 */     scan_scanTime1 = 0;
/* 070 */     scan_batch = null;
/* 071 */     scan_batchIdx = 0;
/* 072 */     scan_colInstance0 = null;
/* 073 */     scan_colInstance1 = null;
/* 074 */     scan_colInstance2 = null;
/* 075 */     scan_colInstance3 = null;
/* 076 */     scan_colInstance4 = null;
/* 077 */     scan_colInstance5 = null;
/* 078 */     scan_colInstance6 = null;
/* 079 */     scan_colInstance7 = null;
/* 080 */     scan_colInstance8 = null;
/* 081 */     scan_colInstance9 = null;
/* 082 */     scan_colInstance10 = null;
/* 083 */     scan_colInstance11 = null;
/* 084 */     scan_colInstance12 = null;
/* 085 */     scan_colInstance13 = null;
/* 086 */     scan_colInstance14 = null;
/* 087 */     scan_colInstance15 = null;
/* 088 */     scan_colInstance16 = null;
/* 089 */     scan_colInstance17 = null;
/* 090 */     scan_colInstance18 = null;
/* 091 */     scan_colInstance19 = null;
/* 092 */     scan_colInstance20 = null;
/* 093 */     scan_colInstance21 = null;
/* 094 */     scan_colInstance22 = null;
/* 095 */     scan_colInstance23 = null;
/* 096 */     scan_colInstance24 = null;
/* 097 */     scan_colInstance25 = null;
/* 098 */     scan_colInstance26 = null;
/* 099 */     scan_colInstance27 = null;
/* 100 */     scan_result = new UnsafeRow(28);
/* 101 */
/* 102 */   }
/* 103 */
/* 104 */   private void scan_nextBatch() throws java.io.IOException {
/* 105 */     long getBatchStart = System.nanoTime();
/* 106 */     if (scan_input.hasNext()) {
/* 107 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 108 */       scan_numOutputRows.add(scan_batch.numRows());
/* 109 */       scan_batchIdx = 0;
/* 110 */       scan_colInstance0 = scan_batch.column(0);
/* 111 */       scan_colInstance1 = scan_batch.column(1);
/* 112 */       scan_colInstance2 = scan_batch.column(2);
/* 113 */       scan_colInstance3 = scan_batch.column(3);
/* 114 */       scan_colInstance4 = scan_batch.column(4);
/* 115 */       scan_colInstance5 = scan_batch.column(5);
/* 116 */       scan_colInstance6 = scan_batch.column(6);
/* 117 */       scan_colInstance7 = scan_batch.column(7);
/* 118 */       scan_colInstance8 = scan_batch.column(8);
/* 119 */       scan_colInstance9 = scan_batch.column(9);
/* 120 */       scan_colInstance10 = scan_batch.column(10);
/* 121 */       scan_colInstance11 = scan_batch.column(11);
/* 122 */       scan_colInstance12 = scan_batch.column(12);
/* 123 */       scan_colInstance13 = scan_batch.column(13);
/* 124 */       scan_colInstance14 = scan_batch.column(14);
/* 125 */       scan_colInstance15 = scan_batch.column(15);
/* 126 */       scan_colInstance16 = scan_batch.column(16);
/* 127 */       scan_colInstance17 = scan_batch.column(17);
/* 128 */       scan_colInstance18 = scan_batch.column(18);
/* 129 */       scan_colInstance19 = scan_batch.column(19);
/* 130 */       scan_colInstance20 = scan_batch.column(20);
/* 131 */       scan_colInstance21 = scan_batch.column(21);
/* 132 */       scan_colInstance22 = scan_batch.column(22);
/* 133 */       scan_colInstance23 = scan_batch.column(23);
/* 134 */       scan_colInstance24 = scan_batch.column(24);
/* 135 */       scan_colInstance25 = scan_batch.column(25);
/* 136 */       scan_colInstance26 = scan_batch.column(26);
/* 137 */       scan_colInstance27 = scan_batch.column(27);
/* 138 */
/* 139 */     }
/* 140 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 141 */   }
/* 142 */
/* 143 */   private void wholestagecodegen_init_1() {
/* 144 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 384);
/* 145 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 28);
/* 146 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 147 */     filter_result = new UnsafeRow(28);
/* 148 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 384);
/* 149 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 28);
/* 150 */     project_result = new UnsafeRow(28);
/* 151 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 384);
/* 152 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 28);
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */   protected void processNext() throws java.io.IOException {
/* 157 */     if (scan_batch == null) {
/* 158 */       scan_nextBatch();
/* 159 */     }
/* 160 */     while (scan_batch != null) {
/* 161 */       int scan_numRows = scan_batch.numRows();
/* 162 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 163 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 164 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 165 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 166 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 167 */
/* 168 */         if (!(!(scan_isNull6))) continue;
/* 169 */
/* 170 */         boolean filter_isNull2 = false;
/* 171 */
/* 172 */         boolean filter_value2 = false;
/* 173 */         filter_value2 = scan_value6 == 2002;
/* 174 */         if (!filter_value2) continue;
/* 175 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 176 */         int scan_value10 = scan_isNull10 ? -1 : (scan_colInstance10.getInt(scan_rowIdx));
/* 177 */
/* 178 */         if (!(!(scan_isNull10))) continue;
/* 179 */
/* 180 */         boolean filter_isNull7 = false;
/* 181 */
/* 182 */         boolean filter_value7 = false;
/* 183 */         filter_value7 = scan_value10 < 4;
/* 184 */         if (!filter_value7) continue;
/* 185 */
/* 186 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 187 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 188 */
/* 189 */         if (!(!(scan_isNull))) continue;
/* 190 */
/* 191 */         filter_numOutputRows.add(1);
/* 192 */
/* 193 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 194 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 195 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 196 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 197 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 198 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 199 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 200 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 201 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 202 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 203 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 204 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 205 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 206 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 207 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 208 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 209 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 210 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 211 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 212 */         int scan_value12 = scan_isNull12 ? -1 : (scan_colInstance12.getInt(scan_rowIdx));
/* 213 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 214 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 215 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 216 */         UTF8String scan_value14 = scan_isNull14 ? null : (scan_colInstance14.getUTF8String(scan_rowIdx));
/* 217 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 218 */         UTF8String scan_value15 = scan_isNull15 ? null : (scan_colInstance15.getUTF8String(scan_rowIdx));
/* 219 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 220 */         UTF8String scan_value16 = scan_isNull16 ? null : (scan_colInstance16.getUTF8String(scan_rowIdx));
/* 221 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 222 */         UTF8String scan_value17 = scan_isNull17 ? null : (scan_colInstance17.getUTF8String(scan_rowIdx));
/* 223 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 224 */         UTF8String scan_value18 = scan_isNull18 ? null : (scan_colInstance18.getUTF8String(scan_rowIdx));
/* 225 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 226 */         int scan_value19 = scan_isNull19 ? -1 : (scan_colInstance19.getInt(scan_rowIdx));
/* 227 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 228 */         int scan_value20 = scan_isNull20 ? -1 : (scan_colInstance20.getInt(scan_rowIdx));
/* 229 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 230 */         int scan_value21 = scan_isNull21 ? -1 : (scan_colInstance21.getInt(scan_rowIdx));
/* 231 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 232 */         int scan_value22 = scan_isNull22 ? -1 : (scan_colInstance22.getInt(scan_rowIdx));
/* 233 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 234 */         UTF8String scan_value23 = scan_isNull23 ? null : (scan_colInstance23.getUTF8String(scan_rowIdx));
/* 235 */         boolean scan_isNull24 = scan_colInstance24.isNullAt(scan_rowIdx);
/* 236 */         UTF8String scan_value24 = scan_isNull24 ? null : (scan_colInstance24.getUTF8String(scan_rowIdx));
/* 237 */         boolean scan_isNull25 = scan_colInstance25.isNullAt(scan_rowIdx);
/* 238 */         UTF8String scan_value25 = scan_isNull25 ? null : (scan_colInstance25.getUTF8String(scan_rowIdx));
/* 239 */         boolean scan_isNull26 = scan_colInstance26.isNullAt(scan_rowIdx);
/* 240 */         UTF8String scan_value26 = scan_isNull26 ? null : (scan_colInstance26.getUTF8String(scan_rowIdx));
/* 241 */         boolean scan_isNull27 = scan_colInstance27.isNullAt(scan_rowIdx);
/* 242 */         UTF8String scan_value27 = scan_isNull27 ? null : (scan_colInstance27.getUTF8String(scan_rowIdx));
/* 243 */         project_holder.reset();
/* 244 */
/* 245 */         project_rowWriter.zeroOutNullBytes();
/* 246 */
/* 247 */         project_rowWriter.write(0, scan_value);
/* 248 */
/* 249 */         if (scan_isNull1) {
/* 250 */           project_rowWriter.setNullAt(1);
/* 251 */         } else {
/* 252 */           project_rowWriter.write(1, scan_value1);
/* 253 */         }
/* 254 */
/* 255 */         if (scan_isNull2) {
/* 256 */           project_rowWriter.setNullAt(2);
/* 257 */         } else {
/* 258 */           project_rowWriter.write(2, scan_value2);
/* 259 */         }
/* 260 */
/* 261 */         if (scan_isNull3) {
/* 262 */           project_rowWriter.setNullAt(3);
/* 263 */         } else {
/* 264 */           project_rowWriter.write(3, scan_value3);
/* 265 */         }
/* 266 */
/* 267 */         if (scan_isNull4) {
/* 268 */           project_rowWriter.setNullAt(4);
/* 269 */         } else {
/* 270 */           project_rowWriter.write(4, scan_value4);
/* 271 */         }
/* 272 */
/* 273 */         if (scan_isNull5) {
/* 274 */           project_rowWriter.setNullAt(5);
/* 275 */         } else {
/* 276 */           project_rowWriter.write(5, scan_value5);
/* 277 */         }
/* 278 */
/* 279 */         project_rowWriter.write(6, scan_value6);
/* 280 */
/* 281 */         if (scan_isNull7) {
/* 282 */           project_rowWriter.setNullAt(7);
/* 283 */         } else {
/* 284 */           project_rowWriter.write(7, scan_value7);
/* 285 */         }
/* 286 */
/* 287 */         if (scan_isNull8) {
/* 288 */           project_rowWriter.setNullAt(8);
/* 289 */         } else {
/* 290 */           project_rowWriter.write(8, scan_value8);
/* 291 */         }
/* 292 */
/* 293 */         if (scan_isNull9) {
/* 294 */           project_rowWriter.setNullAt(9);
/* 295 */         } else {
/* 296 */           project_rowWriter.write(9, scan_value9);
/* 297 */         }
/* 298 */
/* 299 */         project_rowWriter.write(10, scan_value10);
/* 300 */
/* 301 */         if (scan_isNull11) {
/* 302 */           project_rowWriter.setNullAt(11);
/* 303 */         } else {
/* 304 */           project_rowWriter.write(11, scan_value11);
/* 305 */         }
/* 306 */
/* 307 */         if (scan_isNull12) {
/* 308 */           project_rowWriter.setNullAt(12);
/* 309 */         } else {
/* 310 */           project_rowWriter.write(12, scan_value12);
/* 311 */         }
/* 312 */
/* 313 */         if (scan_isNull13) {
/* 314 */           project_rowWriter.setNullAt(13);
/* 315 */         } else {
/* 316 */           project_rowWriter.write(13, scan_value13);
/* 317 */         }
/* 318 */
/* 319 */         if (scan_isNull14) {
/* 320 */           project_rowWriter.setNullAt(14);
/* 321 */         } else {
/* 322 */           project_rowWriter.write(14, scan_value14);
/* 323 */         }
/* 324 */
/* 325 */         if (scan_isNull15) {
/* 326 */           project_rowWriter.setNullAt(15);
/* 327 */         } else {
/* 328 */           project_rowWriter.write(15, scan_value15);
/* 329 */         }
/* 330 */
/* 331 */         if (scan_isNull16) {
/* 332 */           project_rowWriter.setNullAt(16);
/* 333 */         } else {
/* 334 */           project_rowWriter.write(16, scan_value16);
/* 335 */         }
/* 336 */
/* 337 */         if (scan_isNull17) {
/* 338 */           project_rowWriter.setNullAt(17);
/* 339 */         } else {
/* 340 */           project_rowWriter.write(17, scan_value17);
/* 341 */         }
/* 342 */
/* 343 */         if (scan_isNull18) {
/* 344 */           project_rowWriter.setNullAt(18);
/* 345 */         } else {
/* 346 */           project_rowWriter.write(18, scan_value18);
/* 347 */         }
/* 348 */
/* 349 */         if (scan_isNull19) {
/* 350 */           project_rowWriter.setNullAt(19);
/* 351 */         } else {
/* 352 */           project_rowWriter.write(19, scan_value19);
/* 353 */         }
/* 354 */
/* 355 */         if (scan_isNull20) {
/* 356 */           project_rowWriter.setNullAt(20);
/* 357 */         } else {
/* 358 */           project_rowWriter.write(20, scan_value20);
/* 359 */         }
/* 360 */
/* 361 */         if (scan_isNull21) {
/* 362 */           project_rowWriter.setNullAt(21);
/* 363 */         } else {
/* 364 */           project_rowWriter.write(21, scan_value21);
/* 365 */         }
/* 366 */
/* 367 */         if (scan_isNull22) {
/* 368 */           project_rowWriter.setNullAt(22);
/* 369 */         } else {
/* 370 */           project_rowWriter.write(22, scan_value22);
/* 371 */         }
/* 372 */
/* 373 */         if (scan_isNull23) {
/* 374 */           project_rowWriter.setNullAt(23);
/* 375 */         } else {
/* 376 */           project_rowWriter.write(23, scan_value23);
/* 377 */         }
/* 378 */
/* 379 */         if (scan_isNull24) {
/* 380 */           project_rowWriter.setNullAt(24);
/* 381 */         } else {
/* 382 */           project_rowWriter.write(24, scan_value24);
/* 383 */         }
/* 384 */
/* 385 */         if (scan_isNull25) {
/* 386 */           project_rowWriter.setNullAt(25);
/* 387 */         } else {
/* 388 */           project_rowWriter.write(25, scan_value25);
/* 389 */         }
/* 390 */
/* 391 */         if (scan_isNull26) {
/* 392 */           project_rowWriter.setNullAt(26);
/* 393 */         } else {
/* 394 */           project_rowWriter.write(26, scan_value26);
/* 395 */         }
/* 396 */
/* 397 */         if (scan_isNull27) {
/* 398 */           project_rowWriter.setNullAt(27);
/* 399 */         } else {
/* 400 */           project_rowWriter.write(27, scan_value27);
/* 401 */         }
/* 402 */         project_result.setTotalSize(project_holder.totalSize());
/* 403 */         append(project_result);
/* 404 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 405 */       }
/* 406 */       scan_batchIdx = scan_numRows;
/* 407 */       scan_batch = null;
/* 408 */       scan_nextBatch();
/* 409 */     }
/* 410 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 411 */     scan_scanTime1 = 0;
/* 412 */   }
/* 413 */ }
