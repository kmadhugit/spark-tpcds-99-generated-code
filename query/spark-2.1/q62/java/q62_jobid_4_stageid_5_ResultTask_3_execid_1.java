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
/* 065 */     while (inputadapter_input.hasNext()) {
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
/* 155 */         boolean agg_isNull15 = false;
/* 156 */         long agg_value20 = -1L;
/* 157 */         if (!false) {
/* 158 */           agg_value20 = (long) 0;
/* 159 */         }
/* 160 */         // evaluate aggregate function
/* 161 */         boolean agg_isNull18 = true;
/* 162 */         long agg_value23 = -1L;
/* 163 */
/* 164 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 165 */         long agg_value25 = agg_isNull20 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 166 */         boolean agg_isNull19 = agg_isNull20;
/* 167 */         long agg_value24 = agg_value25;
/* 168 */         if (agg_isNull19) {
/* 169 */           if (!agg_isNull15) {
/* 170 */             agg_isNull19 = false;
/* 171 */             agg_value24 = agg_value20;
/* 172 */           }
/* 173 */         }
/* 174 */
/* 175 */         if (!inputadapter_isNull3) {
/* 176 */           agg_isNull18 = false; // resultCode could change nullability.
/* 177 */           agg_value23 = agg_value24 + inputadapter_value3;
/* 178 */
/* 179 */         }
/* 180 */         boolean agg_isNull17 = agg_isNull18;
/* 181 */         long agg_value22 = agg_value23;
/* 182 */         if (agg_isNull17) {
/* 183 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 184 */           long agg_value27 = agg_isNull22 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 185 */           if (!agg_isNull22) {
/* 186 */             agg_isNull17 = false;
/* 187 */             agg_value22 = agg_value27;
/* 188 */           }
/* 189 */         }
/* 190 */         boolean agg_isNull24 = true;
/* 191 */         long agg_value29 = -1L;
/* 192 */
/* 193 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 194 */         long agg_value31 = agg_isNull26 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 195 */         boolean agg_isNull25 = agg_isNull26;
/* 196 */         long agg_value30 = agg_value31;
/* 197 */         if (agg_isNull25) {
/* 198 */           if (!agg_isNull15) {
/* 199 */             agg_isNull25 = false;
/* 200 */             agg_value30 = agg_value20;
/* 201 */           }
/* 202 */         }
/* 203 */
/* 204 */         if (!inputadapter_isNull4) {
/* 205 */           agg_isNull24 = false; // resultCode could change nullability.
/* 206 */           agg_value29 = agg_value30 + inputadapter_value4;
/* 207 */
/* 208 */         }
/* 209 */         boolean agg_isNull23 = agg_isNull24;
/* 210 */         long agg_value28 = agg_value29;
/* 211 */         if (agg_isNull23) {
/* 212 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 213 */           long agg_value33 = agg_isNull28 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 214 */           if (!agg_isNull28) {
/* 215 */             agg_isNull23 = false;
/* 216 */             agg_value28 = agg_value33;
/* 217 */           }
/* 218 */         }
/* 219 */         boolean agg_isNull30 = true;
/* 220 */         long agg_value35 = -1L;
/* 221 */
/* 222 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 223 */         long agg_value37 = agg_isNull32 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 224 */         boolean agg_isNull31 = agg_isNull32;
/* 225 */         long agg_value36 = agg_value37;
/* 226 */         if (agg_isNull31) {
/* 227 */           if (!agg_isNull15) {
/* 228 */             agg_isNull31 = false;
/* 229 */             agg_value36 = agg_value20;
/* 230 */           }
/* 231 */         }
/* 232 */
/* 233 */         if (!inputadapter_isNull5) {
/* 234 */           agg_isNull30 = false; // resultCode could change nullability.
/* 235 */           agg_value35 = agg_value36 + inputadapter_value5;
/* 236 */
/* 237 */         }
/* 238 */         boolean agg_isNull29 = agg_isNull30;
/* 239 */         long agg_value34 = agg_value35;
/* 240 */         if (agg_isNull29) {
/* 241 */           boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 242 */           long agg_value39 = agg_isNull34 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 243 */           if (!agg_isNull34) {
/* 244 */             agg_isNull29 = false;
/* 245 */             agg_value34 = agg_value39;
/* 246 */           }
/* 247 */         }
/* 248 */         boolean agg_isNull36 = true;
/* 249 */         long agg_value41 = -1L;
/* 250 */
/* 251 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 252 */         long agg_value43 = agg_isNull38 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 253 */         boolean agg_isNull37 = agg_isNull38;
/* 254 */         long agg_value42 = agg_value43;
/* 255 */         if (agg_isNull37) {
/* 256 */           if (!agg_isNull15) {
/* 257 */             agg_isNull37 = false;
/* 258 */             agg_value42 = agg_value20;
/* 259 */           }
/* 260 */         }
/* 261 */
/* 262 */         if (!inputadapter_isNull6) {
/* 263 */           agg_isNull36 = false; // resultCode could change nullability.
/* 264 */           agg_value41 = agg_value42 + inputadapter_value6;
/* 265 */
/* 266 */         }
/* 267 */         boolean agg_isNull35 = agg_isNull36;
/* 268 */         long agg_value40 = agg_value41;
/* 269 */         if (agg_isNull35) {
/* 270 */           boolean agg_isNull40 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 271 */           long agg_value45 = agg_isNull40 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 272 */           if (!agg_isNull40) {
/* 273 */             agg_isNull35 = false;
/* 274 */             agg_value40 = agg_value45;
/* 275 */           }
/* 276 */         }
/* 277 */         boolean agg_isNull42 = true;
/* 278 */         long agg_value47 = -1L;
/* 279 */
/* 280 */         boolean agg_isNull44 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 281 */         long agg_value49 = agg_isNull44 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 282 */         boolean agg_isNull43 = agg_isNull44;
/* 283 */         long agg_value48 = agg_value49;
/* 284 */         if (agg_isNull43) {
/* 285 */           if (!agg_isNull15) {
/* 286 */             agg_isNull43 = false;
/* 287 */             agg_value48 = agg_value20;
/* 288 */           }
/* 289 */         }
/* 290 */
/* 291 */         if (!inputadapter_isNull7) {
/* 292 */           agg_isNull42 = false; // resultCode could change nullability.
/* 293 */           agg_value47 = agg_value48 + inputadapter_value7;
/* 294 */
/* 295 */         }
/* 296 */         boolean agg_isNull41 = agg_isNull42;
/* 297 */         long agg_value46 = agg_value47;
/* 298 */         if (agg_isNull41) {
/* 299 */           boolean agg_isNull46 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 300 */           long agg_value51 = agg_isNull46 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 301 */           if (!agg_isNull46) {
/* 302 */             agg_isNull41 = false;
/* 303 */             agg_value46 = agg_value51;
/* 304 */           }
/* 305 */         }
/* 306 */         // update unsafe row buffer
/* 307 */         if (!agg_isNull17) {
/* 308 */           agg_unsafeRowAggBuffer.setLong(0, agg_value22);
/* 309 */         } else {
/* 310 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 311 */         }
/* 312 */
/* 313 */         if (!agg_isNull23) {
/* 314 */           agg_unsafeRowAggBuffer.setLong(1, agg_value28);
/* 315 */         } else {
/* 316 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 317 */         }
/* 318 */
/* 319 */         if (!agg_isNull29) {
/* 320 */           agg_unsafeRowAggBuffer.setLong(2, agg_value34);
/* 321 */         } else {
/* 322 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 323 */         }
/* 324 */
/* 325 */         if (!agg_isNull35) {
/* 326 */           agg_unsafeRowAggBuffer.setLong(3, agg_value40);
/* 327 */         } else {
/* 328 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 329 */         }
/* 330 */
/* 331 */         if (!agg_isNull41) {
/* 332 */           agg_unsafeRowAggBuffer.setLong(4, agg_value46);
/* 333 */         } else {
/* 334 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 335 */         }
/* 336 */
/* 337 */       }
/* 338 */       if (shouldStop()) return;
/* 339 */     }
/* 340 */
/* 341 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 342 */   }
/* 343 */
/* 344 */   protected void processNext() throws java.io.IOException {
/* 345 */     if (!agg_initAgg) {
/* 346 */       agg_initAgg = true;
/* 347 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 348 */       agg_doAggregateWithKeys();
/* 349 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 350 */     }
/* 351 */
/* 352 */     // output the result
/* 353 */
/* 354 */     while (agg_mapIter.next()) {
/* 355 */       wholestagecodegen_numOutputRows.add(1);
/* 356 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 357 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 358 */
/* 359 */       boolean agg_isNull47 = agg_aggKey.isNullAt(0);
/* 360 */       UTF8String agg_value52 = agg_isNull47 ? null : (agg_aggKey.getUTF8String(0));
/* 361 */       boolean agg_isNull48 = agg_aggKey.isNullAt(1);
/* 362 */       UTF8String agg_value53 = agg_isNull48 ? null : (agg_aggKey.getUTF8String(1));
/* 363 */       boolean agg_isNull49 = agg_aggKey.isNullAt(2);
/* 364 */       UTF8String agg_value54 = agg_isNull49 ? null : (agg_aggKey.getUTF8String(2));
/* 365 */       boolean agg_isNull50 = agg_aggBuffer.isNullAt(0);
/* 366 */       long agg_value55 = agg_isNull50 ? -1L : (agg_aggBuffer.getLong(0));
/* 367 */       boolean agg_isNull51 = agg_aggBuffer.isNullAt(1);
/* 368 */       long agg_value56 = agg_isNull51 ? -1L : (agg_aggBuffer.getLong(1));
/* 369 */       boolean agg_isNull52 = agg_aggBuffer.isNullAt(2);
/* 370 */       long agg_value57 = agg_isNull52 ? -1L : (agg_aggBuffer.getLong(2));
/* 371 */       boolean agg_isNull53 = agg_aggBuffer.isNullAt(3);
/* 372 */       long agg_value58 = agg_isNull53 ? -1L : (agg_aggBuffer.getLong(3));
/* 373 */       boolean agg_isNull54 = agg_aggBuffer.isNullAt(4);
/* 374 */       long agg_value59 = agg_isNull54 ? -1L : (agg_aggBuffer.getLong(4));
/* 375 */
/* 376 */       agg_holder1.reset();
/* 377 */
/* 378 */       agg_rowWriter1.zeroOutNullBytes();
/* 379 */
/* 380 */       if (agg_isNull47) {
/* 381 */         agg_rowWriter1.setNullAt(0);
/* 382 */       } else {
/* 383 */         agg_rowWriter1.write(0, agg_value52);
/* 384 */       }
/* 385 */
/* 386 */       if (agg_isNull48) {
/* 387 */         agg_rowWriter1.setNullAt(1);
/* 388 */       } else {
/* 389 */         agg_rowWriter1.write(1, agg_value53);
/* 390 */       }
/* 391 */
/* 392 */       if (agg_isNull49) {
/* 393 */         agg_rowWriter1.setNullAt(2);
/* 394 */       } else {
/* 395 */         agg_rowWriter1.write(2, agg_value54);
/* 396 */       }
/* 397 */
/* 398 */       if (agg_isNull50) {
/* 399 */         agg_rowWriter1.setNullAt(3);
/* 400 */       } else {
/* 401 */         agg_rowWriter1.write(3, agg_value55);
/* 402 */       }
/* 403 */
/* 404 */       if (agg_isNull51) {
/* 405 */         agg_rowWriter1.setNullAt(4);
/* 406 */       } else {
/* 407 */         agg_rowWriter1.write(4, agg_value56);
/* 408 */       }
/* 409 */
/* 410 */       if (agg_isNull52) {
/* 411 */         agg_rowWriter1.setNullAt(5);
/* 412 */       } else {
/* 413 */         agg_rowWriter1.write(5, agg_value57);
/* 414 */       }
/* 415 */
/* 416 */       if (agg_isNull53) {
/* 417 */         agg_rowWriter1.setNullAt(6);
/* 418 */       } else {
/* 419 */         agg_rowWriter1.write(6, agg_value58);
/* 420 */       }
/* 421 */
/* 422 */       if (agg_isNull54) {
/* 423 */         agg_rowWriter1.setNullAt(7);
/* 424 */       } else {
/* 425 */         agg_rowWriter1.write(7, agg_value59);
/* 426 */       }
/* 427 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 428 */       append(agg_result1);
/* 429 */
/* 430 */       if (shouldStop()) return;
/* 431 */     }
/* 432 */
/* 433 */     agg_mapIter.close();
/* 434 */     if (agg_sorter == null) {
/* 435 */       agg_hashMap.free();
/* 436 */     }
/* 437 */   }
/* 438 */ }
