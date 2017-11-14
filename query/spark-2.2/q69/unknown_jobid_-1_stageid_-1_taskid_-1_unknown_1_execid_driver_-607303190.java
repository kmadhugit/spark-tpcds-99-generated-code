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
/* 173 */         filter_value2 = scan_value6 == 2001;
/* 174 */         if (!filter_value2) continue;
/* 175 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 176 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 177 */
/* 178 */         if (!(!(scan_isNull8))) continue;
/* 179 */
/* 180 */         boolean filter_isNull7 = false;
/* 181 */
/* 182 */         boolean filter_value7 = false;
/* 183 */         filter_value7 = scan_value8 >= 4;
/* 184 */         if (!filter_value7) continue;
/* 185 */         boolean filter_isNull10 = false;
/* 186 */
/* 187 */         boolean filter_value10 = false;
/* 188 */         filter_value10 = scan_value8 <= 6;
/* 189 */         if (!filter_value10) continue;
/* 190 */
/* 191 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 192 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 193 */
/* 194 */         if (!(!(scan_isNull))) continue;
/* 195 */
/* 196 */         filter_numOutputRows.add(1);
/* 197 */
/* 198 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 199 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 200 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 201 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 202 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 203 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 204 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 205 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 206 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 207 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 208 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 209 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 210 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 211 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 212 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 213 */         int scan_value10 = scan_isNull10 ? -1 : (scan_colInstance10.getInt(scan_rowIdx));
/* 214 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 215 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 216 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 217 */         int scan_value12 = scan_isNull12 ? -1 : (scan_colInstance12.getInt(scan_rowIdx));
/* 218 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 219 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 220 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 221 */         UTF8String scan_value14 = scan_isNull14 ? null : (scan_colInstance14.getUTF8String(scan_rowIdx));
/* 222 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 223 */         UTF8String scan_value15 = scan_isNull15 ? null : (scan_colInstance15.getUTF8String(scan_rowIdx));
/* 224 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 225 */         UTF8String scan_value16 = scan_isNull16 ? null : (scan_colInstance16.getUTF8String(scan_rowIdx));
/* 226 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 227 */         UTF8String scan_value17 = scan_isNull17 ? null : (scan_colInstance17.getUTF8String(scan_rowIdx));
/* 228 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 229 */         UTF8String scan_value18 = scan_isNull18 ? null : (scan_colInstance18.getUTF8String(scan_rowIdx));
/* 230 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 231 */         int scan_value19 = scan_isNull19 ? -1 : (scan_colInstance19.getInt(scan_rowIdx));
/* 232 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 233 */         int scan_value20 = scan_isNull20 ? -1 : (scan_colInstance20.getInt(scan_rowIdx));
/* 234 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 235 */         int scan_value21 = scan_isNull21 ? -1 : (scan_colInstance21.getInt(scan_rowIdx));
/* 236 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 237 */         int scan_value22 = scan_isNull22 ? -1 : (scan_colInstance22.getInt(scan_rowIdx));
/* 238 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 239 */         UTF8String scan_value23 = scan_isNull23 ? null : (scan_colInstance23.getUTF8String(scan_rowIdx));
/* 240 */         boolean scan_isNull24 = scan_colInstance24.isNullAt(scan_rowIdx);
/* 241 */         UTF8String scan_value24 = scan_isNull24 ? null : (scan_colInstance24.getUTF8String(scan_rowIdx));
/* 242 */         boolean scan_isNull25 = scan_colInstance25.isNullAt(scan_rowIdx);
/* 243 */         UTF8String scan_value25 = scan_isNull25 ? null : (scan_colInstance25.getUTF8String(scan_rowIdx));
/* 244 */         boolean scan_isNull26 = scan_colInstance26.isNullAt(scan_rowIdx);
/* 245 */         UTF8String scan_value26 = scan_isNull26 ? null : (scan_colInstance26.getUTF8String(scan_rowIdx));
/* 246 */         boolean scan_isNull27 = scan_colInstance27.isNullAt(scan_rowIdx);
/* 247 */         UTF8String scan_value27 = scan_isNull27 ? null : (scan_colInstance27.getUTF8String(scan_rowIdx));
/* 248 */         project_holder.reset();
/* 249 */
/* 250 */         project_rowWriter.zeroOutNullBytes();
/* 251 */
/* 252 */         project_rowWriter.write(0, scan_value);
/* 253 */
/* 254 */         if (scan_isNull1) {
/* 255 */           project_rowWriter.setNullAt(1);
/* 256 */         } else {
/* 257 */           project_rowWriter.write(1, scan_value1);
/* 258 */         }
/* 259 */
/* 260 */         if (scan_isNull2) {
/* 261 */           project_rowWriter.setNullAt(2);
/* 262 */         } else {
/* 263 */           project_rowWriter.write(2, scan_value2);
/* 264 */         }
/* 265 */
/* 266 */         if (scan_isNull3) {
/* 267 */           project_rowWriter.setNullAt(3);
/* 268 */         } else {
/* 269 */           project_rowWriter.write(3, scan_value3);
/* 270 */         }
/* 271 */
/* 272 */         if (scan_isNull4) {
/* 273 */           project_rowWriter.setNullAt(4);
/* 274 */         } else {
/* 275 */           project_rowWriter.write(4, scan_value4);
/* 276 */         }
/* 277 */
/* 278 */         if (scan_isNull5) {
/* 279 */           project_rowWriter.setNullAt(5);
/* 280 */         } else {
/* 281 */           project_rowWriter.write(5, scan_value5);
/* 282 */         }
/* 283 */
/* 284 */         project_rowWriter.write(6, scan_value6);
/* 285 */
/* 286 */         if (scan_isNull7) {
/* 287 */           project_rowWriter.setNullAt(7);
/* 288 */         } else {
/* 289 */           project_rowWriter.write(7, scan_value7);
/* 290 */         }
/* 291 */
/* 292 */         project_rowWriter.write(8, scan_value8);
/* 293 */
/* 294 */         if (scan_isNull9) {
/* 295 */           project_rowWriter.setNullAt(9);
/* 296 */         } else {
/* 297 */           project_rowWriter.write(9, scan_value9);
/* 298 */         }
/* 299 */
/* 300 */         if (scan_isNull10) {
/* 301 */           project_rowWriter.setNullAt(10);
/* 302 */         } else {
/* 303 */           project_rowWriter.write(10, scan_value10);
/* 304 */         }
/* 305 */
/* 306 */         if (scan_isNull11) {
/* 307 */           project_rowWriter.setNullAt(11);
/* 308 */         } else {
/* 309 */           project_rowWriter.write(11, scan_value11);
/* 310 */         }
/* 311 */
/* 312 */         if (scan_isNull12) {
/* 313 */           project_rowWriter.setNullAt(12);
/* 314 */         } else {
/* 315 */           project_rowWriter.write(12, scan_value12);
/* 316 */         }
/* 317 */
/* 318 */         if (scan_isNull13) {
/* 319 */           project_rowWriter.setNullAt(13);
/* 320 */         } else {
/* 321 */           project_rowWriter.write(13, scan_value13);
/* 322 */         }
/* 323 */
/* 324 */         if (scan_isNull14) {
/* 325 */           project_rowWriter.setNullAt(14);
/* 326 */         } else {
/* 327 */           project_rowWriter.write(14, scan_value14);
/* 328 */         }
/* 329 */
/* 330 */         if (scan_isNull15) {
/* 331 */           project_rowWriter.setNullAt(15);
/* 332 */         } else {
/* 333 */           project_rowWriter.write(15, scan_value15);
/* 334 */         }
/* 335 */
/* 336 */         if (scan_isNull16) {
/* 337 */           project_rowWriter.setNullAt(16);
/* 338 */         } else {
/* 339 */           project_rowWriter.write(16, scan_value16);
/* 340 */         }
/* 341 */
/* 342 */         if (scan_isNull17) {
/* 343 */           project_rowWriter.setNullAt(17);
/* 344 */         } else {
/* 345 */           project_rowWriter.write(17, scan_value17);
/* 346 */         }
/* 347 */
/* 348 */         if (scan_isNull18) {
/* 349 */           project_rowWriter.setNullAt(18);
/* 350 */         } else {
/* 351 */           project_rowWriter.write(18, scan_value18);
/* 352 */         }
/* 353 */
/* 354 */         if (scan_isNull19) {
/* 355 */           project_rowWriter.setNullAt(19);
/* 356 */         } else {
/* 357 */           project_rowWriter.write(19, scan_value19);
/* 358 */         }
/* 359 */
/* 360 */         if (scan_isNull20) {
/* 361 */           project_rowWriter.setNullAt(20);
/* 362 */         } else {
/* 363 */           project_rowWriter.write(20, scan_value20);
/* 364 */         }
/* 365 */
/* 366 */         if (scan_isNull21) {
/* 367 */           project_rowWriter.setNullAt(21);
/* 368 */         } else {
/* 369 */           project_rowWriter.write(21, scan_value21);
/* 370 */         }
/* 371 */
/* 372 */         if (scan_isNull22) {
/* 373 */           project_rowWriter.setNullAt(22);
/* 374 */         } else {
/* 375 */           project_rowWriter.write(22, scan_value22);
/* 376 */         }
/* 377 */
/* 378 */         if (scan_isNull23) {
/* 379 */           project_rowWriter.setNullAt(23);
/* 380 */         } else {
/* 381 */           project_rowWriter.write(23, scan_value23);
/* 382 */         }
/* 383 */
/* 384 */         if (scan_isNull24) {
/* 385 */           project_rowWriter.setNullAt(24);
/* 386 */         } else {
/* 387 */           project_rowWriter.write(24, scan_value24);
/* 388 */         }
/* 389 */
/* 390 */         if (scan_isNull25) {
/* 391 */           project_rowWriter.setNullAt(25);
/* 392 */         } else {
/* 393 */           project_rowWriter.write(25, scan_value25);
/* 394 */         }
/* 395 */
/* 396 */         if (scan_isNull26) {
/* 397 */           project_rowWriter.setNullAt(26);
/* 398 */         } else {
/* 399 */           project_rowWriter.write(26, scan_value26);
/* 400 */         }
/* 401 */
/* 402 */         if (scan_isNull27) {
/* 403 */           project_rowWriter.setNullAt(27);
/* 404 */         } else {
/* 405 */           project_rowWriter.write(27, scan_value27);
/* 406 */         }
/* 407 */         project_result.setTotalSize(project_holder.totalSize());
/* 408 */         append(project_result);
/* 409 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 410 */       }
/* 411 */       scan_batchIdx = scan_numRows;
/* 412 */       scan_batch = null;
/* 413 */       scan_nextBatch();
/* 414 */     }
/* 415 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 416 */     scan_scanTime1 = 0;
/* 417 */   }
/* 418 */ }
