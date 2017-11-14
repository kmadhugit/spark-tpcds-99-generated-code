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
/* 096 */     while (inputadapter_input.hasNext() && !stopEarly()) {
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
/* 175 */
/* 176 */         // evaluate aggregate function
/* 177 */         boolean agg_isNull15 = true;
/* 178 */         double agg_value22 = -1.0;
/* 179 */
/* 180 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 181 */         double agg_value24 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 182 */         boolean agg_isNull16 = agg_isNull17;
/* 183 */         double agg_value23 = agg_value24;
/* 184 */         if (agg_isNull16) {
/* 185 */           boolean agg_isNull18 = false;
/* 186 */           double agg_value25 = -1.0;
/* 187 */           if (!false) {
/* 188 */             agg_value25 = (double) 0;
/* 189 */           }
/* 190 */           if (!agg_isNull18) {
/* 191 */             agg_isNull16 = false;
/* 192 */             agg_value23 = agg_value25;
/* 193 */           }
/* 194 */         }
/* 195 */
/* 196 */         if (!inputadapter_isNull2) {
/* 197 */           agg_isNull15 = false; // resultCode could change nullability.
/* 198 */           agg_value22 = agg_value23 + inputadapter_value2;
/* 199 */
/* 200 */         }
/* 201 */         boolean agg_isNull14 = agg_isNull15;
/* 202 */         double agg_value21 = agg_value22;
/* 203 */         if (agg_isNull14) {
/* 204 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 205 */           double agg_value28 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 206 */           if (!agg_isNull21) {
/* 207 */             agg_isNull14 = false;
/* 208 */             agg_value21 = agg_value28;
/* 209 */           }
/* 210 */         }
/* 211 */         boolean agg_isNull23 = true;
/* 212 */         double agg_value30 = -1.0;
/* 213 */
/* 214 */         boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 215 */         double agg_value32 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 216 */         boolean agg_isNull24 = agg_isNull25;
/* 217 */         double agg_value31 = agg_value32;
/* 218 */         if (agg_isNull24) {
/* 219 */           boolean agg_isNull26 = false;
/* 220 */           double agg_value33 = -1.0;
/* 221 */           if (!false) {
/* 222 */             agg_value33 = (double) 0;
/* 223 */           }
/* 224 */           if (!agg_isNull26) {
/* 225 */             agg_isNull24 = false;
/* 226 */             agg_value31 = agg_value33;
/* 227 */           }
/* 228 */         }
/* 229 */
/* 230 */         if (!inputadapter_isNull3) {
/* 231 */           agg_isNull23 = false; // resultCode could change nullability.
/* 232 */           agg_value30 = agg_value31 + inputadapter_value3;
/* 233 */
/* 234 */         }
/* 235 */         boolean agg_isNull22 = agg_isNull23;
/* 236 */         double agg_value29 = agg_value30;
/* 237 */         if (agg_isNull22) {
/* 238 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 239 */           double agg_value36 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 240 */           if (!agg_isNull29) {
/* 241 */             agg_isNull22 = false;
/* 242 */             agg_value29 = agg_value36;
/* 243 */           }
/* 244 */         }
/* 245 */         boolean agg_isNull31 = true;
/* 246 */         double agg_value38 = -1.0;
/* 247 */
/* 248 */         boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 249 */         double agg_value40 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 250 */         boolean agg_isNull32 = agg_isNull33;
/* 251 */         double agg_value39 = agg_value40;
/* 252 */         if (agg_isNull32) {
/* 253 */           boolean agg_isNull34 = false;
/* 254 */           double agg_value41 = -1.0;
/* 255 */           if (!false) {
/* 256 */             agg_value41 = (double) 0;
/* 257 */           }
/* 258 */           if (!agg_isNull34) {
/* 259 */             agg_isNull32 = false;
/* 260 */             agg_value39 = agg_value41;
/* 261 */           }
/* 262 */         }
/* 263 */
/* 264 */         if (!inputadapter_isNull4) {
/* 265 */           agg_isNull31 = false; // resultCode could change nullability.
/* 266 */           agg_value38 = agg_value39 + inputadapter_value4;
/* 267 */
/* 268 */         }
/* 269 */         boolean agg_isNull30 = agg_isNull31;
/* 270 */         double agg_value37 = agg_value38;
/* 271 */         if (agg_isNull30) {
/* 272 */           boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 273 */           double agg_value44 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 274 */           if (!agg_isNull37) {
/* 275 */             agg_isNull30 = false;
/* 276 */             agg_value37 = agg_value44;
/* 277 */           }
/* 278 */         }
/* 279 */         boolean agg_isNull39 = true;
/* 280 */         double agg_value46 = -1.0;
/* 281 */
/* 282 */         boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 283 */         double agg_value48 = agg_isNull41 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 284 */         boolean agg_isNull40 = agg_isNull41;
/* 285 */         double agg_value47 = agg_value48;
/* 286 */         if (agg_isNull40) {
/* 287 */           boolean agg_isNull42 = false;
/* 288 */           double agg_value49 = -1.0;
/* 289 */           if (!false) {
/* 290 */             agg_value49 = (double) 0;
/* 291 */           }
/* 292 */           if (!agg_isNull42) {
/* 293 */             agg_isNull40 = false;
/* 294 */             agg_value47 = agg_value49;
/* 295 */           }
/* 296 */         }
/* 297 */
/* 298 */         if (!inputadapter_isNull5) {
/* 299 */           agg_isNull39 = false; // resultCode could change nullability.
/* 300 */           agg_value46 = agg_value47 + inputadapter_value5;
/* 301 */
/* 302 */         }
/* 303 */         boolean agg_isNull38 = agg_isNull39;
/* 304 */         double agg_value45 = agg_value46;
/* 305 */         if (agg_isNull38) {
/* 306 */           boolean agg_isNull45 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 307 */           double agg_value52 = agg_isNull45 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 308 */           if (!agg_isNull45) {
/* 309 */             agg_isNull38 = false;
/* 310 */             agg_value45 = agg_value52;
/* 311 */           }
/* 312 */         }
/* 313 */         boolean agg_isNull47 = true;
/* 314 */         double agg_value54 = -1.0;
/* 315 */
/* 316 */         boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 317 */         double agg_value56 = agg_isNull49 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 318 */         boolean agg_isNull48 = agg_isNull49;
/* 319 */         double agg_value55 = agg_value56;
/* 320 */         if (agg_isNull48) {
/* 321 */           boolean agg_isNull50 = false;
/* 322 */           double agg_value57 = -1.0;
/* 323 */           if (!false) {
/* 324 */             agg_value57 = (double) 0;
/* 325 */           }
/* 326 */           if (!agg_isNull50) {
/* 327 */             agg_isNull48 = false;
/* 328 */             agg_value55 = agg_value57;
/* 329 */           }
/* 330 */         }
/* 331 */
/* 332 */         if (!inputadapter_isNull6) {
/* 333 */           agg_isNull47 = false; // resultCode could change nullability.
/* 334 */           agg_value54 = agg_value55 + inputadapter_value6;
/* 335 */
/* 336 */         }
/* 337 */         boolean agg_isNull46 = agg_isNull47;
/* 338 */         double agg_value53 = agg_value54;
/* 339 */         if (agg_isNull46) {
/* 340 */           boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 341 */           double agg_value60 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 342 */           if (!agg_isNull53) {
/* 343 */             agg_isNull46 = false;
/* 344 */             agg_value53 = agg_value60;
/* 345 */           }
/* 346 */         }
/* 347 */         boolean agg_isNull55 = true;
/* 348 */         double agg_value62 = -1.0;
/* 349 */
/* 350 */         boolean agg_isNull57 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 351 */         double agg_value64 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 352 */         boolean agg_isNull56 = agg_isNull57;
/* 353 */         double agg_value63 = agg_value64;
/* 354 */         if (agg_isNull56) {
/* 355 */           boolean agg_isNull58 = false;
/* 356 */           double agg_value65 = -1.0;
/* 357 */           if (!false) {
/* 358 */             agg_value65 = (double) 0;
/* 359 */           }
/* 360 */           if (!agg_isNull58) {
/* 361 */             agg_isNull56 = false;
/* 362 */             agg_value63 = agg_value65;
/* 363 */           }
/* 364 */         }
/* 365 */
/* 366 */         if (!inputadapter_isNull7) {
/* 367 */           agg_isNull55 = false; // resultCode could change nullability.
/* 368 */           agg_value62 = agg_value63 + inputadapter_value7;
/* 369 */
/* 370 */         }
/* 371 */         boolean agg_isNull54 = agg_isNull55;
/* 372 */         double agg_value61 = agg_value62;
/* 373 */         if (agg_isNull54) {
/* 374 */           boolean agg_isNull61 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 375 */           double agg_value68 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 376 */           if (!agg_isNull61) {
/* 377 */             agg_isNull54 = false;
/* 378 */             agg_value61 = agg_value68;
/* 379 */           }
/* 380 */         }
/* 381 */         boolean agg_isNull63 = true;
/* 382 */         double agg_value70 = -1.0;
/* 383 */
/* 384 */         boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 385 */         double agg_value72 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 386 */         boolean agg_isNull64 = agg_isNull65;
/* 387 */         double agg_value71 = agg_value72;
/* 388 */         if (agg_isNull64) {
/* 389 */           boolean agg_isNull66 = false;
/* 390 */           double agg_value73 = -1.0;
/* 391 */           if (!false) {
/* 392 */             agg_value73 = (double) 0;
/* 393 */           }
/* 394 */           if (!agg_isNull66) {
/* 395 */             agg_isNull64 = false;
/* 396 */             agg_value71 = agg_value73;
/* 397 */           }
/* 398 */         }
/* 399 */
/* 400 */         if (!inputadapter_isNull8) {
/* 401 */           agg_isNull63 = false; // resultCode could change nullability.
/* 402 */           agg_value70 = agg_value71 + inputadapter_value8;
/* 403 */
/* 404 */         }
/* 405 */         boolean agg_isNull62 = agg_isNull63;
/* 406 */         double agg_value69 = agg_value70;
/* 407 */         if (agg_isNull62) {
/* 408 */           boolean agg_isNull69 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 409 */           double agg_value76 = agg_isNull69 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 410 */           if (!agg_isNull69) {
/* 411 */             agg_isNull62 = false;
/* 412 */             agg_value69 = agg_value76;
/* 413 */           }
/* 414 */         }
/* 415 */         // update unsafe row buffer
/* 416 */         if (!agg_isNull14) {
/* 417 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 418 */         } else {
/* 419 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 420 */         }
/* 421 */
/* 422 */         if (!agg_isNull22) {
/* 423 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value29);
/* 424 */         } else {
/* 425 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 426 */         }
/* 427 */
/* 428 */         if (!agg_isNull30) {
/* 429 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value37);
/* 430 */         } else {
/* 431 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 432 */         }
/* 433 */
/* 434 */         if (!agg_isNull38) {
/* 435 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value45);
/* 436 */         } else {
/* 437 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 438 */         }
/* 439 */
/* 440 */         if (!agg_isNull46) {
/* 441 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value53);
/* 442 */         } else {
/* 443 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 444 */         }
/* 445 */
/* 446 */         if (!agg_isNull54) {
/* 447 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value61);
/* 448 */         } else {
/* 449 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 450 */         }
/* 451 */
/* 452 */         if (!agg_isNull62) {
/* 453 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value69);
/* 454 */         } else {
/* 455 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 456 */         }
/* 457 */
/* 458 */       }
/* 459 */       if (shouldStop()) return;
/* 460 */     }
/* 461 */
/* 462 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 463 */   }
/* 464 */
/* 465 */   private void wholestagecodegen_init_2() {
/* 466 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 10);
/* 467 */     project_result1 = new UnsafeRow(9);
/* 468 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 469 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 9);
/* 470 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 471 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 472 */
/* 473 */   }
/* 474 */
/* 475 */   private void wholestagecodegen_init_1() {
/* 476 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 477 */     bhj_result = new UnsafeRow(11);
/* 478 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 479 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 11);
/* 480 */     project_result = new UnsafeRow(9);
/* 481 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 482 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 483 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 484 */
/* 485 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 486 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 487 */
/* 488 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 489 */     bhj_result1 = new UnsafeRow(10);
/* 490 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 491 */
/* 492 */   }
/* 493 */
/* 494 */   protected void processNext() throws java.io.IOException {
/* 495 */     if (!agg_initAgg) {
/* 496 */       agg_initAgg = true;
/* 497 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 498 */       agg_doAggregateWithKeys();
/* 499 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 500 */     }
/* 501 */
/* 502 */     // output the result
/* 503 */
/* 504 */     while (agg_mapIter.next()) {
/* 505 */       wholestagecodegen_numOutputRows.add(1);
/* 506 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 507 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 508 */
/* 509 */       boolean agg_isNull70 = agg_aggKey.isNullAt(0);
/* 510 */       int agg_value77 = agg_isNull70 ? -1 : (agg_aggKey.getInt(0));
/* 511 */       boolean agg_isNull71 = agg_aggKey.isNullAt(1);
/* 512 */       int agg_value78 = agg_isNull71 ? -1 : (agg_aggKey.getInt(1));
/* 513 */       boolean agg_isNull72 = agg_aggBuffer.isNullAt(0);
/* 514 */       double agg_value79 = agg_isNull72 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 515 */       boolean agg_isNull73 = agg_aggBuffer.isNullAt(1);
/* 516 */       double agg_value80 = agg_isNull73 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 517 */       boolean agg_isNull74 = agg_aggBuffer.isNullAt(2);
/* 518 */       double agg_value81 = agg_isNull74 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 519 */       boolean agg_isNull75 = agg_aggBuffer.isNullAt(3);
/* 520 */       double agg_value82 = agg_isNull75 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 521 */       boolean agg_isNull76 = agg_aggBuffer.isNullAt(4);
/* 522 */       double agg_value83 = agg_isNull76 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 523 */       boolean agg_isNull77 = agg_aggBuffer.isNullAt(5);
/* 524 */       double agg_value84 = agg_isNull77 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 525 */       boolean agg_isNull78 = agg_aggBuffer.isNullAt(6);
/* 526 */       double agg_value85 = agg_isNull78 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 527 */
/* 528 */       // generate join key for stream side
/* 529 */
/* 530 */       boolean bhj_isNull = agg_isNull71;
/* 531 */       long bhj_value = -1L;
/* 532 */       if (!agg_isNull71) {
/* 533 */         bhj_value = (long) agg_value78;
/* 534 */       }
/* 535 */       // find matches from HashedRelation
/* 536 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 537 */       if (bhj_matched == null) continue;
/* 538 */
/* 539 */       bhj_numOutputRows.add(1);
/* 540 */
/* 541 */       // generate join key for stream side
/* 542 */
/* 543 */       boolean bhj_isNull15 = agg_isNull70;
/* 544 */       long bhj_value15 = -1L;
/* 545 */       if (!agg_isNull70) {
/* 546 */         bhj_value15 = (long) agg_value77;
/* 547 */       }
/* 548 */       // find matches from HashRelation
/* 549 */       scala.collection.Iterator bhj_matches = bhj_isNull15 ? null : (scala.collection.Iterator)bhj_relation1.get(bhj_value15);
/* 550 */       if (bhj_matches == null) continue;
/* 551 */       while (bhj_matches.hasNext()) {
/* 552 */         UnsafeRow bhj_matched1 = (UnsafeRow) bhj_matches.next();
/* 553 */
/* 554 */         bhj_numOutputRows1.add(1);
/* 555 */
/* 556 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 557 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 558 */         project_holder1.reset();
/* 559 */
/* 560 */         project_rowWriter1.zeroOutNullBytes();
/* 561 */
/* 562 */         if (agg_isNull70) {
/* 563 */           project_rowWriter1.setNullAt(0);
/* 564 */         } else {
/* 565 */           project_rowWriter1.write(0, agg_value77);
/* 566 */         }
/* 567 */
/* 568 */         if (bhj_isNull3) {
/* 569 */           project_rowWriter1.setNullAt(1);
/* 570 */         } else {
/* 571 */           project_rowWriter1.write(1, bhj_value3);
/* 572 */         }
/* 573 */
/* 574 */         if (agg_isNull72) {
/* 575 */           project_rowWriter1.setNullAt(2);
/* 576 */         } else {
/* 577 */           project_rowWriter1.write(2, agg_value79);
/* 578 */         }
/* 579 */
/* 580 */         if (agg_isNull73) {
/* 581 */           project_rowWriter1.setNullAt(3);
/* 582 */         } else {
/* 583 */           project_rowWriter1.write(3, agg_value80);
/* 584 */         }
/* 585 */
/* 586 */         if (agg_isNull74) {
/* 587 */           project_rowWriter1.setNullAt(4);
/* 588 */         } else {
/* 589 */           project_rowWriter1.write(4, agg_value81);
/* 590 */         }
/* 591 */
/* 592 */         if (agg_isNull75) {
/* 593 */           project_rowWriter1.setNullAt(5);
/* 594 */         } else {
/* 595 */           project_rowWriter1.write(5, agg_value82);
/* 596 */         }
/* 597 */
/* 598 */         if (agg_isNull76) {
/* 599 */           project_rowWriter1.setNullAt(6);
/* 600 */         } else {
/* 601 */           project_rowWriter1.write(6, agg_value83);
/* 602 */         }
/* 603 */
/* 604 */         if (agg_isNull77) {
/* 605 */           project_rowWriter1.setNullAt(7);
/* 606 */         } else {
/* 607 */           project_rowWriter1.write(7, agg_value84);
/* 608 */         }
/* 609 */
/* 610 */         if (agg_isNull78) {
/* 611 */           project_rowWriter1.setNullAt(8);
/* 612 */         } else {
/* 613 */           project_rowWriter1.write(8, agg_value85);
/* 614 */         }
/* 615 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 616 */         append(project_result1.copy());
/* 617 */
/* 618 */       }
/* 619 */
/* 620 */       if (shouldStop()) return;
/* 621 */     }
/* 622 */
/* 623 */     agg_mapIter.close();
/* 624 */     if (agg_sorter == null) {
/* 625 */       agg_hashMap.free();
/* 626 */     }
/* 627 */   }
/* 628 */ }
