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
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private long agg_bufValue7;
/* 025 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 026 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 027 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 028 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 031 */   private scala.collection.Iterator inputadapter_input;
/* 032 */   private UnsafeRow agg_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 035 */   private int agg_value22;
/* 036 */   private UnsafeRow agg_result1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 041 */
/* 042 */   public GeneratedIterator(Object[] references) {
/* 043 */     this.references = references;
/* 044 */   }
/* 045 */
/* 046 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 047 */     partitionIndex = index;
/* 048 */     this.inputs = inputs;
/* 049 */     agg_initAgg = false;
/* 050 */
/* 051 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 052 */
/* 053 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 054 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 055 */     inputadapter_input = inputs[0];
/* 056 */     agg_result = new UnsafeRow(1);
/* 057 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 058 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 059 */
/* 060 */     agg_result1 = new UnsafeRow(5);
/* 061 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 062 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 063 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 064 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 069 */     agg_hashMap = agg_plan.createHashMap();
/* 070 */
/* 071 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 072 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 073 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 074 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 075 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 076 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 077 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 078 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 079 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 080 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 081 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 082 */       long inputadapter_value4 = inputadapter_isNull4 ? -1L : (inputadapter_row.getLong(4));
/* 083 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 084 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 085 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 086 */       long inputadapter_value6 = inputadapter_isNull6 ? -1L : (inputadapter_row.getLong(6));
/* 087 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 088 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 089 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 090 */       long inputadapter_value8 = inputadapter_isNull8 ? -1L : (inputadapter_row.getLong(8));
/* 091 */
/* 092 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 093 */
/* 094 */       UnsafeRow agg_fastAggBuffer = null;
/* 095 */
/* 096 */       if (agg_fastAggBuffer == null) {
/* 097 */         // generate grouping key
/* 098 */         agg_holder.reset();
/* 099 */
/* 100 */         agg_rowWriter.zeroOutNullBytes();
/* 101 */
/* 102 */         if (inputadapter_isNull) {
/* 103 */           agg_rowWriter.setNullAt(0);
/* 104 */         } else {
/* 105 */           agg_rowWriter.write(0, inputadapter_value);
/* 106 */         }
/* 107 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 108 */         agg_value22 = 42;
/* 109 */
/* 110 */         if (!inputadapter_isNull) {
/* 111 */           agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value22);
/* 112 */         }
/* 113 */         if (true) {
/* 114 */           // try to get the buffer from hash map
/* 115 */           agg_unsafeRowAggBuffer =
/* 116 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value22);
/* 117 */         }
/* 118 */         if (agg_unsafeRowAggBuffer == null) {
/* 119 */           if (agg_sorter == null) {
/* 120 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 121 */           } else {
/* 122 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 123 */           }
/* 124 */
/* 125 */           // the hash map had be spilled, it should have enough memory now,
/* 126 */           // try  to allocate buffer again.
/* 127 */           agg_unsafeRowAggBuffer =
/* 128 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value22);
/* 129 */           if (agg_unsafeRowAggBuffer == null) {
/* 130 */             // failed to allocate the first page
/* 131 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 132 */           }
/* 133 */         }
/* 134 */       }
/* 135 */
/* 136 */       if (agg_fastAggBuffer != null) {
/* 137 */         // update fast row
/* 138 */
/* 139 */       } else {
/* 140 */         // update unsafe row
/* 141 */
/* 142 */         // common sub-expressions
/* 143 */
/* 144 */         // evaluate aggregate function
/* 145 */         boolean agg_isNull16 = true;
/* 146 */         double agg_value24 = -1.0;
/* 147 */
/* 148 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 149 */         double agg_value25 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 150 */         if (!agg_isNull17) {
/* 151 */           if (!inputadapter_isNull1) {
/* 152 */             agg_isNull16 = false; // resultCode could change nullability.
/* 153 */             agg_value24 = agg_value25 + inputadapter_value1;
/* 154 */
/* 155 */           }
/* 156 */
/* 157 */         }
/* 158 */         boolean agg_isNull19 = true;
/* 159 */         long agg_value27 = -1L;
/* 160 */
/* 161 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 162 */         long agg_value28 = agg_isNull20 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 163 */         if (!agg_isNull20) {
/* 164 */           if (!inputadapter_isNull2) {
/* 165 */             agg_isNull19 = false; // resultCode could change nullability.
/* 166 */             agg_value27 = agg_value28 + inputadapter_value2;
/* 167 */
/* 168 */           }
/* 169 */
/* 170 */         }
/* 171 */         boolean agg_isNull22 = true;
/* 172 */         double agg_value30 = -1.0;
/* 173 */
/* 174 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 175 */         double agg_value31 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 176 */         if (!agg_isNull23) {
/* 177 */           if (!inputadapter_isNull3) {
/* 178 */             agg_isNull22 = false; // resultCode could change nullability.
/* 179 */             agg_value30 = agg_value31 + inputadapter_value3;
/* 180 */
/* 181 */           }
/* 182 */
/* 183 */         }
/* 184 */         boolean agg_isNull25 = true;
/* 185 */         long agg_value33 = -1L;
/* 186 */
/* 187 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 188 */         long agg_value34 = agg_isNull26 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 189 */         if (!agg_isNull26) {
/* 190 */           if (!inputadapter_isNull4) {
/* 191 */             agg_isNull25 = false; // resultCode could change nullability.
/* 192 */             agg_value33 = agg_value34 + inputadapter_value4;
/* 193 */
/* 194 */           }
/* 195 */
/* 196 */         }
/* 197 */         boolean agg_isNull28 = true;
/* 198 */         double agg_value36 = -1.0;
/* 199 */
/* 200 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 201 */         double agg_value37 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 202 */         if (!agg_isNull29) {
/* 203 */           if (!inputadapter_isNull5) {
/* 204 */             agg_isNull28 = false; // resultCode could change nullability.
/* 205 */             agg_value36 = agg_value37 + inputadapter_value5;
/* 206 */
/* 207 */           }
/* 208 */
/* 209 */         }
/* 210 */         boolean agg_isNull31 = true;
/* 211 */         long agg_value39 = -1L;
/* 212 */
/* 213 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 214 */         long agg_value40 = agg_isNull32 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 215 */         if (!agg_isNull32) {
/* 216 */           if (!inputadapter_isNull6) {
/* 217 */             agg_isNull31 = false; // resultCode could change nullability.
/* 218 */             agg_value39 = agg_value40 + inputadapter_value6;
/* 219 */
/* 220 */           }
/* 221 */
/* 222 */         }
/* 223 */         boolean agg_isNull34 = true;
/* 224 */         double agg_value42 = -1.0;
/* 225 */
/* 226 */         boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 227 */         double agg_value43 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 228 */         if (!agg_isNull35) {
/* 229 */           if (!inputadapter_isNull7) {
/* 230 */             agg_isNull34 = false; // resultCode could change nullability.
/* 231 */             agg_value42 = agg_value43 + inputadapter_value7;
/* 232 */
/* 233 */           }
/* 234 */
/* 235 */         }
/* 236 */         boolean agg_isNull37 = true;
/* 237 */         long agg_value45 = -1L;
/* 238 */
/* 239 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 240 */         long agg_value46 = agg_isNull38 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 241 */         if (!agg_isNull38) {
/* 242 */           if (!inputadapter_isNull8) {
/* 243 */             agg_isNull37 = false; // resultCode could change nullability.
/* 244 */             agg_value45 = agg_value46 + inputadapter_value8;
/* 245 */
/* 246 */           }
/* 247 */
/* 248 */         }
/* 249 */         // update unsafe row buffer
/* 250 */         if (!agg_isNull16) {
/* 251 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value24);
/* 252 */         } else {
/* 253 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 254 */         }
/* 255 */
/* 256 */         if (!agg_isNull19) {
/* 257 */           agg_unsafeRowAggBuffer.setLong(1, agg_value27);
/* 258 */         } else {
/* 259 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 260 */         }
/* 261 */
/* 262 */         if (!agg_isNull22) {
/* 263 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value30);
/* 264 */         } else {
/* 265 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 266 */         }
/* 267 */
/* 268 */         if (!agg_isNull25) {
/* 269 */           agg_unsafeRowAggBuffer.setLong(3, agg_value33);
/* 270 */         } else {
/* 271 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 272 */         }
/* 273 */
/* 274 */         if (!agg_isNull28) {
/* 275 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value36);
/* 276 */         } else {
/* 277 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 278 */         }
/* 279 */
/* 280 */         if (!agg_isNull31) {
/* 281 */           agg_unsafeRowAggBuffer.setLong(5, agg_value39);
/* 282 */         } else {
/* 283 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 284 */         }
/* 285 */
/* 286 */         if (!agg_isNull34) {
/* 287 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value42);
/* 288 */         } else {
/* 289 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 290 */         }
/* 291 */
/* 292 */         if (!agg_isNull37) {
/* 293 */           agg_unsafeRowAggBuffer.setLong(7, agg_value45);
/* 294 */         } else {
/* 295 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 296 */         }
/* 297 */
/* 298 */       }
/* 299 */       if (shouldStop()) return;
/* 300 */     }
/* 301 */
/* 302 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 303 */   }
/* 304 */
/* 305 */   protected void processNext() throws java.io.IOException {
/* 306 */     if (!agg_initAgg) {
/* 307 */       agg_initAgg = true;
/* 308 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 309 */       agg_doAggregateWithKeys();
/* 310 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 311 */     }
/* 312 */
/* 313 */     // output the result
/* 314 */
/* 315 */     while (agg_mapIter.next()) {
/* 316 */       wholestagecodegen_numOutputRows.add(1);
/* 317 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 318 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 319 */
/* 320 */       boolean agg_isNull40 = agg_aggKey.isNullAt(0);
/* 321 */       UTF8String agg_value48 = agg_isNull40 ? null : (agg_aggKey.getUTF8String(0));
/* 322 */       boolean agg_isNull41 = agg_aggBuffer.isNullAt(0);
/* 323 */       double agg_value49 = agg_isNull41 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 324 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(1);
/* 325 */       long agg_value50 = agg_isNull42 ? -1L : (agg_aggBuffer.getLong(1));
/* 326 */       boolean agg_isNull43 = agg_aggBuffer.isNullAt(2);
/* 327 */       double agg_value51 = agg_isNull43 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 328 */       boolean agg_isNull44 = agg_aggBuffer.isNullAt(3);
/* 329 */       long agg_value52 = agg_isNull44 ? -1L : (agg_aggBuffer.getLong(3));
/* 330 */       boolean agg_isNull45 = agg_aggBuffer.isNullAt(4);
/* 331 */       double agg_value53 = agg_isNull45 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 332 */       boolean agg_isNull46 = agg_aggBuffer.isNullAt(5);
/* 333 */       long agg_value54 = agg_isNull46 ? -1L : (agg_aggBuffer.getLong(5));
/* 334 */       boolean agg_isNull47 = agg_aggBuffer.isNullAt(6);
/* 335 */       double agg_value55 = agg_isNull47 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 336 */       boolean agg_isNull48 = agg_aggBuffer.isNullAt(7);
/* 337 */       long agg_value56 = agg_isNull48 ? -1L : (agg_aggBuffer.getLong(7));
/* 338 */       boolean agg_isNull51 = agg_isNull42;
/* 339 */       double agg_value59 = -1.0;
/* 340 */       if (!agg_isNull42) {
/* 341 */         agg_value59 = (double) agg_value50;
/* 342 */       }
/* 343 */       boolean agg_isNull49 = false;
/* 344 */       double agg_value57 = -1.0;
/* 345 */       if (agg_isNull51 || agg_value59 == 0) {
/* 346 */         agg_isNull49 = true;
/* 347 */       } else {
/* 348 */         if (agg_isNull41) {
/* 349 */           agg_isNull49 = true;
/* 350 */         } else {
/* 351 */           agg_value57 = (double)(agg_value49 / agg_value59);
/* 352 */         }
/* 353 */       }
/* 354 */       boolean agg_isNull55 = agg_isNull44;
/* 355 */       double agg_value63 = -1.0;
/* 356 */       if (!agg_isNull44) {
/* 357 */         agg_value63 = (double) agg_value52;
/* 358 */       }
/* 359 */       boolean agg_isNull53 = false;
/* 360 */       double agg_value61 = -1.0;
/* 361 */       if (agg_isNull55 || agg_value63 == 0) {
/* 362 */         agg_isNull53 = true;
/* 363 */       } else {
/* 364 */         if (agg_isNull43) {
/* 365 */           agg_isNull53 = true;
/* 366 */         } else {
/* 367 */           agg_value61 = (double)(agg_value51 / agg_value63);
/* 368 */         }
/* 369 */       }
/* 370 */       boolean agg_isNull59 = agg_isNull46;
/* 371 */       double agg_value67 = -1.0;
/* 372 */       if (!agg_isNull46) {
/* 373 */         agg_value67 = (double) agg_value54;
/* 374 */       }
/* 375 */       boolean agg_isNull57 = false;
/* 376 */       double agg_value65 = -1.0;
/* 377 */       if (agg_isNull59 || agg_value67 == 0) {
/* 378 */         agg_isNull57 = true;
/* 379 */       } else {
/* 380 */         if (agg_isNull45) {
/* 381 */           agg_isNull57 = true;
/* 382 */         } else {
/* 383 */           agg_value65 = (double)(agg_value53 / agg_value67);
/* 384 */         }
/* 385 */       }
/* 386 */       boolean agg_isNull63 = agg_isNull48;
/* 387 */       double agg_value71 = -1.0;
/* 388 */       if (!agg_isNull48) {
/* 389 */         agg_value71 = (double) agg_value56;
/* 390 */       }
/* 391 */       boolean agg_isNull61 = false;
/* 392 */       double agg_value69 = -1.0;
/* 393 */       if (agg_isNull63 || agg_value71 == 0) {
/* 394 */         agg_isNull61 = true;
/* 395 */       } else {
/* 396 */         if (agg_isNull47) {
/* 397 */           agg_isNull61 = true;
/* 398 */         } else {
/* 399 */           agg_value69 = (double)(agg_value55 / agg_value71);
/* 400 */         }
/* 401 */       }
/* 402 */
/* 403 */       boolean agg_isNull65 = true;
/* 404 */       UTF8String agg_value73 = null;
/* 405 */
/* 406 */       if (!agg_isNull40) {
/* 407 */         agg_isNull65 = false; // resultCode could change nullability.
/* 408 */         agg_value73 = agg_value48.substringSQL(1, 20);
/* 409 */
/* 410 */       }
/* 411 */       agg_holder1.reset();
/* 412 */
/* 413 */       agg_rowWriter1.zeroOutNullBytes();
/* 414 */
/* 415 */       if (agg_isNull65) {
/* 416 */         agg_rowWriter1.setNullAt(0);
/* 417 */       } else {
/* 418 */         agg_rowWriter1.write(0, agg_value73);
/* 419 */       }
/* 420 */
/* 421 */       if (agg_isNull49) {
/* 422 */         agg_rowWriter1.setNullAt(1);
/* 423 */       } else {
/* 424 */         agg_rowWriter1.write(1, agg_value57);
/* 425 */       }
/* 426 */
/* 427 */       if (agg_isNull53) {
/* 428 */         agg_rowWriter1.setNullAt(2);
/* 429 */       } else {
/* 430 */         agg_rowWriter1.write(2, agg_value61);
/* 431 */       }
/* 432 */
/* 433 */       if (agg_isNull57) {
/* 434 */         agg_rowWriter1.setNullAt(3);
/* 435 */       } else {
/* 436 */         agg_rowWriter1.write(3, agg_value65);
/* 437 */       }
/* 438 */
/* 439 */       if (agg_isNull61) {
/* 440 */         agg_rowWriter1.setNullAt(4);
/* 441 */       } else {
/* 442 */         agg_rowWriter1.write(4, agg_value69);
/* 443 */       }
/* 444 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 445 */       append(agg_result1);
/* 446 */
/* 447 */       if (shouldStop()) return;
/* 448 */     }
/* 449 */
/* 450 */     agg_mapIter.close();
/* 451 */     if (agg_sorter == null) {
/* 452 */       agg_hashMap.free();
/* 453 */     }
/* 454 */   }
/* 455 */ }
