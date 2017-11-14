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
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
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
/* 035 */   private int agg_value19;
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
/* 060 */     agg_result1 = new UnsafeRow(9);
/* 061 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 062 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 9);
/* 063 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 064 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
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
/* 078 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 079 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 080 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 081 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 082 */       long inputadapter_value4 = inputadapter_isNull4 ? -1L : (inputadapter_row.getLong(4));
/* 083 */       double inputadapter_value5 = inputadapter_row.getDouble(5);
/* 084 */       double inputadapter_value6 = inputadapter_row.getDouble(6);
/* 085 */       double inputadapter_value7 = inputadapter_row.getDouble(7);
/* 086 */       long inputadapter_value8 = inputadapter_row.getLong(8);
/* 087 */
/* 088 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 089 */
/* 090 */       UnsafeRow agg_fastAggBuffer = null;
/* 091 */
/* 092 */       if (agg_fastAggBuffer == null) {
/* 093 */         // generate grouping key
/* 094 */         agg_holder.reset();
/* 095 */
/* 096 */         agg_rowWriter.zeroOutNullBytes();
/* 097 */
/* 098 */         if (inputadapter_isNull) {
/* 099 */           agg_rowWriter.setNullAt(0);
/* 100 */         } else {
/* 101 */           agg_rowWriter.write(0, inputadapter_value);
/* 102 */         }
/* 103 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 104 */         agg_value19 = 42;
/* 105 */
/* 106 */         if (!inputadapter_isNull) {
/* 107 */           agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value19);
/* 108 */         }
/* 109 */         if (true) {
/* 110 */           // try to get the buffer from hash map
/* 111 */           agg_unsafeRowAggBuffer =
/* 112 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value19);
/* 113 */         }
/* 114 */         if (agg_unsafeRowAggBuffer == null) {
/* 115 */           if (agg_sorter == null) {
/* 116 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 117 */           } else {
/* 118 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 119 */           }
/* 120 */
/* 121 */           // the hash map had be spilled, it should have enough memory now,
/* 122 */           // try  to allocate buffer again.
/* 123 */           agg_unsafeRowAggBuffer =
/* 124 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value19);
/* 125 */           if (agg_unsafeRowAggBuffer == null) {
/* 126 */             // failed to allocate the first page
/* 127 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 128 */           }
/* 129 */         }
/* 130 */       }
/* 131 */
/* 132 */       if (agg_fastAggBuffer != null) {
/* 133 */         // update fast row
/* 134 */
/* 135 */       } else {
/* 136 */         // update unsafe row
/* 137 */
/* 138 */         // common sub-expressions
/* 139 */         boolean agg_isNull13 = false;
/* 140 */
/* 141 */         double agg_value22 = agg_unsafeRowAggBuffer.getDouble(4);
/* 142 */
/* 143 */         double agg_value21 = -1.0;
/* 144 */         agg_value21 = agg_value22 + inputadapter_value5;
/* 145 */         boolean agg_isNull17 = false;
/* 146 */
/* 147 */         boolean agg_isNull18 = false;
/* 148 */
/* 149 */         double agg_value27 = agg_unsafeRowAggBuffer.getDouble(4);
/* 150 */
/* 151 */         double agg_value26 = -1.0;
/* 152 */         agg_value26 = agg_value27 + inputadapter_value5;
/* 153 */
/* 154 */         boolean agg_value25 = false;
/* 155 */         agg_value25 = (java.lang.Double.isNaN(agg_value26) && java.lang.Double.isNaN(0.0D)) || agg_value26 == 0.0D;
/* 156 */         boolean agg_isNull16 = false;
/* 157 */         double agg_value24 = -1.0;
/* 158 */         if (!false && agg_value25) {
/* 159 */           agg_isNull16 = false;
/* 160 */           agg_value24 = 0.0D;
/* 161 */         } else {
/* 162 */           boolean agg_isNull27 = false;
/* 163 */
/* 164 */           double agg_value36 = agg_unsafeRowAggBuffer.getDouble(4);
/* 165 */
/* 166 */           double agg_value35 = -1.0;
/* 167 */           agg_value35 = agg_value36 + inputadapter_value5;
/* 168 */           boolean agg_isNull23 = false;
/* 169 */           double agg_value31 = -1.0;
/* 170 */           if (agg_value35 == 0) {
/* 171 */             agg_isNull23 = true;
/* 172 */           } else {
/* 173 */             boolean agg_isNull24 = false;
/* 174 */
/* 175 */             double agg_value34 = agg_unsafeRowAggBuffer.getDouble(5);
/* 176 */             double agg_value32 = -1.0;
/* 177 */             agg_value32 = inputadapter_value6 - agg_value34;
/* 178 */             agg_value31 = (double)(agg_value32 / agg_value35);
/* 179 */           }
/* 180 */           agg_isNull16 = agg_isNull23;
/* 181 */           agg_value24 = agg_value31;
/* 182 */         }
/* 183 */         // evaluate aggregate function
/* 184 */         boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 185 */         double agg_value39 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 186 */         boolean agg_isNull30 = agg_isNull31;
/* 187 */         double agg_value38 = agg_value39;
/* 188 */
/* 189 */         if (!inputadapter_isNull1 && (agg_isNull30 ||
/* 190 */             (org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value38, inputadapter_value1)) > 0)) {
/* 191 */           agg_isNull30 = false;
/* 192 */           agg_value38 = inputadapter_value1;
/* 193 */         }
/* 194 */         boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 195 */         double agg_value42 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 196 */         boolean agg_isNull33 = agg_isNull34;
/* 197 */         double agg_value41 = agg_value42;
/* 198 */
/* 199 */         if (!inputadapter_isNull2 && (agg_isNull33 ||
/* 200 */             (org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value2, agg_value41)) > 0)) {
/* 201 */           agg_isNull33 = false;
/* 202 */           agg_value41 = inputadapter_value2;
/* 203 */         }
/* 204 */         boolean agg_isNull36 = true;
/* 205 */         double agg_value44 = -1.0;
/* 206 */
/* 207 */         boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 208 */         double agg_value45 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 209 */         if (!agg_isNull37) {
/* 210 */           if (!inputadapter_isNull3) {
/* 211 */             agg_isNull36 = false; // resultCode could change nullability.
/* 212 */             agg_value44 = agg_value45 + inputadapter_value3;
/* 213 */
/* 214 */           }
/* 215 */
/* 216 */         }
/* 217 */         boolean agg_isNull39 = true;
/* 218 */         long agg_value47 = -1L;
/* 219 */
/* 220 */         boolean agg_isNull40 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 221 */         long agg_value48 = agg_isNull40 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 222 */         if (!agg_isNull40) {
/* 223 */           if (!inputadapter_isNull4) {
/* 224 */             agg_isNull39 = false; // resultCode could change nullability.
/* 225 */             agg_value47 = agg_value48 + inputadapter_value4;
/* 226 */
/* 227 */           }
/* 228 */
/* 229 */         }
/* 230 */         boolean agg_isNull42 = true;
/* 231 */         double agg_value50 = -1.0;
/* 232 */
/* 233 */         double agg_value51 = agg_unsafeRowAggBuffer.getDouble(5);
/* 234 */
/* 235 */         boolean agg_isNull44 = true;
/* 236 */         double agg_value52 = -1.0;
/* 237 */
/* 238 */         if (!agg_isNull16) {
/* 239 */           agg_isNull44 = false; // resultCode could change nullability.
/* 240 */           agg_value52 = agg_value24 * inputadapter_value5;
/* 241 */
/* 242 */         }
/* 243 */         if (!agg_isNull44) {
/* 244 */           agg_isNull42 = false; // resultCode could change nullability.
/* 245 */           agg_value50 = agg_value51 + agg_value52;
/* 246 */
/* 247 */         }
/* 248 */         boolean agg_isNull46 = true;
/* 249 */         double agg_value54 = -1.0;
/* 250 */
/* 251 */         boolean agg_isNull47 = false;
/* 252 */
/* 253 */         double agg_value56 = agg_unsafeRowAggBuffer.getDouble(6);
/* 254 */
/* 255 */         double agg_value55 = -1.0;
/* 256 */         agg_value55 = agg_value56 + inputadapter_value7;
/* 257 */
/* 258 */         boolean agg_isNull50 = true;
/* 259 */         double agg_value58 = -1.0;
/* 260 */
/* 261 */         boolean agg_isNull51 = true;
/* 262 */         double agg_value59 = -1.0;
/* 263 */
/* 264 */         boolean agg_isNull52 = true;
/* 265 */         double agg_value60 = -1.0;
/* 266 */
/* 267 */         boolean agg_isNull53 = false;
/* 268 */
/* 269 */         double agg_value63 = agg_unsafeRowAggBuffer.getDouble(5);
/* 270 */         double agg_value61 = -1.0;
/* 271 */         agg_value61 = inputadapter_value6 - agg_value63;
/* 272 */
/* 273 */         if (!agg_isNull16) {
/* 274 */           agg_isNull52 = false; // resultCode could change nullability.
/* 275 */           agg_value60 = agg_value61 * agg_value24;
/* 276 */
/* 277 */         }
/* 278 */         if (!agg_isNull52) {
/* 279 */           double agg_value64 = agg_unsafeRowAggBuffer.getDouble(4);
/* 280 */
/* 281 */           agg_isNull51 = false; // resultCode could change nullability.
/* 282 */           agg_value59 = agg_value60 * agg_value64;
/* 283 */
/* 284 */         }
/* 285 */         if (!agg_isNull51) {
/* 286 */           agg_isNull50 = false; // resultCode could change nullability.
/* 287 */           agg_value58 = agg_value59 * inputadapter_value5;
/* 288 */
/* 289 */         }
/* 290 */         if (!agg_isNull50) {
/* 291 */           agg_isNull46 = false; // resultCode could change nullability.
/* 292 */           agg_value54 = agg_value55 + agg_value58;
/* 293 */
/* 294 */         }
/* 295 */         boolean agg_isNull58 = false;
/* 296 */
/* 297 */         long agg_value67 = agg_unsafeRowAggBuffer.getLong(7);
/* 298 */
/* 299 */         long agg_value66 = -1L;
/* 300 */         agg_value66 = agg_value67 + inputadapter_value8;
/* 301 */         // update unsafe row buffer
/* 302 */         if (!agg_isNull30) {
/* 303 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value38);
/* 304 */         } else {
/* 305 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 306 */         }
/* 307 */
/* 308 */         if (!agg_isNull33) {
/* 309 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value41);
/* 310 */         } else {
/* 311 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 312 */         }
/* 313 */
/* 314 */         if (!agg_isNull36) {
/* 315 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value44);
/* 316 */         } else {
/* 317 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 318 */         }
/* 319 */
/* 320 */         if (!agg_isNull39) {
/* 321 */           agg_unsafeRowAggBuffer.setLong(3, agg_value47);
/* 322 */         } else {
/* 323 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 324 */         }
/* 325 */
/* 326 */         agg_unsafeRowAggBuffer.setDouble(4, agg_value21);
/* 327 */
/* 328 */         if (!agg_isNull42) {
/* 329 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value50);
/* 330 */         } else {
/* 331 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 332 */         }
/* 333 */
/* 334 */         if (!agg_isNull46) {
/* 335 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value54);
/* 336 */         } else {
/* 337 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 338 */         }
/* 339 */
/* 340 */         agg_unsafeRowAggBuffer.setLong(7, agg_value66);
/* 341 */
/* 342 */       }
/* 343 */       if (shouldStop()) return;
/* 344 */     }
/* 345 */
/* 346 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 347 */   }
/* 348 */
/* 349 */   protected void processNext() throws java.io.IOException {
/* 350 */     if (!agg_initAgg) {
/* 351 */       agg_initAgg = true;
/* 352 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 353 */       agg_doAggregateWithKeys();
/* 354 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 355 */     }
/* 356 */
/* 357 */     // output the result
/* 358 */
/* 359 */     while (agg_mapIter.next()) {
/* 360 */       wholestagecodegen_numOutputRows.add(1);
/* 361 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 362 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 363 */
/* 364 */       boolean agg_isNull61 = agg_aggKey.isNullAt(0);
/* 365 */       UTF8String agg_value69 = agg_isNull61 ? null : (agg_aggKey.getUTF8String(0));
/* 366 */       boolean agg_isNull62 = agg_aggBuffer.isNullAt(0);
/* 367 */       double agg_value70 = agg_isNull62 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 368 */       boolean agg_isNull63 = agg_aggBuffer.isNullAt(1);
/* 369 */       double agg_value71 = agg_isNull63 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 370 */       boolean agg_isNull64 = agg_aggBuffer.isNullAt(2);
/* 371 */       double agg_value72 = agg_isNull64 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 372 */       boolean agg_isNull65 = agg_aggBuffer.isNullAt(3);
/* 373 */       long agg_value73 = agg_isNull65 ? -1L : (agg_aggBuffer.getLong(3));
/* 374 */       double agg_value74 = agg_aggBuffer.getDouble(4);
/* 375 */       double agg_value75 = agg_aggBuffer.getDouble(5);
/* 376 */       double agg_value76 = agg_aggBuffer.getDouble(6);
/* 377 */       long agg_value77 = agg_aggBuffer.getLong(7);
/* 378 */       boolean agg_isNull74 = agg_isNull65;
/* 379 */       double agg_value82 = -1.0;
/* 380 */       if (!agg_isNull65) {
/* 381 */         agg_value82 = (double) agg_value73;
/* 382 */       }
/* 383 */       boolean agg_isNull72 = false;
/* 384 */       double agg_value80 = -1.0;
/* 385 */       if (agg_isNull74 || agg_value82 == 0) {
/* 386 */         agg_isNull72 = true;
/* 387 */       } else {
/* 388 */         if (agg_isNull64) {
/* 389 */           agg_isNull72 = true;
/* 390 */         } else {
/* 391 */           agg_value80 = (double)(agg_value72 / agg_value82);
/* 392 */         }
/* 393 */       }
/* 394 */       boolean agg_isNull77 = false;
/* 395 */
/* 396 */       boolean agg_value85 = false;
/* 397 */       agg_value85 = (java.lang.Double.isNaN(agg_value74) && java.lang.Double.isNaN(0.0D)) || agg_value74 == 0.0D;
/* 398 */       boolean agg_isNull76 = false;
/* 399 */       double agg_value84 = -1.0;
/* 400 */       if (!false && agg_value85) {
/* 401 */         final double agg_value88 = -1.0;
/* 402 */         agg_isNull76 = true;
/* 403 */         agg_value84 = agg_value88;
/* 404 */       } else {
/* 405 */         boolean agg_isNull82 = false;
/* 406 */
/* 407 */         boolean agg_value90 = false;
/* 408 */         agg_value90 = (java.lang.Double.isNaN(agg_value74) && java.lang.Double.isNaN(1.0D)) || agg_value74 == 1.0D;
/* 409 */         boolean agg_isNull81 = false;
/* 410 */         double agg_value89 = -1.0;
/* 411 */         if (!false && agg_value90) {
/* 412 */           final double agg_value93 = (double) ((java.lang.Double) references[3]);
/* 413 */           agg_isNull81 = false;
/* 414 */           agg_value89 = agg_value93;
/* 415 */         } else {
/* 416 */           boolean agg_isNull89 = false;
/* 417 */
/* 418 */           double agg_value97 = -1.0;
/* 419 */           agg_value97 = agg_value74 - 1.0D;
/* 420 */           boolean agg_isNull87 = false;
/* 421 */           double agg_value95 = -1.0;
/* 422 */           if (agg_value97 == 0) {
/* 423 */             agg_isNull87 = true;
/* 424 */           } else {
/* 425 */             agg_value95 = (double)(agg_value76 / agg_value97);
/* 426 */           }
/* 427 */           boolean agg_isNull86 = agg_isNull87;
/* 428 */           double agg_value94 = -1.0;
/* 429 */
/* 430 */           if (!agg_isNull87) {
/* 431 */             agg_value94 = java.lang.Math.sqrt(agg_value95);
/* 432 */           }
/* 433 */           agg_isNull81 = agg_isNull86;
/* 434 */           agg_value89 = agg_value94;
/* 435 */         }
/* 436 */         agg_isNull76 = agg_isNull81;
/* 437 */         agg_value84 = agg_value89;
/* 438 */       }
/* 439 */
/* 440 */       agg_holder1.reset();
/* 441 */
/* 442 */       agg_rowWriter1.zeroOutNullBytes();
/* 443 */
/* 444 */       if (agg_isNull61) {
/* 445 */         agg_rowWriter1.setNullAt(0);
/* 446 */       } else {
/* 447 */         agg_rowWriter1.write(0, agg_value69);
/* 448 */       }
/* 449 */
/* 450 */       if (agg_isNull62) {
/* 451 */         agg_rowWriter1.setNullAt(1);
/* 452 */       } else {
/* 453 */         agg_rowWriter1.write(1, agg_value70);
/* 454 */       }
/* 455 */
/* 456 */       if (agg_isNull63) {
/* 457 */         agg_rowWriter1.setNullAt(2);
/* 458 */       } else {
/* 459 */         agg_rowWriter1.write(2, agg_value71);
/* 460 */       }
/* 461 */
/* 462 */       if (agg_isNull72) {
/* 463 */         agg_rowWriter1.setNullAt(3);
/* 464 */       } else {
/* 465 */         agg_rowWriter1.write(3, agg_value80);
/* 466 */       }
/* 467 */
/* 468 */       if (agg_isNull76) {
/* 469 */         agg_rowWriter1.setNullAt(4);
/* 470 */       } else {
/* 471 */         agg_rowWriter1.write(4, agg_value84);
/* 472 */       }
/* 473 */
/* 474 */       agg_rowWriter1.write(5, agg_value77);
/* 475 */
/* 476 */       agg_rowWriter1.write(6, ((UTF8String) references[4]));
/* 477 */
/* 478 */       agg_rowWriter1.write(7, ((UTF8String) references[5]));
/* 479 */
/* 480 */       agg_rowWriter1.write(8, ((UTF8String) references[6]));
/* 481 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 482 */       append(agg_result1);
/* 483 */
/* 484 */       if (shouldStop()) return;
/* 485 */     }
/* 486 */
/* 487 */     agg_mapIter.close();
/* 488 */     if (agg_sorter == null) {
/* 489 */       agg_hashMap.free();
/* 490 */     }
/* 491 */   }
/* 492 */ }
