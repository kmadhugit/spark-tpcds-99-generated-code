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
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value16;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     agg_initAgg = false;
/* 040 */
/* 041 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 042 */
/* 043 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 045 */     inputadapter_input = inputs[0];
/* 046 */     agg_result = new UnsafeRow(5);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(8);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 8);
/* 053 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 054 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 059 */     agg_hashMap = agg_plan.createHashMap();
/* 060 */
/* 061 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 064 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 071 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 072 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 073 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 074 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 075 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 076 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 077 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 078 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 079 */
/* 080 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 081 */
/* 082 */       UnsafeRow agg_fastAggBuffer = null;
/* 083 */
/* 084 */       if (agg_fastAggBuffer == null) {
/* 085 */         // generate grouping key
/* 086 */         agg_holder.reset();
/* 087 */
/* 088 */         agg_rowWriter.zeroOutNullBytes();
/* 089 */
/* 090 */         if (inputadapter_isNull) {
/* 091 */           agg_rowWriter.setNullAt(0);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(0, inputadapter_value);
/* 094 */         }
/* 095 */
/* 096 */         if (inputadapter_isNull1) {
/* 097 */           agg_rowWriter.setNullAt(1);
/* 098 */         } else {
/* 099 */           agg_rowWriter.write(1, inputadapter_value1);
/* 100 */         }
/* 101 */
/* 102 */         if (inputadapter_isNull2) {
/* 103 */           agg_rowWriter.setNullAt(2);
/* 104 */         } else {
/* 105 */           agg_rowWriter.write(2, inputadapter_value2);
/* 106 */         }
/* 107 */
/* 108 */         if (inputadapter_isNull3) {
/* 109 */           agg_rowWriter.setNullAt(3);
/* 110 */         } else {
/* 111 */           agg_rowWriter.write(3, inputadapter_value3);
/* 112 */         }
/* 113 */
/* 114 */         if (inputadapter_isNull4) {
/* 115 */           agg_rowWriter.setNullAt(4);
/* 116 */         } else {
/* 117 */           agg_rowWriter.write(4, inputadapter_value4);
/* 118 */         }
/* 119 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 120 */         agg_value16 = 42;
/* 121 */
/* 122 */         if (!inputadapter_isNull) {
/* 123 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value16);
/* 124 */         }
/* 125 */
/* 126 */         if (!inputadapter_isNull1) {
/* 127 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value16);
/* 128 */         }
/* 129 */
/* 130 */         if (!inputadapter_isNull2) {
/* 131 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value16);
/* 132 */         }
/* 133 */
/* 134 */         if (!inputadapter_isNull3) {
/* 135 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value16);
/* 136 */         }
/* 137 */
/* 138 */         if (!inputadapter_isNull4) {
/* 139 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(inputadapter_value4), agg_value16);
/* 140 */         }
/* 141 */         if (true) {
/* 142 */           // try to get the buffer from hash map
/* 143 */           agg_unsafeRowAggBuffer =
/* 144 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 145 */         }
/* 146 */         if (agg_unsafeRowAggBuffer == null) {
/* 147 */           if (agg_sorter == null) {
/* 148 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 149 */           } else {
/* 150 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 151 */           }
/* 152 */
/* 153 */           // the hash map had be spilled, it should have enough memory now,
/* 154 */           // try  to allocate buffer again.
/* 155 */           agg_unsafeRowAggBuffer =
/* 156 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 157 */           if (agg_unsafeRowAggBuffer == null) {
/* 158 */             // failed to allocate the first page
/* 159 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 160 */           }
/* 161 */         }
/* 162 */       }
/* 163 */
/* 164 */       if (agg_fastAggBuffer != null) {
/* 165 */         // update fast row
/* 166 */
/* 167 */       } else {
/* 168 */         // update unsafe row
/* 169 */
/* 170 */         // common sub-expressions
/* 171 */
/* 172 */         // evaluate aggregate function
/* 173 */         boolean agg_isNull20 = true;
/* 174 */         double agg_value23 = -1.0;
/* 175 */
/* 176 */         boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 177 */         double agg_value25 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 178 */         boolean agg_isNull21 = agg_isNull22;
/* 179 */         double agg_value24 = agg_value25;
/* 180 */         if (agg_isNull21) {
/* 181 */           boolean agg_isNull23 = false;
/* 182 */           double agg_value26 = -1.0;
/* 183 */           if (!false) {
/* 184 */             agg_value26 = (double) 0;
/* 185 */           }
/* 186 */           if (!agg_isNull23) {
/* 187 */             agg_isNull21 = false;
/* 188 */             agg_value24 = agg_value26;
/* 189 */           }
/* 190 */         }
/* 191 */
/* 192 */         if (!inputadapter_isNull5) {
/* 193 */           agg_isNull20 = false; // resultCode could change nullability.
/* 194 */           agg_value23 = agg_value24 + inputadapter_value5;
/* 195 */
/* 196 */         }
/* 197 */         boolean agg_isNull19 = agg_isNull20;
/* 198 */         double agg_value22 = agg_value23;
/* 199 */         if (agg_isNull19) {
/* 200 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 201 */           double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 202 */           if (!agg_isNull26) {
/* 203 */             agg_isNull19 = false;
/* 204 */             agg_value22 = agg_value29;
/* 205 */           }
/* 206 */         }
/* 207 */         boolean agg_isNull28 = true;
/* 208 */         double agg_value31 = -1.0;
/* 209 */
/* 210 */         boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 211 */         double agg_value33 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 212 */         boolean agg_isNull29 = agg_isNull30;
/* 213 */         double agg_value32 = agg_value33;
/* 214 */         if (agg_isNull29) {
/* 215 */           boolean agg_isNull31 = false;
/* 216 */           double agg_value34 = -1.0;
/* 217 */           if (!false) {
/* 218 */             agg_value34 = (double) 0;
/* 219 */           }
/* 220 */           if (!agg_isNull31) {
/* 221 */             agg_isNull29 = false;
/* 222 */             agg_value32 = agg_value34;
/* 223 */           }
/* 224 */         }
/* 225 */
/* 226 */         if (!inputadapter_isNull6) {
/* 227 */           agg_isNull28 = false; // resultCode could change nullability.
/* 228 */           agg_value31 = agg_value32 + inputadapter_value6;
/* 229 */
/* 230 */         }
/* 231 */         boolean agg_isNull27 = agg_isNull28;
/* 232 */         double agg_value30 = agg_value31;
/* 233 */         if (agg_isNull27) {
/* 234 */           boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 235 */           double agg_value37 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 236 */           if (!agg_isNull34) {
/* 237 */             agg_isNull27 = false;
/* 238 */             agg_value30 = agg_value37;
/* 239 */           }
/* 240 */         }
/* 241 */         boolean agg_isNull36 = true;
/* 242 */         double agg_value39 = -1.0;
/* 243 */
/* 244 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 245 */         double agg_value41 = agg_isNull38 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 246 */         boolean agg_isNull37 = agg_isNull38;
/* 247 */         double agg_value40 = agg_value41;
/* 248 */         if (agg_isNull37) {
/* 249 */           boolean agg_isNull39 = false;
/* 250 */           double agg_value42 = -1.0;
/* 251 */           if (!false) {
/* 252 */             agg_value42 = (double) 0;
/* 253 */           }
/* 254 */           if (!agg_isNull39) {
/* 255 */             agg_isNull37 = false;
/* 256 */             agg_value40 = agg_value42;
/* 257 */           }
/* 258 */         }
/* 259 */
/* 260 */         if (!inputadapter_isNull7) {
/* 261 */           agg_isNull36 = false; // resultCode could change nullability.
/* 262 */           agg_value39 = agg_value40 + inputadapter_value7;
/* 263 */
/* 264 */         }
/* 265 */         boolean agg_isNull35 = agg_isNull36;
/* 266 */         double agg_value38 = agg_value39;
/* 267 */         if (agg_isNull35) {
/* 268 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 269 */           double agg_value45 = agg_isNull42 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 270 */           if (!agg_isNull42) {
/* 271 */             agg_isNull35 = false;
/* 272 */             agg_value38 = agg_value45;
/* 273 */           }
/* 274 */         }
/* 275 */         // update unsafe row buffer
/* 276 */         if (!agg_isNull19) {
/* 277 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value22);
/* 278 */         } else {
/* 279 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 280 */         }
/* 281 */
/* 282 */         if (!agg_isNull27) {
/* 283 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value30);
/* 284 */         } else {
/* 285 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 286 */         }
/* 287 */
/* 288 */         if (!agg_isNull35) {
/* 289 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value38);
/* 290 */         } else {
/* 291 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 292 */         }
/* 293 */
/* 294 */       }
/* 295 */       if (shouldStop()) return;
/* 296 */     }
/* 297 */
/* 298 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 299 */   }
/* 300 */
/* 301 */   protected void processNext() throws java.io.IOException {
/* 302 */     if (!agg_initAgg) {
/* 303 */       agg_initAgg = true;
/* 304 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 305 */       agg_doAggregateWithKeys();
/* 306 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 307 */     }
/* 308 */
/* 309 */     // output the result
/* 310 */
/* 311 */     while (agg_mapIter.next()) {
/* 312 */       wholestagecodegen_numOutputRows.add(1);
/* 313 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 314 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 315 */
/* 316 */       boolean agg_isNull43 = agg_aggKey.isNullAt(0);
/* 317 */       UTF8String agg_value46 = agg_isNull43 ? null : (agg_aggKey.getUTF8String(0));
/* 318 */       boolean agg_isNull44 = agg_aggKey.isNullAt(1);
/* 319 */       UTF8String agg_value47 = agg_isNull44 ? null : (agg_aggKey.getUTF8String(1));
/* 320 */       boolean agg_isNull45 = agg_aggKey.isNullAt(2);
/* 321 */       UTF8String agg_value48 = agg_isNull45 ? null : (agg_aggKey.getUTF8String(2));
/* 322 */       boolean agg_isNull46 = agg_aggKey.isNullAt(3);
/* 323 */       UTF8String agg_value49 = agg_isNull46 ? null : (agg_aggKey.getUTF8String(3));
/* 324 */       boolean agg_isNull47 = agg_aggKey.isNullAt(4);
/* 325 */       double agg_value50 = agg_isNull47 ? -1.0 : (agg_aggKey.getDouble(4));
/* 326 */       boolean agg_isNull48 = agg_aggBuffer.isNullAt(0);
/* 327 */       double agg_value51 = agg_isNull48 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 328 */       boolean agg_isNull49 = agg_aggBuffer.isNullAt(1);
/* 329 */       double agg_value52 = agg_isNull49 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 330 */       boolean agg_isNull50 = agg_aggBuffer.isNullAt(2);
/* 331 */       double agg_value53 = agg_isNull50 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 332 */
/* 333 */       agg_holder1.reset();
/* 334 */
/* 335 */       agg_rowWriter1.zeroOutNullBytes();
/* 336 */
/* 337 */       if (agg_isNull44) {
/* 338 */         agg_rowWriter1.setNullAt(0);
/* 339 */       } else {
/* 340 */         agg_rowWriter1.write(0, agg_value47);
/* 341 */       }
/* 342 */
/* 343 */       if (agg_isNull45) {
/* 344 */         agg_rowWriter1.setNullAt(1);
/* 345 */       } else {
/* 346 */         agg_rowWriter1.write(1, agg_value48);
/* 347 */       }
/* 348 */
/* 349 */       if (agg_isNull46) {
/* 350 */         agg_rowWriter1.setNullAt(2);
/* 351 */       } else {
/* 352 */         agg_rowWriter1.write(2, agg_value49);
/* 353 */       }
/* 354 */
/* 355 */       if (agg_isNull47) {
/* 356 */         agg_rowWriter1.setNullAt(3);
/* 357 */       } else {
/* 358 */         agg_rowWriter1.write(3, agg_value50);
/* 359 */       }
/* 360 */
/* 361 */       if (agg_isNull48) {
/* 362 */         agg_rowWriter1.setNullAt(4);
/* 363 */       } else {
/* 364 */         agg_rowWriter1.write(4, agg_value51);
/* 365 */       }
/* 366 */
/* 367 */       if (agg_isNull49) {
/* 368 */         agg_rowWriter1.setNullAt(5);
/* 369 */       } else {
/* 370 */         agg_rowWriter1.write(5, agg_value52);
/* 371 */       }
/* 372 */
/* 373 */       if (agg_isNull50) {
/* 374 */         agg_rowWriter1.setNullAt(6);
/* 375 */       } else {
/* 376 */         agg_rowWriter1.write(6, agg_value53);
/* 377 */       }
/* 378 */
/* 379 */       if (agg_isNull43) {
/* 380 */         agg_rowWriter1.setNullAt(7);
/* 381 */       } else {
/* 382 */         agg_rowWriter1.write(7, agg_value46);
/* 383 */       }
/* 384 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 385 */       append(agg_result1);
/* 386 */
/* 387 */       if (shouldStop()) return;
/* 388 */     }
/* 389 */
/* 390 */     agg_mapIter.close();
/* 391 */     if (agg_sorter == null) {
/* 392 */       agg_hashMap.free();
/* 393 */     }
/* 394 */   }
/* 395 */ }
