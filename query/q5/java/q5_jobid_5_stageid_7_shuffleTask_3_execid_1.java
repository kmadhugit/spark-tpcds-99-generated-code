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
/* 063 */     while (inputadapter_input.hasNext()) {
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
/* 127 */         boolean agg_isNull8 = false;
/* 128 */         double agg_value12 = -1.0;
/* 129 */         if (!false) {
/* 130 */           agg_value12 = (double) 0;
/* 131 */         }
/* 132 */         // evaluate aggregate function
/* 133 */         boolean agg_isNull11 = true;
/* 134 */         double agg_value15 = -1.0;
/* 135 */
/* 136 */         boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 137 */         double agg_value17 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 138 */         boolean agg_isNull12 = agg_isNull13;
/* 139 */         double agg_value16 = agg_value17;
/* 140 */         if (agg_isNull12) {
/* 141 */           if (!agg_isNull8) {
/* 142 */             agg_isNull12 = false;
/* 143 */             agg_value16 = agg_value12;
/* 144 */           }
/* 145 */         }
/* 146 */
/* 147 */         if (!inputadapter_isNull1) {
/* 148 */           agg_isNull11 = false; // resultCode could change nullability.
/* 149 */           agg_value15 = agg_value16 + inputadapter_value1;
/* 150 */
/* 151 */         }
/* 152 */         boolean agg_isNull10 = agg_isNull11;
/* 153 */         double agg_value14 = agg_value15;
/* 154 */         if (agg_isNull10) {
/* 155 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 156 */           double agg_value19 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 157 */           if (!agg_isNull15) {
/* 158 */             agg_isNull10 = false;
/* 159 */             agg_value14 = agg_value19;
/* 160 */           }
/* 161 */         }
/* 162 */         boolean agg_isNull17 = true;
/* 163 */         double agg_value21 = -1.0;
/* 164 */
/* 165 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 166 */         double agg_value23 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 167 */         boolean agg_isNull18 = agg_isNull19;
/* 168 */         double agg_value22 = agg_value23;
/* 169 */         if (agg_isNull18) {
/* 170 */           if (!agg_isNull8) {
/* 171 */             agg_isNull18 = false;
/* 172 */             agg_value22 = agg_value12;
/* 173 */           }
/* 174 */         }
/* 175 */
/* 176 */         if (!inputadapter_isNull2) {
/* 177 */           agg_isNull17 = false; // resultCode could change nullability.
/* 178 */           agg_value21 = agg_value22 + inputadapter_value2;
/* 179 */
/* 180 */         }
/* 181 */         boolean agg_isNull16 = agg_isNull17;
/* 182 */         double agg_value20 = agg_value21;
/* 183 */         if (agg_isNull16) {
/* 184 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 185 */           double agg_value25 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 186 */           if (!agg_isNull21) {
/* 187 */             agg_isNull16 = false;
/* 188 */             agg_value20 = agg_value25;
/* 189 */           }
/* 190 */         }
/* 191 */         boolean agg_isNull23 = true;
/* 192 */         double agg_value27 = -1.0;
/* 193 */
/* 194 */         boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 195 */         double agg_value29 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 196 */         boolean agg_isNull24 = agg_isNull25;
/* 197 */         double agg_value28 = agg_value29;
/* 198 */         if (agg_isNull24) {
/* 199 */           if (!agg_isNull8) {
/* 200 */             agg_isNull24 = false;
/* 201 */             agg_value28 = agg_value12;
/* 202 */           }
/* 203 */         }
/* 204 */
/* 205 */         if (!inputadapter_isNull3) {
/* 206 */           agg_isNull23 = false; // resultCode could change nullability.
/* 207 */           agg_value27 = agg_value28 + inputadapter_value3;
/* 208 */
/* 209 */         }
/* 210 */         boolean agg_isNull22 = agg_isNull23;
/* 211 */         double agg_value26 = agg_value27;
/* 212 */         if (agg_isNull22) {
/* 213 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 214 */           double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 215 */           if (!agg_isNull27) {
/* 216 */             agg_isNull22 = false;
/* 217 */             agg_value26 = agg_value31;
/* 218 */           }
/* 219 */         }
/* 220 */         boolean agg_isNull29 = true;
/* 221 */         double agg_value33 = -1.0;
/* 222 */
/* 223 */         boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 224 */         double agg_value35 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 225 */         boolean agg_isNull30 = agg_isNull31;
/* 226 */         double agg_value34 = agg_value35;
/* 227 */         if (agg_isNull30) {
/* 228 */           if (!agg_isNull8) {
/* 229 */             agg_isNull30 = false;
/* 230 */             agg_value34 = agg_value12;
/* 231 */           }
/* 232 */         }
/* 233 */
/* 234 */         if (!inputadapter_isNull4) {
/* 235 */           agg_isNull29 = false; // resultCode could change nullability.
/* 236 */           agg_value33 = agg_value34 + inputadapter_value4;
/* 237 */
/* 238 */         }
/* 239 */         boolean agg_isNull28 = agg_isNull29;
/* 240 */         double agg_value32 = agg_value33;
/* 241 */         if (agg_isNull28) {
/* 242 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 243 */           double agg_value37 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 244 */           if (!agg_isNull33) {
/* 245 */             agg_isNull28 = false;
/* 246 */             agg_value32 = agg_value37;
/* 247 */           }
/* 248 */         }
/* 249 */         // update unsafe row buffer
/* 250 */         if (!agg_isNull10) {
/* 251 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value14);
/* 252 */         } else {
/* 253 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 254 */         }
/* 255 */
/* 256 */         if (!agg_isNull16) {
/* 257 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value20);
/* 258 */         } else {
/* 259 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 260 */         }
/* 261 */
/* 262 */         if (!agg_isNull22) {
/* 263 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value26);
/* 264 */         } else {
/* 265 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 266 */         }
/* 267 */
/* 268 */         if (!agg_isNull28) {
/* 269 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value32);
/* 270 */         } else {
/* 271 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 272 */         }
/* 273 */
/* 274 */       }
/* 275 */       if (shouldStop()) return;
/* 276 */     }
/* 277 */
/* 278 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 279 */   }
/* 280 */
/* 281 */   protected void processNext() throws java.io.IOException {
/* 282 */     if (!agg_initAgg) {
/* 283 */       agg_initAgg = true;
/* 284 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 285 */       agg_doAggregateWithKeys();
/* 286 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 287 */     }
/* 288 */
/* 289 */     // output the result
/* 290 */
/* 291 */     while (agg_mapIter.next()) {
/* 292 */       wholestagecodegen_numOutputRows.add(1);
/* 293 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 294 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 295 */
/* 296 */       boolean agg_isNull34 = agg_aggKey.isNullAt(0);
/* 297 */       UTF8String agg_value38 = agg_isNull34 ? null : (agg_aggKey.getUTF8String(0));
/* 298 */       boolean agg_isNull35 = agg_aggBuffer.isNullAt(0);
/* 299 */       double agg_value39 = agg_isNull35 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 300 */       boolean agg_isNull36 = agg_aggBuffer.isNullAt(1);
/* 301 */       double agg_value40 = agg_isNull36 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 302 */       boolean agg_isNull37 = agg_aggBuffer.isNullAt(2);
/* 303 */       double agg_value41 = agg_isNull37 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 304 */       boolean agg_isNull38 = agg_aggBuffer.isNullAt(3);
/* 305 */       double agg_value42 = agg_isNull38 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 306 */
/* 307 */       boolean agg_isNull45 = true;
/* 308 */       double agg_value49 = -1.0;
/* 309 */
/* 310 */       if (!agg_isNull37) {
/* 311 */         if (!agg_isNull38) {
/* 312 */           agg_isNull45 = false; // resultCode could change nullability.
/* 313 */           agg_value49 = agg_value41 - agg_value42;
/* 314 */
/* 315 */         }
/* 316 */
/* 317 */       }
/* 318 */       Object agg_obj = ((Expression) references[3]).eval(null);
/* 319 */       UTF8String agg_value52 = (UTF8String) agg_obj;
/* 320 */       Object agg_obj1 = ((Expression) references[4]).eval(null);
/* 321 */       UTF8String agg_value54 = (UTF8String) agg_obj1;
/* 322 */
/* 323 */       boolean agg_isNull49 = false;
/* 324 */       UTF8String agg_value53 = UTF8String.concat(false ? null : agg_value54, agg_isNull34 ? null : agg_value38);
/* 325 */       if (agg_value53 == null) {
/* 326 */         agg_isNull49 = true;
/* 327 */       }
/* 328 */       agg_holder1.reset();
/* 329 */
/* 330 */       agg_rowWriter1.zeroOutNullBytes();
/* 331 */
/* 332 */       if (agg_isNull35) {
/* 333 */         agg_rowWriter1.setNullAt(0);
/* 334 */       } else {
/* 335 */         agg_rowWriter1.write(0, agg_value39);
/* 336 */       }
/* 337 */
/* 338 */       if (agg_isNull36) {
/* 339 */         agg_rowWriter1.setNullAt(1);
/* 340 */       } else {
/* 341 */         agg_rowWriter1.write(1, agg_value40);
/* 342 */       }
/* 343 */
/* 344 */       if (agg_isNull45) {
/* 345 */         agg_rowWriter1.setNullAt(2);
/* 346 */       } else {
/* 347 */         agg_rowWriter1.write(2, agg_value49);
/* 348 */       }
/* 349 */
/* 350 */       agg_rowWriter1.write(3, agg_value52);
/* 351 */
/* 352 */       if (agg_isNull49) {
/* 353 */         agg_rowWriter1.setNullAt(4);
/* 354 */       } else {
/* 355 */         agg_rowWriter1.write(4, agg_value53);
/* 356 */       }
/* 357 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 358 */       append(agg_result1);
/* 359 */
/* 360 */       if (shouldStop()) return;
/* 361 */     }
/* 362 */
/* 363 */     agg_mapIter.close();
/* 364 */     if (agg_sorter == null) {
/* 365 */       agg_hashMap.free();
/* 366 */     }
/* 367 */   }
/* 368 */ }
