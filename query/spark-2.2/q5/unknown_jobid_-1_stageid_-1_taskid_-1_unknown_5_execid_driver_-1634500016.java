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
/* 016 */   private double agg_bufValue3;
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private UnsafeRow agg_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 027 */   private int agg_value10;
/* 028 */   private UnsafeRow agg_result1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     agg_initAgg = false;
/* 042 */
/* 043 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 044 */
/* 045 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 047 */     inputadapter_input = inputs[0];
/* 048 */     agg_result = new UnsafeRow(1);
/* 049 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 050 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 051 */
/* 052 */     agg_result1 = new UnsafeRow(5);
/* 053 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 054 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 055 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 056 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 061 */     agg_hashMap = agg_plan.createHashMap();
/* 062 */
/* 063 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 064 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 065 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 066 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 067 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 068 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 069 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 070 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 071 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 072 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 073 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 074 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 075 */
/* 076 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 077 */
/* 078 */       UnsafeRow agg_fastAggBuffer = null;
/* 079 */
/* 080 */       if (agg_fastAggBuffer == null) {
/* 081 */         // generate grouping key
/* 082 */         agg_holder.reset();
/* 083 */
/* 084 */         agg_rowWriter.zeroOutNullBytes();
/* 085 */
/* 086 */         if (inputadapter_isNull) {
/* 087 */           agg_rowWriter.setNullAt(0);
/* 088 */         } else {
/* 089 */           agg_rowWriter.write(0, inputadapter_value);
/* 090 */         }
/* 091 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 092 */         agg_value10 = 42;
/* 093 */
/* 094 */         if (!inputadapter_isNull) {
/* 095 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value10);
/* 096 */         }
/* 097 */         if (true) {
/* 098 */           // try to get the buffer from hash map
/* 099 */           agg_unsafeRowAggBuffer =
/* 100 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 101 */         }
/* 102 */         if (agg_unsafeRowAggBuffer == null) {
/* 103 */           if (agg_sorter == null) {
/* 104 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 105 */           } else {
/* 106 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 107 */           }
/* 108 */
/* 109 */           // the hash map had be spilled, it should have enough memory now,
/* 110 */           // try  to allocate buffer again.
/* 111 */           agg_unsafeRowAggBuffer =
/* 112 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 113 */           if (agg_unsafeRowAggBuffer == null) {
/* 114 */             // failed to allocate the first page
/* 115 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 116 */           }
/* 117 */         }
/* 118 */       }
/* 119 */
/* 120 */       if (agg_fastAggBuffer != null) {
/* 121 */         // update fast row
/* 122 */
/* 123 */       } else {
/* 124 */         // update unsafe row
/* 125 */
/* 126 */         // common sub-expressions
/* 127 */
/* 128 */         // evaluate aggregate function
/* 129 */         boolean agg_isNull9 = true;
/* 130 */         double agg_value13 = -1.0;
/* 131 */
/* 132 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 133 */         double agg_value15 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 134 */         boolean agg_isNull10 = agg_isNull11;
/* 135 */         double agg_value14 = agg_value15;
/* 136 */         if (agg_isNull10) {
/* 137 */           boolean agg_isNull12 = false;
/* 138 */           double agg_value16 = -1.0;
/* 139 */           if (!false) {
/* 140 */             agg_value16 = (double) 0;
/* 141 */           }
/* 142 */           if (!agg_isNull12) {
/* 143 */             agg_isNull10 = false;
/* 144 */             agg_value14 = agg_value16;
/* 145 */           }
/* 146 */         }
/* 147 */
/* 148 */         if (!inputadapter_isNull1) {
/* 149 */           agg_isNull9 = false; // resultCode could change nullability.
/* 150 */           agg_value13 = agg_value14 + inputadapter_value1;
/* 151 */
/* 152 */         }
/* 153 */         boolean agg_isNull8 = agg_isNull9;
/* 154 */         double agg_value12 = agg_value13;
/* 155 */         if (agg_isNull8) {
/* 156 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 157 */           double agg_value19 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 158 */           if (!agg_isNull15) {
/* 159 */             agg_isNull8 = false;
/* 160 */             agg_value12 = agg_value19;
/* 161 */           }
/* 162 */         }
/* 163 */         boolean agg_isNull17 = true;
/* 164 */         double agg_value21 = -1.0;
/* 165 */
/* 166 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 167 */         double agg_value23 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 168 */         boolean agg_isNull18 = agg_isNull19;
/* 169 */         double agg_value22 = agg_value23;
/* 170 */         if (agg_isNull18) {
/* 171 */           boolean agg_isNull20 = false;
/* 172 */           double agg_value24 = -1.0;
/* 173 */           if (!false) {
/* 174 */             agg_value24 = (double) 0;
/* 175 */           }
/* 176 */           if (!agg_isNull20) {
/* 177 */             agg_isNull18 = false;
/* 178 */             agg_value22 = agg_value24;
/* 179 */           }
/* 180 */         }
/* 181 */
/* 182 */         if (!inputadapter_isNull2) {
/* 183 */           agg_isNull17 = false; // resultCode could change nullability.
/* 184 */           agg_value21 = agg_value22 + inputadapter_value2;
/* 185 */
/* 186 */         }
/* 187 */         boolean agg_isNull16 = agg_isNull17;
/* 188 */         double agg_value20 = agg_value21;
/* 189 */         if (agg_isNull16) {
/* 190 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 191 */           double agg_value27 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 192 */           if (!agg_isNull23) {
/* 193 */             agg_isNull16 = false;
/* 194 */             agg_value20 = agg_value27;
/* 195 */           }
/* 196 */         }
/* 197 */         boolean agg_isNull25 = true;
/* 198 */         double agg_value29 = -1.0;
/* 199 */
/* 200 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 201 */         double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 202 */         boolean agg_isNull26 = agg_isNull27;
/* 203 */         double agg_value30 = agg_value31;
/* 204 */         if (agg_isNull26) {
/* 205 */           boolean agg_isNull28 = false;
/* 206 */           double agg_value32 = -1.0;
/* 207 */           if (!false) {
/* 208 */             agg_value32 = (double) 0;
/* 209 */           }
/* 210 */           if (!agg_isNull28) {
/* 211 */             agg_isNull26 = false;
/* 212 */             agg_value30 = agg_value32;
/* 213 */           }
/* 214 */         }
/* 215 */
/* 216 */         if (!inputadapter_isNull3) {
/* 217 */           agg_isNull25 = false; // resultCode could change nullability.
/* 218 */           agg_value29 = agg_value30 + inputadapter_value3;
/* 219 */
/* 220 */         }
/* 221 */         boolean agg_isNull24 = agg_isNull25;
/* 222 */         double agg_value28 = agg_value29;
/* 223 */         if (agg_isNull24) {
/* 224 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 225 */           double agg_value35 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 226 */           if (!agg_isNull31) {
/* 227 */             agg_isNull24 = false;
/* 228 */             agg_value28 = agg_value35;
/* 229 */           }
/* 230 */         }
/* 231 */         boolean agg_isNull33 = true;
/* 232 */         double agg_value37 = -1.0;
/* 233 */
/* 234 */         boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 235 */         double agg_value39 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 236 */         boolean agg_isNull34 = agg_isNull35;
/* 237 */         double agg_value38 = agg_value39;
/* 238 */         if (agg_isNull34) {
/* 239 */           boolean agg_isNull36 = false;
/* 240 */           double agg_value40 = -1.0;
/* 241 */           if (!false) {
/* 242 */             agg_value40 = (double) 0;
/* 243 */           }
/* 244 */           if (!agg_isNull36) {
/* 245 */             agg_isNull34 = false;
/* 246 */             agg_value38 = agg_value40;
/* 247 */           }
/* 248 */         }
/* 249 */
/* 250 */         if (!inputadapter_isNull4) {
/* 251 */           agg_isNull33 = false; // resultCode could change nullability.
/* 252 */           agg_value37 = agg_value38 + inputadapter_value4;
/* 253 */
/* 254 */         }
/* 255 */         boolean agg_isNull32 = agg_isNull33;
/* 256 */         double agg_value36 = agg_value37;
/* 257 */         if (agg_isNull32) {
/* 258 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 259 */           double agg_value43 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 260 */           if (!agg_isNull39) {
/* 261 */             agg_isNull32 = false;
/* 262 */             agg_value36 = agg_value43;
/* 263 */           }
/* 264 */         }
/* 265 */         // update unsafe row buffer
/* 266 */         if (!agg_isNull8) {
/* 267 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 268 */         } else {
/* 269 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 270 */         }
/* 271 */
/* 272 */         if (!agg_isNull16) {
/* 273 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value20);
/* 274 */         } else {
/* 275 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 276 */         }
/* 277 */
/* 278 */         if (!agg_isNull24) {
/* 279 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value28);
/* 280 */         } else {
/* 281 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 282 */         }
/* 283 */
/* 284 */         if (!agg_isNull32) {
/* 285 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value36);
/* 286 */         } else {
/* 287 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 288 */         }
/* 289 */
/* 290 */       }
/* 291 */       if (shouldStop()) return;
/* 292 */     }
/* 293 */
/* 294 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 295 */   }
/* 296 */
/* 297 */   protected void processNext() throws java.io.IOException {
/* 298 */     if (!agg_initAgg) {
/* 299 */       agg_initAgg = true;
/* 300 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 301 */       agg_doAggregateWithKeys();
/* 302 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 303 */     }
/* 304 */
/* 305 */     // output the result
/* 306 */
/* 307 */     while (agg_mapIter.next()) {
/* 308 */       wholestagecodegen_numOutputRows.add(1);
/* 309 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 310 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 311 */
/* 312 */       boolean agg_isNull40 = agg_aggKey.isNullAt(0);
/* 313 */       UTF8String agg_value44 = agg_isNull40 ? null : (agg_aggKey.getUTF8String(0));
/* 314 */       boolean agg_isNull41 = agg_aggBuffer.isNullAt(0);
/* 315 */       double agg_value45 = agg_isNull41 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 316 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(1);
/* 317 */       double agg_value46 = agg_isNull42 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 318 */       boolean agg_isNull43 = agg_aggBuffer.isNullAt(2);
/* 319 */       double agg_value47 = agg_isNull43 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 320 */       boolean agg_isNull44 = agg_aggBuffer.isNullAt(3);
/* 321 */       double agg_value48 = agg_isNull44 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 322 */
/* 323 */       boolean agg_isNull51 = true;
/* 324 */       double agg_value55 = -1.0;
/* 325 */
/* 326 */       if (!agg_isNull43) {
/* 327 */         if (!agg_isNull44) {
/* 328 */           agg_isNull51 = false; // resultCode could change nullability.
/* 329 */           agg_value55 = agg_value47 - agg_value48;
/* 330 */
/* 331 */         }
/* 332 */
/* 333 */       }
/* 334 */       boolean agg_isNull55 = false;
/* 335 */       UTF8String agg_value59 = UTF8String.concat(false ? null : ((UTF8String) references[4]), agg_isNull40 ? null : agg_value44);
/* 336 */       if (agg_value59 == null) {
/* 337 */         agg_isNull55 = true;
/* 338 */       }
/* 339 */       agg_holder1.reset();
/* 340 */
/* 341 */       agg_rowWriter1.zeroOutNullBytes();
/* 342 */
/* 343 */       if (agg_isNull41) {
/* 344 */         agg_rowWriter1.setNullAt(0);
/* 345 */       } else {
/* 346 */         agg_rowWriter1.write(0, agg_value45);
/* 347 */       }
/* 348 */
/* 349 */       if (agg_isNull42) {
/* 350 */         agg_rowWriter1.setNullAt(1);
/* 351 */       } else {
/* 352 */         agg_rowWriter1.write(1, agg_value46);
/* 353 */       }
/* 354 */
/* 355 */       if (agg_isNull51) {
/* 356 */         agg_rowWriter1.setNullAt(2);
/* 357 */       } else {
/* 358 */         agg_rowWriter1.write(2, agg_value55);
/* 359 */       }
/* 360 */
/* 361 */       agg_rowWriter1.write(3, ((UTF8String) references[3]));
/* 362 */
/* 363 */       if (agg_isNull55) {
/* 364 */         agg_rowWriter1.setNullAt(4);
/* 365 */       } else {
/* 366 */         agg_rowWriter1.write(4, agg_value59);
/* 367 */       }
/* 368 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 369 */       append(agg_result1);
/* 370 */
/* 371 */       if (shouldStop()) return;
/* 372 */     }
/* 373 */
/* 374 */     agg_mapIter.close();
/* 375 */     if (agg_sorter == null) {
/* 376 */       agg_hashMap.free();
/* 377 */     }
/* 378 */   }
/* 379 */ }
