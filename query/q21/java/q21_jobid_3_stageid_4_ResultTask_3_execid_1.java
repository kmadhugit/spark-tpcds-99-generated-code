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
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value8;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     wholestagecodegen_init_0();
/* 042 */     wholestagecodegen_init_1();
/* 043 */
/* 044 */   }
/* 045 */
/* 046 */   private void wholestagecodegen_init_0() {
/* 047 */     agg_initAgg = false;
/* 048 */
/* 049 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 050 */
/* 051 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 052 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 053 */     inputadapter_input = inputs[0];
/* 054 */     agg_result = new UnsafeRow(2);
/* 055 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 056 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 057 */
/* 058 */     agg_result1 = new UnsafeRow(4);
/* 059 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 060 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 4);
/* 061 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 062 */     filter_result = new UnsafeRow(4);
/* 063 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 068 */     agg_hashMap = agg_plan.createHashMap();
/* 069 */
/* 070 */     while (inputadapter_input.hasNext()) {
/* 071 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 072 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 073 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 074 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 075 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 076 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 077 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 078 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 079 */       long inputadapter_value3 = inputadapter_isNull3 ? -1L : (inputadapter_row.getLong(3));
/* 080 */
/* 081 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 082 */
/* 083 */       UnsafeRow agg_fastAggBuffer = null;
/* 084 */
/* 085 */       if (agg_fastAggBuffer == null) {
/* 086 */         // generate grouping key
/* 087 */         agg_holder.reset();
/* 088 */
/* 089 */         agg_rowWriter.zeroOutNullBytes();
/* 090 */
/* 091 */         if (inputadapter_isNull) {
/* 092 */           agg_rowWriter.setNullAt(0);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(0, inputadapter_value);
/* 095 */         }
/* 096 */
/* 097 */         if (inputadapter_isNull1) {
/* 098 */           agg_rowWriter.setNullAt(1);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(1, inputadapter_value1);
/* 101 */         }
/* 102 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 103 */         agg_value8 = 42;
/* 104 */
/* 105 */         if (!inputadapter_isNull) {
/* 106 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value8);
/* 107 */         }
/* 108 */
/* 109 */         if (!inputadapter_isNull1) {
/* 110 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value8);
/* 111 */         }
/* 112 */         if (true) {
/* 113 */           // try to get the buffer from hash map
/* 114 */           agg_unsafeRowAggBuffer =
/* 115 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 116 */         }
/* 117 */         if (agg_unsafeRowAggBuffer == null) {
/* 118 */           if (agg_sorter == null) {
/* 119 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 120 */           } else {
/* 121 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 122 */           }
/* 123 */
/* 124 */           // the hash map had be spilled, it should have enough memory now,
/* 125 */           // try  to allocate buffer again.
/* 126 */           agg_unsafeRowAggBuffer =
/* 127 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 128 */           if (agg_unsafeRowAggBuffer == null) {
/* 129 */             // failed to allocate the first page
/* 130 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 131 */           }
/* 132 */         }
/* 133 */       }
/* 134 */
/* 135 */       if (agg_fastAggBuffer != null) {
/* 136 */         // update fast row
/* 137 */
/* 138 */       } else {
/* 139 */         // update unsafe row
/* 140 */
/* 141 */         // common sub-expressions
/* 142 */         boolean agg_isNull9 = false;
/* 143 */         long agg_value11 = -1L;
/* 144 */         if (!false) {
/* 145 */           agg_value11 = (long) 0;
/* 146 */         }
/* 147 */         // evaluate aggregate function
/* 148 */         boolean agg_isNull12 = true;
/* 149 */         long agg_value14 = -1L;
/* 150 */
/* 151 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 152 */         long agg_value16 = agg_isNull14 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 153 */         boolean agg_isNull13 = agg_isNull14;
/* 154 */         long agg_value15 = agg_value16;
/* 155 */         if (agg_isNull13) {
/* 156 */           if (!agg_isNull9) {
/* 157 */             agg_isNull13 = false;
/* 158 */             agg_value15 = agg_value11;
/* 159 */           }
/* 160 */         }
/* 161 */
/* 162 */         if (!inputadapter_isNull2) {
/* 163 */           agg_isNull12 = false; // resultCode could change nullability.
/* 164 */           agg_value14 = agg_value15 + inputadapter_value2;
/* 165 */
/* 166 */         }
/* 167 */         boolean agg_isNull11 = agg_isNull12;
/* 168 */         long agg_value13 = agg_value14;
/* 169 */         if (agg_isNull11) {
/* 170 */           boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 171 */           long agg_value18 = agg_isNull16 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 172 */           if (!agg_isNull16) {
/* 173 */             agg_isNull11 = false;
/* 174 */             agg_value13 = agg_value18;
/* 175 */           }
/* 176 */         }
/* 177 */         boolean agg_isNull18 = true;
/* 178 */         long agg_value20 = -1L;
/* 179 */
/* 180 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 181 */         long agg_value22 = agg_isNull20 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 182 */         boolean agg_isNull19 = agg_isNull20;
/* 183 */         long agg_value21 = agg_value22;
/* 184 */         if (agg_isNull19) {
/* 185 */           if (!agg_isNull9) {
/* 186 */             agg_isNull19 = false;
/* 187 */             agg_value21 = agg_value11;
/* 188 */           }
/* 189 */         }
/* 190 */
/* 191 */         if (!inputadapter_isNull3) {
/* 192 */           agg_isNull18 = false; // resultCode could change nullability.
/* 193 */           agg_value20 = agg_value21 + inputadapter_value3;
/* 194 */
/* 195 */         }
/* 196 */         boolean agg_isNull17 = agg_isNull18;
/* 197 */         long agg_value19 = agg_value20;
/* 198 */         if (agg_isNull17) {
/* 199 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 200 */           long agg_value24 = agg_isNull22 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 201 */           if (!agg_isNull22) {
/* 202 */             agg_isNull17 = false;
/* 203 */             agg_value19 = agg_value24;
/* 204 */           }
/* 205 */         }
/* 206 */         // update unsafe row buffer
/* 207 */         if (!agg_isNull11) {
/* 208 */           agg_unsafeRowAggBuffer.setLong(0, agg_value13);
/* 209 */         } else {
/* 210 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 211 */         }
/* 212 */
/* 213 */         if (!agg_isNull17) {
/* 214 */           agg_unsafeRowAggBuffer.setLong(1, agg_value19);
/* 215 */         } else {
/* 216 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 217 */         }
/* 218 */
/* 219 */       }
/* 220 */       if (shouldStop()) return;
/* 221 */     }
/* 222 */
/* 223 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 224 */   }
/* 225 */
/* 226 */   private void wholestagecodegen_init_1() {
/* 227 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 228 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 229 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 230 */
/* 231 */   }
/* 232 */
/* 233 */   protected void processNext() throws java.io.IOException {
/* 234 */     if (!agg_initAgg) {
/* 235 */       agg_initAgg = true;
/* 236 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 237 */       agg_doAggregateWithKeys();
/* 238 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 239 */     }
/* 240 */
/* 241 */     // output the result
/* 242 */
/* 243 */     while (agg_mapIter.next()) {
/* 244 */       wholestagecodegen_numOutputRows.add(1);
/* 245 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 246 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 247 */
/* 248 */       boolean agg_isNull23 = agg_aggKey.isNullAt(0);
/* 249 */       UTF8String agg_value25 = agg_isNull23 ? null : (agg_aggKey.getUTF8String(0));
/* 250 */       boolean agg_isNull24 = agg_aggKey.isNullAt(1);
/* 251 */       UTF8String agg_value26 = agg_isNull24 ? null : (agg_aggKey.getUTF8String(1));
/* 252 */       boolean agg_isNull25 = agg_aggBuffer.isNullAt(0);
/* 253 */       long agg_value27 = agg_isNull25 ? -1L : (agg_aggBuffer.getLong(0));
/* 254 */       boolean agg_isNull26 = agg_aggBuffer.isNullAt(1);
/* 255 */       long agg_value28 = agg_isNull26 ? -1L : (agg_aggBuffer.getLong(1));
/* 256 */
/* 257 */       boolean filter_isNull = true;
/* 258 */       boolean filter_value = false;
/* 259 */
/* 260 */       boolean filter_isNull1 = true;
/* 261 */       double filter_value1 = -1.0;
/* 262 */
/* 263 */       boolean filter_isNull2 = true;
/* 264 */       boolean filter_value2 = false;
/* 265 */
/* 266 */       if (!agg_isNull25) {
/* 267 */         filter_isNull2 = false; // resultCode could change nullability.
/* 268 */         filter_value2 = agg_value27 > 0L;
/* 269 */
/* 270 */       }
/* 271 */       if (!filter_isNull2 && filter_value2) {
/* 272 */         boolean filter_isNull8 = agg_isNull25;
/* 273 */         double filter_value8 = -1.0;
/* 274 */         if (!agg_isNull25) {
/* 275 */           filter_value8 = (double) agg_value27;
/* 276 */         }
/* 277 */         boolean filter_isNull5 = false;
/* 278 */         double filter_value5 = -1.0;
/* 279 */         if (filter_isNull8 || filter_value8 == 0) {
/* 280 */           filter_isNull5 = true;
/* 281 */         } else {
/* 282 */           boolean filter_isNull6 = agg_isNull26;
/* 283 */           double filter_value6 = -1.0;
/* 284 */           if (!agg_isNull26) {
/* 285 */             filter_value6 = (double) agg_value28;
/* 286 */           }
/* 287 */           if (filter_isNull6) {
/* 288 */             filter_isNull5 = true;
/* 289 */           } else {
/* 290 */             filter_value5 = (double)(filter_value6 / filter_value8);
/* 291 */           }
/* 292 */         }
/* 293 */         filter_isNull1 = filter_isNull5;
/* 294 */         filter_value1 = filter_value5;
/* 295 */       }
/* 296 */
/* 297 */       else {
/* 298 */         final double filter_value10 = -1.0;
/* 299 */         filter_isNull1 = true;
/* 300 */         filter_value1 = filter_value10;
/* 301 */       }
/* 302 */       if (!filter_isNull1) {
/* 303 */         filter_isNull = false; // resultCode could change nullability.
/* 304 */         filter_value = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value1, 0.666667D) >= 0;
/* 305 */
/* 306 */       }
/* 307 */       if (filter_isNull || !filter_value) continue;
/* 308 */       boolean filter_isNull12 = true;
/* 309 */       boolean filter_value12 = false;
/* 310 */
/* 311 */       boolean filter_isNull13 = true;
/* 312 */       double filter_value13 = -1.0;
/* 313 */
/* 314 */       boolean filter_isNull14 = true;
/* 315 */       boolean filter_value14 = false;
/* 316 */
/* 317 */       if (!agg_isNull25) {
/* 318 */         filter_isNull14 = false; // resultCode could change nullability.
/* 319 */         filter_value14 = agg_value27 > 0L;
/* 320 */
/* 321 */       }
/* 322 */       if (!filter_isNull14 && filter_value14) {
/* 323 */         boolean filter_isNull20 = agg_isNull25;
/* 324 */         double filter_value20 = -1.0;
/* 325 */         if (!agg_isNull25) {
/* 326 */           filter_value20 = (double) agg_value27;
/* 327 */         }
/* 328 */         boolean filter_isNull17 = false;
/* 329 */         double filter_value17 = -1.0;
/* 330 */         if (filter_isNull20 || filter_value20 == 0) {
/* 331 */           filter_isNull17 = true;
/* 332 */         } else {
/* 333 */           boolean filter_isNull18 = agg_isNull26;
/* 334 */           double filter_value18 = -1.0;
/* 335 */           if (!agg_isNull26) {
/* 336 */             filter_value18 = (double) agg_value28;
/* 337 */           }
/* 338 */           if (filter_isNull18) {
/* 339 */             filter_isNull17 = true;
/* 340 */           } else {
/* 341 */             filter_value17 = (double)(filter_value18 / filter_value20);
/* 342 */           }
/* 343 */         }
/* 344 */         filter_isNull13 = filter_isNull17;
/* 345 */         filter_value13 = filter_value17;
/* 346 */       }
/* 347 */
/* 348 */       else {
/* 349 */         final double filter_value22 = -1.0;
/* 350 */         filter_isNull13 = true;
/* 351 */         filter_value13 = filter_value22;
/* 352 */       }
/* 353 */       if (!filter_isNull13) {
/* 354 */         filter_isNull12 = false; // resultCode could change nullability.
/* 355 */         filter_value12 = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value13, 1.5D) <= 0;
/* 356 */
/* 357 */       }
/* 358 */       if (filter_isNull12 || !filter_value12) continue;
/* 359 */
/* 360 */       filter_numOutputRows.add(1);
/* 361 */
/* 362 */       filter_holder.reset();
/* 363 */
/* 364 */       filter_rowWriter.zeroOutNullBytes();
/* 365 */
/* 366 */       if (agg_isNull23) {
/* 367 */         filter_rowWriter.setNullAt(0);
/* 368 */       } else {
/* 369 */         filter_rowWriter.write(0, agg_value25);
/* 370 */       }
/* 371 */
/* 372 */       if (agg_isNull24) {
/* 373 */         filter_rowWriter.setNullAt(1);
/* 374 */       } else {
/* 375 */         filter_rowWriter.write(1, agg_value26);
/* 376 */       }
/* 377 */
/* 378 */       if (agg_isNull25) {
/* 379 */         filter_rowWriter.setNullAt(2);
/* 380 */       } else {
/* 381 */         filter_rowWriter.write(2, agg_value27);
/* 382 */       }
/* 383 */
/* 384 */       if (agg_isNull26) {
/* 385 */         filter_rowWriter.setNullAt(3);
/* 386 */       } else {
/* 387 */         filter_rowWriter.write(3, agg_value28);
/* 388 */       }
/* 389 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 390 */       append(filter_result);
/* 391 */
/* 392 */       if (shouldStop()) return;
/* 393 */     }
/* 394 */
/* 395 */     agg_mapIter.close();
/* 396 */     if (agg_sorter == null) {
/* 397 */       agg_hashMap.free();
/* 398 */     }
/* 399 */   }
/* 400 */ }
