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
/* 033 */   private int agg_value18;
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
/* 046 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 047 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 049 */   private UnsafeRow bhj_result1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 052 */   private UnsafeRow project_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 055 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 057 */
/* 058 */   public GeneratedIterator(Object[] references) {
/* 059 */     this.references = references;
/* 060 */   }
/* 061 */
/* 062 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 063 */     partitionIndex = index;
/* 064 */     this.inputs = inputs;
/* 065 */     wholestagecodegen_init_0();
/* 066 */     wholestagecodegen_init_1();
/* 067 */     wholestagecodegen_init_2();
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */   private void wholestagecodegen_init_0() {
/* 072 */     agg_initAgg = false;
/* 073 */
/* 074 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 075 */
/* 076 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 077 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 078 */     inputadapter_input = inputs[0];
/* 079 */     agg_result = new UnsafeRow(2);
/* 080 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 081 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 082 */
/* 083 */     agg_result1 = new UnsafeRow(9);
/* 084 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 085 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 9);
/* 086 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 087 */
/* 088 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 089 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 090 */
/* 091 */   }
/* 092 */
/* 093 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 094 */     agg_hashMap = agg_plan.createHashMap();
/* 095 */
/* 096 */     while (inputadapter_input.hasNext()) {
/* 097 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 098 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 099 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 100 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 101 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 102 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 103 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 104 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 105 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 106 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 107 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 108 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 109 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 110 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 111 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 112 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 113 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 114 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 115 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 116 */
/* 117 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 118 */
/* 119 */       UnsafeRow agg_fastAggBuffer = null;
/* 120 */
/* 121 */       if (agg_fastAggBuffer == null) {
/* 122 */         // generate grouping key
/* 123 */         agg_rowWriter.zeroOutNullBytes();
/* 124 */
/* 125 */         if (inputadapter_isNull) {
/* 126 */           agg_rowWriter.setNullAt(0);
/* 127 */         } else {
/* 128 */           agg_rowWriter.write(0, inputadapter_value);
/* 129 */         }
/* 130 */
/* 131 */         if (inputadapter_isNull1) {
/* 132 */           agg_rowWriter.setNullAt(1);
/* 133 */         } else {
/* 134 */           agg_rowWriter.write(1, inputadapter_value1);
/* 135 */         }
/* 136 */         agg_value18 = 42;
/* 137 */
/* 138 */         if (!inputadapter_isNull) {
/* 139 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value18);
/* 140 */         }
/* 141 */
/* 142 */         if (!inputadapter_isNull1) {
/* 143 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value18);
/* 144 */         }
/* 145 */         if (true) {
/* 146 */           // try to get the buffer from hash map
/* 147 */           agg_unsafeRowAggBuffer =
/* 148 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 149 */         }
/* 150 */         if (agg_unsafeRowAggBuffer == null) {
/* 151 */           if (agg_sorter == null) {
/* 152 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 153 */           } else {
/* 154 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 155 */           }
/* 156 */
/* 157 */           // the hash map had be spilled, it should have enough memory now,
/* 158 */           // try  to allocate buffer again.
/* 159 */           agg_unsafeRowAggBuffer =
/* 160 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 161 */           if (agg_unsafeRowAggBuffer == null) {
/* 162 */             // failed to allocate the first page
/* 163 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 164 */           }
/* 165 */         }
/* 166 */       }
/* 167 */
/* 168 */       if (agg_fastAggBuffer != null) {
/* 169 */         // update fast row
/* 170 */
/* 171 */       } else {
/* 172 */         // update unsafe row
/* 173 */
/* 174 */         // common sub-expressions
/* 175 */         boolean agg_isNull14 = false;
/* 176 */         double agg_value21 = -1.0;
/* 177 */         if (!false) {
/* 178 */           agg_value21 = (double) 0;
/* 179 */         }
/* 180 */         // evaluate aggregate function
/* 181 */         boolean agg_isNull17 = true;
/* 182 */         double agg_value24 = -1.0;
/* 183 */
/* 184 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 185 */         double agg_value26 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 186 */         boolean agg_isNull18 = agg_isNull19;
/* 187 */         double agg_value25 = agg_value26;
/* 188 */         if (agg_isNull18) {
/* 189 */           if (!agg_isNull14) {
/* 190 */             agg_isNull18 = false;
/* 191 */             agg_value25 = agg_value21;
/* 192 */           }
/* 193 */         }
/* 194 */
/* 195 */         if (!inputadapter_isNull2) {
/* 196 */           agg_isNull17 = false; // resultCode could change nullability.
/* 197 */           agg_value24 = agg_value25 + inputadapter_value2;
/* 198 */
/* 199 */         }
/* 200 */         boolean agg_isNull16 = agg_isNull17;
/* 201 */         double agg_value23 = agg_value24;
/* 202 */         if (agg_isNull16) {
/* 203 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 204 */           double agg_value28 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 205 */           if (!agg_isNull21) {
/* 206 */             agg_isNull16 = false;
/* 207 */             agg_value23 = agg_value28;
/* 208 */           }
/* 209 */         }
/* 210 */         boolean agg_isNull23 = true;
/* 211 */         double agg_value30 = -1.0;
/* 212 */
/* 213 */         boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 214 */         double agg_value32 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 215 */         boolean agg_isNull24 = agg_isNull25;
/* 216 */         double agg_value31 = agg_value32;
/* 217 */         if (agg_isNull24) {
/* 218 */           if (!agg_isNull14) {
/* 219 */             agg_isNull24 = false;
/* 220 */             agg_value31 = agg_value21;
/* 221 */           }
/* 222 */         }
/* 223 */
/* 224 */         if (!inputadapter_isNull3) {
/* 225 */           agg_isNull23 = false; // resultCode could change nullability.
/* 226 */           agg_value30 = agg_value31 + inputadapter_value3;
/* 227 */
/* 228 */         }
/* 229 */         boolean agg_isNull22 = agg_isNull23;
/* 230 */         double agg_value29 = agg_value30;
/* 231 */         if (agg_isNull22) {
/* 232 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 233 */           double agg_value34 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 234 */           if (!agg_isNull27) {
/* 235 */             agg_isNull22 = false;
/* 236 */             agg_value29 = agg_value34;
/* 237 */           }
/* 238 */         }
/* 239 */         boolean agg_isNull29 = true;
/* 240 */         double agg_value36 = -1.0;
/* 241 */
/* 242 */         boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 243 */         double agg_value38 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 244 */         boolean agg_isNull30 = agg_isNull31;
/* 245 */         double agg_value37 = agg_value38;
/* 246 */         if (agg_isNull30) {
/* 247 */           if (!agg_isNull14) {
/* 248 */             agg_isNull30 = false;
/* 249 */             agg_value37 = agg_value21;
/* 250 */           }
/* 251 */         }
/* 252 */
/* 253 */         if (!inputadapter_isNull4) {
/* 254 */           agg_isNull29 = false; // resultCode could change nullability.
/* 255 */           agg_value36 = agg_value37 + inputadapter_value4;
/* 256 */
/* 257 */         }
/* 258 */         boolean agg_isNull28 = agg_isNull29;
/* 259 */         double agg_value35 = agg_value36;
/* 260 */         if (agg_isNull28) {
/* 261 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 262 */           double agg_value40 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 263 */           if (!agg_isNull33) {
/* 264 */             agg_isNull28 = false;
/* 265 */             agg_value35 = agg_value40;
/* 266 */           }
/* 267 */         }
/* 268 */         boolean agg_isNull35 = true;
/* 269 */         double agg_value42 = -1.0;
/* 270 */
/* 271 */         boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 272 */         double agg_value44 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 273 */         boolean agg_isNull36 = agg_isNull37;
/* 274 */         double agg_value43 = agg_value44;
/* 275 */         if (agg_isNull36) {
/* 276 */           if (!agg_isNull14) {
/* 277 */             agg_isNull36 = false;
/* 278 */             agg_value43 = agg_value21;
/* 279 */           }
/* 280 */         }
/* 281 */
/* 282 */         if (!inputadapter_isNull5) {
/* 283 */           agg_isNull35 = false; // resultCode could change nullability.
/* 284 */           agg_value42 = agg_value43 + inputadapter_value5;
/* 285 */
/* 286 */         }
/* 287 */         boolean agg_isNull34 = agg_isNull35;
/* 288 */         double agg_value41 = agg_value42;
/* 289 */         if (agg_isNull34) {
/* 290 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 291 */           double agg_value46 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 292 */           if (!agg_isNull39) {
/* 293 */             agg_isNull34 = false;
/* 294 */             agg_value41 = agg_value46;
/* 295 */           }
/* 296 */         }
/* 297 */         boolean agg_isNull41 = true;
/* 298 */         double agg_value48 = -1.0;
/* 299 */
/* 300 */         boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 301 */         double agg_value50 = agg_isNull43 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 302 */         boolean agg_isNull42 = agg_isNull43;
/* 303 */         double agg_value49 = agg_value50;
/* 304 */         if (agg_isNull42) {
/* 305 */           if (!agg_isNull14) {
/* 306 */             agg_isNull42 = false;
/* 307 */             agg_value49 = agg_value21;
/* 308 */           }
/* 309 */         }
/* 310 */
/* 311 */         if (!inputadapter_isNull6) {
/* 312 */           agg_isNull41 = false; // resultCode could change nullability.
/* 313 */           agg_value48 = agg_value49 + inputadapter_value6;
/* 314 */
/* 315 */         }
/* 316 */         boolean agg_isNull40 = agg_isNull41;
/* 317 */         double agg_value47 = agg_value48;
/* 318 */         if (agg_isNull40) {
/* 319 */           boolean agg_isNull45 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 320 */           double agg_value52 = agg_isNull45 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 321 */           if (!agg_isNull45) {
/* 322 */             agg_isNull40 = false;
/* 323 */             agg_value47 = agg_value52;
/* 324 */           }
/* 325 */         }
/* 326 */         boolean agg_isNull47 = true;
/* 327 */         double agg_value54 = -1.0;
/* 328 */
/* 329 */         boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 330 */         double agg_value56 = agg_isNull49 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 331 */         boolean agg_isNull48 = agg_isNull49;
/* 332 */         double agg_value55 = agg_value56;
/* 333 */         if (agg_isNull48) {
/* 334 */           if (!agg_isNull14) {
/* 335 */             agg_isNull48 = false;
/* 336 */             agg_value55 = agg_value21;
/* 337 */           }
/* 338 */         }
/* 339 */
/* 340 */         if (!inputadapter_isNull7) {
/* 341 */           agg_isNull47 = false; // resultCode could change nullability.
/* 342 */           agg_value54 = agg_value55 + inputadapter_value7;
/* 343 */
/* 344 */         }
/* 345 */         boolean agg_isNull46 = agg_isNull47;
/* 346 */         double agg_value53 = agg_value54;
/* 347 */         if (agg_isNull46) {
/* 348 */           boolean agg_isNull51 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 349 */           double agg_value58 = agg_isNull51 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 350 */           if (!agg_isNull51) {
/* 351 */             agg_isNull46 = false;
/* 352 */             agg_value53 = agg_value58;
/* 353 */           }
/* 354 */         }
/* 355 */         boolean agg_isNull53 = true;
/* 356 */         double agg_value60 = -1.0;
/* 357 */
/* 358 */         boolean agg_isNull55 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 359 */         double agg_value62 = agg_isNull55 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 360 */         boolean agg_isNull54 = agg_isNull55;
/* 361 */         double agg_value61 = agg_value62;
/* 362 */         if (agg_isNull54) {
/* 363 */           if (!agg_isNull14) {
/* 364 */             agg_isNull54 = false;
/* 365 */             agg_value61 = agg_value21;
/* 366 */           }
/* 367 */         }
/* 368 */
/* 369 */         if (!inputadapter_isNull8) {
/* 370 */           agg_isNull53 = false; // resultCode could change nullability.
/* 371 */           agg_value60 = agg_value61 + inputadapter_value8;
/* 372 */
/* 373 */         }
/* 374 */         boolean agg_isNull52 = agg_isNull53;
/* 375 */         double agg_value59 = agg_value60;
/* 376 */         if (agg_isNull52) {
/* 377 */           boolean agg_isNull57 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 378 */           double agg_value64 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 379 */           if (!agg_isNull57) {
/* 380 */             agg_isNull52 = false;
/* 381 */             agg_value59 = agg_value64;
/* 382 */           }
/* 383 */         }
/* 384 */         // update unsafe row buffer
/* 385 */         if (!agg_isNull16) {
/* 386 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value23);
/* 387 */         } else {
/* 388 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 389 */         }
/* 390 */
/* 391 */         if (!agg_isNull22) {
/* 392 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value29);
/* 393 */         } else {
/* 394 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 395 */         }
/* 396 */
/* 397 */         if (!agg_isNull28) {
/* 398 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value35);
/* 399 */         } else {
/* 400 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 401 */         }
/* 402 */
/* 403 */         if (!agg_isNull34) {
/* 404 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value41);
/* 405 */         } else {
/* 406 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 407 */         }
/* 408 */
/* 409 */         if (!agg_isNull40) {
/* 410 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value47);
/* 411 */         } else {
/* 412 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 413 */         }
/* 414 */
/* 415 */         if (!agg_isNull46) {
/* 416 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value53);
/* 417 */         } else {
/* 418 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 419 */         }
/* 420 */
/* 421 */         if (!agg_isNull52) {
/* 422 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value59);
/* 423 */         } else {
/* 424 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 425 */         }
/* 426 */
/* 427 */       }
/* 428 */       if (shouldStop()) return;
/* 429 */     }
/* 430 */
/* 431 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 432 */   }
/* 433 */
/* 434 */   private void wholestagecodegen_init_2() {
/* 435 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 10);
/* 436 */     project_result1 = new UnsafeRow(9);
/* 437 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 438 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 9);
/* 439 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 440 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 441 */
/* 442 */   }
/* 443 */
/* 444 */   private void wholestagecodegen_init_1() {
/* 445 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 446 */     bhj_result = new UnsafeRow(11);
/* 447 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 448 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 11);
/* 449 */     project_result = new UnsafeRow(9);
/* 450 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 451 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 452 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 453 */
/* 454 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 455 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 456 */
/* 457 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 458 */     bhj_result1 = new UnsafeRow(10);
/* 459 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 460 */
/* 461 */   }
/* 462 */
/* 463 */   protected void processNext() throws java.io.IOException {
/* 464 */     if (!agg_initAgg) {
/* 465 */       agg_initAgg = true;
/* 466 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 467 */       agg_doAggregateWithKeys();
/* 468 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 469 */     }
/* 470 */
/* 471 */     // output the result
/* 472 */
/* 473 */     while (agg_mapIter.next()) {
/* 474 */       wholestagecodegen_numOutputRows.add(1);
/* 475 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 476 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 477 */
/* 478 */       boolean agg_isNull58 = agg_aggKey.isNullAt(0);
/* 479 */       int agg_value65 = agg_isNull58 ? -1 : (agg_aggKey.getInt(0));
/* 480 */       boolean agg_isNull59 = agg_aggKey.isNullAt(1);
/* 481 */       int agg_value66 = agg_isNull59 ? -1 : (agg_aggKey.getInt(1));
/* 482 */       boolean agg_isNull60 = agg_aggBuffer.isNullAt(0);
/* 483 */       double agg_value67 = agg_isNull60 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 484 */       boolean agg_isNull61 = agg_aggBuffer.isNullAt(1);
/* 485 */       double agg_value68 = agg_isNull61 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 486 */       boolean agg_isNull62 = agg_aggBuffer.isNullAt(2);
/* 487 */       double agg_value69 = agg_isNull62 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 488 */       boolean agg_isNull63 = agg_aggBuffer.isNullAt(3);
/* 489 */       double agg_value70 = agg_isNull63 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 490 */       boolean agg_isNull64 = agg_aggBuffer.isNullAt(4);
/* 491 */       double agg_value71 = agg_isNull64 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 492 */       boolean agg_isNull65 = agg_aggBuffer.isNullAt(5);
/* 493 */       double agg_value72 = agg_isNull65 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 494 */       boolean agg_isNull66 = agg_aggBuffer.isNullAt(6);
/* 495 */       double agg_value73 = agg_isNull66 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 496 */
/* 497 */       // generate join key for stream side
/* 498 */
/* 499 */       boolean bhj_isNull = agg_isNull59;
/* 500 */       long bhj_value = -1L;
/* 501 */       if (!agg_isNull59) {
/* 502 */         bhj_value = (long) agg_value66;
/* 503 */       }
/* 504 */       // find matches from HashedRelation
/* 505 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 506 */       if (bhj_matched == null) continue;
/* 507 */
/* 508 */       bhj_numOutputRows.add(1);
/* 509 */
/* 510 */       // generate join key for stream side
/* 511 */
/* 512 */       boolean bhj_isNull15 = agg_isNull58;
/* 513 */       long bhj_value15 = -1L;
/* 514 */       if (!agg_isNull58) {
/* 515 */         bhj_value15 = (long) agg_value65;
/* 516 */       }
/* 517 */       // find matches from HashRelation
/* 518 */       scala.collection.Iterator bhj_matches = bhj_isNull15 ? null : (scala.collection.Iterator)bhj_relation1.get(bhj_value15);
/* 519 */       if (bhj_matches == null) continue;
/* 520 */       while (bhj_matches.hasNext()) {
/* 521 */         UnsafeRow bhj_matched1 = (UnsafeRow) bhj_matches.next();
/* 522 */
/* 523 */         bhj_numOutputRows1.add(1);
/* 524 */
/* 525 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 526 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 527 */         project_holder1.reset();
/* 528 */
/* 529 */         project_rowWriter1.zeroOutNullBytes();
/* 530 */
/* 531 */         if (agg_isNull58) {
/* 532 */           project_rowWriter1.setNullAt(0);
/* 533 */         } else {
/* 534 */           project_rowWriter1.write(0, agg_value65);
/* 535 */         }
/* 536 */
/* 537 */         if (bhj_isNull3) {
/* 538 */           project_rowWriter1.setNullAt(1);
/* 539 */         } else {
/* 540 */           project_rowWriter1.write(1, bhj_value3);
/* 541 */         }
/* 542 */
/* 543 */         if (agg_isNull60) {
/* 544 */           project_rowWriter1.setNullAt(2);
/* 545 */         } else {
/* 546 */           project_rowWriter1.write(2, agg_value67);
/* 547 */         }
/* 548 */
/* 549 */         if (agg_isNull61) {
/* 550 */           project_rowWriter1.setNullAt(3);
/* 551 */         } else {
/* 552 */           project_rowWriter1.write(3, agg_value68);
/* 553 */         }
/* 554 */
/* 555 */         if (agg_isNull62) {
/* 556 */           project_rowWriter1.setNullAt(4);
/* 557 */         } else {
/* 558 */           project_rowWriter1.write(4, agg_value69);
/* 559 */         }
/* 560 */
/* 561 */         if (agg_isNull63) {
/* 562 */           project_rowWriter1.setNullAt(5);
/* 563 */         } else {
/* 564 */           project_rowWriter1.write(5, agg_value70);
/* 565 */         }
/* 566 */
/* 567 */         if (agg_isNull64) {
/* 568 */           project_rowWriter1.setNullAt(6);
/* 569 */         } else {
/* 570 */           project_rowWriter1.write(6, agg_value71);
/* 571 */         }
/* 572 */
/* 573 */         if (agg_isNull65) {
/* 574 */           project_rowWriter1.setNullAt(7);
/* 575 */         } else {
/* 576 */           project_rowWriter1.write(7, agg_value72);
/* 577 */         }
/* 578 */
/* 579 */         if (agg_isNull66) {
/* 580 */           project_rowWriter1.setNullAt(8);
/* 581 */         } else {
/* 582 */           project_rowWriter1.write(8, agg_value73);
/* 583 */         }
/* 584 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 585 */         append(project_result1.copy());
/* 586 */
/* 587 */       }
/* 588 */
/* 589 */       if (shouldStop()) return;
/* 590 */     }
/* 591 */
/* 592 */     agg_mapIter.close();
/* 593 */     if (agg_sorter == null) {
/* 594 */       agg_hashMap.free();
/* 595 */     }
/* 596 */   }
/* 597 */ }
