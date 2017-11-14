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
/* 025 */   private int agg_value14;
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
/* 046 */     agg_result = new UnsafeRow(4);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(6);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 6);
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
/* 064 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 071 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 072 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 073 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 074 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 075 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 076 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 077 */
/* 078 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 079 */
/* 080 */       UnsafeRow agg_fastAggBuffer = null;
/* 081 */
/* 082 */       if (agg_fastAggBuffer == null) {
/* 083 */         // generate grouping key
/* 084 */         agg_holder.reset();
/* 085 */
/* 086 */         agg_rowWriter.zeroOutNullBytes();
/* 087 */
/* 088 */         if (inputadapter_isNull) {
/* 089 */           agg_rowWriter.setNullAt(0);
/* 090 */         } else {
/* 091 */           agg_rowWriter.write(0, inputadapter_value);
/* 092 */         }
/* 093 */
/* 094 */         if (inputadapter_isNull1) {
/* 095 */           agg_rowWriter.setNullAt(1);
/* 096 */         } else {
/* 097 */           agg_rowWriter.write(1, inputadapter_value1);
/* 098 */         }
/* 099 */
/* 100 */         if (inputadapter_isNull2) {
/* 101 */           agg_rowWriter.setNullAt(2);
/* 102 */         } else {
/* 103 */           agg_rowWriter.write(2, inputadapter_value2);
/* 104 */         }
/* 105 */
/* 106 */         if (inputadapter_isNull3) {
/* 107 */           agg_rowWriter.setNullAt(3);
/* 108 */         } else {
/* 109 */           agg_rowWriter.write(3, inputadapter_value3);
/* 110 */         }
/* 111 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 112 */         agg_value14 = 42;
/* 113 */
/* 114 */         if (!inputadapter_isNull) {
/* 115 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value14);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull1) {
/* 119 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value14);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull2) {
/* 123 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value14);
/* 124 */         }
/* 125 */
/* 126 */         if (!inputadapter_isNull3) {
/* 127 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value14);
/* 128 */         }
/* 129 */         if (true) {
/* 130 */           // try to get the buffer from hash map
/* 131 */           agg_unsafeRowAggBuffer =
/* 132 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 133 */         }
/* 134 */         if (agg_unsafeRowAggBuffer == null) {
/* 135 */           if (agg_sorter == null) {
/* 136 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 137 */           } else {
/* 138 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 139 */           }
/* 140 */
/* 141 */           // the hash map had be spilled, it should have enough memory now,
/* 142 */           // try  to allocate buffer again.
/* 143 */           agg_unsafeRowAggBuffer =
/* 144 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 145 */           if (agg_unsafeRowAggBuffer == null) {
/* 146 */             // failed to allocate the first page
/* 147 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 148 */           }
/* 149 */         }
/* 150 */       }
/* 151 */
/* 152 */       if (agg_fastAggBuffer != null) {
/* 153 */         // update fast row
/* 154 */
/* 155 */       } else {
/* 156 */         // update unsafe row
/* 157 */
/* 158 */         // common sub-expressions
/* 159 */
/* 160 */         // evaluate aggregate function
/* 161 */         boolean agg_isNull17 = true;
/* 162 */         double agg_value20 = -1.0;
/* 163 */
/* 164 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 165 */         double agg_value22 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 166 */         boolean agg_isNull18 = agg_isNull19;
/* 167 */         double agg_value21 = agg_value22;
/* 168 */         if (agg_isNull18) {
/* 169 */           boolean agg_isNull20 = false;
/* 170 */           double agg_value23 = -1.0;
/* 171 */           if (!false) {
/* 172 */             agg_value23 = (double) 0;
/* 173 */           }
/* 174 */           if (!agg_isNull20) {
/* 175 */             agg_isNull18 = false;
/* 176 */             agg_value21 = agg_value23;
/* 177 */           }
/* 178 */         }
/* 179 */
/* 180 */         if (!inputadapter_isNull4) {
/* 181 */           agg_isNull17 = false; // resultCode could change nullability.
/* 182 */           agg_value20 = agg_value21 + inputadapter_value4;
/* 183 */
/* 184 */         }
/* 185 */         boolean agg_isNull16 = agg_isNull17;
/* 186 */         double agg_value19 = agg_value20;
/* 187 */         if (agg_isNull16) {
/* 188 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 189 */           double agg_value26 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 190 */           if (!agg_isNull23) {
/* 191 */             agg_isNull16 = false;
/* 192 */             agg_value19 = agg_value26;
/* 193 */           }
/* 194 */         }
/* 195 */         boolean agg_isNull25 = true;
/* 196 */         double agg_value28 = -1.0;
/* 197 */
/* 198 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 199 */         double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 200 */         boolean agg_isNull26 = agg_isNull27;
/* 201 */         double agg_value29 = agg_value30;
/* 202 */         if (agg_isNull26) {
/* 203 */           boolean agg_isNull28 = false;
/* 204 */           double agg_value31 = -1.0;
/* 205 */           if (!false) {
/* 206 */             agg_value31 = (double) 0;
/* 207 */           }
/* 208 */           if (!agg_isNull28) {
/* 209 */             agg_isNull26 = false;
/* 210 */             agg_value29 = agg_value31;
/* 211 */           }
/* 212 */         }
/* 213 */
/* 214 */         if (!inputadapter_isNull5) {
/* 215 */           agg_isNull25 = false; // resultCode could change nullability.
/* 216 */           agg_value28 = agg_value29 + inputadapter_value5;
/* 217 */
/* 218 */         }
/* 219 */         boolean agg_isNull24 = agg_isNull25;
/* 220 */         double agg_value27 = agg_value28;
/* 221 */         if (agg_isNull24) {
/* 222 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 223 */           double agg_value34 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 224 */           if (!agg_isNull31) {
/* 225 */             agg_isNull24 = false;
/* 226 */             agg_value27 = agg_value34;
/* 227 */           }
/* 228 */         }
/* 229 */         boolean agg_isNull33 = true;
/* 230 */         double agg_value36 = -1.0;
/* 231 */
/* 232 */         boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 233 */         double agg_value38 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 234 */         boolean agg_isNull34 = agg_isNull35;
/* 235 */         double agg_value37 = agg_value38;
/* 236 */         if (agg_isNull34) {
/* 237 */           boolean agg_isNull36 = false;
/* 238 */           double agg_value39 = -1.0;
/* 239 */           if (!false) {
/* 240 */             agg_value39 = (double) 0;
/* 241 */           }
/* 242 */           if (!agg_isNull36) {
/* 243 */             agg_isNull34 = false;
/* 244 */             agg_value37 = agg_value39;
/* 245 */           }
/* 246 */         }
/* 247 */
/* 248 */         if (!inputadapter_isNull6) {
/* 249 */           agg_isNull33 = false; // resultCode could change nullability.
/* 250 */           agg_value36 = agg_value37 + inputadapter_value6;
/* 251 */
/* 252 */         }
/* 253 */         boolean agg_isNull32 = agg_isNull33;
/* 254 */         double agg_value35 = agg_value36;
/* 255 */         if (agg_isNull32) {
/* 256 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 257 */           double agg_value42 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 258 */           if (!agg_isNull39) {
/* 259 */             agg_isNull32 = false;
/* 260 */             agg_value35 = agg_value42;
/* 261 */           }
/* 262 */         }
/* 263 */         // update unsafe row buffer
/* 264 */         if (!agg_isNull16) {
/* 265 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value19);
/* 266 */         } else {
/* 267 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 268 */         }
/* 269 */
/* 270 */         if (!agg_isNull24) {
/* 271 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value27);
/* 272 */         } else {
/* 273 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 274 */         }
/* 275 */
/* 276 */         if (!agg_isNull32) {
/* 277 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value35);
/* 278 */         } else {
/* 279 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 280 */         }
/* 281 */
/* 282 */       }
/* 283 */       if (shouldStop()) return;
/* 284 */     }
/* 285 */
/* 286 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 287 */   }
/* 288 */
/* 289 */   protected void processNext() throws java.io.IOException {
/* 290 */     if (!agg_initAgg) {
/* 291 */       agg_initAgg = true;
/* 292 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 293 */       agg_doAggregateWithKeys();
/* 294 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 295 */     }
/* 296 */
/* 297 */     // output the result
/* 298 */
/* 299 */     while (agg_mapIter.next()) {
/* 300 */       wholestagecodegen_numOutputRows.add(1);
/* 301 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 302 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 303 */
/* 304 */       boolean agg_isNull40 = agg_aggKey.isNullAt(0);
/* 305 */       int agg_value43 = agg_isNull40 ? -1 : (agg_aggKey.getInt(0));
/* 306 */       boolean agg_isNull41 = agg_aggKey.isNullAt(1);
/* 307 */       int agg_value44 = agg_isNull41 ? -1 : (agg_aggKey.getInt(1));
/* 308 */       boolean agg_isNull42 = agg_aggKey.isNullAt(2);
/* 309 */       int agg_value45 = agg_isNull42 ? -1 : (agg_aggKey.getInt(2));
/* 310 */       boolean agg_isNull43 = agg_aggKey.isNullAt(3);
/* 311 */       UTF8String agg_value46 = agg_isNull43 ? null : (agg_aggKey.getUTF8String(3));
/* 312 */       boolean agg_isNull44 = agg_aggBuffer.isNullAt(0);
/* 313 */       double agg_value47 = agg_isNull44 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 314 */       boolean agg_isNull45 = agg_aggBuffer.isNullAt(1);
/* 315 */       double agg_value48 = agg_isNull45 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 316 */       boolean agg_isNull46 = agg_aggBuffer.isNullAt(2);
/* 317 */       double agg_value49 = agg_isNull46 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 318 */
/* 319 */       agg_holder1.reset();
/* 320 */
/* 321 */       agg_rowWriter1.zeroOutNullBytes();
/* 322 */
/* 323 */       if (agg_isNull40) {
/* 324 */         agg_rowWriter1.setNullAt(0);
/* 325 */       } else {
/* 326 */         agg_rowWriter1.write(0, agg_value43);
/* 327 */       }
/* 328 */
/* 329 */       if (agg_isNull41) {
/* 330 */         agg_rowWriter1.setNullAt(1);
/* 331 */       } else {
/* 332 */         agg_rowWriter1.write(1, agg_value44);
/* 333 */       }
/* 334 */
/* 335 */       if (agg_isNull43) {
/* 336 */         agg_rowWriter1.setNullAt(2);
/* 337 */       } else {
/* 338 */         agg_rowWriter1.write(2, agg_value46);
/* 339 */       }
/* 340 */
/* 341 */       if (agg_isNull44) {
/* 342 */         agg_rowWriter1.setNullAt(3);
/* 343 */       } else {
/* 344 */         agg_rowWriter1.write(3, agg_value47);
/* 345 */       }
/* 346 */
/* 347 */       if (agg_isNull45) {
/* 348 */         agg_rowWriter1.setNullAt(4);
/* 349 */       } else {
/* 350 */         agg_rowWriter1.write(4, agg_value48);
/* 351 */       }
/* 352 */
/* 353 */       if (agg_isNull46) {
/* 354 */         agg_rowWriter1.setNullAt(5);
/* 355 */       } else {
/* 356 */         agg_rowWriter1.write(5, agg_value49);
/* 357 */       }
/* 358 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 359 */       append(agg_result1);
/* 360 */
/* 361 */       if (shouldStop()) return;
/* 362 */     }
/* 363 */
/* 364 */     agg_mapIter.close();
/* 365 */     if (agg_sorter == null) {
/* 366 */       agg_hashMap.free();
/* 367 */     }
/* 368 */   }
/* 369 */ }
