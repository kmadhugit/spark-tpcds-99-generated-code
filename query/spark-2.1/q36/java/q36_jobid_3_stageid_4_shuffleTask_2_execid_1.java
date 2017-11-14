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
/* 063 */     while (inputadapter_input.hasNext()) {
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
/* 144 */         boolean agg_isNull14 = false;
/* 145 */         double agg_value18 = -1.0;
/* 146 */         if (!false) {
/* 147 */           agg_value18 = (double) 0;
/* 148 */         }
/* 149 */         // evaluate aggregate function
/* 150 */         boolean agg_isNull17 = true;
/* 151 */         double agg_value21 = -1.0;
/* 152 */
/* 153 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 154 */         double agg_value23 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 155 */         boolean agg_isNull18 = agg_isNull19;
/* 156 */         double agg_value22 = agg_value23;
/* 157 */         if (agg_isNull18) {
/* 158 */           if (!agg_isNull14) {
/* 159 */             agg_isNull18 = false;
/* 160 */             agg_value22 = agg_value18;
/* 161 */           }
/* 162 */         }
/* 163 */
/* 164 */         if (!inputadapter_isNull3) {
/* 165 */           agg_isNull17 = false; // resultCode could change nullability.
/* 166 */           agg_value21 = agg_value22 + inputadapter_value3;
/* 167 */
/* 168 */         }
/* 169 */         boolean agg_isNull16 = agg_isNull17;
/* 170 */         double agg_value20 = agg_value21;
/* 171 */         if (agg_isNull16) {
/* 172 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 173 */           double agg_value25 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 174 */           if (!agg_isNull21) {
/* 175 */             agg_isNull16 = false;
/* 176 */             agg_value20 = agg_value25;
/* 177 */           }
/* 178 */         }
/* 179 */         boolean agg_isNull23 = true;
/* 180 */         double agg_value27 = -1.0;
/* 181 */
/* 182 */         boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 183 */         double agg_value29 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 184 */         boolean agg_isNull24 = agg_isNull25;
/* 185 */         double agg_value28 = agg_value29;
/* 186 */         if (agg_isNull24) {
/* 187 */           if (!agg_isNull14) {
/* 188 */             agg_isNull24 = false;
/* 189 */             agg_value28 = agg_value18;
/* 190 */           }
/* 191 */         }
/* 192 */
/* 193 */         if (!inputadapter_isNull4) {
/* 194 */           agg_isNull23 = false; // resultCode could change nullability.
/* 195 */           agg_value27 = agg_value28 + inputadapter_value4;
/* 196 */
/* 197 */         }
/* 198 */         boolean agg_isNull22 = agg_isNull23;
/* 199 */         double agg_value26 = agg_value27;
/* 200 */         if (agg_isNull22) {
/* 201 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 202 */           double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 203 */           if (!agg_isNull27) {
/* 204 */             agg_isNull22 = false;
/* 205 */             agg_value26 = agg_value31;
/* 206 */           }
/* 207 */         }
/* 208 */         boolean agg_isNull29 = true;
/* 209 */         double agg_value33 = -1.0;
/* 210 */
/* 211 */         boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 212 */         double agg_value35 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 213 */         boolean agg_isNull30 = agg_isNull31;
/* 214 */         double agg_value34 = agg_value35;
/* 215 */         if (agg_isNull30) {
/* 216 */           if (!agg_isNull14) {
/* 217 */             agg_isNull30 = false;
/* 218 */             agg_value34 = agg_value18;
/* 219 */           }
/* 220 */         }
/* 221 */
/* 222 */         if (!inputadapter_isNull5) {
/* 223 */           agg_isNull29 = false; // resultCode could change nullability.
/* 224 */           agg_value33 = agg_value34 + inputadapter_value5;
/* 225 */
/* 226 */         }
/* 227 */         boolean agg_isNull28 = agg_isNull29;
/* 228 */         double agg_value32 = agg_value33;
/* 229 */         if (agg_isNull28) {
/* 230 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 231 */           double agg_value37 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 232 */           if (!agg_isNull33) {
/* 233 */             agg_isNull28 = false;
/* 234 */             agg_value32 = agg_value37;
/* 235 */           }
/* 236 */         }
/* 237 */         boolean agg_isNull35 = true;
/* 238 */         double agg_value39 = -1.0;
/* 239 */
/* 240 */         boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 241 */         double agg_value41 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 242 */         boolean agg_isNull36 = agg_isNull37;
/* 243 */         double agg_value40 = agg_value41;
/* 244 */         if (agg_isNull36) {
/* 245 */           if (!agg_isNull14) {
/* 246 */             agg_isNull36 = false;
/* 247 */             agg_value40 = agg_value18;
/* 248 */           }
/* 249 */         }
/* 250 */
/* 251 */         if (!inputadapter_isNull6) {
/* 252 */           agg_isNull35 = false; // resultCode could change nullability.
/* 253 */           agg_value39 = agg_value40 + inputadapter_value6;
/* 254 */
/* 255 */         }
/* 256 */         boolean agg_isNull34 = agg_isNull35;
/* 257 */         double agg_value38 = agg_value39;
/* 258 */         if (agg_isNull34) {
/* 259 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 260 */           double agg_value43 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 261 */           if (!agg_isNull39) {
/* 262 */             agg_isNull34 = false;
/* 263 */             agg_value38 = agg_value43;
/* 264 */           }
/* 265 */         }
/* 266 */         // update unsafe row buffer
/* 267 */         if (!agg_isNull16) {
/* 268 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value20);
/* 269 */         } else {
/* 270 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 271 */         }
/* 272 */
/* 273 */         if (!agg_isNull22) {
/* 274 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value26);
/* 275 */         } else {
/* 276 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 277 */         }
/* 278 */
/* 279 */         if (!agg_isNull28) {
/* 280 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value32);
/* 281 */         } else {
/* 282 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 283 */         }
/* 284 */
/* 285 */         if (!agg_isNull34) {
/* 286 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value38);
/* 287 */         } else {
/* 288 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 289 */         }
/* 290 */
/* 291 */       }
/* 292 */       if (shouldStop()) return;
/* 293 */     }
/* 294 */
/* 295 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 296 */   }
/* 297 */
/* 298 */   protected void processNext() throws java.io.IOException {
/* 299 */     if (!agg_initAgg) {
/* 300 */       agg_initAgg = true;
/* 301 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 302 */       agg_doAggregateWithKeys();
/* 303 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 304 */     }
/* 305 */
/* 306 */     // output the result
/* 307 */
/* 308 */     while (agg_mapIter.next()) {
/* 309 */       wholestagecodegen_numOutputRows.add(1);
/* 310 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 311 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 312 */
/* 313 */       boolean agg_isNull40 = agg_aggKey.isNullAt(0);
/* 314 */       UTF8String agg_value44 = agg_isNull40 ? null : (agg_aggKey.getUTF8String(0));
/* 315 */       boolean agg_isNull41 = agg_aggKey.isNullAt(1);
/* 316 */       UTF8String agg_value45 = agg_isNull41 ? null : (agg_aggKey.getUTF8String(1));
/* 317 */       int agg_value46 = agg_aggKey.getInt(2);
/* 318 */       boolean agg_isNull43 = agg_aggBuffer.isNullAt(0);
/* 319 */       double agg_value47 = agg_isNull43 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 320 */       boolean agg_isNull44 = agg_aggBuffer.isNullAt(1);
/* 321 */       double agg_value48 = agg_isNull44 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 322 */       boolean agg_isNull45 = agg_aggBuffer.isNullAt(2);
/* 323 */       double agg_value49 = agg_isNull45 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 324 */       boolean agg_isNull46 = agg_aggBuffer.isNullAt(3);
/* 325 */       double agg_value50 = agg_isNull46 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 326 */
/* 327 */       boolean agg_isNull51 = false;
/* 328 */       double agg_value55 = -1.0;
/* 329 */       if (agg_isNull44 || agg_value48 == 0) {
/* 330 */         agg_isNull51 = true;
/* 331 */       } else {
/* 332 */         if (agg_isNull43) {
/* 333 */           agg_isNull51 = true;
/* 334 */         } else {
/* 335 */           agg_value55 = (double)(agg_value47 / agg_value48);
/* 336 */         }
/* 337 */       }
/* 338 */       boolean agg_isNull56 = false;
/* 339 */
/* 340 */       boolean agg_isNull58 = false;
/* 341 */
/* 342 */       boolean agg_isNull59 = false;
/* 343 */
/* 344 */       int agg_value63 = -1;
/* 345 */       agg_value63 = agg_value46 >> 1;
/* 346 */
/* 347 */       int agg_value62 = -1;
/* 348 */       agg_value62 = agg_value63 & 1;
/* 349 */       boolean agg_isNull57 = false;
/* 350 */       byte agg_value61 = (byte)-1;
/* 351 */       if (!false) {
/* 352 */         agg_value61 = (byte) agg_value62;
/* 353 */       }
/* 354 */
/* 355 */       boolean agg_isNull64 = false;
/* 356 */
/* 357 */       boolean agg_isNull65 = false;
/* 358 */
/* 359 */       int agg_value69 = -1;
/* 360 */       agg_value69 = agg_value46 >> 0;
/* 361 */
/* 362 */       int agg_value68 = -1;
/* 363 */       agg_value68 = agg_value69 & 1;
/* 364 */       boolean agg_isNull63 = false;
/* 365 */       byte agg_value67 = (byte)-1;
/* 366 */       if (!false) {
/* 367 */         agg_value67 = (byte) agg_value68;
/* 368 */       }
/* 369 */       byte agg_value60 = (byte)-1;
/* 370 */       agg_value60 = (byte)(agg_value61 + agg_value67);
/* 371 */       boolean agg_isNull69 = false;
/* 372 */
/* 373 */       boolean agg_isNull71 = false;
/* 374 */
/* 375 */       boolean agg_isNull72 = false;
/* 376 */
/* 377 */       int agg_value76 = -1;
/* 378 */       agg_value76 = agg_value46 >> 1;
/* 379 */
/* 380 */       int agg_value75 = -1;
/* 381 */       agg_value75 = agg_value76 & 1;
/* 382 */       boolean agg_isNull70 = false;
/* 383 */       byte agg_value74 = (byte)-1;
/* 384 */       if (!false) {
/* 385 */         agg_value74 = (byte) agg_value75;
/* 386 */       }
/* 387 */
/* 388 */       boolean agg_isNull77 = false;
/* 389 */
/* 390 */       boolean agg_isNull78 = false;
/* 391 */
/* 392 */       int agg_value82 = -1;
/* 393 */       agg_value82 = agg_value46 >> 0;
/* 394 */
/* 395 */       int agg_value81 = -1;
/* 396 */       agg_value81 = agg_value82 & 1;
/* 397 */       boolean agg_isNull76 = false;
/* 398 */       byte agg_value80 = (byte)-1;
/* 399 */       if (!false) {
/* 400 */         agg_value80 = (byte) agg_value81;
/* 401 */       }
/* 402 */       byte agg_value73 = (byte)-1;
/* 403 */       agg_value73 = (byte)(agg_value74 + agg_value80);
/* 404 */       boolean agg_isNull82 = true;
/* 405 */       UTF8String agg_value86 = null;
/* 406 */
/* 407 */       boolean agg_isNull83 = false;
/* 408 */
/* 409 */       boolean agg_isNull86 = false;
/* 410 */
/* 411 */       boolean agg_isNull87 = false;
/* 412 */
/* 413 */       int agg_value91 = -1;
/* 414 */       agg_value91 = agg_value46 >> 0;
/* 415 */
/* 416 */       int agg_value90 = -1;
/* 417 */       agg_value90 = agg_value91 & 1;
/* 418 */       boolean agg_isNull85 = false;
/* 419 */       byte agg_value89 = (byte)-1;
/* 420 */       if (!false) {
/* 421 */         agg_value89 = (byte) agg_value90;
/* 422 */       }
/* 423 */       boolean agg_isNull84 = agg_isNull85;
/* 424 */       int agg_value88 = -1;
/* 425 */       if (!agg_isNull85) {
/* 426 */         agg_value88 = (int) agg_value89;
/* 427 */       }
/* 428 */
/* 429 */       boolean agg_value87 = false;
/* 430 */       agg_value87 = agg_value88 == 0;
/* 431 */       if (!false && agg_value87) {
/* 432 */         agg_isNull82 = agg_isNull40;
/* 433 */         agg_value86 = agg_value44;
/* 434 */       }
/* 435 */
/* 436 */       else {
/* 437 */       }
/* 438 */       boolean agg_isNull93 = false;
/* 439 */       double agg_value97 = -1.0;
/* 440 */       if (agg_isNull46 || agg_value50 == 0) {
/* 441 */         agg_isNull93 = true;
/* 442 */       } else {
/* 443 */         if (agg_isNull45) {
/* 444 */           agg_isNull93 = true;
/* 445 */         } else {
/* 446 */           agg_value97 = (double)(agg_value49 / agg_value50);
/* 447 */         }
/* 448 */       }
/* 449 */       agg_holder1.reset();
/* 450 */
/* 451 */       agg_rowWriter1.zeroOutNullBytes();
/* 452 */
/* 453 */       if (agg_isNull51) {
/* 454 */         agg_rowWriter1.setNullAt(0);
/* 455 */       } else {
/* 456 */         agg_rowWriter1.write(0, agg_value55);
/* 457 */       }
/* 458 */
/* 459 */       if (agg_isNull40) {
/* 460 */         agg_rowWriter1.setNullAt(1);
/* 461 */       } else {
/* 462 */         agg_rowWriter1.write(1, agg_value44);
/* 463 */       }
/* 464 */
/* 465 */       if (agg_isNull41) {
/* 466 */         agg_rowWriter1.setNullAt(2);
/* 467 */       } else {
/* 468 */         agg_rowWriter1.write(2, agg_value45);
/* 469 */       }
/* 470 */
/* 471 */       agg_rowWriter1.write(3, agg_value60);
/* 472 */
/* 473 */       agg_rowWriter1.write(4, agg_value73);
/* 474 */
/* 475 */       if (agg_isNull82) {
/* 476 */         agg_rowWriter1.setNullAt(5);
/* 477 */       } else {
/* 478 */         agg_rowWriter1.write(5, agg_value86);
/* 479 */       }
/* 480 */
/* 481 */       if (agg_isNull93) {
/* 482 */         agg_rowWriter1.setNullAt(6);
/* 483 */       } else {
/* 484 */         agg_rowWriter1.write(6, agg_value97);
/* 485 */       }
/* 486 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 487 */       append(agg_result1);
/* 488 */
/* 489 */       if (shouldStop()) return;
/* 490 */     }
/* 491 */
/* 492 */     agg_mapIter.close();
/* 493 */     if (agg_sorter == null) {
/* 494 */       agg_hashMap.free();
/* 495 */     }
/* 496 */   }
/* 497 */ }
