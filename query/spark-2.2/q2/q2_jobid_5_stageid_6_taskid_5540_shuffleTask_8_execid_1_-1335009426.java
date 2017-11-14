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
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 024 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 025 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 026 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 029 */   private scala.collection.Iterator inputadapter_input;
/* 030 */   private UnsafeRow agg_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 033 */   private int agg_value16;
/* 034 */   private UnsafeRow agg_result1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 037 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 038 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 040 */   private UnsafeRow bhj_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 043 */   private UnsafeRow project_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 048 */
/* 049 */   public GeneratedIterator(Object[] references) {
/* 050 */     this.references = references;
/* 051 */   }
/* 052 */
/* 053 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 054 */     partitionIndex = index;
/* 055 */     this.inputs = inputs;
/* 056 */     wholestagecodegen_init_0();
/* 057 */     wholestagecodegen_init_1();
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void wholestagecodegen_init_0() {
/* 062 */     agg_initAgg = false;
/* 063 */
/* 064 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 065 */
/* 066 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 067 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 068 */     inputadapter_input = inputs[0];
/* 069 */     agg_result = new UnsafeRow(1);
/* 070 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 071 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 072 */
/* 073 */     agg_result1 = new UnsafeRow(8);
/* 074 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 075 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 8);
/* 076 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 077 */
/* 078 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 079 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 084 */     agg_hashMap = agg_plan.createHashMap();
/* 085 */
/* 086 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 087 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 088 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 089 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 090 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 091 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 092 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 093 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 094 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 095 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 096 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 097 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 098 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 099 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 100 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 101 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 102 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 103 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 104 */
/* 105 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 106 */
/* 107 */       UnsafeRow agg_fastAggBuffer = null;
/* 108 */
/* 109 */       if (agg_fastAggBuffer == null) {
/* 110 */         // generate grouping key
/* 111 */         agg_rowWriter.zeroOutNullBytes();
/* 112 */
/* 113 */         if (inputadapter_isNull) {
/* 114 */           agg_rowWriter.setNullAt(0);
/* 115 */         } else {
/* 116 */           agg_rowWriter.write(0, inputadapter_value);
/* 117 */         }
/* 118 */         agg_value16 = 42;
/* 119 */
/* 120 */         if (!inputadapter_isNull) {
/* 121 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value16);
/* 122 */         }
/* 123 */         if (true) {
/* 124 */           // try to get the buffer from hash map
/* 125 */           agg_unsafeRowAggBuffer =
/* 126 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 127 */         }
/* 128 */         if (agg_unsafeRowAggBuffer == null) {
/* 129 */           if (agg_sorter == null) {
/* 130 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 131 */           } else {
/* 132 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 133 */           }
/* 134 */
/* 135 */           // the hash map had be spilled, it should have enough memory now,
/* 136 */           // try  to allocate buffer again.
/* 137 */           agg_unsafeRowAggBuffer =
/* 138 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 139 */           if (agg_unsafeRowAggBuffer == null) {
/* 140 */             // failed to allocate the first page
/* 141 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 142 */           }
/* 143 */         }
/* 144 */       }
/* 145 */
/* 146 */       if (agg_fastAggBuffer != null) {
/* 147 */         // update fast row
/* 148 */
/* 149 */       } else {
/* 150 */         // update unsafe row
/* 151 */
/* 152 */         // common sub-expressions
/* 153 */
/* 154 */         // evaluate aggregate function
/* 155 */         boolean agg_isNull12 = true;
/* 156 */         double agg_value19 = -1.0;
/* 157 */
/* 158 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 159 */         double agg_value21 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 160 */         boolean agg_isNull13 = agg_isNull14;
/* 161 */         double agg_value20 = agg_value21;
/* 162 */         if (agg_isNull13) {
/* 163 */           boolean agg_isNull15 = false;
/* 164 */           double agg_value22 = -1.0;
/* 165 */           if (!false) {
/* 166 */             agg_value22 = (double) 0;
/* 167 */           }
/* 168 */           if (!agg_isNull15) {
/* 169 */             agg_isNull13 = false;
/* 170 */             agg_value20 = agg_value22;
/* 171 */           }
/* 172 */         }
/* 173 */
/* 174 */         if (!inputadapter_isNull1) {
/* 175 */           agg_isNull12 = false; // resultCode could change nullability.
/* 176 */           agg_value19 = agg_value20 + inputadapter_value1;
/* 177 */
/* 178 */         }
/* 179 */         boolean agg_isNull11 = agg_isNull12;
/* 180 */         double agg_value18 = agg_value19;
/* 181 */         if (agg_isNull11) {
/* 182 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 183 */           double agg_value25 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 184 */           if (!agg_isNull18) {
/* 185 */             agg_isNull11 = false;
/* 186 */             agg_value18 = agg_value25;
/* 187 */           }
/* 188 */         }
/* 189 */         boolean agg_isNull20 = true;
/* 190 */         double agg_value27 = -1.0;
/* 191 */
/* 192 */         boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 193 */         double agg_value29 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 194 */         boolean agg_isNull21 = agg_isNull22;
/* 195 */         double agg_value28 = agg_value29;
/* 196 */         if (agg_isNull21) {
/* 197 */           boolean agg_isNull23 = false;
/* 198 */           double agg_value30 = -1.0;
/* 199 */           if (!false) {
/* 200 */             agg_value30 = (double) 0;
/* 201 */           }
/* 202 */           if (!agg_isNull23) {
/* 203 */             agg_isNull21 = false;
/* 204 */             agg_value28 = agg_value30;
/* 205 */           }
/* 206 */         }
/* 207 */
/* 208 */         if (!inputadapter_isNull2) {
/* 209 */           agg_isNull20 = false; // resultCode could change nullability.
/* 210 */           agg_value27 = agg_value28 + inputadapter_value2;
/* 211 */
/* 212 */         }
/* 213 */         boolean agg_isNull19 = agg_isNull20;
/* 214 */         double agg_value26 = agg_value27;
/* 215 */         if (agg_isNull19) {
/* 216 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 217 */           double agg_value33 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 218 */           if (!agg_isNull26) {
/* 219 */             agg_isNull19 = false;
/* 220 */             agg_value26 = agg_value33;
/* 221 */           }
/* 222 */         }
/* 223 */         boolean agg_isNull28 = true;
/* 224 */         double agg_value35 = -1.0;
/* 225 */
/* 226 */         boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 227 */         double agg_value37 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 228 */         boolean agg_isNull29 = agg_isNull30;
/* 229 */         double agg_value36 = agg_value37;
/* 230 */         if (agg_isNull29) {
/* 231 */           boolean agg_isNull31 = false;
/* 232 */           double agg_value38 = -1.0;
/* 233 */           if (!false) {
/* 234 */             agg_value38 = (double) 0;
/* 235 */           }
/* 236 */           if (!agg_isNull31) {
/* 237 */             agg_isNull29 = false;
/* 238 */             agg_value36 = agg_value38;
/* 239 */           }
/* 240 */         }
/* 241 */
/* 242 */         if (!inputadapter_isNull3) {
/* 243 */           agg_isNull28 = false; // resultCode could change nullability.
/* 244 */           agg_value35 = agg_value36 + inputadapter_value3;
/* 245 */
/* 246 */         }
/* 247 */         boolean agg_isNull27 = agg_isNull28;
/* 248 */         double agg_value34 = agg_value35;
/* 249 */         if (agg_isNull27) {
/* 250 */           boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 251 */           double agg_value41 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 252 */           if (!agg_isNull34) {
/* 253 */             agg_isNull27 = false;
/* 254 */             agg_value34 = agg_value41;
/* 255 */           }
/* 256 */         }
/* 257 */         boolean agg_isNull36 = true;
/* 258 */         double agg_value43 = -1.0;
/* 259 */
/* 260 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 261 */         double agg_value45 = agg_isNull38 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 262 */         boolean agg_isNull37 = agg_isNull38;
/* 263 */         double agg_value44 = agg_value45;
/* 264 */         if (agg_isNull37) {
/* 265 */           boolean agg_isNull39 = false;
/* 266 */           double agg_value46 = -1.0;
/* 267 */           if (!false) {
/* 268 */             agg_value46 = (double) 0;
/* 269 */           }
/* 270 */           if (!agg_isNull39) {
/* 271 */             agg_isNull37 = false;
/* 272 */             agg_value44 = agg_value46;
/* 273 */           }
/* 274 */         }
/* 275 */
/* 276 */         if (!inputadapter_isNull4) {
/* 277 */           agg_isNull36 = false; // resultCode could change nullability.
/* 278 */           agg_value43 = agg_value44 + inputadapter_value4;
/* 279 */
/* 280 */         }
/* 281 */         boolean agg_isNull35 = agg_isNull36;
/* 282 */         double agg_value42 = agg_value43;
/* 283 */         if (agg_isNull35) {
/* 284 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 285 */           double agg_value49 = agg_isNull42 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 286 */           if (!agg_isNull42) {
/* 287 */             agg_isNull35 = false;
/* 288 */             agg_value42 = agg_value49;
/* 289 */           }
/* 290 */         }
/* 291 */         boolean agg_isNull44 = true;
/* 292 */         double agg_value51 = -1.0;
/* 293 */
/* 294 */         boolean agg_isNull46 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 295 */         double agg_value53 = agg_isNull46 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 296 */         boolean agg_isNull45 = agg_isNull46;
/* 297 */         double agg_value52 = agg_value53;
/* 298 */         if (agg_isNull45) {
/* 299 */           boolean agg_isNull47 = false;
/* 300 */           double agg_value54 = -1.0;
/* 301 */           if (!false) {
/* 302 */             agg_value54 = (double) 0;
/* 303 */           }
/* 304 */           if (!agg_isNull47) {
/* 305 */             agg_isNull45 = false;
/* 306 */             agg_value52 = agg_value54;
/* 307 */           }
/* 308 */         }
/* 309 */
/* 310 */         if (!inputadapter_isNull5) {
/* 311 */           agg_isNull44 = false; // resultCode could change nullability.
/* 312 */           agg_value51 = agg_value52 + inputadapter_value5;
/* 313 */
/* 314 */         }
/* 315 */         boolean agg_isNull43 = agg_isNull44;
/* 316 */         double agg_value50 = agg_value51;
/* 317 */         if (agg_isNull43) {
/* 318 */           boolean agg_isNull50 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 319 */           double agg_value57 = agg_isNull50 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 320 */           if (!agg_isNull50) {
/* 321 */             agg_isNull43 = false;
/* 322 */             agg_value50 = agg_value57;
/* 323 */           }
/* 324 */         }
/* 325 */         boolean agg_isNull52 = true;
/* 326 */         double agg_value59 = -1.0;
/* 327 */
/* 328 */         boolean agg_isNull54 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 329 */         double agg_value61 = agg_isNull54 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 330 */         boolean agg_isNull53 = agg_isNull54;
/* 331 */         double agg_value60 = agg_value61;
/* 332 */         if (agg_isNull53) {
/* 333 */           boolean agg_isNull55 = false;
/* 334 */           double agg_value62 = -1.0;
/* 335 */           if (!false) {
/* 336 */             agg_value62 = (double) 0;
/* 337 */           }
/* 338 */           if (!agg_isNull55) {
/* 339 */             agg_isNull53 = false;
/* 340 */             agg_value60 = agg_value62;
/* 341 */           }
/* 342 */         }
/* 343 */
/* 344 */         if (!inputadapter_isNull6) {
/* 345 */           agg_isNull52 = false; // resultCode could change nullability.
/* 346 */           agg_value59 = agg_value60 + inputadapter_value6;
/* 347 */
/* 348 */         }
/* 349 */         boolean agg_isNull51 = agg_isNull52;
/* 350 */         double agg_value58 = agg_value59;
/* 351 */         if (agg_isNull51) {
/* 352 */           boolean agg_isNull58 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 353 */           double agg_value65 = agg_isNull58 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 354 */           if (!agg_isNull58) {
/* 355 */             agg_isNull51 = false;
/* 356 */             agg_value58 = agg_value65;
/* 357 */           }
/* 358 */         }
/* 359 */         boolean agg_isNull60 = true;
/* 360 */         double agg_value67 = -1.0;
/* 361 */
/* 362 */         boolean agg_isNull62 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 363 */         double agg_value69 = agg_isNull62 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 364 */         boolean agg_isNull61 = agg_isNull62;
/* 365 */         double agg_value68 = agg_value69;
/* 366 */         if (agg_isNull61) {
/* 367 */           boolean agg_isNull63 = false;
/* 368 */           double agg_value70 = -1.0;
/* 369 */           if (!false) {
/* 370 */             agg_value70 = (double) 0;
/* 371 */           }
/* 372 */           if (!agg_isNull63) {
/* 373 */             agg_isNull61 = false;
/* 374 */             agg_value68 = agg_value70;
/* 375 */           }
/* 376 */         }
/* 377 */
/* 378 */         if (!inputadapter_isNull7) {
/* 379 */           agg_isNull60 = false; // resultCode could change nullability.
/* 380 */           agg_value67 = agg_value68 + inputadapter_value7;
/* 381 */
/* 382 */         }
/* 383 */         boolean agg_isNull59 = agg_isNull60;
/* 384 */         double agg_value66 = agg_value67;
/* 385 */         if (agg_isNull59) {
/* 386 */           boolean agg_isNull66 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 387 */           double agg_value73 = agg_isNull66 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 388 */           if (!agg_isNull66) {
/* 389 */             agg_isNull59 = false;
/* 390 */             agg_value66 = agg_value73;
/* 391 */           }
/* 392 */         }
/* 393 */         // update unsafe row buffer
/* 394 */         if (!agg_isNull11) {
/* 395 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 396 */         } else {
/* 397 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 398 */         }
/* 399 */
/* 400 */         if (!agg_isNull19) {
/* 401 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value26);
/* 402 */         } else {
/* 403 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 404 */         }
/* 405 */
/* 406 */         if (!agg_isNull27) {
/* 407 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value34);
/* 408 */         } else {
/* 409 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 410 */         }
/* 411 */
/* 412 */         if (!agg_isNull35) {
/* 413 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value42);
/* 414 */         } else {
/* 415 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 416 */         }
/* 417 */
/* 418 */         if (!agg_isNull43) {
/* 419 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value50);
/* 420 */         } else {
/* 421 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 422 */         }
/* 423 */
/* 424 */         if (!agg_isNull51) {
/* 425 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value58);
/* 426 */         } else {
/* 427 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 428 */         }
/* 429 */
/* 430 */         if (!agg_isNull59) {
/* 431 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value66);
/* 432 */         } else {
/* 433 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 434 */         }
/* 435 */
/* 436 */       }
/* 437 */       if (shouldStop()) return;
/* 438 */     }
/* 439 */
/* 440 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 441 */   }
/* 442 */
/* 443 */   private void wholestagecodegen_init_1() {
/* 444 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 445 */     bhj_result = new UnsafeRow(9);
/* 446 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 447 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 448 */     project_result = new UnsafeRow(8);
/* 449 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 450 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 451 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 452 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 453 */
/* 454 */   }
/* 455 */
/* 456 */   protected void processNext() throws java.io.IOException {
/* 457 */     if (!agg_initAgg) {
/* 458 */       agg_initAgg = true;
/* 459 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 460 */       agg_doAggregateWithKeys();
/* 461 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 462 */     }
/* 463 */
/* 464 */     // output the result
/* 465 */
/* 466 */     while (agg_mapIter.next()) {
/* 467 */       wholestagecodegen_numOutputRows.add(1);
/* 468 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 469 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 470 */
/* 471 */       boolean agg_isNull67 = agg_aggKey.isNullAt(0);
/* 472 */       int agg_value74 = agg_isNull67 ? -1 : (agg_aggKey.getInt(0));
/* 473 */       boolean agg_isNull68 = agg_aggBuffer.isNullAt(0);
/* 474 */       double agg_value75 = agg_isNull68 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 475 */       boolean agg_isNull69 = agg_aggBuffer.isNullAt(1);
/* 476 */       double agg_value76 = agg_isNull69 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 477 */       boolean agg_isNull70 = agg_aggBuffer.isNullAt(2);
/* 478 */       double agg_value77 = agg_isNull70 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 479 */       boolean agg_isNull71 = agg_aggBuffer.isNullAt(3);
/* 480 */       double agg_value78 = agg_isNull71 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 481 */       boolean agg_isNull72 = agg_aggBuffer.isNullAt(4);
/* 482 */       double agg_value79 = agg_isNull72 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 483 */       boolean agg_isNull73 = agg_aggBuffer.isNullAt(5);
/* 484 */       double agg_value80 = agg_isNull73 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 485 */       boolean agg_isNull74 = agg_aggBuffer.isNullAt(6);
/* 486 */       double agg_value81 = agg_isNull74 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 487 */
/* 488 */       // generate join key for stream side
/* 489 */
/* 490 */       boolean bhj_isNull = agg_isNull67;
/* 491 */       long bhj_value = -1L;
/* 492 */       if (!agg_isNull67) {
/* 493 */         bhj_value = (long) agg_value74;
/* 494 */       }
/* 495 */       // find matches from HashRelation
/* 496 */       scala.collection.Iterator bhj_matches = bhj_isNull ? null : (scala.collection.Iterator)bhj_relation.get(bhj_value);
/* 497 */       if (bhj_matches == null) continue;
/* 498 */       while (bhj_matches.hasNext()) {
/* 499 */         UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 500 */
/* 501 */         bhj_numOutputRows.add(1);
/* 502 */
/* 503 */         project_rowWriter.zeroOutNullBytes();
/* 504 */
/* 505 */         if (agg_isNull67) {
/* 506 */           project_rowWriter.setNullAt(0);
/* 507 */         } else {
/* 508 */           project_rowWriter.write(0, agg_value74);
/* 509 */         }
/* 510 */
/* 511 */         if (agg_isNull68) {
/* 512 */           project_rowWriter.setNullAt(1);
/* 513 */         } else {
/* 514 */           project_rowWriter.write(1, agg_value75);
/* 515 */         }
/* 516 */
/* 517 */         if (agg_isNull69) {
/* 518 */           project_rowWriter.setNullAt(2);
/* 519 */         } else {
/* 520 */           project_rowWriter.write(2, agg_value76);
/* 521 */         }
/* 522 */
/* 523 */         if (agg_isNull70) {
/* 524 */           project_rowWriter.setNullAt(3);
/* 525 */         } else {
/* 526 */           project_rowWriter.write(3, agg_value77);
/* 527 */         }
/* 528 */
/* 529 */         if (agg_isNull71) {
/* 530 */           project_rowWriter.setNullAt(4);
/* 531 */         } else {
/* 532 */           project_rowWriter.write(4, agg_value78);
/* 533 */         }
/* 534 */
/* 535 */         if (agg_isNull72) {
/* 536 */           project_rowWriter.setNullAt(5);
/* 537 */         } else {
/* 538 */           project_rowWriter.write(5, agg_value79);
/* 539 */         }
/* 540 */
/* 541 */         if (agg_isNull73) {
/* 542 */           project_rowWriter.setNullAt(6);
/* 543 */         } else {
/* 544 */           project_rowWriter.write(6, agg_value80);
/* 545 */         }
/* 546 */
/* 547 */         if (agg_isNull74) {
/* 548 */           project_rowWriter.setNullAt(7);
/* 549 */         } else {
/* 550 */           project_rowWriter.write(7, agg_value81);
/* 551 */         }
/* 552 */         append(project_result.copy());
/* 553 */
/* 554 */       }
/* 555 */
/* 556 */       if (shouldStop()) return;
/* 557 */     }
/* 558 */
/* 559 */     agg_mapIter.close();
/* 560 */     if (agg_sorter == null) {
/* 561 */       agg_hashMap.free();
/* 562 */     }
/* 563 */   }
/* 564 */ }
