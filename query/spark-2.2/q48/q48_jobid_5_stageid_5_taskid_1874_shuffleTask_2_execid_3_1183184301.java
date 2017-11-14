/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private scala.collection.Iterator scan_input;
/* 012 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 014 */   private long scan_scanTime1;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 016 */   private int scan_batchIdx;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 024 */   private UnsafeRow scan_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 035 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 037 */   private UnsafeRow bhj_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 040 */   private UnsafeRow project_result1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 043 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 044 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 046 */   private UnsafeRow bhj_result1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 049 */   private UnsafeRow project_result2;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 052 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 053 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 054 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 055 */   private UnsafeRow bhj_result2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 058 */   private UnsafeRow project_result3;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 061 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 062 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 064 */   private UnsafeRow bhj_result3;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 067 */   private UnsafeRow project_result4;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 070 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 072 */   private UnsafeRow agg_result;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 075 */
/* 076 */   public GeneratedIterator(Object[] references) {
/* 077 */     this.references = references;
/* 078 */   }
/* 079 */
/* 080 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 081 */     partitionIndex = index;
/* 082 */     this.inputs = inputs;
/* 083 */     wholestagecodegen_init_0();
/* 084 */     wholestagecodegen_init_1();
/* 085 */     wholestagecodegen_init_2();
/* 086 */     wholestagecodegen_init_3();
/* 087 */     wholestagecodegen_init_4();
/* 088 */
/* 089 */   }
/* 090 */
/* 091 */   private void wholestagecodegen_init_0() {
/* 092 */     agg_initAgg = false;
/* 093 */
/* 094 */     scan_input = inputs[0];
/* 095 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 096 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 097 */     scan_scanTime1 = 0;
/* 098 */     scan_batch = null;
/* 099 */     scan_batchIdx = 0;
/* 100 */     scan_colInstance0 = null;
/* 101 */     scan_colInstance1 = null;
/* 102 */     scan_colInstance2 = null;
/* 103 */     scan_colInstance3 = null;
/* 104 */     scan_colInstance4 = null;
/* 105 */     scan_colInstance5 = null;
/* 106 */     scan_colInstance6 = null;
/* 107 */     scan_result = new UnsafeRow(7);
/* 108 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 109 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 7);
/* 110 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 111 */     filter_result = new UnsafeRow(7);
/* 112 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 113 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 7);
/* 114 */
/* 115 */   }
/* 116 */
/* 117 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 118 */     // initialize aggregation buffer
/* 119 */     final long agg_value = -1L;
/* 120 */     agg_bufIsNull = true;
/* 121 */     agg_bufValue = agg_value;
/* 122 */
/* 123 */     if (scan_batch == null) {
/* 124 */       scan_nextBatch();
/* 125 */     }
/* 126 */     while (scan_batch != null) {
/* 127 */       int scan_numRows = scan_batch.numRows();
/* 128 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 129 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 130 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 131 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 132 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 133 */
/* 134 */         if (!(!(scan_isNull2))) continue;
/* 135 */
/* 136 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 137 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 138 */
/* 139 */         if (!(!(scan_isNull))) continue;
/* 140 */
/* 141 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 142 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 143 */
/* 144 */         if (!(!(scan_isNull1))) continue;
/* 145 */
/* 146 */         filter_numOutputRows.add(1);
/* 147 */
/* 148 */         // generate join key for stream side
/* 149 */
/* 150 */         boolean bhj_isNull = false;
/* 151 */         long bhj_value = -1L;
/* 152 */         if (!false) {
/* 153 */           bhj_value = (long) scan_value2;
/* 154 */         }
/* 155 */         // find matches from HashedRelation
/* 156 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 157 */         if (bhj_matched == null) continue;
/* 158 */
/* 159 */         bhj_numOutputRows.add(1);
/* 160 */
/* 161 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 162 */         double scan_value4 = scan_isNull4 ? -1.0 : (scan_colInstance4.getDouble(scan_rowIdx));
/* 163 */
/* 164 */         // generate join key for stream side
/* 165 */
/* 166 */         boolean bhj_isNull11 = false;
/* 167 */         long bhj_value11 = -1L;
/* 168 */         if (!false) {
/* 169 */           bhj_value11 = (long) scan_value;
/* 170 */         }
/* 171 */         // find matches from HashedRelation
/* 172 */         UnsafeRow bhj_matched1 = bhj_isNull11 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value11);
/* 173 */         if (bhj_matched1 == null) continue;
/* 174 */
/* 175 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(1);
/* 176 */         UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(1));
/* 177 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(2);
/* 178 */         UTF8String bhj_value15 = bhj_isNull15 ? null : (bhj_matched1.getUTF8String(2));
/* 179 */
/* 180 */         boolean bhj_isNull21 = true;
/* 181 */         boolean bhj_value21 = false;
/* 182 */
/* 183 */         if (!bhj_isNull14) {
/* 184 */           bhj_isNull21 = false; // resultCode could change nullability.
/* 185 */           bhj_value21 = bhj_value14.equals(((UTF8String) references[6]));
/* 186 */
/* 187 */         }
/* 188 */         boolean bhj_isNull20 = false;
/* 189 */         boolean bhj_value20 = false;
/* 190 */
/* 191 */         if (!bhj_isNull21 && !bhj_value21) {
/* 192 */         } else {
/* 193 */           boolean bhj_isNull24 = true;
/* 194 */           boolean bhj_value24 = false;
/* 195 */
/* 196 */           if (!bhj_isNull15) {
/* 197 */             bhj_isNull24 = false; // resultCode could change nullability.
/* 198 */             bhj_value24 = bhj_value15.equals(((UTF8String) references[7]));
/* 199 */
/* 200 */           }
/* 201 */           if (!bhj_isNull24 && !bhj_value24) {
/* 202 */           } else if (!bhj_isNull21 && !bhj_isNull24) {
/* 203 */             bhj_value20 = true;
/* 204 */           } else {
/* 205 */             bhj_isNull20 = true;
/* 206 */           }
/* 207 */         }
/* 208 */         boolean bhj_isNull19 = false;
/* 209 */         boolean bhj_value19 = false;
/* 210 */
/* 211 */         if (!bhj_isNull20 && !bhj_value20) {
/* 212 */         } else {
/* 213 */           boolean bhj_isNull27 = true;
/* 214 */           boolean bhj_value27 = false;
/* 215 */
/* 216 */           if (!scan_isNull4) {
/* 217 */             bhj_isNull27 = false; // resultCode could change nullability.
/* 218 */             bhj_value27 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value4, 100.0D) >= 0;
/* 219 */
/* 220 */           }
/* 221 */           if (!bhj_isNull27 && !bhj_value27) {
/* 222 */           } else if (!bhj_isNull20 && !bhj_isNull27) {
/* 223 */             bhj_value19 = true;
/* 224 */           } else {
/* 225 */             bhj_isNull19 = true;
/* 226 */           }
/* 227 */         }
/* 228 */         boolean bhj_isNull18 = false;
/* 229 */         boolean bhj_value18 = false;
/* 230 */
/* 231 */         if (!bhj_isNull19 && !bhj_value19) {
/* 232 */         } else {
/* 233 */           boolean bhj_isNull30 = true;
/* 234 */           boolean bhj_value30 = false;
/* 235 */
/* 236 */           if (!scan_isNull4) {
/* 237 */             bhj_isNull30 = false; // resultCode could change nullability.
/* 238 */             bhj_value30 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value4, 150.0D) <= 0;
/* 239 */
/* 240 */           }
/* 241 */           if (!bhj_isNull30 && !bhj_value30) {
/* 242 */           } else if (!bhj_isNull19 && !bhj_isNull30) {
/* 243 */             bhj_value18 = true;
/* 244 */           } else {
/* 245 */             bhj_isNull18 = true;
/* 246 */           }
/* 247 */         }
/* 248 */         boolean bhj_isNull17 = false;
/* 249 */         boolean bhj_value17 = true;
/* 250 */
/* 251 */         if (!bhj_isNull18 && bhj_value18) {
/* 252 */         } else {
/* 253 */           boolean bhj_isNull36 = true;
/* 254 */           boolean bhj_value36 = false;
/* 255 */
/* 256 */           if (!bhj_isNull14) {
/* 257 */             bhj_isNull36 = false; // resultCode could change nullability.
/* 258 */             bhj_value36 = bhj_value14.equals(((UTF8String) references[8]));
/* 259 */
/* 260 */           }
/* 261 */           boolean bhj_isNull35 = false;
/* 262 */           boolean bhj_value35 = false;
/* 263 */
/* 264 */           if (!bhj_isNull36 && !bhj_value36) {
/* 265 */           } else {
/* 266 */             boolean bhj_isNull39 = true;
/* 267 */             boolean bhj_value39 = false;
/* 268 */
/* 269 */             if (!bhj_isNull15) {
/* 270 */               bhj_isNull39 = false; // resultCode could change nullability.
/* 271 */               bhj_value39 = bhj_value15.equals(((UTF8String) references[9]));
/* 272 */
/* 273 */             }
/* 274 */             if (!bhj_isNull39 && !bhj_value39) {
/* 275 */             } else if (!bhj_isNull36 && !bhj_isNull39) {
/* 276 */               bhj_value35 = true;
/* 277 */             } else {
/* 278 */               bhj_isNull35 = true;
/* 279 */             }
/* 280 */           }
/* 281 */           boolean bhj_isNull34 = false;
/* 282 */           boolean bhj_value34 = false;
/* 283 */
/* 284 */           if (!bhj_isNull35 && !bhj_value35) {
/* 285 */           } else {
/* 286 */             boolean bhj_isNull42 = true;
/* 287 */             boolean bhj_value42 = false;
/* 288 */
/* 289 */             if (!scan_isNull4) {
/* 290 */               bhj_isNull42 = false; // resultCode could change nullability.
/* 291 */               bhj_value42 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value4, 50.0D) >= 0;
/* 292 */
/* 293 */             }
/* 294 */             if (!bhj_isNull42 && !bhj_value42) {
/* 295 */             } else if (!bhj_isNull35 && !bhj_isNull42) {
/* 296 */               bhj_value34 = true;
/* 297 */             } else {
/* 298 */               bhj_isNull34 = true;
/* 299 */             }
/* 300 */           }
/* 301 */           boolean bhj_isNull33 = false;
/* 302 */           boolean bhj_value33 = false;
/* 303 */
/* 304 */           if (!bhj_isNull34 && !bhj_value34) {
/* 305 */           } else {
/* 306 */             boolean bhj_isNull45 = true;
/* 307 */             boolean bhj_value45 = false;
/* 308 */
/* 309 */             if (!scan_isNull4) {
/* 310 */               bhj_isNull45 = false; // resultCode could change nullability.
/* 311 */               bhj_value45 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value4, 100.0D) <= 0;
/* 312 */
/* 313 */             }
/* 314 */             if (!bhj_isNull45 && !bhj_value45) {
/* 315 */             } else if (!bhj_isNull34 && !bhj_isNull45) {
/* 316 */               bhj_value33 = true;
/* 317 */             } else {
/* 318 */               bhj_isNull33 = true;
/* 319 */             }
/* 320 */           }
/* 321 */           if (!bhj_isNull33 && bhj_value33) {
/* 322 */           } else if (!bhj_isNull18 && !bhj_isNull33) {
/* 323 */             bhj_value17 = false;
/* 324 */           } else {
/* 325 */             bhj_isNull17 = true;
/* 326 */           }
/* 327 */         }
/* 328 */         boolean bhj_isNull16 = false;
/* 329 */         boolean bhj_value16 = true;
/* 330 */
/* 331 */         if (!bhj_isNull17 && bhj_value17) {
/* 332 */         } else {
/* 333 */           boolean bhj_isNull51 = true;
/* 334 */           boolean bhj_value51 = false;
/* 335 */
/* 336 */           if (!bhj_isNull14) {
/* 337 */             bhj_isNull51 = false; // resultCode could change nullability.
/* 338 */             bhj_value51 = bhj_value14.equals(((UTF8String) references[10]));
/* 339 */
/* 340 */           }
/* 341 */           boolean bhj_isNull50 = false;
/* 342 */           boolean bhj_value50 = false;
/* 343 */
/* 344 */           if (!bhj_isNull51 && !bhj_value51) {
/* 345 */           } else {
/* 346 */             boolean bhj_isNull54 = true;
/* 347 */             boolean bhj_value54 = false;
/* 348 */
/* 349 */             if (!bhj_isNull15) {
/* 350 */               bhj_isNull54 = false; // resultCode could change nullability.
/* 351 */               bhj_value54 = bhj_value15.equals(((UTF8String) references[11]));
/* 352 */
/* 353 */             }
/* 354 */             if (!bhj_isNull54 && !bhj_value54) {
/* 355 */             } else if (!bhj_isNull51 && !bhj_isNull54) {
/* 356 */               bhj_value50 = true;
/* 357 */             } else {
/* 358 */               bhj_isNull50 = true;
/* 359 */             }
/* 360 */           }
/* 361 */           boolean bhj_isNull49 = false;
/* 362 */           boolean bhj_value49 = false;
/* 363 */
/* 364 */           if (!bhj_isNull50 && !bhj_value50) {
/* 365 */           } else {
/* 366 */             boolean bhj_isNull57 = true;
/* 367 */             boolean bhj_value57 = false;
/* 368 */
/* 369 */             if (!scan_isNull4) {
/* 370 */               bhj_isNull57 = false; // resultCode could change nullability.
/* 371 */               bhj_value57 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value4, 150.0D) >= 0;
/* 372 */
/* 373 */             }
/* 374 */             if (!bhj_isNull57 && !bhj_value57) {
/* 375 */             } else if (!bhj_isNull50 && !bhj_isNull57) {
/* 376 */               bhj_value49 = true;
/* 377 */             } else {
/* 378 */               bhj_isNull49 = true;
/* 379 */             }
/* 380 */           }
/* 381 */           boolean bhj_isNull48 = false;
/* 382 */           boolean bhj_value48 = false;
/* 383 */
/* 384 */           if (!bhj_isNull49 && !bhj_value49) {
/* 385 */           } else {
/* 386 */             boolean bhj_isNull60 = true;
/* 387 */             boolean bhj_value60 = false;
/* 388 */
/* 389 */             if (!scan_isNull4) {
/* 390 */               bhj_isNull60 = false; // resultCode could change nullability.
/* 391 */               bhj_value60 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value4, 200.0D) <= 0;
/* 392 */
/* 393 */             }
/* 394 */             if (!bhj_isNull60 && !bhj_value60) {
/* 395 */             } else if (!bhj_isNull49 && !bhj_isNull60) {
/* 396 */               bhj_value48 = true;
/* 397 */             } else {
/* 398 */               bhj_isNull48 = true;
/* 399 */             }
/* 400 */           }
/* 401 */           if (!bhj_isNull48 && bhj_value48) {
/* 402 */           } else if (!bhj_isNull17 && !bhj_isNull48) {
/* 403 */             bhj_value16 = false;
/* 404 */           } else {
/* 405 */             bhj_isNull16 = true;
/* 406 */           }
/* 407 */         }
/* 408 */         if (bhj_isNull16 || !bhj_value16) continue;
/* 409 */
/* 410 */         bhj_numOutputRows1.add(1);
/* 411 */
/* 412 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 413 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 414 */
/* 415 */         // generate join key for stream side
/* 416 */
/* 417 */         boolean bhj_isNull72 = false;
/* 418 */         long bhj_value72 = -1L;
/* 419 */         if (!false) {
/* 420 */           bhj_value72 = (long) scan_value1;
/* 421 */         }
/* 422 */         // find matches from HashedRelation
/* 423 */         UnsafeRow bhj_matched2 = bhj_isNull72 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value72);
/* 424 */         if (bhj_matched2 == null) continue;
/* 425 */
/* 426 */         boolean bhj_isNull75 = bhj_matched2.isNullAt(1);
/* 427 */         UTF8String bhj_value75 = bhj_isNull75 ? null : (bhj_matched2.getUTF8String(1));
/* 428 */
/* 429 */         boolean bhj_value80 = false;
/* 430 */         boolean bhj_isNull80 = bhj_isNull75;
/* 431 */         if (!bhj_isNull80) {
/* 432 */           if (!bhj_value80) {
/* 433 */             if (false) {
/* 434 */               bhj_isNull80 = true;
/* 435 */             } else if (bhj_value75.equals(((UTF8String) references[14]))) {
/* 436 */               bhj_isNull80 = false;
/* 437 */               bhj_value80 = true;
/* 438 */             }
/* 439 */           }
/* 440 */
/* 441 */           if (!bhj_value80) {
/* 442 */             if (false) {
/* 443 */               bhj_isNull80 = true;
/* 444 */             } else if (bhj_value75.equals(((UTF8String) references[15]))) {
/* 445 */               bhj_isNull80 = false;
/* 446 */               bhj_value80 = true;
/* 447 */             }
/* 448 */           }
/* 449 */
/* 450 */           if (!bhj_value80) {
/* 451 */             if (false) {
/* 452 */               bhj_isNull80 = true;
/* 453 */             } else if (bhj_value75.equals(((UTF8String) references[16]))) {
/* 454 */               bhj_isNull80 = false;
/* 455 */               bhj_value80 = true;
/* 456 */             }
/* 457 */           }
/* 458 */
/* 459 */         }
/* 460 */         boolean bhj_isNull79 = false;
/* 461 */         boolean bhj_value79 = false;
/* 462 */
/* 463 */         if (!bhj_isNull80 && !bhj_value80) {
/* 464 */         } else {
/* 465 */           boolean bhj_isNull85 = true;
/* 466 */           boolean bhj_value85 = false;
/* 467 */
/* 468 */           if (!scan_isNull5) {
/* 469 */             bhj_isNull85 = false; // resultCode could change nullability.
/* 470 */             bhj_value85 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 0.0D) >= 0;
/* 471 */
/* 472 */           }
/* 473 */           if (!bhj_isNull85 && !bhj_value85) {
/* 474 */           } else if (!bhj_isNull80 && !bhj_isNull85) {
/* 475 */             bhj_value79 = true;
/* 476 */           } else {
/* 477 */             bhj_isNull79 = true;
/* 478 */           }
/* 479 */         }
/* 480 */         boolean bhj_isNull78 = false;
/* 481 */         boolean bhj_value78 = false;
/* 482 */
/* 483 */         if (!bhj_isNull79 && !bhj_value79) {
/* 484 */         } else {
/* 485 */           boolean bhj_isNull88 = true;
/* 486 */           boolean bhj_value88 = false;
/* 487 */
/* 488 */           if (!scan_isNull5) {
/* 489 */             bhj_isNull88 = false; // resultCode could change nullability.
/* 490 */             bhj_value88 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 2000.0D) <= 0;
/* 491 */
/* 492 */           }
/* 493 */           if (!bhj_isNull88 && !bhj_value88) {
/* 494 */           } else if (!bhj_isNull79 && !bhj_isNull88) {
/* 495 */             bhj_value78 = true;
/* 496 */           } else {
/* 497 */             bhj_isNull78 = true;
/* 498 */           }
/* 499 */         }
/* 500 */         boolean bhj_isNull77 = false;
/* 501 */         boolean bhj_value77 = true;
/* 502 */
/* 503 */         if (!bhj_isNull78 && bhj_value78) {
/* 504 */         } else {
/* 505 */           boolean bhj_value93 = false;
/* 506 */           boolean bhj_isNull93 = bhj_isNull75;
/* 507 */           if (!bhj_isNull93) {
/* 508 */             if (!bhj_value93) {
/* 509 */               if (false) {
/* 510 */                 bhj_isNull93 = true;
/* 511 */               } else if (bhj_value75.equals(((UTF8String) references[17]))) {
/* 512 */                 bhj_isNull93 = false;
/* 513 */                 bhj_value93 = true;
/* 514 */               }
/* 515 */             }
/* 516 */
/* 517 */             if (!bhj_value93) {
/* 518 */               if (false) {
/* 519 */                 bhj_isNull93 = true;
/* 520 */               } else if (bhj_value75.equals(((UTF8String) references[18]))) {
/* 521 */                 bhj_isNull93 = false;
/* 522 */                 bhj_value93 = true;
/* 523 */               }
/* 524 */             }
/* 525 */
/* 526 */             if (!bhj_value93) {
/* 527 */               if (false) {
/* 528 */                 bhj_isNull93 = true;
/* 529 */               } else if (bhj_value75.equals(((UTF8String) references[19]))) {
/* 530 */                 bhj_isNull93 = false;
/* 531 */                 bhj_value93 = true;
/* 532 */               }
/* 533 */             }
/* 534 */
/* 535 */           }
/* 536 */           boolean bhj_isNull92 = false;
/* 537 */           boolean bhj_value92 = false;
/* 538 */
/* 539 */           if (!bhj_isNull93 && !bhj_value93) {
/* 540 */           } else {
/* 541 */             boolean bhj_isNull98 = true;
/* 542 */             boolean bhj_value98 = false;
/* 543 */
/* 544 */             if (!scan_isNull5) {
/* 545 */               bhj_isNull98 = false; // resultCode could change nullability.
/* 546 */               bhj_value98 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 150.0D) >= 0;
/* 547 */
/* 548 */             }
/* 549 */             if (!bhj_isNull98 && !bhj_value98) {
/* 550 */             } else if (!bhj_isNull93 && !bhj_isNull98) {
/* 551 */               bhj_value92 = true;
/* 552 */             } else {
/* 553 */               bhj_isNull92 = true;
/* 554 */             }
/* 555 */           }
/* 556 */           boolean bhj_isNull91 = false;
/* 557 */           boolean bhj_value91 = false;
/* 558 */
/* 559 */           if (!bhj_isNull92 && !bhj_value92) {
/* 560 */           } else {
/* 561 */             boolean bhj_isNull101 = true;
/* 562 */             boolean bhj_value101 = false;
/* 563 */
/* 564 */             if (!scan_isNull5) {
/* 565 */               bhj_isNull101 = false; // resultCode could change nullability.
/* 566 */               bhj_value101 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 3000.0D) <= 0;
/* 567 */
/* 568 */             }
/* 569 */             if (!bhj_isNull101 && !bhj_value101) {
/* 570 */             } else if (!bhj_isNull92 && !bhj_isNull101) {
/* 571 */               bhj_value91 = true;
/* 572 */             } else {
/* 573 */               bhj_isNull91 = true;
/* 574 */             }
/* 575 */           }
/* 576 */           if (!bhj_isNull91 && bhj_value91) {
/* 577 */           } else if (!bhj_isNull78 && !bhj_isNull91) {
/* 578 */             bhj_value77 = false;
/* 579 */           } else {
/* 580 */             bhj_isNull77 = true;
/* 581 */           }
/* 582 */         }
/* 583 */         boolean bhj_isNull76 = false;
/* 584 */         boolean bhj_value76 = true;
/* 585 */
/* 586 */         if (!bhj_isNull77 && bhj_value77) {
/* 587 */         } else {
/* 588 */           boolean bhj_value106 = false;
/* 589 */           boolean bhj_isNull106 = bhj_isNull75;
/* 590 */           if (!bhj_isNull106) {
/* 591 */             if (!bhj_value106) {
/* 592 */               if (false) {
/* 593 */                 bhj_isNull106 = true;
/* 594 */               } else if (bhj_value75.equals(((UTF8String) references[20]))) {
/* 595 */                 bhj_isNull106 = false;
/* 596 */                 bhj_value106 = true;
/* 597 */               }
/* 598 */             }
/* 599 */
/* 600 */             if (!bhj_value106) {
/* 601 */               if (false) {
/* 602 */                 bhj_isNull106 = true;
/* 603 */               } else if (bhj_value75.equals(((UTF8String) references[21]))) {
/* 604 */                 bhj_isNull106 = false;
/* 605 */                 bhj_value106 = true;
/* 606 */               }
/* 607 */             }
/* 608 */
/* 609 */             if (!bhj_value106) {
/* 610 */               if (false) {
/* 611 */                 bhj_isNull106 = true;
/* 612 */               } else if (bhj_value75.equals(((UTF8String) references[22]))) {
/* 613 */                 bhj_isNull106 = false;
/* 614 */                 bhj_value106 = true;
/* 615 */               }
/* 616 */             }
/* 617 */
/* 618 */           }
/* 619 */           boolean bhj_isNull105 = false;
/* 620 */           boolean bhj_value105 = false;
/* 621 */
/* 622 */           if (!bhj_isNull106 && !bhj_value106) {
/* 623 */           } else {
/* 624 */             boolean bhj_isNull111 = true;
/* 625 */             boolean bhj_value111 = false;
/* 626 */
/* 627 */             if (!scan_isNull5) {
/* 628 */               bhj_isNull111 = false; // resultCode could change nullability.
/* 629 */               bhj_value111 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 50.0D) >= 0;
/* 630 */
/* 631 */             }
/* 632 */             if (!bhj_isNull111 && !bhj_value111) {
/* 633 */             } else if (!bhj_isNull106 && !bhj_isNull111) {
/* 634 */               bhj_value105 = true;
/* 635 */             } else {
/* 636 */               bhj_isNull105 = true;
/* 637 */             }
/* 638 */           }
/* 639 */           boolean bhj_isNull104 = false;
/* 640 */           boolean bhj_value104 = false;
/* 641 */
/* 642 */           if (!bhj_isNull105 && !bhj_value105) {
/* 643 */           } else {
/* 644 */             boolean bhj_isNull114 = true;
/* 645 */             boolean bhj_value114 = false;
/* 646 */
/* 647 */             if (!scan_isNull5) {
/* 648 */               bhj_isNull114 = false; // resultCode could change nullability.
/* 649 */               bhj_value114 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 25000.0D) <= 0;
/* 650 */
/* 651 */             }
/* 652 */             if (!bhj_isNull114 && !bhj_value114) {
/* 653 */             } else if (!bhj_isNull105 && !bhj_isNull114) {
/* 654 */               bhj_value104 = true;
/* 655 */             } else {
/* 656 */               bhj_isNull104 = true;
/* 657 */             }
/* 658 */           }
/* 659 */           if (!bhj_isNull104 && bhj_value104) {
/* 660 */           } else if (!bhj_isNull77 && !bhj_isNull104) {
/* 661 */             bhj_value76 = false;
/* 662 */           } else {
/* 663 */             bhj_isNull76 = true;
/* 664 */           }
/* 665 */         }
/* 666 */         if (bhj_isNull76 || !bhj_value76) continue;
/* 667 */
/* 668 */         bhj_numOutputRows2.add(1);
/* 669 */
/* 670 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 671 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 672 */
/* 673 */         // generate join key for stream side
/* 674 */
/* 675 */         boolean bhj_isNull123 = scan_isNull6;
/* 676 */         long bhj_value123 = -1L;
/* 677 */         if (!scan_isNull6) {
/* 678 */           bhj_value123 = (long) scan_value6;
/* 679 */         }
/* 680 */         // find matches from HashedRelation
/* 681 */         UnsafeRow bhj_matched3 = bhj_isNull123 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value123);
/* 682 */         if (bhj_matched3 == null) continue;
/* 683 */
/* 684 */         bhj_numOutputRows3.add(1);
/* 685 */
/* 686 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 687 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 688 */
/* 689 */         // do aggregate
/* 690 */         // common sub-expressions
/* 691 */
/* 692 */         // evaluate aggregate function
/* 693 */         boolean agg_isNull2 = true;
/* 694 */         long agg_value2 = -1L;
/* 695 */
/* 696 */         boolean agg_isNull3 = agg_bufIsNull;
/* 697 */         long agg_value3 = agg_bufValue;
/* 698 */         if (agg_isNull3) {
/* 699 */           boolean agg_isNull5 = false;
/* 700 */           long agg_value5 = -1L;
/* 701 */           if (!false) {
/* 702 */             agg_value5 = (long) 0;
/* 703 */           }
/* 704 */           if (!agg_isNull5) {
/* 705 */             agg_isNull3 = false;
/* 706 */             agg_value3 = agg_value5;
/* 707 */           }
/* 708 */         }
/* 709 */
/* 710 */         boolean agg_isNull7 = scan_isNull3;
/* 711 */         long agg_value7 = -1L;
/* 712 */         if (!scan_isNull3) {
/* 713 */           agg_value7 = (long) scan_value3;
/* 714 */         }
/* 715 */         if (!agg_isNull7) {
/* 716 */           agg_isNull2 = false; // resultCode could change nullability.
/* 717 */           agg_value2 = agg_value3 + agg_value7;
/* 718 */
/* 719 */         }
/* 720 */         boolean agg_isNull1 = agg_isNull2;
/* 721 */         long agg_value1 = agg_value2;
/* 722 */         if (agg_isNull1) {
/* 723 */           if (!agg_bufIsNull) {
/* 724 */             agg_isNull1 = false;
/* 725 */             agg_value1 = agg_bufValue;
/* 726 */           }
/* 727 */         }
/* 728 */         // update aggregation buffer
/* 729 */         agg_bufIsNull = agg_isNull1;
/* 730 */         agg_bufValue = agg_value1;
/* 731 */         // shouldStop check is eliminated
/* 732 */       }
/* 733 */       scan_batchIdx = scan_numRows;
/* 734 */       scan_batch = null;
/* 735 */       scan_nextBatch();
/* 736 */     }
/* 737 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 738 */     scan_scanTime1 = 0;
/* 739 */
/* 740 */   }
/* 741 */
/* 742 */   private void wholestagecodegen_init_3() {
/* 743 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 744 */     bhj_result2 = new UnsafeRow(6);
/* 745 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 746 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 6);
/* 747 */     project_result3 = new UnsafeRow(2);
/* 748 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 749 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 2);
/* 750 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[24];
/* 751 */
/* 752 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 753 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 754 */
/* 755 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[25];
/* 756 */     bhj_result3 = new UnsafeRow(3);
/* 757 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 0);
/* 758 */
/* 759 */   }
/* 760 */
/* 761 */   private void scan_nextBatch() throws java.io.IOException {
/* 762 */     long getBatchStart = System.nanoTime();
/* 763 */     if (scan_input.hasNext()) {
/* 764 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 765 */       scan_numOutputRows.add(scan_batch.numRows());
/* 766 */       scan_batchIdx = 0;
/* 767 */       scan_colInstance0 = scan_batch.column(0);
/* 768 */       scan_colInstance1 = scan_batch.column(1);
/* 769 */       scan_colInstance2 = scan_batch.column(2);
/* 770 */       scan_colInstance3 = scan_batch.column(3);
/* 771 */       scan_colInstance4 = scan_batch.column(4);
/* 772 */       scan_colInstance5 = scan_batch.column(5);
/* 773 */       scan_colInstance6 = scan_batch.column(6);
/* 774 */
/* 775 */     }
/* 776 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 777 */   }
/* 778 */
/* 779 */   private void wholestagecodegen_init_2() {
/* 780 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 781 */
/* 782 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 783 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 784 */
/* 785 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 786 */     bhj_result1 = new UnsafeRow(9);
/* 787 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 788 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 789 */     project_result2 = new UnsafeRow(4);
/* 790 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 791 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 792 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 793 */
/* 794 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 795 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 796 */
/* 797 */   }
/* 798 */
/* 799 */   private void wholestagecodegen_init_1() {
/* 800 */     project_result = new UnsafeRow(7);
/* 801 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 802 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 803 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 804 */
/* 805 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 806 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 807 */
/* 808 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 809 */     bhj_result = new UnsafeRow(8);
/* 810 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 811 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 812 */     project_result1 = new UnsafeRow(6);
/* 813 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 814 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 815 */
/* 816 */   }
/* 817 */
/* 818 */   private void wholestagecodegen_init_4() {
/* 819 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 3);
/* 820 */     project_result4 = new UnsafeRow(1);
/* 821 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 0);
/* 822 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 1);
/* 823 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[26];
/* 824 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[27];
/* 825 */     agg_result = new UnsafeRow(1);
/* 826 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 827 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 828 */
/* 829 */   }
/* 830 */
/* 831 */   protected void processNext() throws java.io.IOException {
/* 832 */     while (!agg_initAgg) {
/* 833 */       agg_initAgg = true;
/* 834 */       long agg_beforeAgg = System.nanoTime();
/* 835 */       agg_doAggregateWithoutKey();
/* 836 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 837 */
/* 838 */       // output the result
/* 839 */
/* 840 */       agg_numOutputRows.add(1);
/* 841 */       agg_rowWriter.zeroOutNullBytes();
/* 842 */
/* 843 */       if (agg_bufIsNull) {
/* 844 */         agg_rowWriter.setNullAt(0);
/* 845 */       } else {
/* 846 */         agg_rowWriter.write(0, agg_bufValue);
/* 847 */       }
/* 848 */       append(agg_result);
/* 849 */     }
/* 850 */   }
/* 851 */ }
