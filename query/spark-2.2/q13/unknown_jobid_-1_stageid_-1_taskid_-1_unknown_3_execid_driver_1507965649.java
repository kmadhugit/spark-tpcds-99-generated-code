/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private scala.collection.Iterator scan_input;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 026 */   private long scan_scanTime1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 028 */   private int scan_batchIdx;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 039 */   private UnsafeRow scan_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 043 */   private UnsafeRow filter_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 046 */   private UnsafeRow project_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 049 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 050 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 052 */   private UnsafeRow bhj_result;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 055 */   private UnsafeRow project_result1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 058 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 059 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 060 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 061 */   private UnsafeRow bhj_result1;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 064 */   private UnsafeRow project_result2;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 067 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 068 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 069 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 070 */   private UnsafeRow bhj_result2;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 073 */   private UnsafeRow project_result3;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 076 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 077 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 078 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 079 */   private UnsafeRow bhj_result3;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 081 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 082 */   private UnsafeRow project_result4;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 084 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 085 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 086 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 087 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 088 */   private UnsafeRow bhj_result4;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 090 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 091 */   private UnsafeRow project_result5;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 093 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 094 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 095 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 096 */   private UnsafeRow agg_result;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 099 */
/* 100 */   public GeneratedIterator(Object[] references) {
/* 101 */     this.references = references;
/* 102 */   }
/* 103 */
/* 104 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 105 */     partitionIndex = index;
/* 106 */     this.inputs = inputs;
/* 107 */     wholestagecodegen_init_0();
/* 108 */     wholestagecodegen_init_1();
/* 109 */     wholestagecodegen_init_2();
/* 110 */     wholestagecodegen_init_3();
/* 111 */     wholestagecodegen_init_4();
/* 112 */     wholestagecodegen_init_5();
/* 113 */
/* 114 */   }
/* 115 */
/* 116 */   private void wholestagecodegen_init_0() {
/* 117 */     agg_initAgg = false;
/* 118 */
/* 119 */     scan_input = inputs[0];
/* 120 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 121 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 122 */     scan_scanTime1 = 0;
/* 123 */     scan_batch = null;
/* 124 */     scan_batchIdx = 0;
/* 125 */     scan_colInstance0 = null;
/* 126 */     scan_colInstance1 = null;
/* 127 */     scan_colInstance2 = null;
/* 128 */     scan_colInstance3 = null;
/* 129 */     scan_colInstance4 = null;
/* 130 */     scan_colInstance5 = null;
/* 131 */     scan_colInstance6 = null;
/* 132 */     scan_colInstance7 = null;
/* 133 */     scan_colInstance8 = null;
/* 134 */     scan_colInstance9 = null;
/* 135 */     scan_result = new UnsafeRow(10);
/* 136 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 137 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 10);
/* 138 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 139 */     filter_result = new UnsafeRow(10);
/* 140 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 141 */
/* 142 */   }
/* 143 */
/* 144 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 145 */     // initialize aggregation buffer
/* 146 */     boolean agg_isNull = false;
/* 147 */     double agg_value = -1.0;
/* 148 */     if (!false) {
/* 149 */       agg_value = (double) 0;
/* 150 */     }
/* 151 */     agg_bufIsNull = agg_isNull;
/* 152 */     agg_bufValue = agg_value;
/* 153 */     agg_bufIsNull1 = false;
/* 154 */     agg_bufValue1 = 0L;
/* 155 */     boolean agg_isNull3 = false;
/* 156 */     double agg_value3 = -1.0;
/* 157 */     if (!false) {
/* 158 */       agg_value3 = (double) 0;
/* 159 */     }
/* 160 */     agg_bufIsNull2 = agg_isNull3;
/* 161 */     agg_bufValue2 = agg_value3;
/* 162 */     agg_bufIsNull3 = false;
/* 163 */     agg_bufValue3 = 0L;
/* 164 */     boolean agg_isNull6 = false;
/* 165 */     double agg_value6 = -1.0;
/* 166 */     if (!false) {
/* 167 */       agg_value6 = (double) 0;
/* 168 */     }
/* 169 */     agg_bufIsNull4 = agg_isNull6;
/* 170 */     agg_bufValue4 = agg_value6;
/* 171 */     agg_bufIsNull5 = false;
/* 172 */     agg_bufValue5 = 0L;
/* 173 */     final double agg_value9 = -1.0;
/* 174 */     agg_bufIsNull6 = true;
/* 175 */     agg_bufValue6 = agg_value9;
/* 176 */
/* 177 */     if (scan_batch == null) {
/* 178 */       scan_nextBatch();
/* 179 */     }
/* 180 */     while (scan_batch != null) {
/* 181 */       int scan_numRows = scan_batch.numRows();
/* 182 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 183 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 184 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 185 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 186 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 187 */
/* 188 */         if (!(!(scan_isNull3))) continue;
/* 189 */
/* 190 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 191 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 192 */
/* 193 */         if (!(!(scan_isNull2))) continue;
/* 194 */
/* 195 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 196 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 197 */
/* 198 */         if (!(!(scan_isNull))) continue;
/* 199 */
/* 200 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 201 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 202 */
/* 203 */         if (!(!(scan_isNull1))) continue;
/* 204 */
/* 205 */         filter_numOutputRows.add(1);
/* 206 */
/* 207 */         // generate join key for stream side
/* 208 */
/* 209 */         boolean bhj_isNull = false;
/* 210 */         long bhj_value = -1L;
/* 211 */         if (!false) {
/* 212 */           bhj_value = (long) scan_value3;
/* 213 */         }
/* 214 */         // find matches from HashedRelation
/* 215 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 216 */         if (bhj_matched == null) continue;
/* 217 */
/* 218 */         bhj_numOutputRows.add(1);
/* 219 */
/* 220 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 221 */         double scan_value8 = scan_isNull8 ? -1.0 : (scan_colInstance8.getDouble(scan_rowIdx));
/* 222 */
/* 223 */         // generate join key for stream side
/* 224 */
/* 225 */         boolean bhj_isNull14 = false;
/* 226 */         long bhj_value14 = -1L;
/* 227 */         if (!false) {
/* 228 */           bhj_value14 = (long) scan_value2;
/* 229 */         }
/* 230 */         // find matches from HashedRelation
/* 231 */         UnsafeRow bhj_matched1 = bhj_isNull14 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value14);
/* 232 */         if (bhj_matched1 == null) continue;
/* 233 */
/* 234 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(1);
/* 235 */         UTF8String bhj_value17 = bhj_isNull17 ? null : (bhj_matched1.getUTF8String(1));
/* 236 */
/* 237 */         boolean bhj_value22 = false;
/* 238 */         boolean bhj_isNull22 = bhj_isNull17;
/* 239 */         if (!bhj_isNull22) {
/* 240 */           if (!bhj_value22) {
/* 241 */             if (false) {
/* 242 */               bhj_isNull22 = true;
/* 243 */             } else if (bhj_value17.equals(((UTF8String) references[6]))) {
/* 244 */               bhj_isNull22 = false;
/* 245 */               bhj_value22 = true;
/* 246 */             }
/* 247 */           }
/* 248 */
/* 249 */           if (!bhj_value22) {
/* 250 */             if (false) {
/* 251 */               bhj_isNull22 = true;
/* 252 */             } else if (bhj_value17.equals(((UTF8String) references[7]))) {
/* 253 */               bhj_isNull22 = false;
/* 254 */               bhj_value22 = true;
/* 255 */             }
/* 256 */           }
/* 257 */
/* 258 */         }
/* 259 */         boolean bhj_isNull21 = false;
/* 260 */         boolean bhj_value21 = false;
/* 261 */
/* 262 */         if (!bhj_isNull22 && !bhj_value22) {
/* 263 */         } else {
/* 264 */           boolean bhj_isNull26 = true;
/* 265 */           boolean bhj_value26 = false;
/* 266 */
/* 267 */           if (!scan_isNull8) {
/* 268 */             bhj_isNull26 = false; // resultCode could change nullability.
/* 269 */             bhj_value26 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value8, 100.0D) >= 0;
/* 270 */
/* 271 */           }
/* 272 */           if (!bhj_isNull26 && !bhj_value26) {
/* 273 */           } else if (!bhj_isNull22 && !bhj_isNull26) {
/* 274 */             bhj_value21 = true;
/* 275 */           } else {
/* 276 */             bhj_isNull21 = true;
/* 277 */           }
/* 278 */         }
/* 279 */         boolean bhj_isNull20 = false;
/* 280 */         boolean bhj_value20 = false;
/* 281 */
/* 282 */         if (!bhj_isNull21 && !bhj_value21) {
/* 283 */         } else {
/* 284 */           boolean bhj_isNull29 = true;
/* 285 */           boolean bhj_value29 = false;
/* 286 */
/* 287 */           if (!scan_isNull8) {
/* 288 */             bhj_isNull29 = false; // resultCode could change nullability.
/* 289 */             bhj_value29 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value8, 200.0D) <= 0;
/* 290 */
/* 291 */           }
/* 292 */           if (!bhj_isNull29 && !bhj_value29) {
/* 293 */           } else if (!bhj_isNull21 && !bhj_isNull29) {
/* 294 */             bhj_value20 = true;
/* 295 */           } else {
/* 296 */             bhj_isNull20 = true;
/* 297 */           }
/* 298 */         }
/* 299 */         boolean bhj_isNull19 = false;
/* 300 */         boolean bhj_value19 = true;
/* 301 */
/* 302 */         if (!bhj_isNull20 && bhj_value20) {
/* 303 */         } else {
/* 304 */           boolean bhj_value34 = false;
/* 305 */           boolean bhj_isNull34 = bhj_isNull17;
/* 306 */           if (!bhj_isNull34) {
/* 307 */             if (!bhj_value34) {
/* 308 */               if (false) {
/* 309 */                 bhj_isNull34 = true;
/* 310 */               } else if (bhj_value17.equals(((UTF8String) references[8]))) {
/* 311 */                 bhj_isNull34 = false;
/* 312 */                 bhj_value34 = true;
/* 313 */               }
/* 314 */             }
/* 315 */
/* 316 */             if (!bhj_value34) {
/* 317 */               if (false) {
/* 318 */                 bhj_isNull34 = true;
/* 319 */               } else if (bhj_value17.equals(((UTF8String) references[9]))) {
/* 320 */                 bhj_isNull34 = false;
/* 321 */                 bhj_value34 = true;
/* 322 */               }
/* 323 */             }
/* 324 */
/* 325 */             if (!bhj_value34) {
/* 326 */               if (false) {
/* 327 */                 bhj_isNull34 = true;
/* 328 */               } else if (bhj_value17.equals(((UTF8String) references[10]))) {
/* 329 */                 bhj_isNull34 = false;
/* 330 */                 bhj_value34 = true;
/* 331 */               }
/* 332 */             }
/* 333 */
/* 334 */           }
/* 335 */           boolean bhj_isNull33 = false;
/* 336 */           boolean bhj_value33 = false;
/* 337 */
/* 338 */           if (!bhj_isNull34 && !bhj_value34) {
/* 339 */           } else {
/* 340 */             boolean bhj_isNull39 = true;
/* 341 */             boolean bhj_value39 = false;
/* 342 */
/* 343 */             if (!scan_isNull8) {
/* 344 */               bhj_isNull39 = false; // resultCode could change nullability.
/* 345 */               bhj_value39 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value8, 150.0D) >= 0;
/* 346 */
/* 347 */             }
/* 348 */             if (!bhj_isNull39 && !bhj_value39) {
/* 349 */             } else if (!bhj_isNull34 && !bhj_isNull39) {
/* 350 */               bhj_value33 = true;
/* 351 */             } else {
/* 352 */               bhj_isNull33 = true;
/* 353 */             }
/* 354 */           }
/* 355 */           boolean bhj_isNull32 = false;
/* 356 */           boolean bhj_value32 = false;
/* 357 */
/* 358 */           if (!bhj_isNull33 && !bhj_value33) {
/* 359 */           } else {
/* 360 */             boolean bhj_isNull42 = true;
/* 361 */             boolean bhj_value42 = false;
/* 362 */
/* 363 */             if (!scan_isNull8) {
/* 364 */               bhj_isNull42 = false; // resultCode could change nullability.
/* 365 */               bhj_value42 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value8, 300.0D) <= 0;
/* 366 */
/* 367 */             }
/* 368 */             if (!bhj_isNull42 && !bhj_value42) {
/* 369 */             } else if (!bhj_isNull33 && !bhj_isNull42) {
/* 370 */               bhj_value32 = true;
/* 371 */             } else {
/* 372 */               bhj_isNull32 = true;
/* 373 */             }
/* 374 */           }
/* 375 */           if (!bhj_isNull32 && bhj_value32) {
/* 376 */           } else if (!bhj_isNull20 && !bhj_isNull32) {
/* 377 */             bhj_value19 = false;
/* 378 */           } else {
/* 379 */             bhj_isNull19 = true;
/* 380 */           }
/* 381 */         }
/* 382 */         boolean bhj_isNull18 = false;
/* 383 */         boolean bhj_value18 = true;
/* 384 */
/* 385 */         if (!bhj_isNull19 && bhj_value19) {
/* 386 */         } else {
/* 387 */           boolean bhj_value47 = false;
/* 388 */           boolean bhj_isNull47 = bhj_isNull17;
/* 389 */           if (!bhj_isNull47) {
/* 390 */             if (!bhj_value47) {
/* 391 */               if (false) {
/* 392 */                 bhj_isNull47 = true;
/* 393 */               } else if (bhj_value17.equals(((UTF8String) references[11]))) {
/* 394 */                 bhj_isNull47 = false;
/* 395 */                 bhj_value47 = true;
/* 396 */               }
/* 397 */             }
/* 398 */
/* 399 */             if (!bhj_value47) {
/* 400 */               if (false) {
/* 401 */                 bhj_isNull47 = true;
/* 402 */               } else if (bhj_value17.equals(((UTF8String) references[12]))) {
/* 403 */                 bhj_isNull47 = false;
/* 404 */                 bhj_value47 = true;
/* 405 */               }
/* 406 */             }
/* 407 */
/* 408 */             if (!bhj_value47) {
/* 409 */               if (false) {
/* 410 */                 bhj_isNull47 = true;
/* 411 */               } else if (bhj_value17.equals(((UTF8String) references[13]))) {
/* 412 */                 bhj_isNull47 = false;
/* 413 */                 bhj_value47 = true;
/* 414 */               }
/* 415 */             }
/* 416 */
/* 417 */           }
/* 418 */           boolean bhj_isNull46 = false;
/* 419 */           boolean bhj_value46 = false;
/* 420 */
/* 421 */           if (!bhj_isNull47 && !bhj_value47) {
/* 422 */           } else {
/* 423 */             boolean bhj_isNull52 = true;
/* 424 */             boolean bhj_value52 = false;
/* 425 */
/* 426 */             if (!scan_isNull8) {
/* 427 */               bhj_isNull52 = false; // resultCode could change nullability.
/* 428 */               bhj_value52 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value8, 50.0D) >= 0;
/* 429 */
/* 430 */             }
/* 431 */             if (!bhj_isNull52 && !bhj_value52) {
/* 432 */             } else if (!bhj_isNull47 && !bhj_isNull52) {
/* 433 */               bhj_value46 = true;
/* 434 */             } else {
/* 435 */               bhj_isNull46 = true;
/* 436 */             }
/* 437 */           }
/* 438 */           boolean bhj_isNull45 = false;
/* 439 */           boolean bhj_value45 = false;
/* 440 */
/* 441 */           if (!bhj_isNull46 && !bhj_value46) {
/* 442 */           } else {
/* 443 */             boolean bhj_isNull55 = true;
/* 444 */             boolean bhj_value55 = false;
/* 445 */
/* 446 */             if (!scan_isNull8) {
/* 447 */               bhj_isNull55 = false; // resultCode could change nullability.
/* 448 */               bhj_value55 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value8, 250.0D) <= 0;
/* 449 */
/* 450 */             }
/* 451 */             if (!bhj_isNull55 && !bhj_value55) {
/* 452 */             } else if (!bhj_isNull46 && !bhj_isNull55) {
/* 453 */               bhj_value45 = true;
/* 454 */             } else {
/* 455 */               bhj_isNull45 = true;
/* 456 */             }
/* 457 */           }
/* 458 */           if (!bhj_isNull45 && bhj_value45) {
/* 459 */           } else if (!bhj_isNull19 && !bhj_isNull45) {
/* 460 */             bhj_value18 = false;
/* 461 */           } else {
/* 462 */             bhj_isNull18 = true;
/* 463 */           }
/* 464 */         }
/* 465 */         if (bhj_isNull18 || !bhj_value18) continue;
/* 466 */
/* 467 */         bhj_numOutputRows1.add(1);
/* 468 */
/* 469 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 470 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 471 */
/* 472 */         // generate join key for stream side
/* 473 */
/* 474 */         boolean bhj_isNull69 = scan_isNull9;
/* 475 */         long bhj_value69 = -1L;
/* 476 */         if (!scan_isNull9) {
/* 477 */           bhj_value69 = (long) scan_value9;
/* 478 */         }
/* 479 */         // find matches from HashedRelation
/* 480 */         UnsafeRow bhj_matched2 = bhj_isNull69 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value69);
/* 481 */         if (bhj_matched2 == null) continue;
/* 482 */
/* 483 */         bhj_numOutputRows2.add(1);
/* 484 */
/* 485 */         // generate join key for stream side
/* 486 */
/* 487 */         boolean bhj_isNull80 = false;
/* 488 */         long bhj_value80 = -1L;
/* 489 */         if (!false) {
/* 490 */           bhj_value80 = (long) scan_value;
/* 491 */         }
/* 492 */         // find matches from HashedRelation
/* 493 */         UnsafeRow bhj_matched3 = bhj_isNull80 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value80);
/* 494 */         if (bhj_matched3 == null) continue;
/* 495 */
/* 496 */         bhj_numOutputRows3.add(1);
/* 497 */
/* 498 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 499 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 500 */         boolean bhj_isNull83 = bhj_matched3.isNullAt(1);
/* 501 */         UTF8String bhj_value83 = bhj_isNull83 ? null : (bhj_matched3.getUTF8String(1));
/* 502 */         boolean bhj_isNull84 = bhj_matched3.isNullAt(2);
/* 503 */         UTF8String bhj_value84 = bhj_isNull84 ? null : (bhj_matched3.getUTF8String(2));
/* 504 */
/* 505 */         // generate join key for stream side
/* 506 */
/* 507 */         boolean bhj_isNull94 = false;
/* 508 */         long bhj_value94 = -1L;
/* 509 */         if (!false) {
/* 510 */           bhj_value94 = (long) scan_value1;
/* 511 */         }
/* 512 */         // find matches from HashedRelation
/* 513 */         UnsafeRow bhj_matched4 = bhj_isNull94 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value94);
/* 514 */         if (bhj_matched4 == null) continue;
/* 515 */
/* 516 */         boolean bhj_isNull97 = bhj_matched4.isNullAt(1);
/* 517 */         int bhj_value97 = bhj_isNull97 ? -1 : (bhj_matched4.getInt(1));
/* 518 */
/* 519 */         boolean bhj_isNull104 = true;
/* 520 */         boolean bhj_value104 = false;
/* 521 */
/* 522 */         if (!bhj_isNull83) {
/* 523 */           bhj_isNull104 = false; // resultCode could change nullability.
/* 524 */           bhj_value104 = bhj_value83.equals(((UTF8String) references[20]));
/* 525 */
/* 526 */         }
/* 527 */         boolean bhj_isNull103 = false;
/* 528 */         boolean bhj_value103 = false;
/* 529 */
/* 530 */         if (!bhj_isNull104 && !bhj_value104) {
/* 531 */         } else {
/* 532 */           boolean bhj_isNull107 = true;
/* 533 */           boolean bhj_value107 = false;
/* 534 */
/* 535 */           if (!bhj_isNull84) {
/* 536 */             bhj_isNull107 = false; // resultCode could change nullability.
/* 537 */             bhj_value107 = bhj_value84.equals(((UTF8String) references[21]));
/* 538 */
/* 539 */           }
/* 540 */           if (!bhj_isNull107 && !bhj_value107) {
/* 541 */           } else if (!bhj_isNull104 && !bhj_isNull107) {
/* 542 */             bhj_value103 = true;
/* 543 */           } else {
/* 544 */             bhj_isNull103 = true;
/* 545 */           }
/* 546 */         }
/* 547 */         boolean bhj_isNull102 = false;
/* 548 */         boolean bhj_value102 = false;
/* 549 */
/* 550 */         if (!bhj_isNull103 && !bhj_value103) {
/* 551 */         } else {
/* 552 */           boolean bhj_isNull110 = true;
/* 553 */           boolean bhj_value110 = false;
/* 554 */
/* 555 */           if (!scan_isNull5) {
/* 556 */             bhj_isNull110 = false; // resultCode could change nullability.
/* 557 */             bhj_value110 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 100.0D) >= 0;
/* 558 */
/* 559 */           }
/* 560 */           if (!bhj_isNull110 && !bhj_value110) {
/* 561 */           } else if (!bhj_isNull103 && !bhj_isNull110) {
/* 562 */             bhj_value102 = true;
/* 563 */           } else {
/* 564 */             bhj_isNull102 = true;
/* 565 */           }
/* 566 */         }
/* 567 */         boolean bhj_isNull101 = false;
/* 568 */         boolean bhj_value101 = false;
/* 569 */
/* 570 */         if (!bhj_isNull102 && !bhj_value102) {
/* 571 */         } else {
/* 572 */           boolean bhj_isNull113 = true;
/* 573 */           boolean bhj_value113 = false;
/* 574 */
/* 575 */           if (!scan_isNull5) {
/* 576 */             bhj_isNull113 = false; // resultCode could change nullability.
/* 577 */             bhj_value113 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 150.0D) <= 0;
/* 578 */
/* 579 */           }
/* 580 */           if (!bhj_isNull113 && !bhj_value113) {
/* 581 */           } else if (!bhj_isNull102 && !bhj_isNull113) {
/* 582 */             bhj_value101 = true;
/* 583 */           } else {
/* 584 */             bhj_isNull101 = true;
/* 585 */           }
/* 586 */         }
/* 587 */         boolean bhj_isNull100 = false;
/* 588 */         boolean bhj_value100 = false;
/* 589 */
/* 590 */         if (!bhj_isNull101 && !bhj_value101) {
/* 591 */         } else {
/* 592 */           boolean bhj_isNull116 = true;
/* 593 */           boolean bhj_value116 = false;
/* 594 */
/* 595 */           if (!bhj_isNull97) {
/* 596 */             bhj_isNull116 = false; // resultCode could change nullability.
/* 597 */             bhj_value116 = bhj_value97 == 3;
/* 598 */
/* 599 */           }
/* 600 */           if (!bhj_isNull116 && !bhj_value116) {
/* 601 */           } else if (!bhj_isNull101 && !bhj_isNull116) {
/* 602 */             bhj_value100 = true;
/* 603 */           } else {
/* 604 */             bhj_isNull100 = true;
/* 605 */           }
/* 606 */         }
/* 607 */         boolean bhj_isNull99 = false;
/* 608 */         boolean bhj_value99 = true;
/* 609 */
/* 610 */         if (!bhj_isNull100 && bhj_value100) {
/* 611 */         } else {
/* 612 */           boolean bhj_isNull123 = true;
/* 613 */           boolean bhj_value123 = false;
/* 614 */
/* 615 */           if (!bhj_isNull83) {
/* 616 */             bhj_isNull123 = false; // resultCode could change nullability.
/* 617 */             bhj_value123 = bhj_value83.equals(((UTF8String) references[22]));
/* 618 */
/* 619 */           }
/* 620 */           boolean bhj_isNull122 = false;
/* 621 */           boolean bhj_value122 = false;
/* 622 */
/* 623 */           if (!bhj_isNull123 && !bhj_value123) {
/* 624 */           } else {
/* 625 */             boolean bhj_isNull126 = true;
/* 626 */             boolean bhj_value126 = false;
/* 627 */
/* 628 */             if (!bhj_isNull84) {
/* 629 */               bhj_isNull126 = false; // resultCode could change nullability.
/* 630 */               bhj_value126 = bhj_value84.equals(((UTF8String) references[23]));
/* 631 */
/* 632 */             }
/* 633 */             if (!bhj_isNull126 && !bhj_value126) {
/* 634 */             } else if (!bhj_isNull123 && !bhj_isNull126) {
/* 635 */               bhj_value122 = true;
/* 636 */             } else {
/* 637 */               bhj_isNull122 = true;
/* 638 */             }
/* 639 */           }
/* 640 */           boolean bhj_isNull121 = false;
/* 641 */           boolean bhj_value121 = false;
/* 642 */
/* 643 */           if (!bhj_isNull122 && !bhj_value122) {
/* 644 */           } else {
/* 645 */             boolean bhj_isNull129 = true;
/* 646 */             boolean bhj_value129 = false;
/* 647 */
/* 648 */             if (!scan_isNull5) {
/* 649 */               bhj_isNull129 = false; // resultCode could change nullability.
/* 650 */               bhj_value129 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 50.0D) >= 0;
/* 651 */
/* 652 */             }
/* 653 */             if (!bhj_isNull129 && !bhj_value129) {
/* 654 */             } else if (!bhj_isNull122 && !bhj_isNull129) {
/* 655 */               bhj_value121 = true;
/* 656 */             } else {
/* 657 */               bhj_isNull121 = true;
/* 658 */             }
/* 659 */           }
/* 660 */           boolean bhj_isNull120 = false;
/* 661 */           boolean bhj_value120 = false;
/* 662 */
/* 663 */           if (!bhj_isNull121 && !bhj_value121) {
/* 664 */           } else {
/* 665 */             boolean bhj_isNull132 = true;
/* 666 */             boolean bhj_value132 = false;
/* 667 */
/* 668 */             if (!scan_isNull5) {
/* 669 */               bhj_isNull132 = false; // resultCode could change nullability.
/* 670 */               bhj_value132 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 100.0D) <= 0;
/* 671 */
/* 672 */             }
/* 673 */             if (!bhj_isNull132 && !bhj_value132) {
/* 674 */             } else if (!bhj_isNull121 && !bhj_isNull132) {
/* 675 */               bhj_value120 = true;
/* 676 */             } else {
/* 677 */               bhj_isNull120 = true;
/* 678 */             }
/* 679 */           }
/* 680 */           boolean bhj_isNull119 = false;
/* 681 */           boolean bhj_value119 = false;
/* 682 */
/* 683 */           if (!bhj_isNull120 && !bhj_value120) {
/* 684 */           } else {
/* 685 */             boolean bhj_isNull135 = true;
/* 686 */             boolean bhj_value135 = false;
/* 687 */
/* 688 */             if (!bhj_isNull97) {
/* 689 */               bhj_isNull135 = false; // resultCode could change nullability.
/* 690 */               bhj_value135 = bhj_value97 == 1;
/* 691 */
/* 692 */             }
/* 693 */             if (!bhj_isNull135 && !bhj_value135) {
/* 694 */             } else if (!bhj_isNull120 && !bhj_isNull135) {
/* 695 */               bhj_value119 = true;
/* 696 */             } else {
/* 697 */               bhj_isNull119 = true;
/* 698 */             }
/* 699 */           }
/* 700 */           if (!bhj_isNull119 && bhj_value119) {
/* 701 */           } else if (!bhj_isNull100 && !bhj_isNull119) {
/* 702 */             bhj_value99 = false;
/* 703 */           } else {
/* 704 */             bhj_isNull99 = true;
/* 705 */           }
/* 706 */         }
/* 707 */         boolean bhj_isNull98 = false;
/* 708 */         boolean bhj_value98 = true;
/* 709 */
/* 710 */         if (!bhj_isNull99 && bhj_value99) {
/* 711 */         } else {
/* 712 */           boolean bhj_isNull142 = true;
/* 713 */           boolean bhj_value142 = false;
/* 714 */
/* 715 */           if (!bhj_isNull83) {
/* 716 */             bhj_isNull142 = false; // resultCode could change nullability.
/* 717 */             bhj_value142 = bhj_value83.equals(((UTF8String) references[24]));
/* 718 */
/* 719 */           }
/* 720 */           boolean bhj_isNull141 = false;
/* 721 */           boolean bhj_value141 = false;
/* 722 */
/* 723 */           if (!bhj_isNull142 && !bhj_value142) {
/* 724 */           } else {
/* 725 */             boolean bhj_isNull145 = true;
/* 726 */             boolean bhj_value145 = false;
/* 727 */
/* 728 */             if (!bhj_isNull84) {
/* 729 */               bhj_isNull145 = false; // resultCode could change nullability.
/* 730 */               bhj_value145 = bhj_value84.equals(((UTF8String) references[25]));
/* 731 */
/* 732 */             }
/* 733 */             if (!bhj_isNull145 && !bhj_value145) {
/* 734 */             } else if (!bhj_isNull142 && !bhj_isNull145) {
/* 735 */               bhj_value141 = true;
/* 736 */             } else {
/* 737 */               bhj_isNull141 = true;
/* 738 */             }
/* 739 */           }
/* 740 */           boolean bhj_isNull140 = false;
/* 741 */           boolean bhj_value140 = false;
/* 742 */
/* 743 */           if (!bhj_isNull141 && !bhj_value141) {
/* 744 */           } else {
/* 745 */             boolean bhj_isNull148 = true;
/* 746 */             boolean bhj_value148 = false;
/* 747 */
/* 748 */             if (!scan_isNull5) {
/* 749 */               bhj_isNull148 = false; // resultCode could change nullability.
/* 750 */               bhj_value148 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 150.0D) >= 0;
/* 751 */
/* 752 */             }
/* 753 */             if (!bhj_isNull148 && !bhj_value148) {
/* 754 */             } else if (!bhj_isNull141 && !bhj_isNull148) {
/* 755 */               bhj_value140 = true;
/* 756 */             } else {
/* 757 */               bhj_isNull140 = true;
/* 758 */             }
/* 759 */           }
/* 760 */           boolean bhj_isNull139 = false;
/* 761 */           boolean bhj_value139 = false;
/* 762 */
/* 763 */           if (!bhj_isNull140 && !bhj_value140) {
/* 764 */           } else {
/* 765 */             boolean bhj_isNull151 = true;
/* 766 */             boolean bhj_value151 = false;
/* 767 */
/* 768 */             if (!scan_isNull5) {
/* 769 */               bhj_isNull151 = false; // resultCode could change nullability.
/* 770 */               bhj_value151 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value5, 200.0D) <= 0;
/* 771 */
/* 772 */             }
/* 773 */             if (!bhj_isNull151 && !bhj_value151) {
/* 774 */             } else if (!bhj_isNull140 && !bhj_isNull151) {
/* 775 */               bhj_value139 = true;
/* 776 */             } else {
/* 777 */               bhj_isNull139 = true;
/* 778 */             }
/* 779 */           }
/* 780 */           boolean bhj_isNull138 = false;
/* 781 */           boolean bhj_value138 = false;
/* 782 */
/* 783 */           if (!bhj_isNull139 && !bhj_value139) {
/* 784 */           } else {
/* 785 */             boolean bhj_isNull154 = true;
/* 786 */             boolean bhj_value154 = false;
/* 787 */
/* 788 */             if (!bhj_isNull97) {
/* 789 */               bhj_isNull154 = false; // resultCode could change nullability.
/* 790 */               bhj_value154 = bhj_value97 == 1;
/* 791 */
/* 792 */             }
/* 793 */             if (!bhj_isNull154 && !bhj_value154) {
/* 794 */             } else if (!bhj_isNull139 && !bhj_isNull154) {
/* 795 */               bhj_value138 = true;
/* 796 */             } else {
/* 797 */               bhj_isNull138 = true;
/* 798 */             }
/* 799 */           }
/* 800 */           if (!bhj_isNull138 && bhj_value138) {
/* 801 */           } else if (!bhj_isNull99 && !bhj_isNull138) {
/* 802 */             bhj_value98 = false;
/* 803 */           } else {
/* 804 */             bhj_isNull98 = true;
/* 805 */           }
/* 806 */         }
/* 807 */         if (bhj_isNull98 || !bhj_value98) continue;
/* 808 */
/* 809 */         bhj_numOutputRows4.add(1);
/* 810 */
/* 811 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 812 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 813 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 814 */         double scan_value6 = scan_isNull6 ? -1.0 : (scan_colInstance6.getDouble(scan_rowIdx));
/* 815 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 816 */         double scan_value7 = scan_isNull7 ? -1.0 : (scan_colInstance7.getDouble(scan_rowIdx));
/* 817 */
/* 818 */         // do aggregate
/* 819 */         // common sub-expressions
/* 820 */
/* 821 */         boolean agg_isNull11 = scan_isNull4;
/* 822 */         long agg_value11 = -1L;
/* 823 */         if (!scan_isNull4) {
/* 824 */           agg_value11 = (long) scan_value4;
/* 825 */         }
/* 826 */         // evaluate aggregate function
/* 827 */         boolean agg_isNull13 = true;
/* 828 */         double agg_value13 = -1.0;
/* 829 */
/* 830 */         if (!agg_bufIsNull) {
/* 831 */           boolean agg_isNull16 = agg_isNull11;
/* 832 */           double agg_value16 = -1.0;
/* 833 */           if (!agg_isNull11) {
/* 834 */             agg_value16 = (double) agg_value11;
/* 835 */           }
/* 836 */           boolean agg_isNull15 = agg_isNull16;
/* 837 */           double agg_value15 = agg_value16;
/* 838 */           if (agg_isNull15) {
/* 839 */             boolean agg_isNull17 = false;
/* 840 */             double agg_value17 = -1.0;
/* 841 */             if (!false) {
/* 842 */               agg_value17 = (double) 0;
/* 843 */             }
/* 844 */             if (!agg_isNull17) {
/* 845 */               agg_isNull15 = false;
/* 846 */               agg_value15 = agg_value17;
/* 847 */             }
/* 848 */           }
/* 849 */
/* 850 */           agg_isNull13 = false; // resultCode could change nullability.
/* 851 */           agg_value13 = agg_bufValue + agg_value15;
/* 852 */
/* 853 */         }
/* 854 */         boolean agg_isNull19 = false;
/* 855 */         long agg_value19 = -1L;
/* 856 */         if (!false && agg_isNull11) {
/* 857 */           agg_isNull19 = agg_bufIsNull1;
/* 858 */           agg_value19 = agg_bufValue1;
/* 859 */         } else {
/* 860 */           boolean agg_isNull22 = true;
/* 861 */           long agg_value22 = -1L;
/* 862 */
/* 863 */           if (!agg_bufIsNull1) {
/* 864 */             agg_isNull22 = false; // resultCode could change nullability.
/* 865 */             agg_value22 = agg_bufValue1 + 1L;
/* 866 */
/* 867 */           }
/* 868 */           agg_isNull19 = agg_isNull22;
/* 869 */           agg_value19 = agg_value22;
/* 870 */         }
/* 871 */         boolean agg_isNull25 = true;
/* 872 */         double agg_value25 = -1.0;
/* 873 */
/* 874 */         if (!agg_bufIsNull2) {
/* 875 */           boolean agg_isNull27 = scan_isNull6;
/* 876 */           double agg_value27 = scan_value6;
/* 877 */           if (agg_isNull27) {
/* 878 */             boolean agg_isNull29 = false;
/* 879 */             double agg_value29 = -1.0;
/* 880 */             if (!false) {
/* 881 */               agg_value29 = (double) 0;
/* 882 */             }
/* 883 */             if (!agg_isNull29) {
/* 884 */               agg_isNull27 = false;
/* 885 */               agg_value27 = agg_value29;
/* 886 */             }
/* 887 */           }
/* 888 */
/* 889 */           agg_isNull25 = false; // resultCode could change nullability.
/* 890 */           agg_value25 = agg_bufValue2 + agg_value27;
/* 891 */
/* 892 */         }
/* 893 */         boolean agg_isNull31 = false;
/* 894 */         long agg_value31 = -1L;
/* 895 */         if (!false && scan_isNull6) {
/* 896 */           agg_isNull31 = agg_bufIsNull3;
/* 897 */           agg_value31 = agg_bufValue3;
/* 898 */         } else {
/* 899 */           boolean agg_isNull35 = true;
/* 900 */           long agg_value35 = -1L;
/* 901 */
/* 902 */           if (!agg_bufIsNull3) {
/* 903 */             agg_isNull35 = false; // resultCode could change nullability.
/* 904 */             agg_value35 = agg_bufValue3 + 1L;
/* 905 */
/* 906 */           }
/* 907 */           agg_isNull31 = agg_isNull35;
/* 908 */           agg_value31 = agg_value35;
/* 909 */         }
/* 910 */         boolean agg_isNull38 = true;
/* 911 */         double agg_value38 = -1.0;
/* 912 */
/* 913 */         if (!agg_bufIsNull4) {
/* 914 */           boolean agg_isNull40 = scan_isNull7;
/* 915 */           double agg_value40 = scan_value7;
/* 916 */           if (agg_isNull40) {
/* 917 */             boolean agg_isNull42 = false;
/* 918 */             double agg_value42 = -1.0;
/* 919 */             if (!false) {
/* 920 */               agg_value42 = (double) 0;
/* 921 */             }
/* 922 */             if (!agg_isNull42) {
/* 923 */               agg_isNull40 = false;
/* 924 */               agg_value40 = agg_value42;
/* 925 */             }
/* 926 */           }
/* 927 */
/* 928 */           agg_isNull38 = false; // resultCode could change nullability.
/* 929 */           agg_value38 = agg_bufValue4 + agg_value40;
/* 930 */
/* 931 */         }
/* 932 */         boolean agg_isNull44 = false;
/* 933 */         long agg_value44 = -1L;
/* 934 */         if (!false && scan_isNull7) {
/* 935 */           agg_isNull44 = agg_bufIsNull5;
/* 936 */           agg_value44 = agg_bufValue5;
/* 937 */         } else {
/* 938 */           boolean agg_isNull48 = true;
/* 939 */           long agg_value48 = -1L;
/* 940 */
/* 941 */           if (!agg_bufIsNull5) {
/* 942 */             agg_isNull48 = false; // resultCode could change nullability.
/* 943 */             agg_value48 = agg_bufValue5 + 1L;
/* 944 */
/* 945 */           }
/* 946 */           agg_isNull44 = agg_isNull48;
/* 947 */           agg_value44 = agg_value48;
/* 948 */         }
/* 949 */         boolean agg_isNull52 = true;
/* 950 */         double agg_value52 = -1.0;
/* 951 */
/* 952 */         boolean agg_isNull53 = agg_bufIsNull6;
/* 953 */         double agg_value53 = agg_bufValue6;
/* 954 */         if (agg_isNull53) {
/* 955 */           boolean agg_isNull55 = false;
/* 956 */           double agg_value55 = -1.0;
/* 957 */           if (!false) {
/* 958 */             agg_value55 = (double) 0;
/* 959 */           }
/* 960 */           if (!agg_isNull55) {
/* 961 */             agg_isNull53 = false;
/* 962 */             agg_value53 = agg_value55;
/* 963 */           }
/* 964 */         }
/* 965 */
/* 966 */         if (!scan_isNull7) {
/* 967 */           agg_isNull52 = false; // resultCode could change nullability.
/* 968 */           agg_value52 = agg_value53 + scan_value7;
/* 969 */
/* 970 */         }
/* 971 */         boolean agg_isNull51 = agg_isNull52;
/* 972 */         double agg_value51 = agg_value52;
/* 973 */         if (agg_isNull51) {
/* 974 */           if (!agg_bufIsNull6) {
/* 975 */             agg_isNull51 = false;
/* 976 */             agg_value51 = agg_bufValue6;
/* 977 */           }
/* 978 */         }
/* 979 */         // update aggregation buffer
/* 980 */         agg_bufIsNull = agg_isNull13;
/* 981 */         agg_bufValue = agg_value13;
/* 982 */
/* 983 */         agg_bufIsNull1 = agg_isNull19;
/* 984 */         agg_bufValue1 = agg_value19;
/* 985 */
/* 986 */         agg_bufIsNull2 = agg_isNull25;
/* 987 */         agg_bufValue2 = agg_value25;
/* 988 */
/* 989 */         agg_bufIsNull3 = agg_isNull31;
/* 990 */         agg_bufValue3 = agg_value31;
/* 991 */
/* 992 */         agg_bufIsNull4 = agg_isNull38;
/* 993 */         agg_bufValue4 = agg_value38;
/* 994 */
/* 995 */         agg_bufIsNull5 = agg_isNull44;
/* 996 */         agg_bufValue5 = agg_value44;
/* 997 */
/* 998 */         agg_bufIsNull6 = agg_isNull51;
/* 999 */         agg_bufValue6 = agg_value51;
/* 1000 */         // shouldStop check is eliminated
/* 1001 */       }
/* 1002 */       scan_batchIdx = scan_numRows;
/* 1003 */       scan_batch = null;
/* 1004 */       scan_nextBatch();
/* 1005 */     }
/* 1006 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 1007 */     scan_scanTime1 = 0;
/* 1008 */
/* 1009 */   }
/* 1010 */
/* 1011 */   private void wholestagecodegen_init_3() {
/* 1012 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 1013 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 1014 */
/* 1015 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 1016 */     bhj_result2 = new UnsafeRow(8);
/* 1017 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 1018 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 1019 */     project_result3 = new UnsafeRow(6);
/* 1020 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 1021 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 1022 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 1023 */
/* 1024 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 1025 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 1026 */
/* 1027 */   }
/* 1028 */
/* 1029 */   private void scan_nextBatch() throws java.io.IOException {
/* 1030 */     long getBatchStart = System.nanoTime();
/* 1031 */     if (scan_input.hasNext()) {
/* 1032 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 1033 */       scan_numOutputRows.add(scan_batch.numRows());
/* 1034 */       scan_batchIdx = 0;
/* 1035 */       scan_colInstance0 = scan_batch.column(0);
/* 1036 */       scan_colInstance1 = scan_batch.column(1);
/* 1037 */       scan_colInstance2 = scan_batch.column(2);
/* 1038 */       scan_colInstance3 = scan_batch.column(3);
/* 1039 */       scan_colInstance4 = scan_batch.column(4);
/* 1040 */       scan_colInstance5 = scan_batch.column(5);
/* 1041 */       scan_colInstance6 = scan_batch.column(6);
/* 1042 */       scan_colInstance7 = scan_batch.column(7);
/* 1043 */       scan_colInstance8 = scan_batch.column(8);
/* 1044 */       scan_colInstance9 = scan_batch.column(9);
/* 1045 */
/* 1046 */     }
/* 1047 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 1048 */   }
/* 1049 */
/* 1050 */   private void wholestagecodegen_init_5() {
/* 1051 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 9);
/* 1052 */     project_result5 = new UnsafeRow(3);
/* 1053 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 0);
/* 1054 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 3);
/* 1055 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[27];
/* 1056 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[28];
/* 1057 */     agg_result = new UnsafeRow(7);
/* 1058 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 1059 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 7);
/* 1060 */
/* 1061 */   }
/* 1062 */
/* 1063 */   private void wholestagecodegen_init_2() {
/* 1064 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 9);
/* 1065 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 1066 */
/* 1067 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1068 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1069 */
/* 1070 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 1071 */     bhj_result1 = new UnsafeRow(11);
/* 1072 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 1073 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 11);
/* 1074 */     project_result2 = new UnsafeRow(7);
/* 1075 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 1076 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 1077 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 1078 */
/* 1079 */   }
/* 1080 */
/* 1081 */   private void wholestagecodegen_init_1() {
/* 1082 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 10);
/* 1083 */     project_result = new UnsafeRow(10);
/* 1084 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 1085 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 10);
/* 1086 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 1087 */
/* 1088 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1089 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1090 */
/* 1091 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 1092 */     bhj_result = new UnsafeRow(11);
/* 1093 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1094 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 11);
/* 1095 */     project_result1 = new UnsafeRow(9);
/* 1096 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 1097 */
/* 1098 */   }
/* 1099 */
/* 1100 */   private void wholestagecodegen_init_4() {
/* 1101 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 1102 */     bhj_result3 = new UnsafeRow(9);
/* 1103 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 64);
/* 1104 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 9);
/* 1105 */     project_result4 = new UnsafeRow(7);
/* 1106 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 64);
/* 1107 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 7);
/* 1108 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 1109 */
/* 1110 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 1111 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 1112 */
/* 1113 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[26];
/* 1114 */     bhj_result4 = new UnsafeRow(9);
/* 1115 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 64);
/* 1116 */
/* 1117 */   }
/* 1118 */
/* 1119 */   protected void processNext() throws java.io.IOException {
/* 1120 */     while (!agg_initAgg) {
/* 1121 */       agg_initAgg = true;
/* 1122 */       long agg_beforeAgg = System.nanoTime();
/* 1123 */       agg_doAggregateWithoutKey();
/* 1124 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 1125 */
/* 1126 */       // output the result
/* 1127 */
/* 1128 */       agg_numOutputRows.add(1);
/* 1129 */       agg_rowWriter.zeroOutNullBytes();
/* 1130 */
/* 1131 */       if (agg_bufIsNull) {
/* 1132 */         agg_rowWriter.setNullAt(0);
/* 1133 */       } else {
/* 1134 */         agg_rowWriter.write(0, agg_bufValue);
/* 1135 */       }
/* 1136 */
/* 1137 */       if (agg_bufIsNull1) {
/* 1138 */         agg_rowWriter.setNullAt(1);
/* 1139 */       } else {
/* 1140 */         agg_rowWriter.write(1, agg_bufValue1);
/* 1141 */       }
/* 1142 */
/* 1143 */       if (agg_bufIsNull2) {
/* 1144 */         agg_rowWriter.setNullAt(2);
/* 1145 */       } else {
/* 1146 */         agg_rowWriter.write(2, agg_bufValue2);
/* 1147 */       }
/* 1148 */
/* 1149 */       if (agg_bufIsNull3) {
/* 1150 */         agg_rowWriter.setNullAt(3);
/* 1151 */       } else {
/* 1152 */         agg_rowWriter.write(3, agg_bufValue3);
/* 1153 */       }
/* 1154 */
/* 1155 */       if (agg_bufIsNull4) {
/* 1156 */         agg_rowWriter.setNullAt(4);
/* 1157 */       } else {
/* 1158 */         agg_rowWriter.write(4, agg_bufValue4);
/* 1159 */       }
/* 1160 */
/* 1161 */       if (agg_bufIsNull5) {
/* 1162 */         agg_rowWriter.setNullAt(5);
/* 1163 */       } else {
/* 1164 */         agg_rowWriter.write(5, agg_bufValue5);
/* 1165 */       }
/* 1166 */
/* 1167 */       if (agg_bufIsNull6) {
/* 1168 */         agg_rowWriter.setNullAt(6);
/* 1169 */       } else {
/* 1170 */         agg_rowWriter.write(6, agg_bufValue6);
/* 1171 */       }
/* 1172 */       append(agg_result);
/* 1173 */     }
/* 1174 */   }
/* 1175 */ }
