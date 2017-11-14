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
/* 043 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance29;
/* 044 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance30;
/* 045 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance31;
/* 046 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance32;
/* 047 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance33;
/* 048 */   private UnsafeRow scan_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 051 */
/* 052 */   public GeneratedIterator(Object[] references) {
/* 053 */     this.references = references;
/* 054 */   }
/* 055 */
/* 056 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 057 */     partitionIndex = index;
/* 058 */     this.inputs = inputs;
/* 059 */     wholestagecodegen_init_0();
/* 060 */     wholestagecodegen_init_1();
/* 061 */
/* 062 */   }
/* 063 */
/* 064 */   private void wholestagecodegen_init_0() {
/* 065 */     scan_input = inputs[0];
/* 066 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 067 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 068 */     scan_scanTime1 = 0;
/* 069 */     scan_batch = null;
/* 070 */     scan_batchIdx = 0;
/* 071 */     scan_colInstance0 = null;
/* 072 */     scan_colInstance1 = null;
/* 073 */     scan_colInstance2 = null;
/* 074 */     scan_colInstance3 = null;
/* 075 */     scan_colInstance4 = null;
/* 076 */     scan_colInstance5 = null;
/* 077 */     scan_colInstance6 = null;
/* 078 */     scan_colInstance7 = null;
/* 079 */     scan_colInstance8 = null;
/* 080 */     scan_colInstance9 = null;
/* 081 */     scan_colInstance10 = null;
/* 082 */     scan_colInstance11 = null;
/* 083 */     scan_colInstance12 = null;
/* 084 */     scan_colInstance13 = null;
/* 085 */     scan_colInstance14 = null;
/* 086 */     scan_colInstance15 = null;
/* 087 */     scan_colInstance16 = null;
/* 088 */     scan_colInstance17 = null;
/* 089 */     scan_colInstance18 = null;
/* 090 */     scan_colInstance19 = null;
/* 091 */     scan_colInstance20 = null;
/* 092 */     scan_colInstance21 = null;
/* 093 */     scan_colInstance22 = null;
/* 094 */     scan_colInstance23 = null;
/* 095 */     scan_colInstance24 = null;
/* 096 */     scan_colInstance25 = null;
/* 097 */     scan_colInstance26 = null;
/* 098 */     scan_colInstance27 = null;
/* 099 */     scan_colInstance28 = null;
/* 100 */
/* 101 */   }
/* 102 */
/* 103 */   private void scan_nextBatch() throws java.io.IOException {
/* 104 */     long getBatchStart = System.nanoTime();
/* 105 */     if (scan_input.hasNext()) {
/* 106 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 107 */       scan_numOutputRows.add(scan_batch.numRows());
/* 108 */       scan_batchIdx = 0;
/* 109 */       scan_colInstance0 = scan_batch.column(0);
/* 110 */       scan_colInstance1 = scan_batch.column(1);
/* 111 */       scan_colInstance2 = scan_batch.column(2);
/* 112 */       scan_colInstance3 = scan_batch.column(3);
/* 113 */       scan_colInstance4 = scan_batch.column(4);
/* 114 */       scan_colInstance5 = scan_batch.column(5);
/* 115 */       scan_colInstance6 = scan_batch.column(6);
/* 116 */       scan_colInstance7 = scan_batch.column(7);
/* 117 */       scan_colInstance8 = scan_batch.column(8);
/* 118 */       scan_colInstance9 = scan_batch.column(9);
/* 119 */       scan_colInstance10 = scan_batch.column(10);
/* 120 */       scan_colInstance11 = scan_batch.column(11);
/* 121 */       scan_colInstance12 = scan_batch.column(12);
/* 122 */       scan_colInstance13 = scan_batch.column(13);
/* 123 */       scan_colInstance14 = scan_batch.column(14);
/* 124 */       scan_colInstance15 = scan_batch.column(15);
/* 125 */       scan_colInstance16 = scan_batch.column(16);
/* 126 */       scan_colInstance17 = scan_batch.column(17);
/* 127 */       scan_colInstance18 = scan_batch.column(18);
/* 128 */       scan_colInstance19 = scan_batch.column(19);
/* 129 */       scan_colInstance20 = scan_batch.column(20);
/* 130 */       scan_colInstance21 = scan_batch.column(21);
/* 131 */       scan_colInstance22 = scan_batch.column(22);
/* 132 */       scan_colInstance23 = scan_batch.column(23);
/* 133 */       scan_colInstance24 = scan_batch.column(24);
/* 134 */       scan_colInstance25 = scan_batch.column(25);
/* 135 */       scan_colInstance26 = scan_batch.column(26);
/* 136 */       scan_colInstance27 = scan_batch.column(27);
/* 137 */       scan_colInstance28 = scan_batch.column(28);
/* 138 */       scan_colInstance29 = scan_batch.column(29);
/* 139 */       scan_colInstance30 = scan_batch.column(30);
/* 140 */       scan_colInstance31 = scan_batch.column(31);
/* 141 */       scan_colInstance32 = scan_batch.column(32);
/* 142 */       scan_colInstance33 = scan_batch.column(33);
/* 143 */
/* 144 */     }
/* 145 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 146 */   }
/* 147 */
/* 148 */   private void wholestagecodegen_init_1() {
/* 149 */     scan_colInstance29 = null;
/* 150 */     scan_colInstance30 = null;
/* 151 */     scan_colInstance31 = null;
/* 152 */     scan_colInstance32 = null;
/* 153 */     scan_colInstance33 = null;
/* 154 */     scan_result = new UnsafeRow(34);
/* 155 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 156 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 34);
/* 157 */
/* 158 */   }
/* 159 */
/* 160 */   protected void processNext() throws java.io.IOException {
/* 161 */     if (scan_batch == null) {
/* 162 */       scan_nextBatch();
/* 163 */     }
/* 164 */     while (scan_batch != null) {
/* 165 */       int scan_numRows = scan_batch.numRows();
/* 166 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 167 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 168 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 169 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 170 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 171 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 172 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 173 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 174 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 175 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 176 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 177 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 178 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 179 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 180 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 181 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 182 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 183 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 184 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 185 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 186 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 187 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 188 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 189 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 190 */         int scan_value10 = scan_isNull10 ? -1 : (scan_colInstance10.getInt(scan_rowIdx));
/* 191 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 192 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 193 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 194 */         int scan_value12 = scan_isNull12 ? -1 : (scan_colInstance12.getInt(scan_rowIdx));
/* 195 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 196 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 197 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 198 */         int scan_value14 = scan_isNull14 ? -1 : (scan_colInstance14.getInt(scan_rowIdx));
/* 199 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 200 */         int scan_value15 = scan_isNull15 ? -1 : (scan_colInstance15.getInt(scan_rowIdx));
/* 201 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 202 */         int scan_value16 = scan_isNull16 ? -1 : (scan_colInstance16.getInt(scan_rowIdx));
/* 203 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 204 */         int scan_value17 = scan_isNull17 ? -1 : (scan_colInstance17.getInt(scan_rowIdx));
/* 205 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 206 */         double scan_value18 = scan_isNull18 ? -1.0 : (scan_colInstance18.getDouble(scan_rowIdx));
/* 207 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 208 */         double scan_value19 = scan_isNull19 ? -1.0 : (scan_colInstance19.getDouble(scan_rowIdx));
/* 209 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 210 */         double scan_value20 = scan_isNull20 ? -1.0 : (scan_colInstance20.getDouble(scan_rowIdx));
/* 211 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 212 */         double scan_value21 = scan_isNull21 ? -1.0 : (scan_colInstance21.getDouble(scan_rowIdx));
/* 213 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 214 */         double scan_value22 = scan_isNull22 ? -1.0 : (scan_colInstance22.getDouble(scan_rowIdx));
/* 215 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 216 */         double scan_value23 = scan_isNull23 ? -1.0 : (scan_colInstance23.getDouble(scan_rowIdx));
/* 217 */         boolean scan_isNull24 = scan_colInstance24.isNullAt(scan_rowIdx);
/* 218 */         double scan_value24 = scan_isNull24 ? -1.0 : (scan_colInstance24.getDouble(scan_rowIdx));
/* 219 */         boolean scan_isNull25 = scan_colInstance25.isNullAt(scan_rowIdx);
/* 220 */         double scan_value25 = scan_isNull25 ? -1.0 : (scan_colInstance25.getDouble(scan_rowIdx));
/* 221 */         boolean scan_isNull26 = scan_colInstance26.isNullAt(scan_rowIdx);
/* 222 */         double scan_value26 = scan_isNull26 ? -1.0 : (scan_colInstance26.getDouble(scan_rowIdx));
/* 223 */         boolean scan_isNull27 = scan_colInstance27.isNullAt(scan_rowIdx);
/* 224 */         double scan_value27 = scan_isNull27 ? -1.0 : (scan_colInstance27.getDouble(scan_rowIdx));
/* 225 */         boolean scan_isNull28 = scan_colInstance28.isNullAt(scan_rowIdx);
/* 226 */         double scan_value28 = scan_isNull28 ? -1.0 : (scan_colInstance28.getDouble(scan_rowIdx));
/* 227 */         boolean scan_isNull29 = scan_colInstance29.isNullAt(scan_rowIdx);
/* 228 */         double scan_value29 = scan_isNull29 ? -1.0 : (scan_colInstance29.getDouble(scan_rowIdx));
/* 229 */         boolean scan_isNull30 = scan_colInstance30.isNullAt(scan_rowIdx);
/* 230 */         double scan_value30 = scan_isNull30 ? -1.0 : (scan_colInstance30.getDouble(scan_rowIdx));
/* 231 */         boolean scan_isNull31 = scan_colInstance31.isNullAt(scan_rowIdx);
/* 232 */         double scan_value31 = scan_isNull31 ? -1.0 : (scan_colInstance31.getDouble(scan_rowIdx));
/* 233 */         boolean scan_isNull32 = scan_colInstance32.isNullAt(scan_rowIdx);
/* 234 */         double scan_value32 = scan_isNull32 ? -1.0 : (scan_colInstance32.getDouble(scan_rowIdx));
/* 235 */         boolean scan_isNull33 = scan_colInstance33.isNullAt(scan_rowIdx);
/* 236 */         int scan_value33 = scan_isNull33 ? -1 : (scan_colInstance33.getInt(scan_rowIdx));
/* 237 */         scan_rowWriter.zeroOutNullBytes();
/* 238 */
/* 239 */         if (scan_isNull) {
/* 240 */           scan_rowWriter.setNullAt(0);
/* 241 */         } else {
/* 242 */           scan_rowWriter.write(0, scan_value);
/* 243 */         }
/* 244 */
/* 245 */         if (scan_isNull1) {
/* 246 */           scan_rowWriter.setNullAt(1);
/* 247 */         } else {
/* 248 */           scan_rowWriter.write(1, scan_value1);
/* 249 */         }
/* 250 */
/* 251 */         if (scan_isNull2) {
/* 252 */           scan_rowWriter.setNullAt(2);
/* 253 */         } else {
/* 254 */           scan_rowWriter.write(2, scan_value2);
/* 255 */         }
/* 256 */
/* 257 */         if (scan_isNull3) {
/* 258 */           scan_rowWriter.setNullAt(3);
/* 259 */         } else {
/* 260 */           scan_rowWriter.write(3, scan_value3);
/* 261 */         }
/* 262 */
/* 263 */         if (scan_isNull4) {
/* 264 */           scan_rowWriter.setNullAt(4);
/* 265 */         } else {
/* 266 */           scan_rowWriter.write(4, scan_value4);
/* 267 */         }
/* 268 */
/* 269 */         if (scan_isNull5) {
/* 270 */           scan_rowWriter.setNullAt(5);
/* 271 */         } else {
/* 272 */           scan_rowWriter.write(5, scan_value5);
/* 273 */         }
/* 274 */
/* 275 */         if (scan_isNull6) {
/* 276 */           scan_rowWriter.setNullAt(6);
/* 277 */         } else {
/* 278 */           scan_rowWriter.write(6, scan_value6);
/* 279 */         }
/* 280 */
/* 281 */         if (scan_isNull7) {
/* 282 */           scan_rowWriter.setNullAt(7);
/* 283 */         } else {
/* 284 */           scan_rowWriter.write(7, scan_value7);
/* 285 */         }
/* 286 */
/* 287 */         if (scan_isNull8) {
/* 288 */           scan_rowWriter.setNullAt(8);
/* 289 */         } else {
/* 290 */           scan_rowWriter.write(8, scan_value8);
/* 291 */         }
/* 292 */
/* 293 */         if (scan_isNull9) {
/* 294 */           scan_rowWriter.setNullAt(9);
/* 295 */         } else {
/* 296 */           scan_rowWriter.write(9, scan_value9);
/* 297 */         }
/* 298 */
/* 299 */         if (scan_isNull10) {
/* 300 */           scan_rowWriter.setNullAt(10);
/* 301 */         } else {
/* 302 */           scan_rowWriter.write(10, scan_value10);
/* 303 */         }
/* 304 */
/* 305 */         if (scan_isNull11) {
/* 306 */           scan_rowWriter.setNullAt(11);
/* 307 */         } else {
/* 308 */           scan_rowWriter.write(11, scan_value11);
/* 309 */         }
/* 310 */
/* 311 */         if (scan_isNull12) {
/* 312 */           scan_rowWriter.setNullAt(12);
/* 313 */         } else {
/* 314 */           scan_rowWriter.write(12, scan_value12);
/* 315 */         }
/* 316 */
/* 317 */         if (scan_isNull13) {
/* 318 */           scan_rowWriter.setNullAt(13);
/* 319 */         } else {
/* 320 */           scan_rowWriter.write(13, scan_value13);
/* 321 */         }
/* 322 */
/* 323 */         if (scan_isNull14) {
/* 324 */           scan_rowWriter.setNullAt(14);
/* 325 */         } else {
/* 326 */           scan_rowWriter.write(14, scan_value14);
/* 327 */         }
/* 328 */
/* 329 */         if (scan_isNull15) {
/* 330 */           scan_rowWriter.setNullAt(15);
/* 331 */         } else {
/* 332 */           scan_rowWriter.write(15, scan_value15);
/* 333 */         }
/* 334 */
/* 335 */         if (scan_isNull16) {
/* 336 */           scan_rowWriter.setNullAt(16);
/* 337 */         } else {
/* 338 */           scan_rowWriter.write(16, scan_value16);
/* 339 */         }
/* 340 */
/* 341 */         if (scan_isNull17) {
/* 342 */           scan_rowWriter.setNullAt(17);
/* 343 */         } else {
/* 344 */           scan_rowWriter.write(17, scan_value17);
/* 345 */         }
/* 346 */
/* 347 */         if (scan_isNull18) {
/* 348 */           scan_rowWriter.setNullAt(18);
/* 349 */         } else {
/* 350 */           scan_rowWriter.write(18, scan_value18);
/* 351 */         }
/* 352 */
/* 353 */         if (scan_isNull19) {
/* 354 */           scan_rowWriter.setNullAt(19);
/* 355 */         } else {
/* 356 */           scan_rowWriter.write(19, scan_value19);
/* 357 */         }
/* 358 */
/* 359 */         if (scan_isNull20) {
/* 360 */           scan_rowWriter.setNullAt(20);
/* 361 */         } else {
/* 362 */           scan_rowWriter.write(20, scan_value20);
/* 363 */         }
/* 364 */
/* 365 */         if (scan_isNull21) {
/* 366 */           scan_rowWriter.setNullAt(21);
/* 367 */         } else {
/* 368 */           scan_rowWriter.write(21, scan_value21);
/* 369 */         }
/* 370 */
/* 371 */         if (scan_isNull22) {
/* 372 */           scan_rowWriter.setNullAt(22);
/* 373 */         } else {
/* 374 */           scan_rowWriter.write(22, scan_value22);
/* 375 */         }
/* 376 */
/* 377 */         if (scan_isNull23) {
/* 378 */           scan_rowWriter.setNullAt(23);
/* 379 */         } else {
/* 380 */           scan_rowWriter.write(23, scan_value23);
/* 381 */         }
/* 382 */
/* 383 */         if (scan_isNull24) {
/* 384 */           scan_rowWriter.setNullAt(24);
/* 385 */         } else {
/* 386 */           scan_rowWriter.write(24, scan_value24);
/* 387 */         }
/* 388 */
/* 389 */         if (scan_isNull25) {
/* 390 */           scan_rowWriter.setNullAt(25);
/* 391 */         } else {
/* 392 */           scan_rowWriter.write(25, scan_value25);
/* 393 */         }
/* 394 */
/* 395 */         if (scan_isNull26) {
/* 396 */           scan_rowWriter.setNullAt(26);
/* 397 */         } else {
/* 398 */           scan_rowWriter.write(26, scan_value26);
/* 399 */         }
/* 400 */
/* 401 */         if (scan_isNull27) {
/* 402 */           scan_rowWriter.setNullAt(27);
/* 403 */         } else {
/* 404 */           scan_rowWriter.write(27, scan_value27);
/* 405 */         }
/* 406 */
/* 407 */         if (scan_isNull28) {
/* 408 */           scan_rowWriter.setNullAt(28);
/* 409 */         } else {
/* 410 */           scan_rowWriter.write(28, scan_value28);
/* 411 */         }
/* 412 */
/* 413 */         if (scan_isNull29) {
/* 414 */           scan_rowWriter.setNullAt(29);
/* 415 */         } else {
/* 416 */           scan_rowWriter.write(29, scan_value29);
/* 417 */         }
/* 418 */
/* 419 */         if (scan_isNull30) {
/* 420 */           scan_rowWriter.setNullAt(30);
/* 421 */         } else {
/* 422 */           scan_rowWriter.write(30, scan_value30);
/* 423 */         }
/* 424 */
/* 425 */         if (scan_isNull31) {
/* 426 */           scan_rowWriter.setNullAt(31);
/* 427 */         } else {
/* 428 */           scan_rowWriter.write(31, scan_value31);
/* 429 */         }
/* 430 */
/* 431 */         if (scan_isNull32) {
/* 432 */           scan_rowWriter.setNullAt(32);
/* 433 */         } else {
/* 434 */           scan_rowWriter.write(32, scan_value32);
/* 435 */         }
/* 436 */
/* 437 */         if (scan_isNull33) {
/* 438 */           scan_rowWriter.setNullAt(33);
/* 439 */         } else {
/* 440 */           scan_rowWriter.write(33, scan_value33);
/* 441 */         }
/* 442 */         append(scan_result);
/* 443 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 444 */       }
/* 445 */       scan_batchIdx = scan_numRows;
/* 446 */       scan_batch = null;
/* 447 */       scan_nextBatch();
/* 448 */     }
/* 449 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 450 */     scan_scanTime1 = 0;
/* 451 */   }
/* 452 */ }
