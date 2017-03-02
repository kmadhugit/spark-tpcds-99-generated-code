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
/* 059 */     while (inputadapter_input.hasNext()) {
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
/* 136 */         boolean agg_isNull12 = false;
/* 137 */         double agg_value14 = -1.0;
/* 138 */         if (!false) {
/* 139 */           agg_value14 = (double) 0;
/* 140 */         }
/* 141 */         // evaluate aggregate function
/* 142 */         boolean agg_isNull15 = true;
/* 143 */         double agg_value17 = -1.0;
/* 144 */
/* 145 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 146 */         double agg_value19 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 147 */         boolean agg_isNull16 = agg_isNull17;
/* 148 */         double agg_value18 = agg_value19;
/* 149 */         if (agg_isNull16) {
/* 150 */           if (!agg_isNull12) {
/* 151 */             agg_isNull16 = false;
/* 152 */             agg_value18 = agg_value14;
/* 153 */           }
/* 154 */         }
/* 155 */
/* 156 */         if (!inputadapter_isNull3) {
/* 157 */           agg_isNull15 = false; // resultCode could change nullability.
/* 158 */           agg_value17 = agg_value18 + inputadapter_value3;
/* 159 */
/* 160 */         }
/* 161 */         boolean agg_isNull14 = agg_isNull15;
/* 162 */         double agg_value16 = agg_value17;
/* 163 */         if (agg_isNull14) {
/* 164 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 165 */           double agg_value21 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 166 */           if (!agg_isNull19) {
/* 167 */             agg_isNull14 = false;
/* 168 */             agg_value16 = agg_value21;
/* 169 */           }
/* 170 */         }
/* 171 */         boolean agg_isNull21 = true;
/* 172 */         double agg_value23 = -1.0;
/* 173 */
/* 174 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 175 */         double agg_value25 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 176 */         boolean agg_isNull22 = agg_isNull23;
/* 177 */         double agg_value24 = agg_value25;
/* 178 */         if (agg_isNull22) {
/* 179 */           if (!agg_isNull12) {
/* 180 */             agg_isNull22 = false;
/* 181 */             agg_value24 = agg_value14;
/* 182 */           }
/* 183 */         }
/* 184 */
/* 185 */         if (!inputadapter_isNull4) {
/* 186 */           agg_isNull21 = false; // resultCode could change nullability.
/* 187 */           agg_value23 = agg_value24 + inputadapter_value4;
/* 188 */
/* 189 */         }
/* 190 */         boolean agg_isNull20 = agg_isNull21;
/* 191 */         double agg_value22 = agg_value23;
/* 192 */         if (agg_isNull20) {
/* 193 */           boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 194 */           double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 195 */           if (!agg_isNull25) {
/* 196 */             agg_isNull20 = false;
/* 197 */             agg_value22 = agg_value27;
/* 198 */           }
/* 199 */         }
/* 200 */         // update unsafe row buffer
/* 201 */         if (!agg_isNull14) {
/* 202 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value16);
/* 203 */         } else {
/* 204 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 205 */         }
/* 206 */
/* 207 */         if (!agg_isNull20) {
/* 208 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value22);
/* 209 */         } else {
/* 210 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 211 */         }
/* 212 */
/* 213 */       }
/* 214 */       if (shouldStop()) return;
/* 215 */     }
/* 216 */
/* 217 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 218 */   }
/* 219 */
/* 220 */   protected void processNext() throws java.io.IOException {
/* 221 */     if (!agg_initAgg) {
/* 222 */       agg_initAgg = true;
/* 223 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 224 */       agg_doAggregateWithKeys();
/* 225 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 226 */     }
/* 227 */
/* 228 */     // output the result
/* 229 */
/* 230 */     while (agg_mapIter.next()) {
/* 231 */       wholestagecodegen_numOutputRows.add(1);
/* 232 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 233 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 234 */
/* 235 */       boolean agg_isNull26 = agg_aggKey.isNullAt(0);
/* 236 */       UTF8String agg_value28 = agg_isNull26 ? null : (agg_aggKey.getUTF8String(0));
/* 237 */       boolean agg_isNull27 = agg_aggKey.isNullAt(1);
/* 238 */       UTF8String agg_value29 = agg_isNull27 ? null : (agg_aggKey.getUTF8String(1));
/* 239 */       int agg_value30 = agg_aggKey.getInt(2);
/* 240 */       boolean agg_isNull29 = agg_aggBuffer.isNullAt(0);
/* 241 */       double agg_value31 = agg_isNull29 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 242 */       boolean agg_isNull30 = agg_aggBuffer.isNullAt(1);
/* 243 */       double agg_value32 = agg_isNull30 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 244 */
/* 245 */       boolean agg_isNull36 = false;
/* 246 */
/* 247 */       boolean agg_isNull38 = false;
/* 248 */
/* 249 */       boolean agg_isNull39 = false;
/* 250 */
/* 251 */       int agg_value41 = -1;
/* 252 */       agg_value41 = agg_value30 >> 1;
/* 253 */
/* 254 */       int agg_value40 = -1;
/* 255 */       agg_value40 = agg_value41 & 1;
/* 256 */       boolean agg_isNull37 = false;
/* 257 */       byte agg_value39 = (byte)-1;
/* 258 */       if (!false) {
/* 259 */         agg_value39 = (byte) agg_value40;
/* 260 */       }
/* 261 */
/* 262 */       boolean agg_isNull44 = false;
/* 263 */
/* 264 */       boolean agg_isNull45 = false;
/* 265 */
/* 266 */       int agg_value47 = -1;
/* 267 */       agg_value47 = agg_value30 >> 0;
/* 268 */
/* 269 */       int agg_value46 = -1;
/* 270 */       agg_value46 = agg_value47 & 1;
/* 271 */       boolean agg_isNull43 = false;
/* 272 */       byte agg_value45 = (byte)-1;
/* 273 */       if (!false) {
/* 274 */         agg_value45 = (byte) agg_value46;
/* 275 */       }
/* 276 */       byte agg_value38 = (byte)-1;
/* 277 */       agg_value38 = (byte)(agg_value39 + agg_value45);
/* 278 */       boolean agg_isNull49 = false;
/* 279 */
/* 280 */       boolean agg_isNull51 = false;
/* 281 */
/* 282 */       boolean agg_isNull52 = false;
/* 283 */
/* 284 */       int agg_value54 = -1;
/* 285 */       agg_value54 = agg_value30 >> 1;
/* 286 */
/* 287 */       int agg_value53 = -1;
/* 288 */       agg_value53 = agg_value54 & 1;
/* 289 */       boolean agg_isNull50 = false;
/* 290 */       byte agg_value52 = (byte)-1;
/* 291 */       if (!false) {
/* 292 */         agg_value52 = (byte) agg_value53;
/* 293 */       }
/* 294 */
/* 295 */       boolean agg_isNull57 = false;
/* 296 */
/* 297 */       boolean agg_isNull58 = false;
/* 298 */
/* 299 */       int agg_value60 = -1;
/* 300 */       agg_value60 = agg_value30 >> 0;
/* 301 */
/* 302 */       int agg_value59 = -1;
/* 303 */       agg_value59 = agg_value60 & 1;
/* 304 */       boolean agg_isNull56 = false;
/* 305 */       byte agg_value58 = (byte)-1;
/* 306 */       if (!false) {
/* 307 */         agg_value58 = (byte) agg_value59;
/* 308 */       }
/* 309 */       byte agg_value51 = (byte)-1;
/* 310 */       agg_value51 = (byte)(agg_value52 + agg_value58);
/* 311 */       boolean agg_isNull62 = true;
/* 312 */       UTF8String agg_value64 = null;
/* 313 */
/* 314 */       boolean agg_isNull63 = false;
/* 315 */
/* 316 */       boolean agg_isNull66 = false;
/* 317 */
/* 318 */       boolean agg_isNull67 = false;
/* 319 */
/* 320 */       int agg_value69 = -1;
/* 321 */       agg_value69 = agg_value30 >> 0;
/* 322 */
/* 323 */       int agg_value68 = -1;
/* 324 */       agg_value68 = agg_value69 & 1;
/* 325 */       boolean agg_isNull65 = false;
/* 326 */       byte agg_value67 = (byte)-1;
/* 327 */       if (!false) {
/* 328 */         agg_value67 = (byte) agg_value68;
/* 329 */       }
/* 330 */       boolean agg_isNull64 = agg_isNull65;
/* 331 */       int agg_value66 = -1;
/* 332 */       if (!agg_isNull65) {
/* 333 */         agg_value66 = (int) agg_value67;
/* 334 */       }
/* 335 */
/* 336 */       boolean agg_value65 = false;
/* 337 */       agg_value65 = agg_value66 == 0;
/* 338 */       if (!false && agg_value65) {
/* 339 */         agg_isNull62 = agg_isNull26;
/* 340 */         agg_value64 = agg_value28;
/* 341 */       }
/* 342 */
/* 343 */       else {
/* 344 */       }
/* 345 */       agg_holder1.reset();
/* 346 */
/* 347 */       agg_rowWriter1.zeroOutNullBytes();
/* 348 */
/* 349 */       if (agg_isNull29) {
/* 350 */         agg_rowWriter1.setNullAt(0);
/* 351 */       } else {
/* 352 */         agg_rowWriter1.write(0, agg_value31);
/* 353 */       }
/* 354 */
/* 355 */       if (agg_isNull26) {
/* 356 */         agg_rowWriter1.setNullAt(1);
/* 357 */       } else {
/* 358 */         agg_rowWriter1.write(1, agg_value28);
/* 359 */       }
/* 360 */
/* 361 */       if (agg_isNull27) {
/* 362 */         agg_rowWriter1.setNullAt(2);
/* 363 */       } else {
/* 364 */         agg_rowWriter1.write(2, agg_value29);
/* 365 */       }
/* 366 */
/* 367 */       agg_rowWriter1.write(3, agg_value38);
/* 368 */
/* 369 */       agg_rowWriter1.write(4, agg_value51);
/* 370 */
/* 371 */       if (agg_isNull62) {
/* 372 */         agg_rowWriter1.setNullAt(5);
/* 373 */       } else {
/* 374 */         agg_rowWriter1.write(5, agg_value64);
/* 375 */       }
/* 376 */
/* 377 */       if (agg_isNull30) {
/* 378 */         agg_rowWriter1.setNullAt(6);
/* 379 */       } else {
/* 380 */         agg_rowWriter1.write(6, agg_value32);
/* 381 */       }
/* 382 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 383 */       append(agg_result1);
/* 384 */
/* 385 */       if (shouldStop()) return;
/* 386 */     }
/* 387 */
/* 388 */     agg_mapIter.close();
/* 389 */     if (agg_sorter == null) {
/* 390 */       agg_hashMap.free();
/* 391 */     }
/* 392 */   }
/* 393 */ }
