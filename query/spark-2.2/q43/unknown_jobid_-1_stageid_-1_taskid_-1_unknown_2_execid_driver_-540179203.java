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
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 039 */
/* 040 */   public GeneratedIterator(Object[] references) {
/* 041 */     this.references = references;
/* 042 */   }
/* 043 */
/* 044 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 045 */     partitionIndex = index;
/* 046 */     this.inputs = inputs;
/* 047 */     agg_initAgg = false;
/* 048 */
/* 049 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 050 */
/* 051 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 052 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 053 */     inputadapter_input = inputs[0];
/* 054 */     agg_result = new UnsafeRow(2);
/* 055 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 056 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 057 */
/* 058 */     agg_result1 = new UnsafeRow(9);
/* 059 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 060 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 9);
/* 061 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 062 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 067 */     agg_hashMap = agg_plan.createHashMap();
/* 068 */
/* 069 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 070 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 071 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 072 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 073 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 074 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 075 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 076 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 077 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 078 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 079 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 080 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 081 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 082 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 083 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 084 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 085 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 086 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 087 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 088 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 089 */
/* 090 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 091 */
/* 092 */       UnsafeRow agg_fastAggBuffer = null;
/* 093 */
/* 094 */       if (agg_fastAggBuffer == null) {
/* 095 */         // generate grouping key
/* 096 */         agg_holder.reset();
/* 097 */
/* 098 */         agg_rowWriter.zeroOutNullBytes();
/* 099 */
/* 100 */         if (inputadapter_isNull) {
/* 101 */           agg_rowWriter.setNullAt(0);
/* 102 */         } else {
/* 103 */           agg_rowWriter.write(0, inputadapter_value);
/* 104 */         }
/* 105 */
/* 106 */         if (inputadapter_isNull1) {
/* 107 */           agg_rowWriter.setNullAt(1);
/* 108 */         } else {
/* 109 */           agg_rowWriter.write(1, inputadapter_value1);
/* 110 */         }
/* 111 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 112 */         agg_value18 = 42;
/* 113 */
/* 114 */         if (!inputadapter_isNull) {
/* 115 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value18);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull1) {
/* 119 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value18);
/* 120 */         }
/* 121 */         if (true) {
/* 122 */           // try to get the buffer from hash map
/* 123 */           agg_unsafeRowAggBuffer =
/* 124 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 125 */         }
/* 126 */         if (agg_unsafeRowAggBuffer == null) {
/* 127 */           if (agg_sorter == null) {
/* 128 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 129 */           } else {
/* 130 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 131 */           }
/* 132 */
/* 133 */           // the hash map had be spilled, it should have enough memory now,
/* 134 */           // try  to allocate buffer again.
/* 135 */           agg_unsafeRowAggBuffer =
/* 136 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 137 */           if (agg_unsafeRowAggBuffer == null) {
/* 138 */             // failed to allocate the first page
/* 139 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 140 */           }
/* 141 */         }
/* 142 */       }
/* 143 */
/* 144 */       if (agg_fastAggBuffer != null) {
/* 145 */         // update fast row
/* 146 */
/* 147 */       } else {
/* 148 */         // update unsafe row
/* 149 */
/* 150 */         // common sub-expressions
/* 151 */
/* 152 */         // evaluate aggregate function
/* 153 */         boolean agg_isNull15 = true;
/* 154 */         double agg_value22 = -1.0;
/* 155 */
/* 156 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 157 */         double agg_value24 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 158 */         boolean agg_isNull16 = agg_isNull17;
/* 159 */         double agg_value23 = agg_value24;
/* 160 */         if (agg_isNull16) {
/* 161 */           boolean agg_isNull18 = false;
/* 162 */           double agg_value25 = -1.0;
/* 163 */           if (!false) {
/* 164 */             agg_value25 = (double) 0;
/* 165 */           }
/* 166 */           if (!agg_isNull18) {
/* 167 */             agg_isNull16 = false;
/* 168 */             agg_value23 = agg_value25;
/* 169 */           }
/* 170 */         }
/* 171 */
/* 172 */         if (!inputadapter_isNull2) {
/* 173 */           agg_isNull15 = false; // resultCode could change nullability.
/* 174 */           agg_value22 = agg_value23 + inputadapter_value2;
/* 175 */
/* 176 */         }
/* 177 */         boolean agg_isNull14 = agg_isNull15;
/* 178 */         double agg_value21 = agg_value22;
/* 179 */         if (agg_isNull14) {
/* 180 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 181 */           double agg_value28 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 182 */           if (!agg_isNull21) {
/* 183 */             agg_isNull14 = false;
/* 184 */             agg_value21 = agg_value28;
/* 185 */           }
/* 186 */         }
/* 187 */         boolean agg_isNull23 = true;
/* 188 */         double agg_value30 = -1.0;
/* 189 */
/* 190 */         boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 191 */         double agg_value32 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 192 */         boolean agg_isNull24 = agg_isNull25;
/* 193 */         double agg_value31 = agg_value32;
/* 194 */         if (agg_isNull24) {
/* 195 */           boolean agg_isNull26 = false;
/* 196 */           double agg_value33 = -1.0;
/* 197 */           if (!false) {
/* 198 */             agg_value33 = (double) 0;
/* 199 */           }
/* 200 */           if (!agg_isNull26) {
/* 201 */             agg_isNull24 = false;
/* 202 */             agg_value31 = agg_value33;
/* 203 */           }
/* 204 */         }
/* 205 */
/* 206 */         if (!inputadapter_isNull3) {
/* 207 */           agg_isNull23 = false; // resultCode could change nullability.
/* 208 */           agg_value30 = agg_value31 + inputadapter_value3;
/* 209 */
/* 210 */         }
/* 211 */         boolean agg_isNull22 = agg_isNull23;
/* 212 */         double agg_value29 = agg_value30;
/* 213 */         if (agg_isNull22) {
/* 214 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 215 */           double agg_value36 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 216 */           if (!agg_isNull29) {
/* 217 */             agg_isNull22 = false;
/* 218 */             agg_value29 = agg_value36;
/* 219 */           }
/* 220 */         }
/* 221 */         boolean agg_isNull31 = true;
/* 222 */         double agg_value38 = -1.0;
/* 223 */
/* 224 */         boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 225 */         double agg_value40 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 226 */         boolean agg_isNull32 = agg_isNull33;
/* 227 */         double agg_value39 = agg_value40;
/* 228 */         if (agg_isNull32) {
/* 229 */           boolean agg_isNull34 = false;
/* 230 */           double agg_value41 = -1.0;
/* 231 */           if (!false) {
/* 232 */             agg_value41 = (double) 0;
/* 233 */           }
/* 234 */           if (!agg_isNull34) {
/* 235 */             agg_isNull32 = false;
/* 236 */             agg_value39 = agg_value41;
/* 237 */           }
/* 238 */         }
/* 239 */
/* 240 */         if (!inputadapter_isNull4) {
/* 241 */           agg_isNull31 = false; // resultCode could change nullability.
/* 242 */           agg_value38 = agg_value39 + inputadapter_value4;
/* 243 */
/* 244 */         }
/* 245 */         boolean agg_isNull30 = agg_isNull31;
/* 246 */         double agg_value37 = agg_value38;
/* 247 */         if (agg_isNull30) {
/* 248 */           boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 249 */           double agg_value44 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 250 */           if (!agg_isNull37) {
/* 251 */             agg_isNull30 = false;
/* 252 */             agg_value37 = agg_value44;
/* 253 */           }
/* 254 */         }
/* 255 */         boolean agg_isNull39 = true;
/* 256 */         double agg_value46 = -1.0;
/* 257 */
/* 258 */         boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 259 */         double agg_value48 = agg_isNull41 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 260 */         boolean agg_isNull40 = agg_isNull41;
/* 261 */         double agg_value47 = agg_value48;
/* 262 */         if (agg_isNull40) {
/* 263 */           boolean agg_isNull42 = false;
/* 264 */           double agg_value49 = -1.0;
/* 265 */           if (!false) {
/* 266 */             agg_value49 = (double) 0;
/* 267 */           }
/* 268 */           if (!agg_isNull42) {
/* 269 */             agg_isNull40 = false;
/* 270 */             agg_value47 = agg_value49;
/* 271 */           }
/* 272 */         }
/* 273 */
/* 274 */         if (!inputadapter_isNull5) {
/* 275 */           agg_isNull39 = false; // resultCode could change nullability.
/* 276 */           agg_value46 = agg_value47 + inputadapter_value5;
/* 277 */
/* 278 */         }
/* 279 */         boolean agg_isNull38 = agg_isNull39;
/* 280 */         double agg_value45 = agg_value46;
/* 281 */         if (agg_isNull38) {
/* 282 */           boolean agg_isNull45 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 283 */           double agg_value52 = agg_isNull45 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 284 */           if (!agg_isNull45) {
/* 285 */             agg_isNull38 = false;
/* 286 */             agg_value45 = agg_value52;
/* 287 */           }
/* 288 */         }
/* 289 */         boolean agg_isNull47 = true;
/* 290 */         double agg_value54 = -1.0;
/* 291 */
/* 292 */         boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 293 */         double agg_value56 = agg_isNull49 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 294 */         boolean agg_isNull48 = agg_isNull49;
/* 295 */         double agg_value55 = agg_value56;
/* 296 */         if (agg_isNull48) {
/* 297 */           boolean agg_isNull50 = false;
/* 298 */           double agg_value57 = -1.0;
/* 299 */           if (!false) {
/* 300 */             agg_value57 = (double) 0;
/* 301 */           }
/* 302 */           if (!agg_isNull50) {
/* 303 */             agg_isNull48 = false;
/* 304 */             agg_value55 = agg_value57;
/* 305 */           }
/* 306 */         }
/* 307 */
/* 308 */         if (!inputadapter_isNull6) {
/* 309 */           agg_isNull47 = false; // resultCode could change nullability.
/* 310 */           agg_value54 = agg_value55 + inputadapter_value6;
/* 311 */
/* 312 */         }
/* 313 */         boolean agg_isNull46 = agg_isNull47;
/* 314 */         double agg_value53 = agg_value54;
/* 315 */         if (agg_isNull46) {
/* 316 */           boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 317 */           double agg_value60 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 318 */           if (!agg_isNull53) {
/* 319 */             agg_isNull46 = false;
/* 320 */             agg_value53 = agg_value60;
/* 321 */           }
/* 322 */         }
/* 323 */         boolean agg_isNull55 = true;
/* 324 */         double agg_value62 = -1.0;
/* 325 */
/* 326 */         boolean agg_isNull57 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 327 */         double agg_value64 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 328 */         boolean agg_isNull56 = agg_isNull57;
/* 329 */         double agg_value63 = agg_value64;
/* 330 */         if (agg_isNull56) {
/* 331 */           boolean agg_isNull58 = false;
/* 332 */           double agg_value65 = -1.0;
/* 333 */           if (!false) {
/* 334 */             agg_value65 = (double) 0;
/* 335 */           }
/* 336 */           if (!agg_isNull58) {
/* 337 */             agg_isNull56 = false;
/* 338 */             agg_value63 = agg_value65;
/* 339 */           }
/* 340 */         }
/* 341 */
/* 342 */         if (!inputadapter_isNull7) {
/* 343 */           agg_isNull55 = false; // resultCode could change nullability.
/* 344 */           agg_value62 = agg_value63 + inputadapter_value7;
/* 345 */
/* 346 */         }
/* 347 */         boolean agg_isNull54 = agg_isNull55;
/* 348 */         double agg_value61 = agg_value62;
/* 349 */         if (agg_isNull54) {
/* 350 */           boolean agg_isNull61 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 351 */           double agg_value68 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 352 */           if (!agg_isNull61) {
/* 353 */             agg_isNull54 = false;
/* 354 */             agg_value61 = agg_value68;
/* 355 */           }
/* 356 */         }
/* 357 */         boolean agg_isNull63 = true;
/* 358 */         double agg_value70 = -1.0;
/* 359 */
/* 360 */         boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 361 */         double agg_value72 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 362 */         boolean agg_isNull64 = agg_isNull65;
/* 363 */         double agg_value71 = agg_value72;
/* 364 */         if (agg_isNull64) {
/* 365 */           boolean agg_isNull66 = false;
/* 366 */           double agg_value73 = -1.0;
/* 367 */           if (!false) {
/* 368 */             agg_value73 = (double) 0;
/* 369 */           }
/* 370 */           if (!agg_isNull66) {
/* 371 */             agg_isNull64 = false;
/* 372 */             agg_value71 = agg_value73;
/* 373 */           }
/* 374 */         }
/* 375 */
/* 376 */         if (!inputadapter_isNull8) {
/* 377 */           agg_isNull63 = false; // resultCode could change nullability.
/* 378 */           agg_value70 = agg_value71 + inputadapter_value8;
/* 379 */
/* 380 */         }
/* 381 */         boolean agg_isNull62 = agg_isNull63;
/* 382 */         double agg_value69 = agg_value70;
/* 383 */         if (agg_isNull62) {
/* 384 */           boolean agg_isNull69 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 385 */           double agg_value76 = agg_isNull69 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 386 */           if (!agg_isNull69) {
/* 387 */             agg_isNull62 = false;
/* 388 */             agg_value69 = agg_value76;
/* 389 */           }
/* 390 */         }
/* 391 */         // update unsafe row buffer
/* 392 */         if (!agg_isNull14) {
/* 393 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 394 */         } else {
/* 395 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 396 */         }
/* 397 */
/* 398 */         if (!agg_isNull22) {
/* 399 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value29);
/* 400 */         } else {
/* 401 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 402 */         }
/* 403 */
/* 404 */         if (!agg_isNull30) {
/* 405 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value37);
/* 406 */         } else {
/* 407 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 408 */         }
/* 409 */
/* 410 */         if (!agg_isNull38) {
/* 411 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value45);
/* 412 */         } else {
/* 413 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 414 */         }
/* 415 */
/* 416 */         if (!agg_isNull46) {
/* 417 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value53);
/* 418 */         } else {
/* 419 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 420 */         }
/* 421 */
/* 422 */         if (!agg_isNull54) {
/* 423 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value61);
/* 424 */         } else {
/* 425 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 426 */         }
/* 427 */
/* 428 */         if (!agg_isNull62) {
/* 429 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value69);
/* 430 */         } else {
/* 431 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 432 */         }
/* 433 */
/* 434 */       }
/* 435 */       if (shouldStop()) return;
/* 436 */     }
/* 437 */
/* 438 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 439 */   }
/* 440 */
/* 441 */   protected void processNext() throws java.io.IOException {
/* 442 */     if (!agg_initAgg) {
/* 443 */       agg_initAgg = true;
/* 444 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 445 */       agg_doAggregateWithKeys();
/* 446 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 447 */     }
/* 448 */
/* 449 */     // output the result
/* 450 */
/* 451 */     while (agg_mapIter.next()) {
/* 452 */       wholestagecodegen_numOutputRows.add(1);
/* 453 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 454 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 455 */
/* 456 */       boolean agg_isNull70 = agg_aggKey.isNullAt(0);
/* 457 */       UTF8String agg_value77 = agg_isNull70 ? null : (agg_aggKey.getUTF8String(0));
/* 458 */       boolean agg_isNull71 = agg_aggKey.isNullAt(1);
/* 459 */       UTF8String agg_value78 = agg_isNull71 ? null : (agg_aggKey.getUTF8String(1));
/* 460 */       boolean agg_isNull72 = agg_aggBuffer.isNullAt(0);
/* 461 */       double agg_value79 = agg_isNull72 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 462 */       boolean agg_isNull73 = agg_aggBuffer.isNullAt(1);
/* 463 */       double agg_value80 = agg_isNull73 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 464 */       boolean agg_isNull74 = agg_aggBuffer.isNullAt(2);
/* 465 */       double agg_value81 = agg_isNull74 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 466 */       boolean agg_isNull75 = agg_aggBuffer.isNullAt(3);
/* 467 */       double agg_value82 = agg_isNull75 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 468 */       boolean agg_isNull76 = agg_aggBuffer.isNullAt(4);
/* 469 */       double agg_value83 = agg_isNull76 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 470 */       boolean agg_isNull77 = agg_aggBuffer.isNullAt(5);
/* 471 */       double agg_value84 = agg_isNull77 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 472 */       boolean agg_isNull78 = agg_aggBuffer.isNullAt(6);
/* 473 */       double agg_value85 = agg_isNull78 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 474 */
/* 475 */       agg_holder1.reset();
/* 476 */
/* 477 */       agg_rowWriter1.zeroOutNullBytes();
/* 478 */
/* 479 */       if (agg_isNull70) {
/* 480 */         agg_rowWriter1.setNullAt(0);
/* 481 */       } else {
/* 482 */         agg_rowWriter1.write(0, agg_value77);
/* 483 */       }
/* 484 */
/* 485 */       if (agg_isNull71) {
/* 486 */         agg_rowWriter1.setNullAt(1);
/* 487 */       } else {
/* 488 */         agg_rowWriter1.write(1, agg_value78);
/* 489 */       }
/* 490 */
/* 491 */       if (agg_isNull72) {
/* 492 */         agg_rowWriter1.setNullAt(2);
/* 493 */       } else {
/* 494 */         agg_rowWriter1.write(2, agg_value79);
/* 495 */       }
/* 496 */
/* 497 */       if (agg_isNull73) {
/* 498 */         agg_rowWriter1.setNullAt(3);
/* 499 */       } else {
/* 500 */         agg_rowWriter1.write(3, agg_value80);
/* 501 */       }
/* 502 */
/* 503 */       if (agg_isNull74) {
/* 504 */         agg_rowWriter1.setNullAt(4);
/* 505 */       } else {
/* 506 */         agg_rowWriter1.write(4, agg_value81);
/* 507 */       }
/* 508 */
/* 509 */       if (agg_isNull75) {
/* 510 */         agg_rowWriter1.setNullAt(5);
/* 511 */       } else {
/* 512 */         agg_rowWriter1.write(5, agg_value82);
/* 513 */       }
/* 514 */
/* 515 */       if (agg_isNull76) {
/* 516 */         agg_rowWriter1.setNullAt(6);
/* 517 */       } else {
/* 518 */         agg_rowWriter1.write(6, agg_value83);
/* 519 */       }
/* 520 */
/* 521 */       if (agg_isNull77) {
/* 522 */         agg_rowWriter1.setNullAt(7);
/* 523 */       } else {
/* 524 */         agg_rowWriter1.write(7, agg_value84);
/* 525 */       }
/* 526 */
/* 527 */       if (agg_isNull78) {
/* 528 */         agg_rowWriter1.setNullAt(8);
/* 529 */       } else {
/* 530 */         agg_rowWriter1.write(8, agg_value85);
/* 531 */       }
/* 532 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 533 */       append(agg_result1);
/* 534 */
/* 535 */       if (shouldStop()) return;
/* 536 */     }
/* 537 */
/* 538 */     agg_mapIter.close();
/* 539 */     if (agg_sorter == null) {
/* 540 */       agg_hashMap.free();
/* 541 */     }
/* 542 */   }
/* 543 */ }
