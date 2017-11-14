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
/* 130 */         boolean agg_isNull59 = agg_isNull53;
/* 131 */         double agg_value60 = agg_value54;
/* 132 */         if (agg_isNull59) {
/* 133 */           boolean agg_isNull61 = false;
/* 134 */           double agg_value62 = -1.0;
/* 135 */           if (!false) {
/* 136 */             agg_value62 = (double) 0;
/* 137 */           }
/* 138 */           if (!agg_isNull61) {
/* 139 */             agg_isNull59 = false;
/* 140 */             agg_value60 = agg_value62;
/* 141 */           }
/* 142 */         }
/* 143 */
/* 144 */         agg_isNull57 = false; // resultCode could change nullability.
/* 145 */         agg_value58 = agg_bufValue + agg_value60;
/* 146 */
/* 147 */       }
/* 148 */       boolean agg_isNull63 = false;
/* 149 */       long agg_value64 = -1L;
/* 150 */       if (!false && agg_isNull53) {
/* 151 */         agg_isNull63 = agg_bufIsNull1;
/* 152 */         agg_value64 = agg_bufValue1;
/* 153 */       } else {
/* 154 */         boolean agg_isNull67 = true;
/* 155 */         long agg_value68 = -1L;
/* 156 */
/* 157 */         if (!agg_bufIsNull1) {
/* 158 */           agg_isNull67 = false; // resultCode could change nullability.
/* 159 */           agg_value68 = agg_bufValue1 + 1L;
/* 160 */
/* 161 */         }
/* 162 */         agg_isNull63 = agg_isNull67;
/* 163 */         agg_value64 = agg_value68;
/* 164 */       }
/* 165 */       // update aggregation buffer
/* 166 */       agg_bufIsNull = agg_isNull57;
/* 167 */       agg_bufValue = agg_value58;
/* 168 */
/* 169 */       agg_bufIsNull1 = agg_isNull63;
/* 170 */       agg_bufValue1 = agg_value64;
/* 171 */
/* 172 */       if (shouldStop()) return;
/* 173 */     }
/* 174 */
/* 175 */     agg_mapIter.close();
/* 176 */     if (agg_sorter == null) {
/* 177 */       agg_hashMap.free();
/* 178 */     }
/* 179 */
/* 180 */   }
/* 181 */
/* 182 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 183 */     agg_hashMap = agg_plan.createHashMap();
/* 184 */
/* 185 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 186 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 187 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 188 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 189 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 190 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 191 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 192 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 193 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 194 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 195 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 196 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 197 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 198 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 199 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 200 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 201 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 202 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 203 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 204 */       UTF8String inputadapter_value8 = inputadapter_isNull8 ? null : (inputadapter_row.getUTF8String(8));
/* 205 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 206 */       UTF8String inputadapter_value9 = inputadapter_isNull9 ? null : (inputadapter_row.getUTF8String(9));
/* 207 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 208 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 209 */
/* 210 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 211 */
/* 212 */       UnsafeRow agg_fastAggBuffer = null;
/* 213 */
/* 214 */       if (agg_fastAggBuffer == null) {
/* 215 */         // generate grouping key
/* 216 */         agg_holder.reset();
/* 217 */
/* 218 */         agg_rowWriter.zeroOutNullBytes();
/* 219 */
/* 220 */         if (inputadapter_isNull) {
/* 221 */           agg_rowWriter.setNullAt(0);
/* 222 */         } else {
/* 223 */           agg_rowWriter.write(0, inputadapter_value);
/* 224 */         }
/* 225 */
/* 226 */         if (inputadapter_isNull1) {
/* 227 */           agg_rowWriter.setNullAt(1);
/* 228 */         } else {
/* 229 */           agg_rowWriter.write(1, inputadapter_value1);
/* 230 */         }
/* 231 */
/* 232 */         if (inputadapter_isNull2) {
/* 233 */           agg_rowWriter.setNullAt(2);
/* 234 */         } else {
/* 235 */           agg_rowWriter.write(2, inputadapter_value2);
/* 236 */         }
/* 237 */
/* 238 */         if (inputadapter_isNull3) {
/* 239 */           agg_rowWriter.setNullAt(3);
/* 240 */         } else {
/* 241 */           agg_rowWriter.write(3, inputadapter_value3);
/* 242 */         }
/* 243 */
/* 244 */         if (inputadapter_isNull4) {
/* 245 */           agg_rowWriter.setNullAt(4);
/* 246 */         } else {
/* 247 */           agg_rowWriter.write(4, inputadapter_value4);
/* 248 */         }
/* 249 */
/* 250 */         if (inputadapter_isNull5) {
/* 251 */           agg_rowWriter.setNullAt(5);
/* 252 */         } else {
/* 253 */           agg_rowWriter.write(5, inputadapter_value5);
/* 254 */         }
/* 255 */
/* 256 */         if (inputadapter_isNull6) {
/* 257 */           agg_rowWriter.setNullAt(6);
/* 258 */         } else {
/* 259 */           agg_rowWriter.write(6, inputadapter_value6);
/* 260 */         }
/* 261 */
/* 262 */         if (inputadapter_isNull7) {
/* 263 */           agg_rowWriter.setNullAt(7);
/* 264 */         } else {
/* 265 */           agg_rowWriter.write(7, inputadapter_value7);
/* 266 */         }
/* 267 */
/* 268 */         if (inputadapter_isNull8) {
/* 269 */           agg_rowWriter.setNullAt(8);
/* 270 */         } else {
/* 271 */           agg_rowWriter.write(8, inputadapter_value8);
/* 272 */         }
/* 273 */
/* 274 */         if (inputadapter_isNull9) {
/* 275 */           agg_rowWriter.setNullAt(9);
/* 276 */         } else {
/* 277 */           agg_rowWriter.write(9, inputadapter_value9);
/* 278 */         }
/* 279 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 280 */         agg_value25 = 42;
/* 281 */
/* 282 */         if (!inputadapter_isNull) {
/* 283 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value25);
/* 284 */         }
/* 285 */
/* 286 */         if (!inputadapter_isNull1) {
/* 287 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value25);
/* 288 */         }
/* 289 */
/* 290 */         if (!inputadapter_isNull2) {
/* 291 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value25);
/* 292 */         }
/* 293 */
/* 294 */         if (!inputadapter_isNull3) {
/* 295 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value25);
/* 296 */         }
/* 297 */
/* 298 */         if (!inputadapter_isNull4) {
/* 299 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value25);
/* 300 */         }
/* 301 */
/* 302 */         if (!inputadapter_isNull5) {
/* 303 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value25);
/* 304 */         }
/* 305 */
/* 306 */         if (!inputadapter_isNull6) {
/* 307 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(inputadapter_value6), agg_value25);
/* 308 */         }
/* 309 */
/* 310 */         if (!inputadapter_isNull7) {
/* 311 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value25);
/* 312 */         }
/* 313 */
/* 314 */         if (!inputadapter_isNull8) {
/* 315 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value8.getBaseObject(), inputadapter_value8.getBaseOffset(), inputadapter_value8.numBytes(), agg_value25);
/* 316 */         }
/* 317 */
/* 318 */         if (!inputadapter_isNull9) {
/* 319 */           agg_value25 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value9.getBaseObject(), inputadapter_value9.getBaseOffset(), inputadapter_value9.numBytes(), agg_value25);
/* 320 */         }
/* 321 */         if (true) {
/* 322 */           // try to get the buffer from hash map
/* 323 */           agg_unsafeRowAggBuffer =
/* 324 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value25);
/* 325 */         }
/* 326 */         if (agg_unsafeRowAggBuffer == null) {
/* 327 */           if (agg_sorter == null) {
/* 328 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 329 */           } else {
/* 330 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 331 */           }
/* 332 */
/* 333 */           // the hash map had be spilled, it should have enough memory now,
/* 334 */           // try  to allocate buffer again.
/* 335 */           agg_unsafeRowAggBuffer =
/* 336 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value25);
/* 337 */           if (agg_unsafeRowAggBuffer == null) {
/* 338 */             // failed to allocate the first page
/* 339 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 340 */           }
/* 341 */         }
/* 342 */       }
/* 343 */
/* 344 */       if (agg_fastAggBuffer != null) {
/* 345 */         // update fast row
/* 346 */
/* 347 */       } else {
/* 348 */         // update unsafe row
/* 349 */
/* 350 */         // common sub-expressions
/* 351 */
/* 352 */         // evaluate aggregate function
/* 353 */         boolean agg_isNull36 = true;
/* 354 */         double agg_value37 = -1.0;
/* 355 */
/* 356 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 357 */         double agg_value39 = agg_isNull38 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 358 */         boolean agg_isNull37 = agg_isNull38;
/* 359 */         double agg_value38 = agg_value39;
/* 360 */         if (agg_isNull37) {
/* 361 */           boolean agg_isNull39 = false;
/* 362 */           double agg_value40 = -1.0;
/* 363 */           if (!false) {
/* 364 */             agg_value40 = (double) 0;
/* 365 */           }
/* 366 */           if (!agg_isNull39) {
/* 367 */             agg_isNull37 = false;
/* 368 */             agg_value38 = agg_value40;
/* 369 */           }
/* 370 */         }
/* 371 */
/* 372 */         if (!inputadapter_isNull10) {
/* 373 */           agg_isNull36 = false; // resultCode could change nullability.
/* 374 */           agg_value37 = agg_value38 + inputadapter_value10;
/* 375 */
/* 376 */         }
/* 377 */         boolean agg_isNull35 = agg_isNull36;
/* 378 */         double agg_value36 = agg_value37;
/* 379 */         if (agg_isNull35) {
/* 380 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 381 */           double agg_value43 = agg_isNull42 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 382 */           if (!agg_isNull42) {
/* 383 */             agg_isNull35 = false;
/* 384 */             agg_value36 = agg_value43;
/* 385 */           }
/* 386 */         }
/* 387 */         // update unsafe row buffer
/* 388 */         if (!agg_isNull35) {
/* 389 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value36);
/* 390 */         } else {
/* 391 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 392 */         }
/* 393 */
/* 394 */       }
/* 395 */       if (shouldStop()) return;
/* 396 */     }
/* 397 */
/* 398 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 399 */   }
/* 400 */
/* 401 */   private void wholestagecodegen_init_1() {
/* 402 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 403 */     agg_result2 = new UnsafeRow(2);
/* 404 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 405 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 2);
/* 406 */
/* 407 */   }
/* 408 */
/* 409 */   protected void processNext() throws java.io.IOException {
/* 410 */     while (!agg_initAgg) {
/* 411 */       agg_initAgg = true;
/* 412 */       long agg_beforeAgg1 = System.nanoTime();
/* 413 */       agg_doAggregateWithoutKey();
/* 414 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 415 */
/* 416 */       // output the result
/* 417 */
/* 418 */       agg_numOutputRows1.add(1);
/* 419 */       agg_rowWriter2.zeroOutNullBytes();
/* 420 */
/* 421 */       if (agg_bufIsNull) {
/* 422 */         agg_rowWriter2.setNullAt(0);
/* 423 */       } else {
/* 424 */         agg_rowWriter2.write(0, agg_bufValue);
/* 425 */       }
/* 426 */
/* 427 */       if (agg_bufIsNull1) {
/* 428 */         agg_rowWriter2.setNullAt(1);
/* 429 */       } else {
/* 430 */         agg_rowWriter2.write(1, agg_bufValue1);
/* 431 */       }
/* 432 */       append(agg_result2);
/* 433 */     }
/* 434 */   }
/* 435 */ }
