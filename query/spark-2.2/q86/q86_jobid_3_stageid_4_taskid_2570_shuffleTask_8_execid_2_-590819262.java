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
/* 023 */   private int agg_value10;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */
/* 041 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 043 */     inputadapter_input = inputs[0];
/* 044 */     agg_result = new UnsafeRow(3);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(7);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 065 */       int inputadapter_value2 = inputadapter_row.getInt(2);
/* 066 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 067 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 068 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 069 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 070 */
/* 071 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 072 */
/* 073 */       UnsafeRow agg_fastAggBuffer = null;
/* 074 */
/* 075 */       if (agg_fastAggBuffer == null) {
/* 076 */         // generate grouping key
/* 077 */         agg_holder.reset();
/* 078 */
/* 079 */         agg_rowWriter.zeroOutNullBytes();
/* 080 */
/* 081 */         if (inputadapter_isNull) {
/* 082 */           agg_rowWriter.setNullAt(0);
/* 083 */         } else {
/* 084 */           agg_rowWriter.write(0, inputadapter_value);
/* 085 */         }
/* 086 */
/* 087 */         if (inputadapter_isNull1) {
/* 088 */           agg_rowWriter.setNullAt(1);
/* 089 */         } else {
/* 090 */           agg_rowWriter.write(1, inputadapter_value1);
/* 091 */         }
/* 092 */
/* 093 */         agg_rowWriter.write(2, inputadapter_value2);
/* 094 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 095 */         agg_value10 = 42;
/* 096 */
/* 097 */         if (!inputadapter_isNull) {
/* 098 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value10);
/* 099 */         }
/* 100 */
/* 101 */         if (!inputadapter_isNull1) {
/* 102 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value10);
/* 103 */         }
/* 104 */
/* 105 */         agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value10);
/* 106 */         if (true) {
/* 107 */           // try to get the buffer from hash map
/* 108 */           agg_unsafeRowAggBuffer =
/* 109 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 110 */         }
/* 111 */         if (agg_unsafeRowAggBuffer == null) {
/* 112 */           if (agg_sorter == null) {
/* 113 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 114 */           } else {
/* 115 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 116 */           }
/* 117 */
/* 118 */           // the hash map had be spilled, it should have enough memory now,
/* 119 */           // try  to allocate buffer again.
/* 120 */           agg_unsafeRowAggBuffer =
/* 121 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 122 */           if (agg_unsafeRowAggBuffer == null) {
/* 123 */             // failed to allocate the first page
/* 124 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 125 */           }
/* 126 */         }
/* 127 */       }
/* 128 */
/* 129 */       if (agg_fastAggBuffer != null) {
/* 130 */         // update fast row
/* 131 */
/* 132 */       } else {
/* 133 */         // update unsafe row
/* 134 */
/* 135 */         // common sub-expressions
/* 136 */
/* 137 */         // evaluate aggregate function
/* 138 */         boolean agg_isNull13 = true;
/* 139 */         double agg_value15 = -1.0;
/* 140 */
/* 141 */         boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 142 */         double agg_value17 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 143 */         boolean agg_isNull14 = agg_isNull15;
/* 144 */         double agg_value16 = agg_value17;
/* 145 */         if (agg_isNull14) {
/* 146 */           boolean agg_isNull16 = false;
/* 147 */           double agg_value18 = -1.0;
/* 148 */           if (!false) {
/* 149 */             agg_value18 = (double) 0;
/* 150 */           }
/* 151 */           if (!agg_isNull16) {
/* 152 */             agg_isNull14 = false;
/* 153 */             agg_value16 = agg_value18;
/* 154 */           }
/* 155 */         }
/* 156 */
/* 157 */         if (!inputadapter_isNull3) {
/* 158 */           agg_isNull13 = false; // resultCode could change nullability.
/* 159 */           agg_value15 = agg_value16 + inputadapter_value3;
/* 160 */
/* 161 */         }
/* 162 */         boolean agg_isNull12 = agg_isNull13;
/* 163 */         double agg_value14 = agg_value15;
/* 164 */         if (agg_isNull12) {
/* 165 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 166 */           double agg_value21 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 167 */           if (!agg_isNull19) {
/* 168 */             agg_isNull12 = false;
/* 169 */             agg_value14 = agg_value21;
/* 170 */           }
/* 171 */         }
/* 172 */         boolean agg_isNull21 = true;
/* 173 */         double agg_value23 = -1.0;
/* 174 */
/* 175 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 176 */         double agg_value25 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 177 */         boolean agg_isNull22 = agg_isNull23;
/* 178 */         double agg_value24 = agg_value25;
/* 179 */         if (agg_isNull22) {
/* 180 */           boolean agg_isNull24 = false;
/* 181 */           double agg_value26 = -1.0;
/* 182 */           if (!false) {
/* 183 */             agg_value26 = (double) 0;
/* 184 */           }
/* 185 */           if (!agg_isNull24) {
/* 186 */             agg_isNull22 = false;
/* 187 */             agg_value24 = agg_value26;
/* 188 */           }
/* 189 */         }
/* 190 */
/* 191 */         if (!inputadapter_isNull4) {
/* 192 */           agg_isNull21 = false; // resultCode could change nullability.
/* 193 */           agg_value23 = agg_value24 + inputadapter_value4;
/* 194 */
/* 195 */         }
/* 196 */         boolean agg_isNull20 = agg_isNull21;
/* 197 */         double agg_value22 = agg_value23;
/* 198 */         if (agg_isNull20) {
/* 199 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 200 */           double agg_value29 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 201 */           if (!agg_isNull27) {
/* 202 */             agg_isNull20 = false;
/* 203 */             agg_value22 = agg_value29;
/* 204 */           }
/* 205 */         }
/* 206 */         // update unsafe row buffer
/* 207 */         if (!agg_isNull12) {
/* 208 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value14);
/* 209 */         } else {
/* 210 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 211 */         }
/* 212 */
/* 213 */         if (!agg_isNull20) {
/* 214 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value22);
/* 215 */         } else {
/* 216 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 217 */         }
/* 218 */
/* 219 */       }
/* 220 */       if (shouldStop()) return;
/* 221 */     }
/* 222 */
/* 223 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 224 */   }
/* 225 */
/* 226 */   protected void processNext() throws java.io.IOException {
/* 227 */     if (!agg_initAgg) {
/* 228 */       agg_initAgg = true;
/* 229 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 230 */       agg_doAggregateWithKeys();
/* 231 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 232 */     }
/* 233 */
/* 234 */     // output the result
/* 235 */
/* 236 */     while (agg_mapIter.next()) {
/* 237 */       wholestagecodegen_numOutputRows.add(1);
/* 238 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 239 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 240 */
/* 241 */       boolean agg_isNull28 = agg_aggKey.isNullAt(0);
/* 242 */       UTF8String agg_value30 = agg_isNull28 ? null : (agg_aggKey.getUTF8String(0));
/* 243 */       boolean agg_isNull29 = agg_aggKey.isNullAt(1);
/* 244 */       UTF8String agg_value31 = agg_isNull29 ? null : (agg_aggKey.getUTF8String(1));
/* 245 */       int agg_value32 = agg_aggKey.getInt(2);
/* 246 */       boolean agg_isNull31 = agg_aggBuffer.isNullAt(0);
/* 247 */       double agg_value33 = agg_isNull31 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 248 */       boolean agg_isNull32 = agg_aggBuffer.isNullAt(1);
/* 249 */       double agg_value34 = agg_isNull32 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 250 */
/* 251 */       boolean agg_isNull38 = false;
/* 252 */
/* 253 */       boolean agg_isNull40 = false;
/* 254 */
/* 255 */       boolean agg_isNull41 = false;
/* 256 */
/* 257 */       int agg_value43 = -1;
/* 258 */       agg_value43 = agg_value32 >> 1;
/* 259 */
/* 260 */       int agg_value42 = -1;
/* 261 */       agg_value42 = agg_value43 & 1;
/* 262 */       boolean agg_isNull39 = false;
/* 263 */       byte agg_value41 = (byte)-1;
/* 264 */       if (!false) {
/* 265 */         agg_value41 = (byte) agg_value42;
/* 266 */       }
/* 267 */
/* 268 */       boolean agg_isNull46 = false;
/* 269 */
/* 270 */       boolean agg_isNull47 = false;
/* 271 */
/* 272 */       int agg_value49 = -1;
/* 273 */       agg_value49 = agg_value32 >> 0;
/* 274 */
/* 275 */       int agg_value48 = -1;
/* 276 */       agg_value48 = agg_value49 & 1;
/* 277 */       boolean agg_isNull45 = false;
/* 278 */       byte agg_value47 = (byte)-1;
/* 279 */       if (!false) {
/* 280 */         agg_value47 = (byte) agg_value48;
/* 281 */       }
/* 282 */       byte agg_value40 = (byte)-1;
/* 283 */       agg_value40 = (byte)(agg_value41 + agg_value47);
/* 284 */       boolean agg_isNull51 = false;
/* 285 */
/* 286 */       boolean agg_isNull53 = false;
/* 287 */
/* 288 */       boolean agg_isNull54 = false;
/* 289 */
/* 290 */       int agg_value56 = -1;
/* 291 */       agg_value56 = agg_value32 >> 1;
/* 292 */
/* 293 */       int agg_value55 = -1;
/* 294 */       agg_value55 = agg_value56 & 1;
/* 295 */       boolean agg_isNull52 = false;
/* 296 */       byte agg_value54 = (byte)-1;
/* 297 */       if (!false) {
/* 298 */         agg_value54 = (byte) agg_value55;
/* 299 */       }
/* 300 */
/* 301 */       boolean agg_isNull59 = false;
/* 302 */
/* 303 */       boolean agg_isNull60 = false;
/* 304 */
/* 305 */       int agg_value62 = -1;
/* 306 */       agg_value62 = agg_value32 >> 0;
/* 307 */
/* 308 */       int agg_value61 = -1;
/* 309 */       agg_value61 = agg_value62 & 1;
/* 310 */       boolean agg_isNull58 = false;
/* 311 */       byte agg_value60 = (byte)-1;
/* 312 */       if (!false) {
/* 313 */         agg_value60 = (byte) agg_value61;
/* 314 */       }
/* 315 */       byte agg_value53 = (byte)-1;
/* 316 */       agg_value53 = (byte)(agg_value54 + agg_value60);
/* 317 */       boolean agg_isNull64 = true;
/* 318 */       UTF8String agg_value66 = null;
/* 319 */
/* 320 */       boolean agg_isNull65 = false;
/* 321 */
/* 322 */       boolean agg_isNull68 = false;
/* 323 */
/* 324 */       boolean agg_isNull69 = false;
/* 325 */
/* 326 */       int agg_value71 = -1;
/* 327 */       agg_value71 = agg_value32 >> 0;
/* 328 */
/* 329 */       int agg_value70 = -1;
/* 330 */       agg_value70 = agg_value71 & 1;
/* 331 */       boolean agg_isNull67 = false;
/* 332 */       byte agg_value69 = (byte)-1;
/* 333 */       if (!false) {
/* 334 */         agg_value69 = (byte) agg_value70;
/* 335 */       }
/* 336 */       boolean agg_isNull66 = agg_isNull67;
/* 337 */       int agg_value68 = -1;
/* 338 */       if (!agg_isNull67) {
/* 339 */         agg_value68 = (int) agg_value69;
/* 340 */       }
/* 341 */
/* 342 */       boolean agg_value67 = false;
/* 343 */       agg_value67 = agg_value68 == 0;
/* 344 */       if (!false && agg_value67) {
/* 345 */         agg_isNull64 = agg_isNull28;
/* 346 */         agg_value66 = agg_value30;
/* 347 */       }
/* 348 */
/* 349 */       else {
/* 350 */       }
/* 351 */       agg_holder1.reset();
/* 352 */
/* 353 */       agg_rowWriter1.zeroOutNullBytes();
/* 354 */
/* 355 */       if (agg_isNull31) {
/* 356 */         agg_rowWriter1.setNullAt(0);
/* 357 */       } else {
/* 358 */         agg_rowWriter1.write(0, agg_value33);
/* 359 */       }
/* 360 */
/* 361 */       if (agg_isNull28) {
/* 362 */         agg_rowWriter1.setNullAt(1);
/* 363 */       } else {
/* 364 */         agg_rowWriter1.write(1, agg_value30);
/* 365 */       }
/* 366 */
/* 367 */       if (agg_isNull29) {
/* 368 */         agg_rowWriter1.setNullAt(2);
/* 369 */       } else {
/* 370 */         agg_rowWriter1.write(2, agg_value31);
/* 371 */       }
/* 372 */
/* 373 */       agg_rowWriter1.write(3, agg_value40);
/* 374 */
/* 375 */       agg_rowWriter1.write(4, agg_value53);
/* 376 */
/* 377 */       if (agg_isNull64) {
/* 378 */         agg_rowWriter1.setNullAt(5);
/* 379 */       } else {
/* 380 */         agg_rowWriter1.write(5, agg_value66);
/* 381 */       }
/* 382 */
/* 383 */       if (agg_isNull32) {
/* 384 */         agg_rowWriter1.setNullAt(6);
/* 385 */       } else {
/* 386 */         agg_rowWriter1.write(6, agg_value34);
/* 387 */       }
/* 388 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 389 */       append(agg_result1);
/* 390 */
/* 391 */       if (shouldStop()) return;
/* 392 */     }
/* 393 */
/* 394 */     agg_mapIter.close();
/* 395 */     if (agg_sorter == null) {
/* 396 */       agg_hashMap.free();
/* 397 */     }
/* 398 */   }
/* 399 */ }
