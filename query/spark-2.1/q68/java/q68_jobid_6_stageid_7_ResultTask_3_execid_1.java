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
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private double agg_bufValue7;
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
/* 035 */   private int agg_value24;
/* 036 */   private UnsafeRow agg_result1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 039 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 040 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 042 */   private UnsafeRow bhj_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 045 */   private UnsafeRow project_result;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 048 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 049 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 051 */   private UnsafeRow bhj_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 054 */   private UnsafeRow project_result1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 059 */
/* 060 */   public GeneratedIterator(Object[] references) {
/* 061 */     this.references = references;
/* 062 */   }
/* 063 */
/* 064 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 065 */     partitionIndex = index;
/* 066 */     this.inputs = inputs;
/* 067 */     wholestagecodegen_init_0();
/* 068 */     wholestagecodegen_init_1();
/* 069 */     wholestagecodegen_init_2();
/* 070 */
/* 071 */   }
/* 072 */
/* 073 */   private void wholestagecodegen_init_0() {
/* 074 */     agg_initAgg = false;
/* 075 */
/* 076 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 077 */
/* 078 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 079 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 080 */     inputadapter_input = inputs[0];
/* 081 */     agg_result = new UnsafeRow(4);
/* 082 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 083 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 084 */
/* 085 */     agg_result1 = new UnsafeRow(11);
/* 086 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 087 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 11);
/* 088 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 089 */
/* 090 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 091 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 096 */     agg_hashMap = agg_plan.createHashMap();
/* 097 */
/* 098 */     while (inputadapter_input.hasNext()) {
/* 099 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 100 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 101 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 102 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 103 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 104 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 105 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 106 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 107 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 108 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 109 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 110 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 111 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 112 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 113 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 114 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 115 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 116 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 117 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 118 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 119 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 120 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 121 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 122 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 123 */       double inputadapter_value11 = inputadapter_isNull11 ? -1.0 : (inputadapter_row.getDouble(11));
/* 124 */
/* 125 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 126 */
/* 127 */       UnsafeRow agg_fastAggBuffer = null;
/* 128 */
/* 129 */       if (agg_fastAggBuffer == null) {
/* 130 */         // generate grouping key
/* 131 */         agg_holder.reset();
/* 132 */
/* 133 */         agg_rowWriter.zeroOutNullBytes();
/* 134 */
/* 135 */         if (inputadapter_isNull) {
/* 136 */           agg_rowWriter.setNullAt(0);
/* 137 */         } else {
/* 138 */           agg_rowWriter.write(0, inputadapter_value);
/* 139 */         }
/* 140 */
/* 141 */         if (inputadapter_isNull1) {
/* 142 */           agg_rowWriter.setNullAt(1);
/* 143 */         } else {
/* 144 */           agg_rowWriter.write(1, inputadapter_value1);
/* 145 */         }
/* 146 */
/* 147 */         if (inputadapter_isNull2) {
/* 148 */           agg_rowWriter.setNullAt(2);
/* 149 */         } else {
/* 150 */           agg_rowWriter.write(2, inputadapter_value2);
/* 151 */         }
/* 152 */
/* 153 */         if (inputadapter_isNull3) {
/* 154 */           agg_rowWriter.setNullAt(3);
/* 155 */         } else {
/* 156 */           agg_rowWriter.write(3, inputadapter_value3);
/* 157 */         }
/* 158 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 159 */         agg_value24 = 42;
/* 160 */
/* 161 */         if (!inputadapter_isNull) {
/* 162 */           agg_value24 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value24);
/* 163 */         }
/* 164 */
/* 165 */         if (!inputadapter_isNull1) {
/* 166 */           agg_value24 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value24);
/* 167 */         }
/* 168 */
/* 169 */         if (!inputadapter_isNull2) {
/* 170 */           agg_value24 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value24);
/* 171 */         }
/* 172 */
/* 173 */         if (!inputadapter_isNull3) {
/* 174 */           agg_value24 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value24);
/* 175 */         }
/* 176 */         if (true) {
/* 177 */           // try to get the buffer from hash map
/* 178 */           agg_unsafeRowAggBuffer =
/* 179 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value24);
/* 180 */         }
/* 181 */         if (agg_unsafeRowAggBuffer == null) {
/* 182 */           if (agg_sorter == null) {
/* 183 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 184 */           } else {
/* 185 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 186 */           }
/* 187 */
/* 188 */           // the hash map had be spilled, it should have enough memory now,
/* 189 */           // try  to allocate buffer again.
/* 190 */           agg_unsafeRowAggBuffer =
/* 191 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value24);
/* 192 */           if (agg_unsafeRowAggBuffer == null) {
/* 193 */             // failed to allocate the first page
/* 194 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 195 */           }
/* 196 */         }
/* 197 */       }
/* 198 */
/* 199 */       if (agg_fastAggBuffer != null) {
/* 200 */         // update fast row
/* 201 */
/* 202 */       } else {
/* 203 */         // update unsafe row
/* 204 */
/* 205 */         // common sub-expressions
/* 206 */         boolean agg_isNull21 = false;
/* 207 */         double agg_value29 = -1.0;
/* 208 */         if (!false) {
/* 209 */           agg_value29 = (double) 0;
/* 210 */         }
/* 211 */         // evaluate aggregate function
/* 212 */         boolean agg_isNull24 = true;
/* 213 */         double agg_value32 = -1.0;
/* 214 */
/* 215 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 216 */         double agg_value34 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 217 */         boolean agg_isNull25 = agg_isNull26;
/* 218 */         double agg_value33 = agg_value34;
/* 219 */         if (agg_isNull25) {
/* 220 */           if (!agg_isNull21) {
/* 221 */             agg_isNull25 = false;
/* 222 */             agg_value33 = agg_value29;
/* 223 */           }
/* 224 */         }
/* 225 */
/* 226 */         if (!inputadapter_isNull4) {
/* 227 */           agg_isNull24 = false; // resultCode could change nullability.
/* 228 */           agg_value32 = agg_value33 + inputadapter_value4;
/* 229 */
/* 230 */         }
/* 231 */         boolean agg_isNull23 = agg_isNull24;
/* 232 */         double agg_value31 = agg_value32;
/* 233 */         if (agg_isNull23) {
/* 234 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 235 */           double agg_value36 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 236 */           if (!agg_isNull28) {
/* 237 */             agg_isNull23 = false;
/* 238 */             agg_value31 = agg_value36;
/* 239 */           }
/* 240 */         }
/* 241 */         boolean agg_isNull30 = true;
/* 242 */         double agg_value38 = -1.0;
/* 243 */
/* 244 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 245 */         double agg_value40 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 246 */         boolean agg_isNull31 = agg_isNull32;
/* 247 */         double agg_value39 = agg_value40;
/* 248 */         if (agg_isNull31) {
/* 249 */           if (!agg_isNull21) {
/* 250 */             agg_isNull31 = false;
/* 251 */             agg_value39 = agg_value29;
/* 252 */           }
/* 253 */         }
/* 254 */
/* 255 */         if (!inputadapter_isNull5) {
/* 256 */           agg_isNull30 = false; // resultCode could change nullability.
/* 257 */           agg_value38 = agg_value39 + inputadapter_value5;
/* 258 */
/* 259 */         }
/* 260 */         boolean agg_isNull29 = agg_isNull30;
/* 261 */         double agg_value37 = agg_value38;
/* 262 */         if (agg_isNull29) {
/* 263 */           boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 264 */           double agg_value42 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 265 */           if (!agg_isNull34) {
/* 266 */             agg_isNull29 = false;
/* 267 */             agg_value37 = agg_value42;
/* 268 */           }
/* 269 */         }
/* 270 */         boolean agg_isNull36 = true;
/* 271 */         double agg_value44 = -1.0;
/* 272 */
/* 273 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 274 */         double agg_value46 = agg_isNull38 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 275 */         boolean agg_isNull37 = agg_isNull38;
/* 276 */         double agg_value45 = agg_value46;
/* 277 */         if (agg_isNull37) {
/* 278 */           if (!agg_isNull21) {
/* 279 */             agg_isNull37 = false;
/* 280 */             agg_value45 = agg_value29;
/* 281 */           }
/* 282 */         }
/* 283 */
/* 284 */         if (!inputadapter_isNull6) {
/* 285 */           agg_isNull36 = false; // resultCode could change nullability.
/* 286 */           agg_value44 = agg_value45 + inputadapter_value6;
/* 287 */
/* 288 */         }
/* 289 */         boolean agg_isNull35 = agg_isNull36;
/* 290 */         double agg_value43 = agg_value44;
/* 291 */         if (agg_isNull35) {
/* 292 */           boolean agg_isNull40 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 293 */           double agg_value48 = agg_isNull40 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 294 */           if (!agg_isNull40) {
/* 295 */             agg_isNull35 = false;
/* 296 */             agg_value43 = agg_value48;
/* 297 */           }
/* 298 */         }
/* 299 */         boolean agg_isNull42 = true;
/* 300 */         double agg_value50 = -1.0;
/* 301 */
/* 302 */         boolean agg_isNull44 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 303 */         double agg_value52 = agg_isNull44 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 304 */         boolean agg_isNull43 = agg_isNull44;
/* 305 */         double agg_value51 = agg_value52;
/* 306 */         if (agg_isNull43) {
/* 307 */           if (!agg_isNull21) {
/* 308 */             agg_isNull43 = false;
/* 309 */             agg_value51 = agg_value29;
/* 310 */           }
/* 311 */         }
/* 312 */
/* 313 */         if (!inputadapter_isNull7) {
/* 314 */           agg_isNull42 = false; // resultCode could change nullability.
/* 315 */           agg_value50 = agg_value51 + inputadapter_value7;
/* 316 */
/* 317 */         }
/* 318 */         boolean agg_isNull41 = agg_isNull42;
/* 319 */         double agg_value49 = agg_value50;
/* 320 */         if (agg_isNull41) {
/* 321 */           boolean agg_isNull46 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 322 */           double agg_value54 = agg_isNull46 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 323 */           if (!agg_isNull46) {
/* 324 */             agg_isNull41 = false;
/* 325 */             agg_value49 = agg_value54;
/* 326 */           }
/* 327 */         }
/* 328 */         boolean agg_isNull48 = true;
/* 329 */         double agg_value56 = -1.0;
/* 330 */
/* 331 */         boolean agg_isNull50 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 332 */         double agg_value58 = agg_isNull50 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 333 */         boolean agg_isNull49 = agg_isNull50;
/* 334 */         double agg_value57 = agg_value58;
/* 335 */         if (agg_isNull49) {
/* 336 */           if (!agg_isNull21) {
/* 337 */             agg_isNull49 = false;
/* 338 */             agg_value57 = agg_value29;
/* 339 */           }
/* 340 */         }
/* 341 */
/* 342 */         if (!inputadapter_isNull8) {
/* 343 */           agg_isNull48 = false; // resultCode could change nullability.
/* 344 */           agg_value56 = agg_value57 + inputadapter_value8;
/* 345 */
/* 346 */         }
/* 347 */         boolean agg_isNull47 = agg_isNull48;
/* 348 */         double agg_value55 = agg_value56;
/* 349 */         if (agg_isNull47) {
/* 350 */           boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 351 */           double agg_value60 = agg_isNull52 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 352 */           if (!agg_isNull52) {
/* 353 */             agg_isNull47 = false;
/* 354 */             agg_value55 = agg_value60;
/* 355 */           }
/* 356 */         }
/* 357 */         boolean agg_isNull54 = true;
/* 358 */         double agg_value62 = -1.0;
/* 359 */
/* 360 */         boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 361 */         double agg_value64 = agg_isNull56 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 362 */         boolean agg_isNull55 = agg_isNull56;
/* 363 */         double agg_value63 = agg_value64;
/* 364 */         if (agg_isNull55) {
/* 365 */           if (!agg_isNull21) {
/* 366 */             agg_isNull55 = false;
/* 367 */             agg_value63 = agg_value29;
/* 368 */           }
/* 369 */         }
/* 370 */
/* 371 */         if (!inputadapter_isNull9) {
/* 372 */           agg_isNull54 = false; // resultCode could change nullability.
/* 373 */           agg_value62 = agg_value63 + inputadapter_value9;
/* 374 */
/* 375 */         }
/* 376 */         boolean agg_isNull53 = agg_isNull54;
/* 377 */         double agg_value61 = agg_value62;
/* 378 */         if (agg_isNull53) {
/* 379 */           boolean agg_isNull58 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 380 */           double agg_value66 = agg_isNull58 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 381 */           if (!agg_isNull58) {
/* 382 */             agg_isNull53 = false;
/* 383 */             agg_value61 = agg_value66;
/* 384 */           }
/* 385 */         }
/* 386 */         boolean agg_isNull60 = true;
/* 387 */         double agg_value68 = -1.0;
/* 388 */
/* 389 */         boolean agg_isNull62 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 390 */         double agg_value70 = agg_isNull62 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 391 */         boolean agg_isNull61 = agg_isNull62;
/* 392 */         double agg_value69 = agg_value70;
/* 393 */         if (agg_isNull61) {
/* 394 */           if (!agg_isNull21) {
/* 395 */             agg_isNull61 = false;
/* 396 */             agg_value69 = agg_value29;
/* 397 */           }
/* 398 */         }
/* 399 */
/* 400 */         if (!inputadapter_isNull10) {
/* 401 */           agg_isNull60 = false; // resultCode could change nullability.
/* 402 */           agg_value68 = agg_value69 + inputadapter_value10;
/* 403 */
/* 404 */         }
/* 405 */         boolean agg_isNull59 = agg_isNull60;
/* 406 */         double agg_value67 = agg_value68;
/* 407 */         if (agg_isNull59) {
/* 408 */           boolean agg_isNull64 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 409 */           double agg_value72 = agg_isNull64 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 410 */           if (!agg_isNull64) {
/* 411 */             agg_isNull59 = false;
/* 412 */             agg_value67 = agg_value72;
/* 413 */           }
/* 414 */         }
/* 415 */         boolean agg_isNull66 = true;
/* 416 */         double agg_value74 = -1.0;
/* 417 */
/* 418 */         boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 419 */         double agg_value76 = agg_isNull68 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 420 */         boolean agg_isNull67 = agg_isNull68;
/* 421 */         double agg_value75 = agg_value76;
/* 422 */         if (agg_isNull67) {
/* 423 */           if (!agg_isNull21) {
/* 424 */             agg_isNull67 = false;
/* 425 */             agg_value75 = agg_value29;
/* 426 */           }
/* 427 */         }
/* 428 */
/* 429 */         if (!inputadapter_isNull11) {
/* 430 */           agg_isNull66 = false; // resultCode could change nullability.
/* 431 */           agg_value74 = agg_value75 + inputadapter_value11;
/* 432 */
/* 433 */         }
/* 434 */         boolean agg_isNull65 = agg_isNull66;
/* 435 */         double agg_value73 = agg_value74;
/* 436 */         if (agg_isNull65) {
/* 437 */           boolean agg_isNull70 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 438 */           double agg_value78 = agg_isNull70 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 439 */           if (!agg_isNull70) {
/* 440 */             agg_isNull65 = false;
/* 441 */             agg_value73 = agg_value78;
/* 442 */           }
/* 443 */         }
/* 444 */         // update unsafe row buffer
/* 445 */         if (!agg_isNull23) {
/* 446 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value31);
/* 447 */         } else {
/* 448 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 449 */         }
/* 450 */
/* 451 */         if (!agg_isNull29) {
/* 452 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value37);
/* 453 */         } else {
/* 454 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 455 */         }
/* 456 */
/* 457 */         if (!agg_isNull35) {
/* 458 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value43);
/* 459 */         } else {
/* 460 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 461 */         }
/* 462 */
/* 463 */         if (!agg_isNull41) {
/* 464 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value49);
/* 465 */         } else {
/* 466 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 467 */         }
/* 468 */
/* 469 */         if (!agg_isNull47) {
/* 470 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value55);
/* 471 */         } else {
/* 472 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 473 */         }
/* 474 */
/* 475 */         if (!agg_isNull53) {
/* 476 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value61);
/* 477 */         } else {
/* 478 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 479 */         }
/* 480 */
/* 481 */         if (!agg_isNull59) {
/* 482 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value67);
/* 483 */         } else {
/* 484 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 485 */         }
/* 486 */
/* 487 */         if (!agg_isNull65) {
/* 488 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value73);
/* 489 */         } else {
/* 490 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 491 */         }
/* 492 */
/* 493 */       }
/* 494 */       if (shouldStop()) return;
/* 495 */     }
/* 496 */
/* 497 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 498 */   }
/* 499 */
/* 500 */   private void wholestagecodegen_init_2() {
/* 501 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 15);
/* 502 */     project_result1 = new UnsafeRow(13);
/* 503 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 128);
/* 504 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 13);
/* 505 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 506 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 507 */
/* 508 */   }
/* 509 */
/* 510 */   private void wholestagecodegen_init_1() {
/* 511 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 512 */     bhj_result = new UnsafeRow(15);
/* 513 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 514 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 15);
/* 515 */     project_result = new UnsafeRow(13);
/* 516 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 517 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 13);
/* 518 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 519 */
/* 520 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 521 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 522 */
/* 523 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 524 */     bhj_result1 = new UnsafeRow(15);
/* 525 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 128);
/* 526 */
/* 527 */   }
/* 528 */
/* 529 */   protected void processNext() throws java.io.IOException {
/* 530 */     if (!agg_initAgg) {
/* 531 */       agg_initAgg = true;
/* 532 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 533 */       agg_doAggregateWithKeys();
/* 534 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 535 */     }
/* 536 */
/* 537 */     // output the result
/* 538 */
/* 539 */     while (agg_mapIter.next()) {
/* 540 */       wholestagecodegen_numOutputRows.add(1);
/* 541 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 542 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 543 */
/* 544 */       boolean agg_isNull71 = agg_aggKey.isNullAt(0);
/* 545 */       int agg_value79 = agg_isNull71 ? -1 : (agg_aggKey.getInt(0));
/* 546 */       boolean agg_isNull72 = agg_aggKey.isNullAt(1);
/* 547 */       int agg_value80 = agg_isNull72 ? -1 : (agg_aggKey.getInt(1));
/* 548 */       boolean agg_isNull73 = agg_aggKey.isNullAt(2);
/* 549 */       int agg_value81 = agg_isNull73 ? -1 : (agg_aggKey.getInt(2));
/* 550 */       boolean agg_isNull74 = agg_aggKey.isNullAt(3);
/* 551 */       UTF8String agg_value82 = agg_isNull74 ? null : (agg_aggKey.getUTF8String(3));
/* 552 */       boolean agg_isNull75 = agg_aggBuffer.isNullAt(0);
/* 553 */       double agg_value83 = agg_isNull75 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 554 */       boolean agg_isNull76 = agg_aggBuffer.isNullAt(1);
/* 555 */       double agg_value84 = agg_isNull76 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 556 */       boolean agg_isNull77 = agg_aggBuffer.isNullAt(2);
/* 557 */       double agg_value85 = agg_isNull77 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 558 */       boolean agg_isNull78 = agg_aggBuffer.isNullAt(3);
/* 559 */       double agg_value86 = agg_isNull78 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 560 */       boolean agg_isNull79 = agg_aggBuffer.isNullAt(4);
/* 561 */       double agg_value87 = agg_isNull79 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 562 */       boolean agg_isNull80 = agg_aggBuffer.isNullAt(5);
/* 563 */       double agg_value88 = agg_isNull80 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 564 */       boolean agg_isNull81 = agg_aggBuffer.isNullAt(6);
/* 565 */       double agg_value89 = agg_isNull81 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 566 */       boolean agg_isNull82 = agg_aggBuffer.isNullAt(7);
/* 567 */       double agg_value90 = agg_isNull82 ? -1.0 : (agg_aggBuffer.getDouble(7));
/* 568 */
/* 569 */       // generate join key for stream side
/* 570 */
/* 571 */       boolean bhj_isNull = agg_isNull72;
/* 572 */       long bhj_value = -1L;
/* 573 */       if (!agg_isNull72) {
/* 574 */         bhj_value = (long) agg_value80;
/* 575 */       }
/* 576 */       // find matches from HashedRelation
/* 577 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 578 */       if (bhj_matched == null) continue;
/* 579 */
/* 580 */       bhj_numOutputRows.add(1);
/* 581 */
/* 582 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 583 */       int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 584 */
/* 585 */       // generate join key for stream side
/* 586 */
/* 587 */       boolean bhj_isNull21 = bhj_isNull3;
/* 588 */       long bhj_value21 = -1L;
/* 589 */       if (!bhj_isNull3) {
/* 590 */         bhj_value21 = (long) bhj_value3;
/* 591 */       }
/* 592 */       // find matches from HashedRelation
/* 593 */       UnsafeRow bhj_matched1 = bhj_isNull21 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value21);
/* 594 */       if (bhj_matched1 == null) continue;
/* 595 */
/* 596 */       boolean bhj_isNull24 = bhj_matched1.isNullAt(1);
/* 597 */       UTF8String bhj_value24 = bhj_isNull24 ? null : (bhj_matched1.getUTF8String(1));
/* 598 */
/* 599 */       boolean bhj_isNull26 = true;
/* 600 */       boolean bhj_value26 = false;
/* 601 */
/* 602 */       if (!bhj_isNull24) {
/* 603 */         if (!agg_isNull74) {
/* 604 */           bhj_isNull26 = false; // resultCode could change nullability.
/* 605 */           bhj_value26 = bhj_value24.equals(agg_value82);
/* 606 */
/* 607 */         }
/* 608 */
/* 609 */       }
/* 610 */       boolean bhj_isNull25 = bhj_isNull26;
/* 611 */       boolean bhj_value25 = false;
/* 612 */
/* 613 */       if (!bhj_isNull26) {
/* 614 */         bhj_value25 = !(bhj_value26);
/* 615 */       }
/* 616 */       if (bhj_isNull25 || !bhj_value25) continue;
/* 617 */
/* 618 */       bhj_numOutputRows1.add(1);
/* 619 */
/* 620 */       boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 621 */       UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 622 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 623 */       UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 624 */       project_holder1.reset();
/* 625 */
/* 626 */       project_rowWriter1.zeroOutNullBytes();
/* 627 */
/* 628 */       if (bhj_isNull5) {
/* 629 */         project_rowWriter1.setNullAt(0);
/* 630 */       } else {
/* 631 */         project_rowWriter1.write(0, bhj_value5);
/* 632 */       }
/* 633 */
/* 634 */       if (bhj_isNull4) {
/* 635 */         project_rowWriter1.setNullAt(1);
/* 636 */       } else {
/* 637 */         project_rowWriter1.write(1, bhj_value4);
/* 638 */       }
/* 639 */
/* 640 */       if (bhj_isNull24) {
/* 641 */         project_rowWriter1.setNullAt(2);
/* 642 */       } else {
/* 643 */         project_rowWriter1.write(2, bhj_value24);
/* 644 */       }
/* 645 */
/* 646 */       if (agg_isNull74) {
/* 647 */         project_rowWriter1.setNullAt(3);
/* 648 */       } else {
/* 649 */         project_rowWriter1.write(3, agg_value82);
/* 650 */       }
/* 651 */
/* 652 */       if (agg_isNull71) {
/* 653 */         project_rowWriter1.setNullAt(4);
/* 654 */       } else {
/* 655 */         project_rowWriter1.write(4, agg_value79);
/* 656 */       }
/* 657 */
/* 658 */       if (agg_isNull75) {
/* 659 */         project_rowWriter1.setNullAt(5);
/* 660 */       } else {
/* 661 */         project_rowWriter1.write(5, agg_value83);
/* 662 */       }
/* 663 */
/* 664 */       if (agg_isNull76) {
/* 665 */         project_rowWriter1.setNullAt(6);
/* 666 */       } else {
/* 667 */         project_rowWriter1.write(6, agg_value84);
/* 668 */       }
/* 669 */
/* 670 */       if (agg_isNull77) {
/* 671 */         project_rowWriter1.setNullAt(7);
/* 672 */       } else {
/* 673 */         project_rowWriter1.write(7, agg_value85);
/* 674 */       }
/* 675 */
/* 676 */       if (agg_isNull78) {
/* 677 */         project_rowWriter1.setNullAt(8);
/* 678 */       } else {
/* 679 */         project_rowWriter1.write(8, agg_value86);
/* 680 */       }
/* 681 */
/* 682 */       if (agg_isNull79) {
/* 683 */         project_rowWriter1.setNullAt(9);
/* 684 */       } else {
/* 685 */         project_rowWriter1.write(9, agg_value87);
/* 686 */       }
/* 687 */
/* 688 */       if (agg_isNull80) {
/* 689 */         project_rowWriter1.setNullAt(10);
/* 690 */       } else {
/* 691 */         project_rowWriter1.write(10, agg_value88);
/* 692 */       }
/* 693 */
/* 694 */       if (agg_isNull81) {
/* 695 */         project_rowWriter1.setNullAt(11);
/* 696 */       } else {
/* 697 */         project_rowWriter1.write(11, agg_value89);
/* 698 */       }
/* 699 */
/* 700 */       if (agg_isNull82) {
/* 701 */         project_rowWriter1.setNullAt(12);
/* 702 */       } else {
/* 703 */         project_rowWriter1.write(12, agg_value90);
/* 704 */       }
/* 705 */       project_result1.setTotalSize(project_holder1.totalSize());
/* 706 */       append(project_result1);
/* 707 */
/* 708 */       if (shouldStop()) return;
/* 709 */     }
/* 710 */
/* 711 */     agg_mapIter.close();
/* 712 */     if (agg_sorter == null) {
/* 713 */       agg_hashMap.free();
/* 714 */     }
/* 715 */   }
/* 716 */ }
