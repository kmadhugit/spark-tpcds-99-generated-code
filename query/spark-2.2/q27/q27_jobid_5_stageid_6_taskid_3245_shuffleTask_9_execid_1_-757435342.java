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
/* 035 */   private int agg_value26;
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
/* 056 */     agg_result = new UnsafeRow(3);
/* 057 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 058 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 059 */
/* 060 */     agg_result1 = new UnsafeRow(7);
/* 061 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 062 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
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
/* 076 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 077 */       int inputadapter_value2 = inputadapter_row.getInt(2);
/* 078 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 079 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 080 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 081 */       long inputadapter_value4 = inputadapter_isNull4 ? -1L : (inputadapter_row.getLong(4));
/* 082 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 083 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 084 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 085 */       long inputadapter_value6 = inputadapter_isNull6 ? -1L : (inputadapter_row.getLong(6));
/* 086 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 087 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 088 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 089 */       long inputadapter_value8 = inputadapter_isNull8 ? -1L : (inputadapter_row.getLong(8));
/* 090 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 091 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 092 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 093 */       long inputadapter_value10 = inputadapter_isNull10 ? -1L : (inputadapter_row.getLong(10));
/* 094 */
/* 095 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 096 */
/* 097 */       UnsafeRow agg_fastAggBuffer = null;
/* 098 */
/* 099 */       if (agg_fastAggBuffer == null) {
/* 100 */         // generate grouping key
/* 101 */         agg_holder.reset();
/* 102 */
/* 103 */         agg_rowWriter.zeroOutNullBytes();
/* 104 */
/* 105 */         if (inputadapter_isNull) {
/* 106 */           agg_rowWriter.setNullAt(0);
/* 107 */         } else {
/* 108 */           agg_rowWriter.write(0, inputadapter_value);
/* 109 */         }
/* 110 */
/* 111 */         if (inputadapter_isNull1) {
/* 112 */           agg_rowWriter.setNullAt(1);
/* 113 */         } else {
/* 114 */           agg_rowWriter.write(1, inputadapter_value1);
/* 115 */         }
/* 116 */
/* 117 */         agg_rowWriter.write(2, inputadapter_value2);
/* 118 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 119 */         agg_value26 = 42;
/* 120 */
/* 121 */         if (!inputadapter_isNull) {
/* 122 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value26);
/* 123 */         }
/* 124 */
/* 125 */         if (!inputadapter_isNull1) {
/* 126 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value26);
/* 127 */         }
/* 128 */
/* 129 */         agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value26);
/* 130 */         if (true) {
/* 131 */           // try to get the buffer from hash map
/* 132 */           agg_unsafeRowAggBuffer =
/* 133 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value26);
/* 134 */         }
/* 135 */         if (agg_unsafeRowAggBuffer == null) {
/* 136 */           if (agg_sorter == null) {
/* 137 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 138 */           } else {
/* 139 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 140 */           }
/* 141 */
/* 142 */           // the hash map had be spilled, it should have enough memory now,
/* 143 */           // try  to allocate buffer again.
/* 144 */           agg_unsafeRowAggBuffer =
/* 145 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value26);
/* 146 */           if (agg_unsafeRowAggBuffer == null) {
/* 147 */             // failed to allocate the first page
/* 148 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 149 */           }
/* 150 */         }
/* 151 */       }
/* 152 */
/* 153 */       if (agg_fastAggBuffer != null) {
/* 154 */         // update fast row
/* 155 */
/* 156 */       } else {
/* 157 */         // update unsafe row
/* 158 */
/* 159 */         // common sub-expressions
/* 160 */
/* 161 */         // evaluate aggregate function
/* 162 */         boolean agg_isNull22 = true;
/* 163 */         double agg_value30 = -1.0;
/* 164 */
/* 165 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 166 */         double agg_value31 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 167 */         if (!agg_isNull23) {
/* 168 */           if (!inputadapter_isNull3) {
/* 169 */             agg_isNull22 = false; // resultCode could change nullability.
/* 170 */             agg_value30 = agg_value31 + inputadapter_value3;
/* 171 */
/* 172 */           }
/* 173 */
/* 174 */         }
/* 175 */         boolean agg_isNull25 = true;
/* 176 */         long agg_value33 = -1L;
/* 177 */
/* 178 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 179 */         long agg_value34 = agg_isNull26 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 180 */         if (!agg_isNull26) {
/* 181 */           if (!inputadapter_isNull4) {
/* 182 */             agg_isNull25 = false; // resultCode could change nullability.
/* 183 */             agg_value33 = agg_value34 + inputadapter_value4;
/* 184 */
/* 185 */           }
/* 186 */
/* 187 */         }
/* 188 */         boolean agg_isNull28 = true;
/* 189 */         double agg_value36 = -1.0;
/* 190 */
/* 191 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 192 */         double agg_value37 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 193 */         if (!agg_isNull29) {
/* 194 */           if (!inputadapter_isNull5) {
/* 195 */             agg_isNull28 = false; // resultCode could change nullability.
/* 196 */             agg_value36 = agg_value37 + inputadapter_value5;
/* 197 */
/* 198 */           }
/* 199 */
/* 200 */         }
/* 201 */         boolean agg_isNull31 = true;
/* 202 */         long agg_value39 = -1L;
/* 203 */
/* 204 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 205 */         long agg_value40 = agg_isNull32 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 206 */         if (!agg_isNull32) {
/* 207 */           if (!inputadapter_isNull6) {
/* 208 */             agg_isNull31 = false; // resultCode could change nullability.
/* 209 */             agg_value39 = agg_value40 + inputadapter_value6;
/* 210 */
/* 211 */           }
/* 212 */
/* 213 */         }
/* 214 */         boolean agg_isNull34 = true;
/* 215 */         double agg_value42 = -1.0;
/* 216 */
/* 217 */         boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 218 */         double agg_value43 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 219 */         if (!agg_isNull35) {
/* 220 */           if (!inputadapter_isNull7) {
/* 221 */             agg_isNull34 = false; // resultCode could change nullability.
/* 222 */             agg_value42 = agg_value43 + inputadapter_value7;
/* 223 */
/* 224 */           }
/* 225 */
/* 226 */         }
/* 227 */         boolean agg_isNull37 = true;
/* 228 */         long agg_value45 = -1L;
/* 229 */
/* 230 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 231 */         long agg_value46 = agg_isNull38 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 232 */         if (!agg_isNull38) {
/* 233 */           if (!inputadapter_isNull8) {
/* 234 */             agg_isNull37 = false; // resultCode could change nullability.
/* 235 */             agg_value45 = agg_value46 + inputadapter_value8;
/* 236 */
/* 237 */           }
/* 238 */
/* 239 */         }
/* 240 */         boolean agg_isNull40 = true;
/* 241 */         double agg_value48 = -1.0;
/* 242 */
/* 243 */         boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 244 */         double agg_value49 = agg_isNull41 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 245 */         if (!agg_isNull41) {
/* 246 */           if (!inputadapter_isNull9) {
/* 247 */             agg_isNull40 = false; // resultCode could change nullability.
/* 248 */             agg_value48 = agg_value49 + inputadapter_value9;
/* 249 */
/* 250 */           }
/* 251 */
/* 252 */         }
/* 253 */         boolean agg_isNull43 = true;
/* 254 */         long agg_value51 = -1L;
/* 255 */
/* 256 */         boolean agg_isNull44 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 257 */         long agg_value52 = agg_isNull44 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 258 */         if (!agg_isNull44) {
/* 259 */           if (!inputadapter_isNull10) {
/* 260 */             agg_isNull43 = false; // resultCode could change nullability.
/* 261 */             agg_value51 = agg_value52 + inputadapter_value10;
/* 262 */
/* 263 */           }
/* 264 */
/* 265 */         }
/* 266 */         // update unsafe row buffer
/* 267 */         if (!agg_isNull22) {
/* 268 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value30);
/* 269 */         } else {
/* 270 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 271 */         }
/* 272 */
/* 273 */         if (!agg_isNull25) {
/* 274 */           agg_unsafeRowAggBuffer.setLong(1, agg_value33);
/* 275 */         } else {
/* 276 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 277 */         }
/* 278 */
/* 279 */         if (!agg_isNull28) {
/* 280 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value36);
/* 281 */         } else {
/* 282 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 283 */         }
/* 284 */
/* 285 */         if (!agg_isNull31) {
/* 286 */           agg_unsafeRowAggBuffer.setLong(3, agg_value39);
/* 287 */         } else {
/* 288 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 289 */         }
/* 290 */
/* 291 */         if (!agg_isNull34) {
/* 292 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value42);
/* 293 */         } else {
/* 294 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 295 */         }
/* 296 */
/* 297 */         if (!agg_isNull37) {
/* 298 */           agg_unsafeRowAggBuffer.setLong(5, agg_value45);
/* 299 */         } else {
/* 300 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 301 */         }
/* 302 */
/* 303 */         if (!agg_isNull40) {
/* 304 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value48);
/* 305 */         } else {
/* 306 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 307 */         }
/* 308 */
/* 309 */         if (!agg_isNull43) {
/* 310 */           agg_unsafeRowAggBuffer.setLong(7, agg_value51);
/* 311 */         } else {
/* 312 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 313 */         }
/* 314 */
/* 315 */       }
/* 316 */       if (shouldStop()) return;
/* 317 */     }
/* 318 */
/* 319 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 320 */   }
/* 321 */
/* 322 */   protected void processNext() throws java.io.IOException {
/* 323 */     if (!agg_initAgg) {
/* 324 */       agg_initAgg = true;
/* 325 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 326 */       agg_doAggregateWithKeys();
/* 327 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 328 */     }
/* 329 */
/* 330 */     // output the result
/* 331 */
/* 332 */     while (agg_mapIter.next()) {
/* 333 */       wholestagecodegen_numOutputRows.add(1);
/* 334 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 335 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 336 */
/* 337 */       boolean agg_isNull46 = agg_aggKey.isNullAt(0);
/* 338 */       UTF8String agg_value54 = agg_isNull46 ? null : (agg_aggKey.getUTF8String(0));
/* 339 */       boolean agg_isNull47 = agg_aggKey.isNullAt(1);
/* 340 */       UTF8String agg_value55 = agg_isNull47 ? null : (agg_aggKey.getUTF8String(1));
/* 341 */       int agg_value56 = agg_aggKey.getInt(2);
/* 342 */       boolean agg_isNull49 = agg_aggBuffer.isNullAt(0);
/* 343 */       double agg_value57 = agg_isNull49 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 344 */       boolean agg_isNull50 = agg_aggBuffer.isNullAt(1);
/* 345 */       long agg_value58 = agg_isNull50 ? -1L : (agg_aggBuffer.getLong(1));
/* 346 */       boolean agg_isNull51 = agg_aggBuffer.isNullAt(2);
/* 347 */       double agg_value59 = agg_isNull51 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 348 */       boolean agg_isNull52 = agg_aggBuffer.isNullAt(3);
/* 349 */       long agg_value60 = agg_isNull52 ? -1L : (agg_aggBuffer.getLong(3));
/* 350 */       boolean agg_isNull53 = agg_aggBuffer.isNullAt(4);
/* 351 */       double agg_value61 = agg_isNull53 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 352 */       boolean agg_isNull54 = agg_aggBuffer.isNullAt(5);
/* 353 */       long agg_value62 = agg_isNull54 ? -1L : (agg_aggBuffer.getLong(5));
/* 354 */       boolean agg_isNull55 = agg_aggBuffer.isNullAt(6);
/* 355 */       double agg_value63 = agg_isNull55 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 356 */       boolean agg_isNull56 = agg_aggBuffer.isNullAt(7);
/* 357 */       long agg_value64 = agg_isNull56 ? -1L : (agg_aggBuffer.getLong(7));
/* 358 */       boolean agg_isNull59 = agg_isNull50;
/* 359 */       double agg_value67 = -1.0;
/* 360 */       if (!agg_isNull50) {
/* 361 */         agg_value67 = (double) agg_value58;
/* 362 */       }
/* 363 */       boolean agg_isNull57 = false;
/* 364 */       double agg_value65 = -1.0;
/* 365 */       if (agg_isNull59 || agg_value67 == 0) {
/* 366 */         agg_isNull57 = true;
/* 367 */       } else {
/* 368 */         if (agg_isNull49) {
/* 369 */           agg_isNull57 = true;
/* 370 */         } else {
/* 371 */           agg_value65 = (double)(agg_value57 / agg_value67);
/* 372 */         }
/* 373 */       }
/* 374 */       boolean agg_isNull63 = agg_isNull52;
/* 375 */       double agg_value71 = -1.0;
/* 376 */       if (!agg_isNull52) {
/* 377 */         agg_value71 = (double) agg_value60;
/* 378 */       }
/* 379 */       boolean agg_isNull61 = false;
/* 380 */       double agg_value69 = -1.0;
/* 381 */       if (agg_isNull63 || agg_value71 == 0) {
/* 382 */         agg_isNull61 = true;
/* 383 */       } else {
/* 384 */         if (agg_isNull51) {
/* 385 */           agg_isNull61 = true;
/* 386 */         } else {
/* 387 */           agg_value69 = (double)(agg_value59 / agg_value71);
/* 388 */         }
/* 389 */       }
/* 390 */       boolean agg_isNull67 = agg_isNull54;
/* 391 */       double agg_value75 = -1.0;
/* 392 */       if (!agg_isNull54) {
/* 393 */         agg_value75 = (double) agg_value62;
/* 394 */       }
/* 395 */       boolean agg_isNull65 = false;
/* 396 */       double agg_value73 = -1.0;
/* 397 */       if (agg_isNull67 || agg_value75 == 0) {
/* 398 */         agg_isNull65 = true;
/* 399 */       } else {
/* 400 */         if (agg_isNull53) {
/* 401 */           agg_isNull65 = true;
/* 402 */         } else {
/* 403 */           agg_value73 = (double)(agg_value61 / agg_value75);
/* 404 */         }
/* 405 */       }
/* 406 */       boolean agg_isNull71 = agg_isNull56;
/* 407 */       double agg_value79 = -1.0;
/* 408 */       if (!agg_isNull56) {
/* 409 */         agg_value79 = (double) agg_value64;
/* 410 */       }
/* 411 */       boolean agg_isNull69 = false;
/* 412 */       double agg_value77 = -1.0;
/* 413 */       if (agg_isNull71 || agg_value79 == 0) {
/* 414 */         agg_isNull69 = true;
/* 415 */       } else {
/* 416 */         if (agg_isNull55) {
/* 417 */           agg_isNull69 = true;
/* 418 */         } else {
/* 419 */           agg_value77 = (double)(agg_value63 / agg_value79);
/* 420 */         }
/* 421 */       }
/* 422 */
/* 423 */       boolean agg_isNull76 = false;
/* 424 */
/* 425 */       boolean agg_isNull77 = false;
/* 426 */
/* 427 */       int agg_value85 = -1;
/* 428 */       agg_value85 = agg_value56 >> 0;
/* 429 */
/* 430 */       int agg_value84 = -1;
/* 431 */       agg_value84 = agg_value85 & 1;
/* 432 */       boolean agg_isNull75 = false;
/* 433 */       byte agg_value83 = (byte)-1;
/* 434 */       if (!false) {
/* 435 */         agg_value83 = (byte) agg_value84;
/* 436 */       }
/* 437 */       agg_holder1.reset();
/* 438 */
/* 439 */       agg_rowWriter1.zeroOutNullBytes();
/* 440 */
/* 441 */       if (agg_isNull46) {
/* 442 */         agg_rowWriter1.setNullAt(0);
/* 443 */       } else {
/* 444 */         agg_rowWriter1.write(0, agg_value54);
/* 445 */       }
/* 446 */
/* 447 */       if (agg_isNull47) {
/* 448 */         agg_rowWriter1.setNullAt(1);
/* 449 */       } else {
/* 450 */         agg_rowWriter1.write(1, agg_value55);
/* 451 */       }
/* 452 */
/* 453 */       if (agg_isNull75) {
/* 454 */         agg_rowWriter1.setNullAt(2);
/* 455 */       } else {
/* 456 */         agg_rowWriter1.write(2, agg_value83);
/* 457 */       }
/* 458 */
/* 459 */       if (agg_isNull57) {
/* 460 */         agg_rowWriter1.setNullAt(3);
/* 461 */       } else {
/* 462 */         agg_rowWriter1.write(3, agg_value65);
/* 463 */       }
/* 464 */
/* 465 */       if (agg_isNull61) {
/* 466 */         agg_rowWriter1.setNullAt(4);
/* 467 */       } else {
/* 468 */         agg_rowWriter1.write(4, agg_value69);
/* 469 */       }
/* 470 */
/* 471 */       if (agg_isNull65) {
/* 472 */         agg_rowWriter1.setNullAt(5);
/* 473 */       } else {
/* 474 */         agg_rowWriter1.write(5, agg_value73);
/* 475 */       }
/* 476 */
/* 477 */       if (agg_isNull69) {
/* 478 */         agg_rowWriter1.setNullAt(6);
/* 479 */       } else {
/* 480 */         agg_rowWriter1.write(6, agg_value77);
/* 481 */       }
/* 482 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 483 */       append(agg_result1);
/* 484 */
/* 485 */       if (shouldStop()) return;
/* 486 */     }
/* 487 */
/* 488 */     agg_mapIter.close();
/* 489 */     if (agg_sorter == null) {
/* 490 */       agg_hashMap.free();
/* 491 */     }
/* 492 */   }
/* 493 */ }
