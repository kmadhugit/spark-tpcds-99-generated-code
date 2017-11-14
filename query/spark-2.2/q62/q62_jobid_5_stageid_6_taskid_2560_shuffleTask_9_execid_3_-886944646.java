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
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private long agg_bufValue4;
/* 019 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 020 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 021 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 025 */   private scala.collection.Iterator inputadapter_input;
/* 026 */   private UnsafeRow agg_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 029 */   private int agg_value16;
/* 030 */   private UnsafeRow agg_result1;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     agg_initAgg = false;
/* 044 */
/* 045 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 046 */
/* 047 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 048 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 049 */     inputadapter_input = inputs[0];
/* 050 */     agg_result = new UnsafeRow(3);
/* 051 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 052 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 053 */
/* 054 */     agg_result1 = new UnsafeRow(8);
/* 055 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 056 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 8);
/* 057 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 058 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 063 */     agg_hashMap = agg_plan.createHashMap();
/* 064 */
/* 065 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 066 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 067 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 068 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 069 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 070 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 071 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 072 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 073 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 074 */       long inputadapter_value3 = inputadapter_isNull3 ? -1L : (inputadapter_row.getLong(3));
/* 075 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 076 */       long inputadapter_value4 = inputadapter_isNull4 ? -1L : (inputadapter_row.getLong(4));
/* 077 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 078 */       long inputadapter_value5 = inputadapter_isNull5 ? -1L : (inputadapter_row.getLong(5));
/* 079 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 080 */       long inputadapter_value6 = inputadapter_isNull6 ? -1L : (inputadapter_row.getLong(6));
/* 081 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 082 */       long inputadapter_value7 = inputadapter_isNull7 ? -1L : (inputadapter_row.getLong(7));
/* 083 */
/* 084 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 085 */
/* 086 */       UnsafeRow agg_fastAggBuffer = null;
/* 087 */
/* 088 */       if (agg_fastAggBuffer == null) {
/* 089 */         // generate grouping key
/* 090 */         agg_holder.reset();
/* 091 */
/* 092 */         agg_rowWriter.zeroOutNullBytes();
/* 093 */
/* 094 */         if (inputadapter_isNull) {
/* 095 */           agg_rowWriter.setNullAt(0);
/* 096 */         } else {
/* 097 */           agg_rowWriter.write(0, inputadapter_value);
/* 098 */         }
/* 099 */
/* 100 */         if (inputadapter_isNull1) {
/* 101 */           agg_rowWriter.setNullAt(1);
/* 102 */         } else {
/* 103 */           agg_rowWriter.write(1, inputadapter_value1);
/* 104 */         }
/* 105 */
/* 106 */         if (inputadapter_isNull2) {
/* 107 */           agg_rowWriter.setNullAt(2);
/* 108 */         } else {
/* 109 */           agg_rowWriter.write(2, inputadapter_value2);
/* 110 */         }
/* 111 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 112 */         agg_value16 = 42;
/* 113 */
/* 114 */         if (!inputadapter_isNull) {
/* 115 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value16);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull1) {
/* 119 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value16);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull2) {
/* 123 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value16);
/* 124 */         }
/* 125 */         if (true) {
/* 126 */           // try to get the buffer from hash map
/* 127 */           agg_unsafeRowAggBuffer =
/* 128 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 129 */         }
/* 130 */         if (agg_unsafeRowAggBuffer == null) {
/* 131 */           if (agg_sorter == null) {
/* 132 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 133 */           } else {
/* 134 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 135 */           }
/* 136 */
/* 137 */           // the hash map had be spilled, it should have enough memory now,
/* 138 */           // try  to allocate buffer again.
/* 139 */           agg_unsafeRowAggBuffer =
/* 140 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 141 */           if (agg_unsafeRowAggBuffer == null) {
/* 142 */             // failed to allocate the first page
/* 143 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 144 */           }
/* 145 */         }
/* 146 */       }
/* 147 */
/* 148 */       if (agg_fastAggBuffer != null) {
/* 149 */         // update fast row
/* 150 */
/* 151 */       } else {
/* 152 */         // update unsafe row
/* 153 */
/* 154 */         // common sub-expressions
/* 155 */
/* 156 */         // evaluate aggregate function
/* 157 */         boolean agg_isNull16 = true;
/* 158 */         long agg_value21 = -1L;
/* 159 */
/* 160 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 161 */         long agg_value23 = agg_isNull18 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 162 */         boolean agg_isNull17 = agg_isNull18;
/* 163 */         long agg_value22 = agg_value23;
/* 164 */         if (agg_isNull17) {
/* 165 */           boolean agg_isNull19 = false;
/* 166 */           long agg_value24 = -1L;
/* 167 */           if (!false) {
/* 168 */             agg_value24 = (long) 0;
/* 169 */           }
/* 170 */           if (!agg_isNull19) {
/* 171 */             agg_isNull17 = false;
/* 172 */             agg_value22 = agg_value24;
/* 173 */           }
/* 174 */         }
/* 175 */
/* 176 */         if (!inputadapter_isNull3) {
/* 177 */           agg_isNull16 = false; // resultCode could change nullability.
/* 178 */           agg_value21 = agg_value22 + inputadapter_value3;
/* 179 */
/* 180 */         }
/* 181 */         boolean agg_isNull15 = agg_isNull16;
/* 182 */         long agg_value20 = agg_value21;
/* 183 */         if (agg_isNull15) {
/* 184 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 185 */           long agg_value27 = agg_isNull22 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 186 */           if (!agg_isNull22) {
/* 187 */             agg_isNull15 = false;
/* 188 */             agg_value20 = agg_value27;
/* 189 */           }
/* 190 */         }
/* 191 */         boolean agg_isNull24 = true;
/* 192 */         long agg_value29 = -1L;
/* 193 */
/* 194 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 195 */         long agg_value31 = agg_isNull26 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 196 */         boolean agg_isNull25 = agg_isNull26;
/* 197 */         long agg_value30 = agg_value31;
/* 198 */         if (agg_isNull25) {
/* 199 */           boolean agg_isNull27 = false;
/* 200 */           long agg_value32 = -1L;
/* 201 */           if (!false) {
/* 202 */             agg_value32 = (long) 0;
/* 203 */           }
/* 204 */           if (!agg_isNull27) {
/* 205 */             agg_isNull25 = false;
/* 206 */             agg_value30 = agg_value32;
/* 207 */           }
/* 208 */         }
/* 209 */
/* 210 */         if (!inputadapter_isNull4) {
/* 211 */           agg_isNull24 = false; // resultCode could change nullability.
/* 212 */           agg_value29 = agg_value30 + inputadapter_value4;
/* 213 */
/* 214 */         }
/* 215 */         boolean agg_isNull23 = agg_isNull24;
/* 216 */         long agg_value28 = agg_value29;
/* 217 */         if (agg_isNull23) {
/* 218 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 219 */           long agg_value35 = agg_isNull30 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 220 */           if (!agg_isNull30) {
/* 221 */             agg_isNull23 = false;
/* 222 */             agg_value28 = agg_value35;
/* 223 */           }
/* 224 */         }
/* 225 */         boolean agg_isNull32 = true;
/* 226 */         long agg_value37 = -1L;
/* 227 */
/* 228 */         boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 229 */         long agg_value39 = agg_isNull34 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 230 */         boolean agg_isNull33 = agg_isNull34;
/* 231 */         long agg_value38 = agg_value39;
/* 232 */         if (agg_isNull33) {
/* 233 */           boolean agg_isNull35 = false;
/* 234 */           long agg_value40 = -1L;
/* 235 */           if (!false) {
/* 236 */             agg_value40 = (long) 0;
/* 237 */           }
/* 238 */           if (!agg_isNull35) {
/* 239 */             agg_isNull33 = false;
/* 240 */             agg_value38 = agg_value40;
/* 241 */           }
/* 242 */         }
/* 243 */
/* 244 */         if (!inputadapter_isNull5) {
/* 245 */           agg_isNull32 = false; // resultCode could change nullability.
/* 246 */           agg_value37 = agg_value38 + inputadapter_value5;
/* 247 */
/* 248 */         }
/* 249 */         boolean agg_isNull31 = agg_isNull32;
/* 250 */         long agg_value36 = agg_value37;
/* 251 */         if (agg_isNull31) {
/* 252 */           boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 253 */           long agg_value43 = agg_isNull38 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 254 */           if (!agg_isNull38) {
/* 255 */             agg_isNull31 = false;
/* 256 */             agg_value36 = agg_value43;
/* 257 */           }
/* 258 */         }
/* 259 */         boolean agg_isNull40 = true;
/* 260 */         long agg_value45 = -1L;
/* 261 */
/* 262 */         boolean agg_isNull42 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 263 */         long agg_value47 = agg_isNull42 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 264 */         boolean agg_isNull41 = agg_isNull42;
/* 265 */         long agg_value46 = agg_value47;
/* 266 */         if (agg_isNull41) {
/* 267 */           boolean agg_isNull43 = false;
/* 268 */           long agg_value48 = -1L;
/* 269 */           if (!false) {
/* 270 */             agg_value48 = (long) 0;
/* 271 */           }
/* 272 */           if (!agg_isNull43) {
/* 273 */             agg_isNull41 = false;
/* 274 */             agg_value46 = agg_value48;
/* 275 */           }
/* 276 */         }
/* 277 */
/* 278 */         if (!inputadapter_isNull6) {
/* 279 */           agg_isNull40 = false; // resultCode could change nullability.
/* 280 */           agg_value45 = agg_value46 + inputadapter_value6;
/* 281 */
/* 282 */         }
/* 283 */         boolean agg_isNull39 = agg_isNull40;
/* 284 */         long agg_value44 = agg_value45;
/* 285 */         if (agg_isNull39) {
/* 286 */           boolean agg_isNull46 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 287 */           long agg_value51 = agg_isNull46 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 288 */           if (!agg_isNull46) {
/* 289 */             agg_isNull39 = false;
/* 290 */             agg_value44 = agg_value51;
/* 291 */           }
/* 292 */         }
/* 293 */         boolean agg_isNull48 = true;
/* 294 */         long agg_value53 = -1L;
/* 295 */
/* 296 */         boolean agg_isNull50 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 297 */         long agg_value55 = agg_isNull50 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 298 */         boolean agg_isNull49 = agg_isNull50;
/* 299 */         long agg_value54 = agg_value55;
/* 300 */         if (agg_isNull49) {
/* 301 */           boolean agg_isNull51 = false;
/* 302 */           long agg_value56 = -1L;
/* 303 */           if (!false) {
/* 304 */             agg_value56 = (long) 0;
/* 305 */           }
/* 306 */           if (!agg_isNull51) {
/* 307 */             agg_isNull49 = false;
/* 308 */             agg_value54 = agg_value56;
/* 309 */           }
/* 310 */         }
/* 311 */
/* 312 */         if (!inputadapter_isNull7) {
/* 313 */           agg_isNull48 = false; // resultCode could change nullability.
/* 314 */           agg_value53 = agg_value54 + inputadapter_value7;
/* 315 */
/* 316 */         }
/* 317 */         boolean agg_isNull47 = agg_isNull48;
/* 318 */         long agg_value52 = agg_value53;
/* 319 */         if (agg_isNull47) {
/* 320 */           boolean agg_isNull54 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 321 */           long agg_value59 = agg_isNull54 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 322 */           if (!agg_isNull54) {
/* 323 */             agg_isNull47 = false;
/* 324 */             agg_value52 = agg_value59;
/* 325 */           }
/* 326 */         }
/* 327 */         // update unsafe row buffer
/* 328 */         if (!agg_isNull15) {
/* 329 */           agg_unsafeRowAggBuffer.setLong(0, agg_value20);
/* 330 */         } else {
/* 331 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 332 */         }
/* 333 */
/* 334 */         if (!agg_isNull23) {
/* 335 */           agg_unsafeRowAggBuffer.setLong(1, agg_value28);
/* 336 */         } else {
/* 337 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 338 */         }
/* 339 */
/* 340 */         if (!agg_isNull31) {
/* 341 */           agg_unsafeRowAggBuffer.setLong(2, agg_value36);
/* 342 */         } else {
/* 343 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 344 */         }
/* 345 */
/* 346 */         if (!agg_isNull39) {
/* 347 */           agg_unsafeRowAggBuffer.setLong(3, agg_value44);
/* 348 */         } else {
/* 349 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 350 */         }
/* 351 */
/* 352 */         if (!agg_isNull47) {
/* 353 */           agg_unsafeRowAggBuffer.setLong(4, agg_value52);
/* 354 */         } else {
/* 355 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 356 */         }
/* 357 */
/* 358 */       }
/* 359 */       if (shouldStop()) return;
/* 360 */     }
/* 361 */
/* 362 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 363 */   }
/* 364 */
/* 365 */   protected void processNext() throws java.io.IOException {
/* 366 */     if (!agg_initAgg) {
/* 367 */       agg_initAgg = true;
/* 368 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 369 */       agg_doAggregateWithKeys();
/* 370 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 371 */     }
/* 372 */
/* 373 */     // output the result
/* 374 */
/* 375 */     while (agg_mapIter.next()) {
/* 376 */       wholestagecodegen_numOutputRows.add(1);
/* 377 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 378 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 379 */
/* 380 */       boolean agg_isNull55 = agg_aggKey.isNullAt(0);
/* 381 */       UTF8String agg_value60 = agg_isNull55 ? null : (agg_aggKey.getUTF8String(0));
/* 382 */       boolean agg_isNull56 = agg_aggKey.isNullAt(1);
/* 383 */       UTF8String agg_value61 = agg_isNull56 ? null : (agg_aggKey.getUTF8String(1));
/* 384 */       boolean agg_isNull57 = agg_aggKey.isNullAt(2);
/* 385 */       UTF8String agg_value62 = agg_isNull57 ? null : (agg_aggKey.getUTF8String(2));
/* 386 */       boolean agg_isNull58 = agg_aggBuffer.isNullAt(0);
/* 387 */       long agg_value63 = agg_isNull58 ? -1L : (agg_aggBuffer.getLong(0));
/* 388 */       boolean agg_isNull59 = agg_aggBuffer.isNullAt(1);
/* 389 */       long agg_value64 = agg_isNull59 ? -1L : (agg_aggBuffer.getLong(1));
/* 390 */       boolean agg_isNull60 = agg_aggBuffer.isNullAt(2);
/* 391 */       long agg_value65 = agg_isNull60 ? -1L : (agg_aggBuffer.getLong(2));
/* 392 */       boolean agg_isNull61 = agg_aggBuffer.isNullAt(3);
/* 393 */       long agg_value66 = agg_isNull61 ? -1L : (agg_aggBuffer.getLong(3));
/* 394 */       boolean agg_isNull62 = agg_aggBuffer.isNullAt(4);
/* 395 */       long agg_value67 = agg_isNull62 ? -1L : (agg_aggBuffer.getLong(4));
/* 396 */
/* 397 */       agg_holder1.reset();
/* 398 */
/* 399 */       agg_rowWriter1.zeroOutNullBytes();
/* 400 */
/* 401 */       if (agg_isNull55) {
/* 402 */         agg_rowWriter1.setNullAt(0);
/* 403 */       } else {
/* 404 */         agg_rowWriter1.write(0, agg_value60);
/* 405 */       }
/* 406 */
/* 407 */       if (agg_isNull56) {
/* 408 */         agg_rowWriter1.setNullAt(1);
/* 409 */       } else {
/* 410 */         agg_rowWriter1.write(1, agg_value61);
/* 411 */       }
/* 412 */
/* 413 */       if (agg_isNull57) {
/* 414 */         agg_rowWriter1.setNullAt(2);
/* 415 */       } else {
/* 416 */         agg_rowWriter1.write(2, agg_value62);
/* 417 */       }
/* 418 */
/* 419 */       if (agg_isNull58) {
/* 420 */         agg_rowWriter1.setNullAt(3);
/* 421 */       } else {
/* 422 */         agg_rowWriter1.write(3, agg_value63);
/* 423 */       }
/* 424 */
/* 425 */       if (agg_isNull59) {
/* 426 */         agg_rowWriter1.setNullAt(4);
/* 427 */       } else {
/* 428 */         agg_rowWriter1.write(4, agg_value64);
/* 429 */       }
/* 430 */
/* 431 */       if (agg_isNull60) {
/* 432 */         agg_rowWriter1.setNullAt(5);
/* 433 */       } else {
/* 434 */         agg_rowWriter1.write(5, agg_value65);
/* 435 */       }
/* 436 */
/* 437 */       if (agg_isNull61) {
/* 438 */         agg_rowWriter1.setNullAt(6);
/* 439 */       } else {
/* 440 */         agg_rowWriter1.write(6, agg_value66);
/* 441 */       }
/* 442 */
/* 443 */       if (agg_isNull62) {
/* 444 */         agg_rowWriter1.setNullAt(7);
/* 445 */       } else {
/* 446 */         agg_rowWriter1.write(7, agg_value67);
/* 447 */       }
/* 448 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 449 */       append(agg_result1);
/* 450 */
/* 451 */       if (shouldStop()) return;
/* 452 */     }
/* 453 */
/* 454 */     agg_mapIter.close();
/* 455 */     if (agg_sorter == null) {
/* 456 */       agg_hashMap.free();
/* 457 */     }
/* 458 */   }
/* 459 */ }
