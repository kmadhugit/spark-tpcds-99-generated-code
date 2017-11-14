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
/* 013 */   private boolean agg_initAgg1;
/* 014 */   private boolean agg_bufIsNull2;
/* 015 */   private double agg_bufValue2;
/* 016 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 017 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 018 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 019 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 022 */   private scala.collection.Iterator inputadapter_input;
/* 023 */   private UnsafeRow agg_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 026 */   private int agg_value25;
/* 027 */   private UnsafeRow agg_result1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows1;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime1;
/* 034 */   private UnsafeRow agg_result2;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 037 */
/* 038 */   public GeneratedIterator(Object[] references) {
/* 039 */     this.references = references;
/* 040 */   }
/* 041 */
/* 042 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 043 */     partitionIndex = index;
/* 044 */     this.inputs = inputs;
/* 045 */     wholestagecodegen_init_0();
/* 046 */     wholestagecodegen_init_1();
/* 047 */
/* 048 */   }
/* 049 */
/* 050 */   private void wholestagecodegen_init_0() {
/* 051 */     agg_initAgg = false;
/* 052 */
/* 053 */     agg_initAgg1 = false;
/* 054 */
/* 055 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 056 */
/* 057 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 058 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 059 */     inputadapter_input = inputs[0];
/* 060 */     agg_result = new UnsafeRow(10);
/* 061 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 256);
/* 062 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 10);
/* 063 */
/* 064 */     agg_result1 = new UnsafeRow(1);
/* 065 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 066 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 067 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 068 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 069 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 070 */
/* 071 */   }
/* 072 */
/* 073 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 074 */     // initialize aggregation buffer
/* 075 */     boolean agg_isNull = false;
/* 076 */     double agg_value = -1.0;
/* 077 */     if (!false) {
/* 078 */       agg_value = (double) 0;
/* 079 */     }
/* 080 */     agg_bufIsNull = agg_isNull;
/* 081 */     agg_bufValue = agg_value;
/* 082 */     agg_bufIsNull1 = false;
/* 083 */     agg_bufValue1 = 0L;
/* 084 */
/* 085 */     if (!agg_initAgg1) {
/* 086 */       agg_initAgg1 = true;
/* 087 */       long agg_beforeAgg = System.nanoTime();
/* 088 */       agg_doAggregateWithKeys();
/* 089 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 090 */     }
/* 091 */
/* 092 */     // output the result
/* 093 */
/* 094 */     while (agg_mapIter.next()) {
/* 095 */       agg_numOutputRows.add(1);
/* 096 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 097 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 098 */
/* 099 */       boolean agg_isNull43 = agg_aggKey.isNullAt(0);
/* 100 */       UTF8String agg_value44 = agg_isNull43 ? null : (agg_aggKey.getUTF8String(0));
/* 101 */       boolean agg_isNull44 = agg_aggKey.isNullAt(1);
/* 102 */       UTF8String agg_value45 = agg_isNull44 ? null : (agg_aggKey.getUTF8String(1));
/* 103 */       boolean agg_isNull45 = agg_aggKey.isNullAt(2);
/* 104 */       UTF8String agg_value46 = agg_isNull45 ? null : (agg_aggKey.getUTF8String(2));
/* 105 */       boolean agg_isNull46 = agg_aggKey.isNullAt(3);
/* 106 */       UTF8String agg_value47 = agg_isNull46 ? null : (agg_aggKey.getUTF8String(3));
/* 107 */       boolean agg_isNull47 = agg_aggKey.isNullAt(4);
/* 108 */       UTF8String agg_value48 = agg_isNull47 ? null : (agg_aggKey.getUTF8String(4));
/* 109 */       boolean agg_isNull48 = agg_aggKey.isNullAt(5);
/* 110 */       UTF8String agg_value49 = agg_isNull48 ? null : (agg_aggKey.getUTF8String(5));
/* 111 */       boolean agg_isNull49 = agg_aggKey.isNullAt(6);
/* 112 */       double agg_value50 = agg_isNull49 ? -1.0 : (agg_aggKey.getDouble(6));
/* 113 */       boolean agg_isNull50 = agg_aggKey.isNullAt(7);
/* 114 */       int agg_value51 = agg_isNull50 ? -1 : (agg_aggKey.getInt(7));
/* 115 */       boolean agg_isNull51 = agg_aggKey.isNullAt(8);
/* 116 */       UTF8String agg_value52 = agg_isNull51 ? null : (agg_aggKey.getUTF8String(8));
/* 117 */       boolean agg_isNull52 = agg_aggKey.isNullAt(9);
/* 118 */       UTF8String agg_value53 = agg_isNull52 ? null : (agg_aggKey.getUTF8String(9));
/* 119 */       boolean agg_isNull53 = agg_aggBuffer.isNullAt(0);
/* 120 */       double agg_value54 = agg_isNull53 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 121 */
/* 122 */       // do aggregate
/* 123 */       // common sub-expressions
/* 124 */
/* 125 */       // evaluate aggregate function
/* 126 */       boolean agg_isNull57 = true;
/* 127 */       double agg_value58 = -1.0;
/* 128 */
/* 129 */       if (!agg_bufIsNull) {
/* 130 */         boolean agg_isNull60 = agg_isNull53;
/* 131 */         double agg_value61 = -1.0;
/* 132 */         if (!agg_isNull53) {
/* 133 */           agg_value61 = agg_value54;
/* 134 */         }
/* 135 */         boolean agg_isNull59 = agg_isNull60;
/* 136 */         double agg_value60 = agg_value61;
/* 137 */         if (agg_isNull59) {
/* 138 */           boolean agg_isNull62 = false;
/* 139 */           double agg_value63 = -1.0;
/* 140 */           if (!false) {
/* 141 */             agg_value63 = (double) 0;
/* 142 */           }
/* 143 */           if (!agg_isNull62) {
/* 144 */             agg_isNull59 = false;
/* 145 */             agg_value60 = agg_value63;
/* 146 */           }
/* 147 */         }
/* 148 */
/* 149 */         agg_isNull57 = false; // resultCode could change nullability.
/* 150 */         agg_value58 = agg_bufValue + agg_value60;
/* 151 */
/* 152 */       }
/* 153 */       boolean agg_isNull64 = false;
/* 154 */       long agg_value65 = -1L;
/* 155 */       if (!false && agg_isNull53) {
/* 156 */         agg_isNull64 = agg_bufIsNull1;
/* 157 */         agg_value65 = agg_bufValue1;
/* 158 */       } else {
/* 159 */         boolean agg_isNull68 = true;
/* 160 */         long agg_value69 = -1L;
/* 161 */
/* 162 */         if (!agg_bufIsNull1) {
/* 163 */           agg_isNull68 = false; // resultCode could change nullability.
/* 164 */           agg_value69 = agg_bufValue1 + 1L;
/* 165 */
/* 166 */         }
/* 167 */         agg_isNull64 = agg_isNull68;
/* 168 */         agg_value65 = agg_value69;
/* 169 */       }
/* 170 */       // update aggregation buffer
/* 171 */       agg_bufIsNull = agg_isNull57;
/* 172 */       agg_bufValue = agg_value58;
/* 173 */
/* 174 */       agg_bufIsNull1 = agg_isNull64;
/* 175 */       agg_bufValue1 = agg_value65;
/* 176 */
/* 177 */       if (shouldStop()) return;
/* 178 */     }
/* 179 */
/* 180 */     agg_mapIter.close();
/* 181 */     if (agg_sorter == null) {
/* 182 */       agg_hashMap.free();
/* 183 */     }
/* 184 */
/* 185 */   }
/* 186 */
/* 187 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 188 */     agg_hashMap = agg_plan.createHashMap();
/* 189 */
/* 190 */     while (inputadapter_input.hasNext()) {
/* 191 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 192 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 193 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 194 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 195 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 196 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 197 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 198 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 199 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 200 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 201 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 202 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 203 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 204 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 205 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 206 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 207 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 208 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 209 */       UTF8String inputadapter_value8 = inputadapter_isNull8 ? null : (inputadapter_row.getUTF8String(8));
/* 210 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 211 */       UTF8String inputadapter_value9 = inputadapter_isNull9 ? null : (inputadapter_row.getUTF8String(9));
/* 212 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 213 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 214 */
/* 215 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 216 */
/* 217 */       UnsafeRow agg_fastAggBuffer = null;
/* 218 */
/* 219 */       if (agg_fastAggBuffer == null) {
/* 220 */         // generate grouping key
/* 221 */         agg_holder.reset();
/* 222 */
/* 223 */         agg_rowWriter.zeroOutNullBytes();
/* 224 */
/* 225 */         if (inputadapter_isNull) {
/* 226 */           agg_rowWriter.setNullAt(0);
/* 227 */         } else {
/* 228 */           agg_rowWriter.write(0, inputadapter_value);
/* 229 */         }
/* 230 */
/* 231 */         if (inputadapter_isNull1) {
/* 232 */           agg_rowWriter.setNullAt(1);
/* 233 */         } else {
/* 234 */           agg_rowWriter.write(1, inputadapter_value1);
/* 235 */         }
/* 236 */
/* 237 */         if (inputadapter_isNull2) {
/* 238 */           agg_rowWriter.setNullAt(2);
/* 239 */         } else {
/* 240 */           agg_rowWriter.write(2, inputadapter_value2);
/* 241 */         }
/* 242 */
/* 243 */         if (inputadapter_isNull3) {
/* 244 */           agg_rowWriter.setNullAt(3);
/* 245 */         } else {
/* 246 */           agg_rowWriter.write(3, inputadapter_value3);
/* 247 */         }
/* 248 */
/* 249 */         if (inputadapter_isNull4) {
/* 250 */           agg_rowWriter.setNullAt(4);
/* 251 */         } else {
/* 252 */           agg_rowWriter.write(4, inputadapter_value4);
/* 253 */         }
/* 254 */
/* 255 */         if (inputadapter_isNull5) {
/* 256 */           agg_rowWriter.setNullAt(5);
/* 257 */         } else {
/* 258 */           agg_rowWriter.write(5, inputadapter_value5);
/* 259 */         }
/* 260 */
/* 261 */         if (inputadapter_isNull6) {
/* 262 */           agg_rowWriter.setNullAt(6);
/* 263 */         } else {
/* 264 */           agg_rowWriter.write(6, inputadapter_value6);
/* 265 */         }
/* 266 */
/* 267 */         if (inputadapter_isNull7) {
/* 268 */           agg_rowWriter.setNullAt(7);
/* 269 */         } else {
/* 270 */           agg_rowWriter.write(7, inputadapter_value7);
/* 271 */         }
/* 272 */
/* 273 */         if (inputadapter_isNull8) {
/* 274 */           agg_rowWriter.setNullAt(8);
/* 275 */         } else {
/* 276 */           agg_rowWriter.write(8, inputadapter_value8);
/* 277 */         }
/* 278 */
/* 279 */         if (inputadapter_isNull9) {
/* 280 */           agg_rowWriter.setNullAt(9);
/* 281 */         } else {
/* 282 */           agg_rowWriter.write(9, inputadapter_value9);
/* 283 */         }
/* 284 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 285 */         agg_value25 = 42;
/* 286 */
/* 287 */         if (!inputadapter_isNull) {
/* 288 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value25);
/* 289 */         }
/* 290 */
/* 291 */         if (!inputadapter_isNull1) {
/* 292 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value25);
/* 293 */         }
/* 294 */
/* 295 */         if (!inputadapter_isNull2) {
/* 296 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value25);
/* 297 */         }
/* 298 */
/* 299 */         if (!inputadapter_isNull3) {
/* 300 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value25);
/* 301 */         }
/* 302 */
/* 303 */         if (!inputadapter_isNull4) {
/* 304 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value25);
/* 305 */         }
/* 306 */
/* 307 */         if (!inputadapter_isNull5) {
/* 308 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value25);
/* 309 */         }
/* 310 */
/* 311 */         if (!inputadapter_isNull6) {
/* 312 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(inputadapter_value6), agg_value25);
/* 313 */         }
/* 314 */
/* 315 */         if (!inputadapter_isNull7) {
/* 316 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value25);
/* 317 */         }
/* 318 */
/* 319 */         if (!inputadapter_isNull8) {
/* 320 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value8.getBaseObject(), inputadapter_value8.getBaseOffset(), inputadapter_value8.numBytes(), agg_value25);
/* 321 */         }
/* 322 */
/* 323 */         if (!inputadapter_isNull9) {
/* 324 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value9.getBaseObject(), inputadapter_value9.getBaseOffset(), inputadapter_value9.numBytes(), agg_value25);
/* 325 */         }
/* 326 */         if (true) {
/* 327 */           // try to get the buffer from hash map
/* 328 */           agg_unsafeRowAggBuffer =
/* 329 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value25);
/* 330 */         }
/* 331 */         if (agg_unsafeRowAggBuffer == null) {
/* 332 */           if (agg_sorter == null) {
/* 333 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 334 */           } else {
/* 335 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 336 */           }
/* 337 */
/* 338 */           // the hash map had be spilled, it should have enough memory now,
/* 339 */           // try  to allocate buffer again.
/* 340 */           agg_unsafeRowAggBuffer =
/* 341 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value25);
/* 342 */           if (agg_unsafeRowAggBuffer == null) {
/* 343 */             // failed to allocate the first page
/* 344 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 345 */           }
/* 346 */         }
/* 347 */       }
/* 348 */
/* 349 */       if (agg_fastAggBuffer != null) {
/* 350 */         // update fast row
/* 351 */
/* 352 */       } else {
/* 353 */         // update unsafe row
/* 354 */
/* 355 */         // common sub-expressions
/* 356 */
/* 357 */         // evaluate aggregate function
/* 358 */         boolean agg_isNull36 = true;
/* 359 */         double agg_value37 = -1.0;
/* 360 */
/* 361 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 362 */         double agg_value39 = agg_isNull38 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 363 */         boolean agg_isNull37 = agg_isNull38;
/* 364 */         double agg_value38 = agg_value39;
/* 365 */         if (agg_isNull37) {
/* 366 */           boolean agg_isNull39 = false;
/* 367 */           double agg_value40 = -1.0;
/* 368 */           if (!false) {
/* 369 */             agg_value40 = (double) 0;
/* 370 */           }
/* 371 */           if (!agg_isNull39) {
/* 372 */             agg_isNull37 = false;
/* 373 */             agg_value38 = agg_value40;
/* 374 */           }
/* 375 */         }
/* 376 */
/* 377 */         if (!inputadapter_isNull10) {
/* 378 */           agg_isNull36 = false; // resultCode could change nullability.
/* 379 */           agg_value37 = agg_value38 + inputadapter_value10;
/* 380 */
/* 381 */         }
/* 382 */         boolean agg_isNull35 = agg_isNull36;
/* 383 */         double agg_value36 = agg_value37;
/* 384 */         if (agg_isNull35) {
/* 385 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 386 */           double agg_value43 = agg_isNull42 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 387 */           if (!agg_isNull42) {
/* 388 */             agg_isNull35 = false;
/* 389 */             agg_value36 = agg_value43;
/* 390 */           }
/* 391 */         }
/* 392 */         // update unsafe row buffer
/* 393 */         if (!agg_isNull35) {
/* 394 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value36);
/* 395 */         } else {
/* 396 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 397 */         }
/* 398 */
/* 399 */       }
/* 400 */       if (shouldStop()) return;
/* 401 */     }
/* 402 */
/* 403 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 404 */   }
/* 405 */
/* 406 */   private void wholestagecodegen_init_1() {
/* 407 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 408 */     agg_result2 = new UnsafeRow(2);
/* 409 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 410 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 2);
/* 411 */
/* 412 */   }
/* 413 */
/* 414 */   protected void processNext() throws java.io.IOException {
/* 415 */     while (!agg_initAgg) {
/* 416 */       agg_initAgg = true;
/* 417 */       long agg_beforeAgg1 = System.nanoTime();
/* 418 */       agg_doAggregateWithoutKey();
/* 419 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 420 */
/* 421 */       // output the result
/* 422 */
/* 423 */       agg_numOutputRows1.add(1);
/* 424 */       agg_rowWriter2.zeroOutNullBytes();
/* 425 */
/* 426 */       if (agg_bufIsNull) {
/* 427 */         agg_rowWriter2.setNullAt(0);
/* 428 */       } else {
/* 429 */         agg_rowWriter2.write(0, agg_bufValue);
/* 430 */       }
/* 431 */
/* 432 */       if (agg_bufIsNull1) {
/* 433 */         agg_rowWriter2.setNullAt(1);
/* 434 */       } else {
/* 435 */         agg_rowWriter2.write(1, agg_bufValue1);
/* 436 */       }
/* 437 */       append(agg_result2);
/* 438 */     }
/* 439 */   }
/* 440 */ }
