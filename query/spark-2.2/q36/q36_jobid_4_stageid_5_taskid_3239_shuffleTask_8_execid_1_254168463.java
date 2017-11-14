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
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private UnsafeRow agg_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 027 */   private int agg_value14;
/* 028 */   private UnsafeRow agg_result1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
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
/* 041 */     agg_initAgg = false;
/* 042 */
/* 043 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 044 */
/* 045 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 047 */     inputadapter_input = inputs[0];
/* 048 */     agg_result = new UnsafeRow(3);
/* 049 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 050 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 051 */
/* 052 */     agg_result1 = new UnsafeRow(7);
/* 053 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 054 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 055 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 056 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 061 */     agg_hashMap = agg_plan.createHashMap();
/* 062 */
/* 063 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 064 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 065 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 066 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 067 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 068 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 069 */       int inputadapter_value2 = inputadapter_row.getInt(2);
/* 070 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 071 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 072 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 073 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 074 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 075 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 076 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 077 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 078 */
/* 079 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 080 */
/* 081 */       UnsafeRow agg_fastAggBuffer = null;
/* 082 */
/* 083 */       if (agg_fastAggBuffer == null) {
/* 084 */         // generate grouping key
/* 085 */         agg_holder.reset();
/* 086 */
/* 087 */         agg_rowWriter.zeroOutNullBytes();
/* 088 */
/* 089 */         if (inputadapter_isNull) {
/* 090 */           agg_rowWriter.setNullAt(0);
/* 091 */         } else {
/* 092 */           agg_rowWriter.write(0, inputadapter_value);
/* 093 */         }
/* 094 */
/* 095 */         if (inputadapter_isNull1) {
/* 096 */           agg_rowWriter.setNullAt(1);
/* 097 */         } else {
/* 098 */           agg_rowWriter.write(1, inputadapter_value1);
/* 099 */         }
/* 100 */
/* 101 */         agg_rowWriter.write(2, inputadapter_value2);
/* 102 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 103 */         agg_value14 = 42;
/* 104 */
/* 105 */         if (!inputadapter_isNull) {
/* 106 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value14);
/* 107 */         }
/* 108 */
/* 109 */         if (!inputadapter_isNull1) {
/* 110 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value14);
/* 111 */         }
/* 112 */
/* 113 */         agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value14);
/* 114 */         if (true) {
/* 115 */           // try to get the buffer from hash map
/* 116 */           agg_unsafeRowAggBuffer =
/* 117 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 118 */         }
/* 119 */         if (agg_unsafeRowAggBuffer == null) {
/* 120 */           if (agg_sorter == null) {
/* 121 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 122 */           } else {
/* 123 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 124 */           }
/* 125 */
/* 126 */           // the hash map had be spilled, it should have enough memory now,
/* 127 */           // try  to allocate buffer again.
/* 128 */           agg_unsafeRowAggBuffer =
/* 129 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 130 */           if (agg_unsafeRowAggBuffer == null) {
/* 131 */             // failed to allocate the first page
/* 132 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 133 */           }
/* 134 */         }
/* 135 */       }
/* 136 */
/* 137 */       if (agg_fastAggBuffer != null) {
/* 138 */         // update fast row
/* 139 */
/* 140 */       } else {
/* 141 */         // update unsafe row
/* 142 */
/* 143 */         // common sub-expressions
/* 144 */
/* 145 */         // evaluate aggregate function
/* 146 */         boolean agg_isNull15 = true;
/* 147 */         double agg_value19 = -1.0;
/* 148 */
/* 149 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 150 */         double agg_value21 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 151 */         boolean agg_isNull16 = agg_isNull17;
/* 152 */         double agg_value20 = agg_value21;
/* 153 */         if (agg_isNull16) {
/* 154 */           boolean agg_isNull18 = false;
/* 155 */           double agg_value22 = -1.0;
/* 156 */           if (!false) {
/* 157 */             agg_value22 = (double) 0;
/* 158 */           }
/* 159 */           if (!agg_isNull18) {
/* 160 */             agg_isNull16 = false;
/* 161 */             agg_value20 = agg_value22;
/* 162 */           }
/* 163 */         }
/* 164 */
/* 165 */         if (!inputadapter_isNull3) {
/* 166 */           agg_isNull15 = false; // resultCode could change nullability.
/* 167 */           agg_value19 = agg_value20 + inputadapter_value3;
/* 168 */
/* 169 */         }
/* 170 */         boolean agg_isNull14 = agg_isNull15;
/* 171 */         double agg_value18 = agg_value19;
/* 172 */         if (agg_isNull14) {
/* 173 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 174 */           double agg_value25 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 175 */           if (!agg_isNull21) {
/* 176 */             agg_isNull14 = false;
/* 177 */             agg_value18 = agg_value25;
/* 178 */           }
/* 179 */         }
/* 180 */         boolean agg_isNull23 = true;
/* 181 */         double agg_value27 = -1.0;
/* 182 */
/* 183 */         boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 184 */         double agg_value29 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 185 */         boolean agg_isNull24 = agg_isNull25;
/* 186 */         double agg_value28 = agg_value29;
/* 187 */         if (agg_isNull24) {
/* 188 */           boolean agg_isNull26 = false;
/* 189 */           double agg_value30 = -1.0;
/* 190 */           if (!false) {
/* 191 */             agg_value30 = (double) 0;
/* 192 */           }
/* 193 */           if (!agg_isNull26) {
/* 194 */             agg_isNull24 = false;
/* 195 */             agg_value28 = agg_value30;
/* 196 */           }
/* 197 */         }
/* 198 */
/* 199 */         if (!inputadapter_isNull4) {
/* 200 */           agg_isNull23 = false; // resultCode could change nullability.
/* 201 */           agg_value27 = agg_value28 + inputadapter_value4;
/* 202 */
/* 203 */         }
/* 204 */         boolean agg_isNull22 = agg_isNull23;
/* 205 */         double agg_value26 = agg_value27;
/* 206 */         if (agg_isNull22) {
/* 207 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 208 */           double agg_value33 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 209 */           if (!agg_isNull29) {
/* 210 */             agg_isNull22 = false;
/* 211 */             agg_value26 = agg_value33;
/* 212 */           }
/* 213 */         }
/* 214 */         boolean agg_isNull31 = true;
/* 215 */         double agg_value35 = -1.0;
/* 216 */
/* 217 */         boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 218 */         double agg_value37 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 219 */         boolean agg_isNull32 = agg_isNull33;
/* 220 */         double agg_value36 = agg_value37;
/* 221 */         if (agg_isNull32) {
/* 222 */           boolean agg_isNull34 = false;
/* 223 */           double agg_value38 = -1.0;
/* 224 */           if (!false) {
/* 225 */             agg_value38 = (double) 0;
/* 226 */           }
/* 227 */           if (!agg_isNull34) {
/* 228 */             agg_isNull32 = false;
/* 229 */             agg_value36 = agg_value38;
/* 230 */           }
/* 231 */         }
/* 232 */
/* 233 */         if (!inputadapter_isNull5) {
/* 234 */           agg_isNull31 = false; // resultCode could change nullability.
/* 235 */           agg_value35 = agg_value36 + inputadapter_value5;
/* 236 */
/* 237 */         }
/* 238 */         boolean agg_isNull30 = agg_isNull31;
/* 239 */         double agg_value34 = agg_value35;
/* 240 */         if (agg_isNull30) {
/* 241 */           boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 242 */           double agg_value41 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 243 */           if (!agg_isNull37) {
/* 244 */             agg_isNull30 = false;
/* 245 */             agg_value34 = agg_value41;
/* 246 */           }
/* 247 */         }
/* 248 */         boolean agg_isNull39 = true;
/* 249 */         double agg_value43 = -1.0;
/* 250 */
/* 251 */         boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 252 */         double agg_value45 = agg_isNull41 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 253 */         boolean agg_isNull40 = agg_isNull41;
/* 254 */         double agg_value44 = agg_value45;
/* 255 */         if (agg_isNull40) {
/* 256 */           boolean agg_isNull42 = false;
/* 257 */           double agg_value46 = -1.0;
/* 258 */           if (!false) {
/* 259 */             agg_value46 = (double) 0;
/* 260 */           }
/* 261 */           if (!agg_isNull42) {
/* 262 */             agg_isNull40 = false;
/* 263 */             agg_value44 = agg_value46;
/* 264 */           }
/* 265 */         }
/* 266 */
/* 267 */         if (!inputadapter_isNull6) {
/* 268 */           agg_isNull39 = false; // resultCode could change nullability.
/* 269 */           agg_value43 = agg_value44 + inputadapter_value6;
/* 270 */
/* 271 */         }
/* 272 */         boolean agg_isNull38 = agg_isNull39;
/* 273 */         double agg_value42 = agg_value43;
/* 274 */         if (agg_isNull38) {
/* 275 */           boolean agg_isNull45 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 276 */           double agg_value49 = agg_isNull45 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 277 */           if (!agg_isNull45) {
/* 278 */             agg_isNull38 = false;
/* 279 */             agg_value42 = agg_value49;
/* 280 */           }
/* 281 */         }
/* 282 */         // update unsafe row buffer
/* 283 */         if (!agg_isNull14) {
/* 284 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 285 */         } else {
/* 286 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 287 */         }
/* 288 */
/* 289 */         if (!agg_isNull22) {
/* 290 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value26);
/* 291 */         } else {
/* 292 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 293 */         }
/* 294 */
/* 295 */         if (!agg_isNull30) {
/* 296 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value34);
/* 297 */         } else {
/* 298 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 299 */         }
/* 300 */
/* 301 */         if (!agg_isNull38) {
/* 302 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value42);
/* 303 */         } else {
/* 304 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 305 */         }
/* 306 */
/* 307 */       }
/* 308 */       if (shouldStop()) return;
/* 309 */     }
/* 310 */
/* 311 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 312 */   }
/* 313 */
/* 314 */   protected void processNext() throws java.io.IOException {
/* 315 */     if (!agg_initAgg) {
/* 316 */       agg_initAgg = true;
/* 317 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 318 */       agg_doAggregateWithKeys();
/* 319 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 320 */     }
/* 321 */
/* 322 */     // output the result
/* 323 */
/* 324 */     while (agg_mapIter.next()) {
/* 325 */       wholestagecodegen_numOutputRows.add(1);
/* 326 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 327 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 328 */
/* 329 */       boolean agg_isNull46 = agg_aggKey.isNullAt(0);
/* 330 */       UTF8String agg_value50 = agg_isNull46 ? null : (agg_aggKey.getUTF8String(0));
/* 331 */       boolean agg_isNull47 = agg_aggKey.isNullAt(1);
/* 332 */       UTF8String agg_value51 = agg_isNull47 ? null : (agg_aggKey.getUTF8String(1));
/* 333 */       int agg_value52 = agg_aggKey.getInt(2);
/* 334 */       boolean agg_isNull49 = agg_aggBuffer.isNullAt(0);
/* 335 */       double agg_value53 = agg_isNull49 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 336 */       boolean agg_isNull50 = agg_aggBuffer.isNullAt(1);
/* 337 */       double agg_value54 = agg_isNull50 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 338 */       boolean agg_isNull51 = agg_aggBuffer.isNullAt(2);
/* 339 */       double agg_value55 = agg_isNull51 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 340 */       boolean agg_isNull52 = agg_aggBuffer.isNullAt(3);
/* 341 */       double agg_value56 = agg_isNull52 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 342 */
/* 343 */       boolean agg_isNull57 = false;
/* 344 */       double agg_value61 = -1.0;
/* 345 */       if (agg_isNull50 || agg_value54 == 0) {
/* 346 */         agg_isNull57 = true;
/* 347 */       } else {
/* 348 */         if (agg_isNull49) {
/* 349 */           agg_isNull57 = true;
/* 350 */         } else {
/* 351 */           agg_value61 = (double)(agg_value53 / agg_value54);
/* 352 */         }
/* 353 */       }
/* 354 */       boolean agg_isNull62 = false;
/* 355 */
/* 356 */       boolean agg_isNull64 = false;
/* 357 */
/* 358 */       boolean agg_isNull65 = false;
/* 359 */
/* 360 */       int agg_value69 = -1;
/* 361 */       agg_value69 = agg_value52 >> 1;
/* 362 */
/* 363 */       int agg_value68 = -1;
/* 364 */       agg_value68 = agg_value69 & 1;
/* 365 */       boolean agg_isNull63 = false;
/* 366 */       byte agg_value67 = (byte)-1;
/* 367 */       if (!false) {
/* 368 */         agg_value67 = (byte) agg_value68;
/* 369 */       }
/* 370 */
/* 371 */       boolean agg_isNull70 = false;
/* 372 */
/* 373 */       boolean agg_isNull71 = false;
/* 374 */
/* 375 */       int agg_value75 = -1;
/* 376 */       agg_value75 = agg_value52 >> 0;
/* 377 */
/* 378 */       int agg_value74 = -1;
/* 379 */       agg_value74 = agg_value75 & 1;
/* 380 */       boolean agg_isNull69 = false;
/* 381 */       byte agg_value73 = (byte)-1;
/* 382 */       if (!false) {
/* 383 */         agg_value73 = (byte) agg_value74;
/* 384 */       }
/* 385 */       byte agg_value66 = (byte)-1;
/* 386 */       agg_value66 = (byte)(agg_value67 + agg_value73);
/* 387 */       boolean agg_isNull75 = false;
/* 388 */
/* 389 */       boolean agg_isNull77 = false;
/* 390 */
/* 391 */       boolean agg_isNull78 = false;
/* 392 */
/* 393 */       int agg_value82 = -1;
/* 394 */       agg_value82 = agg_value52 >> 1;
/* 395 */
/* 396 */       int agg_value81 = -1;
/* 397 */       agg_value81 = agg_value82 & 1;
/* 398 */       boolean agg_isNull76 = false;
/* 399 */       byte agg_value80 = (byte)-1;
/* 400 */       if (!false) {
/* 401 */         agg_value80 = (byte) agg_value81;
/* 402 */       }
/* 403 */
/* 404 */       boolean agg_isNull83 = false;
/* 405 */
/* 406 */       boolean agg_isNull84 = false;
/* 407 */
/* 408 */       int agg_value88 = -1;
/* 409 */       agg_value88 = agg_value52 >> 0;
/* 410 */
/* 411 */       int agg_value87 = -1;
/* 412 */       agg_value87 = agg_value88 & 1;
/* 413 */       boolean agg_isNull82 = false;
/* 414 */       byte agg_value86 = (byte)-1;
/* 415 */       if (!false) {
/* 416 */         agg_value86 = (byte) agg_value87;
/* 417 */       }
/* 418 */       byte agg_value79 = (byte)-1;
/* 419 */       agg_value79 = (byte)(agg_value80 + agg_value86);
/* 420 */       boolean agg_isNull88 = true;
/* 421 */       UTF8String agg_value92 = null;
/* 422 */
/* 423 */       boolean agg_isNull89 = false;
/* 424 */
/* 425 */       boolean agg_isNull92 = false;
/* 426 */
/* 427 */       boolean agg_isNull93 = false;
/* 428 */
/* 429 */       int agg_value97 = -1;
/* 430 */       agg_value97 = agg_value52 >> 0;
/* 431 */
/* 432 */       int agg_value96 = -1;
/* 433 */       agg_value96 = agg_value97 & 1;
/* 434 */       boolean agg_isNull91 = false;
/* 435 */       byte agg_value95 = (byte)-1;
/* 436 */       if (!false) {
/* 437 */         agg_value95 = (byte) agg_value96;
/* 438 */       }
/* 439 */       boolean agg_isNull90 = agg_isNull91;
/* 440 */       int agg_value94 = -1;
/* 441 */       if (!agg_isNull91) {
/* 442 */         agg_value94 = (int) agg_value95;
/* 443 */       }
/* 444 */
/* 445 */       boolean agg_value93 = false;
/* 446 */       agg_value93 = agg_value94 == 0;
/* 447 */       if (!false && agg_value93) {
/* 448 */         agg_isNull88 = agg_isNull46;
/* 449 */         agg_value92 = agg_value50;
/* 450 */       }
/* 451 */
/* 452 */       else {
/* 453 */       }
/* 454 */       boolean agg_isNull99 = false;
/* 455 */       double agg_value103 = -1.0;
/* 456 */       if (agg_isNull52 || agg_value56 == 0) {
/* 457 */         agg_isNull99 = true;
/* 458 */       } else {
/* 459 */         if (agg_isNull51) {
/* 460 */           agg_isNull99 = true;
/* 461 */         } else {
/* 462 */           agg_value103 = (double)(agg_value55 / agg_value56);
/* 463 */         }
/* 464 */       }
/* 465 */       agg_holder1.reset();
/* 466 */
/* 467 */       agg_rowWriter1.zeroOutNullBytes();
/* 468 */
/* 469 */       if (agg_isNull57) {
/* 470 */         agg_rowWriter1.setNullAt(0);
/* 471 */       } else {
/* 472 */         agg_rowWriter1.write(0, agg_value61);
/* 473 */       }
/* 474 */
/* 475 */       if (agg_isNull46) {
/* 476 */         agg_rowWriter1.setNullAt(1);
/* 477 */       } else {
/* 478 */         agg_rowWriter1.write(1, agg_value50);
/* 479 */       }
/* 480 */
/* 481 */       if (agg_isNull47) {
/* 482 */         agg_rowWriter1.setNullAt(2);
/* 483 */       } else {
/* 484 */         agg_rowWriter1.write(2, agg_value51);
/* 485 */       }
/* 486 */
/* 487 */       agg_rowWriter1.write(3, agg_value66);
/* 488 */
/* 489 */       agg_rowWriter1.write(4, agg_value79);
/* 490 */
/* 491 */       if (agg_isNull88) {
/* 492 */         agg_rowWriter1.setNullAt(5);
/* 493 */       } else {
/* 494 */         agg_rowWriter1.write(5, agg_value92);
/* 495 */       }
/* 496 */
/* 497 */       if (agg_isNull99) {
/* 498 */         agg_rowWriter1.setNullAt(6);
/* 499 */       } else {
/* 500 */         agg_rowWriter1.write(6, agg_value103);
/* 501 */       }
/* 502 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 503 */       append(agg_result1);
/* 504 */
/* 505 */       if (shouldStop()) return;
/* 506 */     }
/* 507 */
/* 508 */     agg_mapIter.close();
/* 509 */     if (agg_sorter == null) {
/* 510 */       agg_hashMap.free();
/* 511 */     }
/* 512 */   }
/* 513 */ }
