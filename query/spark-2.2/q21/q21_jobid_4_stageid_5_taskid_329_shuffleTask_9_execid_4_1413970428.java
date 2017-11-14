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
/* 070 */     while (inputadapter_input.hasNext() && !stopEarly()) {
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
/* 142 */
/* 143 */         // evaluate aggregate function
/* 144 */         boolean agg_isNull10 = true;
/* 145 */         long agg_value12 = -1L;
/* 146 */
/* 147 */         boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 148 */         long agg_value14 = agg_isNull12 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 149 */         boolean agg_isNull11 = agg_isNull12;
/* 150 */         long agg_value13 = agg_value14;
/* 151 */         if (agg_isNull11) {
/* 152 */           boolean agg_isNull13 = false;
/* 153 */           long agg_value15 = -1L;
/* 154 */           if (!false) {
/* 155 */             agg_value15 = (long) 0;
/* 156 */           }
/* 157 */           if (!agg_isNull13) {
/* 158 */             agg_isNull11 = false;
/* 159 */             agg_value13 = agg_value15;
/* 160 */           }
/* 161 */         }
/* 162 */
/* 163 */         if (!inputadapter_isNull2) {
/* 164 */           agg_isNull10 = false; // resultCode could change nullability.
/* 165 */           agg_value12 = agg_value13 + inputadapter_value2;
/* 166 */
/* 167 */         }
/* 168 */         boolean agg_isNull9 = agg_isNull10;
/* 169 */         long agg_value11 = agg_value12;
/* 170 */         if (agg_isNull9) {
/* 171 */           boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 172 */           long agg_value18 = agg_isNull16 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 173 */           if (!agg_isNull16) {
/* 174 */             agg_isNull9 = false;
/* 175 */             agg_value11 = agg_value18;
/* 176 */           }
/* 177 */         }
/* 178 */         boolean agg_isNull18 = true;
/* 179 */         long agg_value20 = -1L;
/* 180 */
/* 181 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 182 */         long agg_value22 = agg_isNull20 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 183 */         boolean agg_isNull19 = agg_isNull20;
/* 184 */         long agg_value21 = agg_value22;
/* 185 */         if (agg_isNull19) {
/* 186 */           boolean agg_isNull21 = false;
/* 187 */           long agg_value23 = -1L;
/* 188 */           if (!false) {
/* 189 */             agg_value23 = (long) 0;
/* 190 */           }
/* 191 */           if (!agg_isNull21) {
/* 192 */             agg_isNull19 = false;
/* 193 */             agg_value21 = agg_value23;
/* 194 */           }
/* 195 */         }
/* 196 */
/* 197 */         if (!inputadapter_isNull3) {
/* 198 */           agg_isNull18 = false; // resultCode could change nullability.
/* 199 */           agg_value20 = agg_value21 + inputadapter_value3;
/* 200 */
/* 201 */         }
/* 202 */         boolean agg_isNull17 = agg_isNull18;
/* 203 */         long agg_value19 = agg_value20;
/* 204 */         if (agg_isNull17) {
/* 205 */           boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 206 */           long agg_value26 = agg_isNull24 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 207 */           if (!agg_isNull24) {
/* 208 */             agg_isNull17 = false;
/* 209 */             agg_value19 = agg_value26;
/* 210 */           }
/* 211 */         }
/* 212 */         // update unsafe row buffer
/* 213 */         if (!agg_isNull9) {
/* 214 */           agg_unsafeRowAggBuffer.setLong(0, agg_value11);
/* 215 */         } else {
/* 216 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 217 */         }
/* 218 */
/* 219 */         if (!agg_isNull17) {
/* 220 */           agg_unsafeRowAggBuffer.setLong(1, agg_value19);
/* 221 */         } else {
/* 222 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 223 */         }
/* 224 */
/* 225 */       }
/* 226 */       if (shouldStop()) return;
/* 227 */     }
/* 228 */
/* 229 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 230 */   }
/* 231 */
/* 232 */   private void wholestagecodegen_init_1() {
/* 233 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 234 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 235 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 236 */
/* 237 */   }
/* 238 */
/* 239 */   protected void processNext() throws java.io.IOException {
/* 240 */     if (!agg_initAgg) {
/* 241 */       agg_initAgg = true;
/* 242 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 243 */       agg_doAggregateWithKeys();
/* 244 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 245 */     }
/* 246 */
/* 247 */     // output the result
/* 248 */
/* 249 */     while (agg_mapIter.next()) {
/* 250 */       wholestagecodegen_numOutputRows.add(1);
/* 251 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 252 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 253 */
/* 254 */       boolean agg_isNull25 = agg_aggKey.isNullAt(0);
/* 255 */       UTF8String agg_value27 = agg_isNull25 ? null : (agg_aggKey.getUTF8String(0));
/* 256 */       boolean agg_isNull26 = agg_aggKey.isNullAt(1);
/* 257 */       UTF8String agg_value28 = agg_isNull26 ? null : (agg_aggKey.getUTF8String(1));
/* 258 */       boolean agg_isNull27 = agg_aggBuffer.isNullAt(0);
/* 259 */       long agg_value29 = agg_isNull27 ? -1L : (agg_aggBuffer.getLong(0));
/* 260 */       boolean agg_isNull28 = agg_aggBuffer.isNullAt(1);
/* 261 */       long agg_value30 = agg_isNull28 ? -1L : (agg_aggBuffer.getLong(1));
/* 262 */
/* 263 */       boolean filter_isNull = true;
/* 264 */       boolean filter_value = false;
/* 265 */
/* 266 */       boolean filter_isNull1 = true;
/* 267 */       double filter_value1 = -1.0;
/* 268 */
/* 269 */       boolean filter_isNull2 = true;
/* 270 */       boolean filter_value2 = false;
/* 271 */
/* 272 */       if (!agg_isNull27) {
/* 273 */         filter_isNull2 = false; // resultCode could change nullability.
/* 274 */         filter_value2 = agg_value29 > 0L;
/* 275 */
/* 276 */       }
/* 277 */       if (!filter_isNull2 && filter_value2) {
/* 278 */         boolean filter_isNull8 = agg_isNull27;
/* 279 */         double filter_value8 = -1.0;
/* 280 */         if (!agg_isNull27) {
/* 281 */           filter_value8 = (double) agg_value29;
/* 282 */         }
/* 283 */         boolean filter_isNull5 = false;
/* 284 */         double filter_value5 = -1.0;
/* 285 */         if (filter_isNull8 || filter_value8 == 0) {
/* 286 */           filter_isNull5 = true;
/* 287 */         } else {
/* 288 */           boolean filter_isNull6 = agg_isNull28;
/* 289 */           double filter_value6 = -1.0;
/* 290 */           if (!agg_isNull28) {
/* 291 */             filter_value6 = (double) agg_value30;
/* 292 */           }
/* 293 */           if (filter_isNull6) {
/* 294 */             filter_isNull5 = true;
/* 295 */           } else {
/* 296 */             filter_value5 = (double)(filter_value6 / filter_value8);
/* 297 */           }
/* 298 */         }
/* 299 */         filter_isNull1 = filter_isNull5;
/* 300 */         filter_value1 = filter_value5;
/* 301 */       }
/* 302 */
/* 303 */       else {
/* 304 */         final double filter_value10 = -1.0;
/* 305 */         filter_isNull1 = true;
/* 306 */         filter_value1 = filter_value10;
/* 307 */       }
/* 308 */       if (!filter_isNull1) {
/* 309 */         filter_isNull = false; // resultCode could change nullability.
/* 310 */         filter_value = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value1, 0.666667D) >= 0;
/* 311 */
/* 312 */       }
/* 313 */       if (filter_isNull || !filter_value) continue;
/* 314 */       boolean filter_isNull12 = true;
/* 315 */       boolean filter_value12 = false;
/* 316 */
/* 317 */       boolean filter_isNull13 = true;
/* 318 */       double filter_value13 = -1.0;
/* 319 */
/* 320 */       boolean filter_isNull14 = true;
/* 321 */       boolean filter_value14 = false;
/* 322 */
/* 323 */       if (!agg_isNull27) {
/* 324 */         filter_isNull14 = false; // resultCode could change nullability.
/* 325 */         filter_value14 = agg_value29 > 0L;
/* 326 */
/* 327 */       }
/* 328 */       if (!filter_isNull14 && filter_value14) {
/* 329 */         boolean filter_isNull20 = agg_isNull27;
/* 330 */         double filter_value20 = -1.0;
/* 331 */         if (!agg_isNull27) {
/* 332 */           filter_value20 = (double) agg_value29;
/* 333 */         }
/* 334 */         boolean filter_isNull17 = false;
/* 335 */         double filter_value17 = -1.0;
/* 336 */         if (filter_isNull20 || filter_value20 == 0) {
/* 337 */           filter_isNull17 = true;
/* 338 */         } else {
/* 339 */           boolean filter_isNull18 = agg_isNull28;
/* 340 */           double filter_value18 = -1.0;
/* 341 */           if (!agg_isNull28) {
/* 342 */             filter_value18 = (double) agg_value30;
/* 343 */           }
/* 344 */           if (filter_isNull18) {
/* 345 */             filter_isNull17 = true;
/* 346 */           } else {
/* 347 */             filter_value17 = (double)(filter_value18 / filter_value20);
/* 348 */           }
/* 349 */         }
/* 350 */         filter_isNull13 = filter_isNull17;
/* 351 */         filter_value13 = filter_value17;
/* 352 */       }
/* 353 */
/* 354 */       else {
/* 355 */         final double filter_value22 = -1.0;
/* 356 */         filter_isNull13 = true;
/* 357 */         filter_value13 = filter_value22;
/* 358 */       }
/* 359 */       if (!filter_isNull13) {
/* 360 */         filter_isNull12 = false; // resultCode could change nullability.
/* 361 */         filter_value12 = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value13, 1.5D) <= 0;
/* 362 */
/* 363 */       }
/* 364 */       if (filter_isNull12 || !filter_value12) continue;
/* 365 */
/* 366 */       filter_numOutputRows.add(1);
/* 367 */
/* 368 */       filter_holder.reset();
/* 369 */
/* 370 */       filter_rowWriter.zeroOutNullBytes();
/* 371 */
/* 372 */       if (agg_isNull25) {
/* 373 */         filter_rowWriter.setNullAt(0);
/* 374 */       } else {
/* 375 */         filter_rowWriter.write(0, agg_value27);
/* 376 */       }
/* 377 */
/* 378 */       if (agg_isNull26) {
/* 379 */         filter_rowWriter.setNullAt(1);
/* 380 */       } else {
/* 381 */         filter_rowWriter.write(1, agg_value28);
/* 382 */       }
/* 383 */
/* 384 */       if (agg_isNull27) {
/* 385 */         filter_rowWriter.setNullAt(2);
/* 386 */       } else {
/* 387 */         filter_rowWriter.write(2, agg_value29);
/* 388 */       }
/* 389 */
/* 390 */       if (agg_isNull28) {
/* 391 */         filter_rowWriter.setNullAt(3);
/* 392 */       } else {
/* 393 */         filter_rowWriter.write(3, agg_value30);
/* 394 */       }
/* 395 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 396 */       append(filter_result);
/* 397 */
/* 398 */       if (shouldStop()) return;
/* 399 */     }
/* 400 */
/* 401 */     agg_mapIter.close();
/* 402 */     if (agg_sorter == null) {
/* 403 */       agg_hashMap.free();
/* 404 */     }
/* 405 */   }
/* 406 */ }
