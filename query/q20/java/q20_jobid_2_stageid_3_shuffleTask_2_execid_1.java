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
/* 061 */     while (inputadapter_input.hasNext()) {
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
/* 171 */         boolean agg_isNull19 = false;
/* 172 */         double agg_value22 = -1.0;
/* 173 */         if (!false) {
/* 174 */           agg_value22 = (double) 0;
/* 175 */         }
/* 176 */         // evaluate aggregate function
/* 177 */         boolean agg_isNull22 = true;
/* 178 */         double agg_value25 = -1.0;
/* 179 */
/* 180 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 181 */         double agg_value27 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 182 */         boolean agg_isNull23 = agg_isNull24;
/* 183 */         double agg_value26 = agg_value27;
/* 184 */         if (agg_isNull23) {
/* 185 */           if (!agg_isNull19) {
/* 186 */             agg_isNull23 = false;
/* 187 */             agg_value26 = agg_value22;
/* 188 */           }
/* 189 */         }
/* 190 */
/* 191 */         if (!inputadapter_isNull5) {
/* 192 */           agg_isNull22 = false; // resultCode could change nullability.
/* 193 */           agg_value25 = agg_value26 + inputadapter_value5;
/* 194 */
/* 195 */         }
/* 196 */         boolean agg_isNull21 = agg_isNull22;
/* 197 */         double agg_value24 = agg_value25;
/* 198 */         if (agg_isNull21) {
/* 199 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 200 */           double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 201 */           if (!agg_isNull26) {
/* 202 */             agg_isNull21 = false;
/* 203 */             agg_value24 = agg_value29;
/* 204 */           }
/* 205 */         }
/* 206 */         boolean agg_isNull28 = true;
/* 207 */         double agg_value31 = -1.0;
/* 208 */
/* 209 */         boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 210 */         double agg_value33 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 211 */         boolean agg_isNull29 = agg_isNull30;
/* 212 */         double agg_value32 = agg_value33;
/* 213 */         if (agg_isNull29) {
/* 214 */           if (!agg_isNull19) {
/* 215 */             agg_isNull29 = false;
/* 216 */             agg_value32 = agg_value22;
/* 217 */           }
/* 218 */         }
/* 219 */
/* 220 */         if (!inputadapter_isNull6) {
/* 221 */           agg_isNull28 = false; // resultCode could change nullability.
/* 222 */           agg_value31 = agg_value32 + inputadapter_value6;
/* 223 */
/* 224 */         }
/* 225 */         boolean agg_isNull27 = agg_isNull28;
/* 226 */         double agg_value30 = agg_value31;
/* 227 */         if (agg_isNull27) {
/* 228 */           boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 229 */           double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 230 */           if (!agg_isNull32) {
/* 231 */             agg_isNull27 = false;
/* 232 */             agg_value30 = agg_value35;
/* 233 */           }
/* 234 */         }
/* 235 */         boolean agg_isNull34 = true;
/* 236 */         double agg_value37 = -1.0;
/* 237 */
/* 238 */         boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 239 */         double agg_value39 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 240 */         boolean agg_isNull35 = agg_isNull36;
/* 241 */         double agg_value38 = agg_value39;
/* 242 */         if (agg_isNull35) {
/* 243 */           if (!agg_isNull19) {
/* 244 */             agg_isNull35 = false;
/* 245 */             agg_value38 = agg_value22;
/* 246 */           }
/* 247 */         }
/* 248 */
/* 249 */         if (!inputadapter_isNull7) {
/* 250 */           agg_isNull34 = false; // resultCode could change nullability.
/* 251 */           agg_value37 = agg_value38 + inputadapter_value7;
/* 252 */
/* 253 */         }
/* 254 */         boolean agg_isNull33 = agg_isNull34;
/* 255 */         double agg_value36 = agg_value37;
/* 256 */         if (agg_isNull33) {
/* 257 */           boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 258 */           double agg_value41 = agg_isNull38 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 259 */           if (!agg_isNull38) {
/* 260 */             agg_isNull33 = false;
/* 261 */             agg_value36 = agg_value41;
/* 262 */           }
/* 263 */         }
/* 264 */         // update unsafe row buffer
/* 265 */         if (!agg_isNull21) {
/* 266 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value24);
/* 267 */         } else {
/* 268 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 269 */         }
/* 270 */
/* 271 */         if (!agg_isNull27) {
/* 272 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value30);
/* 273 */         } else {
/* 274 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 275 */         }
/* 276 */
/* 277 */         if (!agg_isNull33) {
/* 278 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value36);
/* 279 */         } else {
/* 280 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 281 */         }
/* 282 */
/* 283 */       }
/* 284 */       if (shouldStop()) return;
/* 285 */     }
/* 286 */
/* 287 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 288 */   }
/* 289 */
/* 290 */   protected void processNext() throws java.io.IOException {
/* 291 */     if (!agg_initAgg) {
/* 292 */       agg_initAgg = true;
/* 293 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 294 */       agg_doAggregateWithKeys();
/* 295 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 296 */     }
/* 297 */
/* 298 */     // output the result
/* 299 */
/* 300 */     while (agg_mapIter.next()) {
/* 301 */       wholestagecodegen_numOutputRows.add(1);
/* 302 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 303 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 304 */
/* 305 */       boolean agg_isNull39 = agg_aggKey.isNullAt(0);
/* 306 */       UTF8String agg_value42 = agg_isNull39 ? null : (agg_aggKey.getUTF8String(0));
/* 307 */       boolean agg_isNull40 = agg_aggKey.isNullAt(1);
/* 308 */       UTF8String agg_value43 = agg_isNull40 ? null : (agg_aggKey.getUTF8String(1));
/* 309 */       boolean agg_isNull41 = agg_aggKey.isNullAt(2);
/* 310 */       UTF8String agg_value44 = agg_isNull41 ? null : (agg_aggKey.getUTF8String(2));
/* 311 */       boolean agg_isNull42 = agg_aggKey.isNullAt(3);
/* 312 */       UTF8String agg_value45 = agg_isNull42 ? null : (agg_aggKey.getUTF8String(3));
/* 313 */       boolean agg_isNull43 = agg_aggKey.isNullAt(4);
/* 314 */       double agg_value46 = agg_isNull43 ? -1.0 : (agg_aggKey.getDouble(4));
/* 315 */       boolean agg_isNull44 = agg_aggBuffer.isNullAt(0);
/* 316 */       double agg_value47 = agg_isNull44 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 317 */       boolean agg_isNull45 = agg_aggBuffer.isNullAt(1);
/* 318 */       double agg_value48 = agg_isNull45 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 319 */       boolean agg_isNull46 = agg_aggBuffer.isNullAt(2);
/* 320 */       double agg_value49 = agg_isNull46 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 321 */
/* 322 */       agg_holder1.reset();
/* 323 */
/* 324 */       agg_rowWriter1.zeroOutNullBytes();
/* 325 */
/* 326 */       if (agg_isNull40) {
/* 327 */         agg_rowWriter1.setNullAt(0);
/* 328 */       } else {
/* 329 */         agg_rowWriter1.write(0, agg_value43);
/* 330 */       }
/* 331 */
/* 332 */       if (agg_isNull41) {
/* 333 */         agg_rowWriter1.setNullAt(1);
/* 334 */       } else {
/* 335 */         agg_rowWriter1.write(1, agg_value44);
/* 336 */       }
/* 337 */
/* 338 */       if (agg_isNull42) {
/* 339 */         agg_rowWriter1.setNullAt(2);
/* 340 */       } else {
/* 341 */         agg_rowWriter1.write(2, agg_value45);
/* 342 */       }
/* 343 */
/* 344 */       if (agg_isNull43) {
/* 345 */         agg_rowWriter1.setNullAt(3);
/* 346 */       } else {
/* 347 */         agg_rowWriter1.write(3, agg_value46);
/* 348 */       }
/* 349 */
/* 350 */       if (agg_isNull44) {
/* 351 */         agg_rowWriter1.setNullAt(4);
/* 352 */       } else {
/* 353 */         agg_rowWriter1.write(4, agg_value47);
/* 354 */       }
/* 355 */
/* 356 */       if (agg_isNull45) {
/* 357 */         agg_rowWriter1.setNullAt(5);
/* 358 */       } else {
/* 359 */         agg_rowWriter1.write(5, agg_value48);
/* 360 */       }
/* 361 */
/* 362 */       if (agg_isNull46) {
/* 363 */         agg_rowWriter1.setNullAt(6);
/* 364 */       } else {
/* 365 */         agg_rowWriter1.write(6, agg_value49);
/* 366 */       }
/* 367 */
/* 368 */       if (agg_isNull39) {
/* 369 */         agg_rowWriter1.setNullAt(7);
/* 370 */       } else {
/* 371 */         agg_rowWriter1.write(7, agg_value42);
/* 372 */       }
/* 373 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 374 */       append(agg_result1);
/* 375 */
/* 376 */       if (shouldStop()) return;
/* 377 */     }
/* 378 */
/* 379 */     agg_mapIter.close();
/* 380 */     if (agg_sorter == null) {
/* 381 */       agg_hashMap.free();
/* 382 */     }
/* 383 */   }
/* 384 */ }
