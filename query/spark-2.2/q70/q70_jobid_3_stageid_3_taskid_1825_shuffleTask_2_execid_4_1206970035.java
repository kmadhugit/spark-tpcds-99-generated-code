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
/* 042 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance28;
/* 043 */   private UnsafeRow scan_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 047 */   private UnsafeRow filter_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 050 */   private UnsafeRow project_result;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 053 */
/* 054 */   public GeneratedIterator(Object[] references) {
/* 055 */     this.references = references;
/* 056 */   }
/* 057 */
/* 058 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 059 */     partitionIndex = index;
/* 060 */     this.inputs = inputs;
/* 061 */     wholestagecodegen_init_0();
/* 062 */     wholestagecodegen_init_1();
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void wholestagecodegen_init_0() {
/* 067 */     scan_input = inputs[0];
/* 068 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 069 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 070 */     scan_scanTime1 = 0;
/* 071 */     scan_batch = null;
/* 072 */     scan_batchIdx = 0;
/* 073 */     scan_colInstance0 = null;
/* 074 */     scan_colInstance1 = null;
/* 075 */     scan_colInstance2 = null;
/* 076 */     scan_colInstance3 = null;
/* 077 */     scan_colInstance4 = null;
/* 078 */     scan_colInstance5 = null;
/* 079 */     scan_colInstance6 = null;
/* 080 */     scan_colInstance7 = null;
/* 081 */     scan_colInstance8 = null;
/* 082 */     scan_colInstance9 = null;
/* 083 */     scan_colInstance10 = null;
/* 084 */     scan_colInstance11 = null;
/* 085 */     scan_colInstance12 = null;
/* 086 */     scan_colInstance13 = null;
/* 087 */     scan_colInstance14 = null;
/* 088 */     scan_colInstance15 = null;
/* 089 */     scan_colInstance16 = null;
/* 090 */     scan_colInstance17 = null;
/* 091 */     scan_colInstance18 = null;
/* 092 */     scan_colInstance19 = null;
/* 093 */     scan_colInstance20 = null;
/* 094 */     scan_colInstance21 = null;
/* 095 */     scan_colInstance22 = null;
/* 096 */     scan_colInstance23 = null;
/* 097 */     scan_colInstance24 = null;
/* 098 */     scan_colInstance25 = null;
/* 099 */     scan_colInstance26 = null;
/* 100 */     scan_colInstance27 = null;
/* 101 */     scan_colInstance28 = null;
/* 102 */
/* 103 */   }
/* 104 */
/* 105 */   private void scan_nextBatch() throws java.io.IOException {
/* 106 */     long getBatchStart = System.nanoTime();
/* 107 */     if (scan_input.hasNext()) {
/* 108 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 109 */       scan_numOutputRows.add(scan_batch.numRows());
/* 110 */       scan_batchIdx = 0;
/* 111 */       scan_colInstance0 = scan_batch.column(0);
/* 112 */       scan_colInstance1 = scan_batch.column(1);
/* 113 */       scan_colInstance2 = scan_batch.column(2);
/* 114 */       scan_colInstance3 = scan_batch.column(3);
/* 115 */       scan_colInstance4 = scan_batch.column(4);
/* 116 */       scan_colInstance5 = scan_batch.column(5);
/* 117 */       scan_colInstance6 = scan_batch.column(6);
/* 118 */       scan_colInstance7 = scan_batch.column(7);
/* 119 */       scan_colInstance8 = scan_batch.column(8);
/* 120 */       scan_colInstance9 = scan_batch.column(9);
/* 121 */       scan_colInstance10 = scan_batch.column(10);
/* 122 */       scan_colInstance11 = scan_batch.column(11);
/* 123 */       scan_colInstance12 = scan_batch.column(12);
/* 124 */       scan_colInstance13 = scan_batch.column(13);
/* 125 */       scan_colInstance14 = scan_batch.column(14);
/* 126 */       scan_colInstance15 = scan_batch.column(15);
/* 127 */       scan_colInstance16 = scan_batch.column(16);
/* 128 */       scan_colInstance17 = scan_batch.column(17);
/* 129 */       scan_colInstance18 = scan_batch.column(18);
/* 130 */       scan_colInstance19 = scan_batch.column(19);
/* 131 */       scan_colInstance20 = scan_batch.column(20);
/* 132 */       scan_colInstance21 = scan_batch.column(21);
/* 133 */       scan_colInstance22 = scan_batch.column(22);
/* 134 */       scan_colInstance23 = scan_batch.column(23);
/* 135 */       scan_colInstance24 = scan_batch.column(24);
/* 136 */       scan_colInstance25 = scan_batch.column(25);
/* 137 */       scan_colInstance26 = scan_batch.column(26);
/* 138 */       scan_colInstance27 = scan_batch.column(27);
/* 139 */       scan_colInstance28 = scan_batch.column(28);
/* 140 */
/* 141 */     }
/* 142 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 143 */   }
/* 144 */
/* 145 */   private void wholestagecodegen_init_1() {
/* 146 */     scan_result = new UnsafeRow(29);
/* 147 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 640);
/* 148 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 29);
/* 149 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 150 */     filter_result = new UnsafeRow(29);
/* 151 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 640);
/* 152 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 29);
/* 153 */     project_result = new UnsafeRow(29);
/* 154 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 640);
/* 155 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 29);
/* 156 */
/* 157 */   }
/* 158 */
/* 159 */   protected void processNext() throws java.io.IOException {
/* 160 */     if (scan_batch == null) {
/* 161 */       scan_nextBatch();
/* 162 */     }
/* 163 */     while (scan_batch != null) {
/* 164 */       int scan_numRows = scan_batch.numRows();
/* 165 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 166 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 167 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 168 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 169 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 170 */
/* 171 */         if (!(!(scan_isNull))) continue;
/* 172 */
/* 173 */         filter_numOutputRows.add(1);
/* 174 */
/* 175 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 176 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 177 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 178 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 179 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 180 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 181 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 182 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 183 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 184 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 185 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 186 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 187 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 188 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 189 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 190 */         UTF8String scan_value8 = scan_isNull8 ? null : (scan_colInstance8.getUTF8String(scan_rowIdx));
/* 191 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 192 */         UTF8String scan_value9 = scan_isNull9 ? null : (scan_colInstance9.getUTF8String(scan_rowIdx));
/* 193 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 194 */         int scan_value10 = scan_isNull10 ? -1 : (scan_colInstance10.getInt(scan_rowIdx));
/* 195 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 196 */         UTF8String scan_value11 = scan_isNull11 ? null : (scan_colInstance11.getUTF8String(scan_rowIdx));
/* 197 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 198 */         UTF8String scan_value12 = scan_isNull12 ? null : (scan_colInstance12.getUTF8String(scan_rowIdx));
/* 199 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 200 */         UTF8String scan_value13 = scan_isNull13 ? null : (scan_colInstance13.getUTF8String(scan_rowIdx));
/* 201 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 202 */         int scan_value14 = scan_isNull14 ? -1 : (scan_colInstance14.getInt(scan_rowIdx));
/* 203 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 204 */         UTF8String scan_value15 = scan_isNull15 ? null : (scan_colInstance15.getUTF8String(scan_rowIdx));
/* 205 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 206 */         int scan_value16 = scan_isNull16 ? -1 : (scan_colInstance16.getInt(scan_rowIdx));
/* 207 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 208 */         UTF8String scan_value17 = scan_isNull17 ? null : (scan_colInstance17.getUTF8String(scan_rowIdx));
/* 209 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 210 */         UTF8String scan_value18 = scan_isNull18 ? null : (scan_colInstance18.getUTF8String(scan_rowIdx));
/* 211 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 212 */         UTF8String scan_value19 = scan_isNull19 ? null : (scan_colInstance19.getUTF8String(scan_rowIdx));
/* 213 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 214 */         UTF8String scan_value20 = scan_isNull20 ? null : (scan_colInstance20.getUTF8String(scan_rowIdx));
/* 215 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 216 */         UTF8String scan_value21 = scan_isNull21 ? null : (scan_colInstance21.getUTF8String(scan_rowIdx));
/* 217 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 218 */         UTF8String scan_value22 = scan_isNull22 ? null : (scan_colInstance22.getUTF8String(scan_rowIdx));
/* 219 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 220 */         UTF8String scan_value23 = scan_isNull23 ? null : (scan_colInstance23.getUTF8String(scan_rowIdx));
/* 221 */         boolean scan_isNull24 = scan_colInstance24.isNullAt(scan_rowIdx);
/* 222 */         UTF8String scan_value24 = scan_isNull24 ? null : (scan_colInstance24.getUTF8String(scan_rowIdx));
/* 223 */         boolean scan_isNull25 = scan_colInstance25.isNullAt(scan_rowIdx);
/* 224 */         UTF8String scan_value25 = scan_isNull25 ? null : (scan_colInstance25.getUTF8String(scan_rowIdx));
/* 225 */         boolean scan_isNull26 = scan_colInstance26.isNullAt(scan_rowIdx);
/* 226 */         UTF8String scan_value26 = scan_isNull26 ? null : (scan_colInstance26.getUTF8String(scan_rowIdx));
/* 227 */         boolean scan_isNull27 = scan_colInstance27.isNullAt(scan_rowIdx);
/* 228 */         double scan_value27 = scan_isNull27 ? -1.0 : (scan_colInstance27.getDouble(scan_rowIdx));
/* 229 */         boolean scan_isNull28 = scan_colInstance28.isNullAt(scan_rowIdx);
/* 230 */         double scan_value28 = scan_isNull28 ? -1.0 : (scan_colInstance28.getDouble(scan_rowIdx));
/* 231 */         project_holder.reset();
/* 232 */
/* 233 */         project_rowWriter.zeroOutNullBytes();
/* 234 */
/* 235 */         project_rowWriter.write(0, scan_value);
/* 236 */
/* 237 */         if (scan_isNull1) {
/* 238 */           project_rowWriter.setNullAt(1);
/* 239 */         } else {
/* 240 */           project_rowWriter.write(1, scan_value1);
/* 241 */         }
/* 242 */
/* 243 */         if (scan_isNull2) {
/* 244 */           project_rowWriter.setNullAt(2);
/* 245 */         } else {
/* 246 */           project_rowWriter.write(2, scan_value2);
/* 247 */         }
/* 248 */
/* 249 */         if (scan_isNull3) {
/* 250 */           project_rowWriter.setNullAt(3);
/* 251 */         } else {
/* 252 */           project_rowWriter.write(3, scan_value3);
/* 253 */         }
/* 254 */
/* 255 */         if (scan_isNull4) {
/* 256 */           project_rowWriter.setNullAt(4);
/* 257 */         } else {
/* 258 */           project_rowWriter.write(4, scan_value4);
/* 259 */         }
/* 260 */
/* 261 */         if (scan_isNull5) {
/* 262 */           project_rowWriter.setNullAt(5);
/* 263 */         } else {
/* 264 */           project_rowWriter.write(5, scan_value5);
/* 265 */         }
/* 266 */
/* 267 */         if (scan_isNull6) {
/* 268 */           project_rowWriter.setNullAt(6);
/* 269 */         } else {
/* 270 */           project_rowWriter.write(6, scan_value6);
/* 271 */         }
/* 272 */
/* 273 */         if (scan_isNull7) {
/* 274 */           project_rowWriter.setNullAt(7);
/* 275 */         } else {
/* 276 */           project_rowWriter.write(7, scan_value7);
/* 277 */         }
/* 278 */
/* 279 */         if (scan_isNull8) {
/* 280 */           project_rowWriter.setNullAt(8);
/* 281 */         } else {
/* 282 */           project_rowWriter.write(8, scan_value8);
/* 283 */         }
/* 284 */
/* 285 */         if (scan_isNull9) {
/* 286 */           project_rowWriter.setNullAt(9);
/* 287 */         } else {
/* 288 */           project_rowWriter.write(9, scan_value9);
/* 289 */         }
/* 290 */
/* 291 */         if (scan_isNull10) {
/* 292 */           project_rowWriter.setNullAt(10);
/* 293 */         } else {
/* 294 */           project_rowWriter.write(10, scan_value10);
/* 295 */         }
/* 296 */
/* 297 */         if (scan_isNull11) {
/* 298 */           project_rowWriter.setNullAt(11);
/* 299 */         } else {
/* 300 */           project_rowWriter.write(11, scan_value11);
/* 301 */         }
/* 302 */
/* 303 */         if (scan_isNull12) {
/* 304 */           project_rowWriter.setNullAt(12);
/* 305 */         } else {
/* 306 */           project_rowWriter.write(12, scan_value12);
/* 307 */         }
/* 308 */
/* 309 */         if (scan_isNull13) {
/* 310 */           project_rowWriter.setNullAt(13);
/* 311 */         } else {
/* 312 */           project_rowWriter.write(13, scan_value13);
/* 313 */         }
/* 314 */
/* 315 */         if (scan_isNull14) {
/* 316 */           project_rowWriter.setNullAt(14);
/* 317 */         } else {
/* 318 */           project_rowWriter.write(14, scan_value14);
/* 319 */         }
/* 320 */
/* 321 */         if (scan_isNull15) {
/* 322 */           project_rowWriter.setNullAt(15);
/* 323 */         } else {
/* 324 */           project_rowWriter.write(15, scan_value15);
/* 325 */         }
/* 326 */
/* 327 */         if (scan_isNull16) {
/* 328 */           project_rowWriter.setNullAt(16);
/* 329 */         } else {
/* 330 */           project_rowWriter.write(16, scan_value16);
/* 331 */         }
/* 332 */
/* 333 */         if (scan_isNull17) {
/* 334 */           project_rowWriter.setNullAt(17);
/* 335 */         } else {
/* 336 */           project_rowWriter.write(17, scan_value17);
/* 337 */         }
/* 338 */
/* 339 */         if (scan_isNull18) {
/* 340 */           project_rowWriter.setNullAt(18);
/* 341 */         } else {
/* 342 */           project_rowWriter.write(18, scan_value18);
/* 343 */         }
/* 344 */
/* 345 */         if (scan_isNull19) {
/* 346 */           project_rowWriter.setNullAt(19);
/* 347 */         } else {
/* 348 */           project_rowWriter.write(19, scan_value19);
/* 349 */         }
/* 350 */
/* 351 */         if (scan_isNull20) {
/* 352 */           project_rowWriter.setNullAt(20);
/* 353 */         } else {
/* 354 */           project_rowWriter.write(20, scan_value20);
/* 355 */         }
/* 356 */
/* 357 */         if (scan_isNull21) {
/* 358 */           project_rowWriter.setNullAt(21);
/* 359 */         } else {
/* 360 */           project_rowWriter.write(21, scan_value21);
/* 361 */         }
/* 362 */
/* 363 */         if (scan_isNull22) {
/* 364 */           project_rowWriter.setNullAt(22);
/* 365 */         } else {
/* 366 */           project_rowWriter.write(22, scan_value22);
/* 367 */         }
/* 368 */
/* 369 */         if (scan_isNull23) {
/* 370 */           project_rowWriter.setNullAt(23);
/* 371 */         } else {
/* 372 */           project_rowWriter.write(23, scan_value23);
/* 373 */         }
/* 374 */
/* 375 */         if (scan_isNull24) {
/* 376 */           project_rowWriter.setNullAt(24);
/* 377 */         } else {
/* 378 */           project_rowWriter.write(24, scan_value24);
/* 379 */         }
/* 380 */
/* 381 */         if (scan_isNull25) {
/* 382 */           project_rowWriter.setNullAt(25);
/* 383 */         } else {
/* 384 */           project_rowWriter.write(25, scan_value25);
/* 385 */         }
/* 386 */
/* 387 */         if (scan_isNull26) {
/* 388 */           project_rowWriter.setNullAt(26);
/* 389 */         } else {
/* 390 */           project_rowWriter.write(26, scan_value26);
/* 391 */         }
/* 392 */
/* 393 */         if (scan_isNull27) {
/* 394 */           project_rowWriter.setNullAt(27);
/* 395 */         } else {
/* 396 */           project_rowWriter.write(27, scan_value27);
/* 397 */         }
/* 398 */
/* 399 */         if (scan_isNull28) {
/* 400 */           project_rowWriter.setNullAt(28);
/* 401 */         } else {
/* 402 */           project_rowWriter.write(28, scan_value28);
/* 403 */         }
/* 404 */         project_result.setTotalSize(project_holder.totalSize());
/* 405 */         append(project_result);
/* 406 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 407 */       }
/* 408 */       scan_batchIdx = scan_numRows;
/* 409 */       scan_batch = null;
/* 410 */       scan_nextBatch();
/* 411 */     }
/* 412 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 413 */     scan_scanTime1 = 0;
/* 414 */   }
/* 415 */ }
