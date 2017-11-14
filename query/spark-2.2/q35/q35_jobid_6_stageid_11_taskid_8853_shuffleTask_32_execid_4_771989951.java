/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private int agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private int agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private long agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private int agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private int agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private double agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private long agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private long agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private int agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private int agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private double agg_bufValue13;
/* 037 */   private boolean agg_bufIsNull14;
/* 038 */   private long agg_bufValue14;
/* 039 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 040 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 041 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 042 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 045 */   private scala.collection.Iterator inputadapter_input;
/* 046 */   private UnsafeRow agg_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 049 */   private int agg_value45;
/* 050 */   private UnsafeRow agg_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 054 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 055 */
/* 056 */   public GeneratedIterator(Object[] references) {
/* 057 */     this.references = references;
/* 058 */   }
/* 059 */
/* 060 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 061 */     partitionIndex = index;
/* 062 */     this.inputs = inputs;
/* 063 */     agg_initAgg = false;
/* 064 */
/* 065 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 066 */
/* 067 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 068 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 069 */     inputadapter_input = inputs[0];
/* 070 */     agg_result = new UnsafeRow(6);
/* 071 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 072 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 073 */
/* 074 */     agg_result1 = new UnsafeRow(18);
/* 075 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 076 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 18);
/* 077 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 078 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 083 */     agg_hashMap = agg_plan.createHashMap();
/* 084 */
/* 085 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 086 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 087 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 088 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 089 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 090 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 091 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 092 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 093 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 094 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 095 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 096 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 097 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 098 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 099 */       long inputadapter_value6 = inputadapter_row.getLong(6);
/* 100 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 101 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 102 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 103 */       int inputadapter_value8 = inputadapter_isNull8 ? -1 : (inputadapter_row.getInt(8));
/* 104 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 105 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 106 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 107 */       long inputadapter_value10 = inputadapter_isNull10 ? -1L : (inputadapter_row.getLong(10));
/* 108 */       long inputadapter_value11 = inputadapter_row.getLong(11);
/* 109 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 110 */       int inputadapter_value12 = inputadapter_isNull12 ? -1 : (inputadapter_row.getInt(12));
/* 111 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 112 */       int inputadapter_value13 = inputadapter_isNull13 ? -1 : (inputadapter_row.getInt(13));
/* 113 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 114 */       double inputadapter_value14 = inputadapter_isNull14 ? -1.0 : (inputadapter_row.getDouble(14));
/* 115 */       boolean inputadapter_isNull15 = inputadapter_row.isNullAt(15);
/* 116 */       long inputadapter_value15 = inputadapter_isNull15 ? -1L : (inputadapter_row.getLong(15));
/* 117 */       long inputadapter_value16 = inputadapter_row.getLong(16);
/* 118 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 119 */       int inputadapter_value17 = inputadapter_isNull17 ? -1 : (inputadapter_row.getInt(17));
/* 120 */       boolean inputadapter_isNull18 = inputadapter_row.isNullAt(18);
/* 121 */       int inputadapter_value18 = inputadapter_isNull18 ? -1 : (inputadapter_row.getInt(18));
/* 122 */       boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 123 */       double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 124 */       boolean inputadapter_isNull20 = inputadapter_row.isNullAt(20);
/* 125 */       long inputadapter_value20 = inputadapter_isNull20 ? -1L : (inputadapter_row.getLong(20));
/* 126 */
/* 127 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 128 */
/* 129 */       UnsafeRow agg_fastAggBuffer = null;
/* 130 */
/* 131 */       if (agg_fastAggBuffer == null) {
/* 132 */         // generate grouping key
/* 133 */         agg_holder.reset();
/* 134 */
/* 135 */         agg_rowWriter.zeroOutNullBytes();
/* 136 */
/* 137 */         if (inputadapter_isNull) {
/* 138 */           agg_rowWriter.setNullAt(0);
/* 139 */         } else {
/* 140 */           agg_rowWriter.write(0, inputadapter_value);
/* 141 */         }
/* 142 */
/* 143 */         if (inputadapter_isNull1) {
/* 144 */           agg_rowWriter.setNullAt(1);
/* 145 */         } else {
/* 146 */           agg_rowWriter.write(1, inputadapter_value1);
/* 147 */         }
/* 148 */
/* 149 */         if (inputadapter_isNull2) {
/* 150 */           agg_rowWriter.setNullAt(2);
/* 151 */         } else {
/* 152 */           agg_rowWriter.write(2, inputadapter_value2);
/* 153 */         }
/* 154 */
/* 155 */         if (inputadapter_isNull3) {
/* 156 */           agg_rowWriter.setNullAt(3);
/* 157 */         } else {
/* 158 */           agg_rowWriter.write(3, inputadapter_value3);
/* 159 */         }
/* 160 */
/* 161 */         if (inputadapter_isNull4) {
/* 162 */           agg_rowWriter.setNullAt(4);
/* 163 */         } else {
/* 164 */           agg_rowWriter.write(4, inputadapter_value4);
/* 165 */         }
/* 166 */
/* 167 */         if (inputadapter_isNull5) {
/* 168 */           agg_rowWriter.setNullAt(5);
/* 169 */         } else {
/* 170 */           agg_rowWriter.write(5, inputadapter_value5);
/* 171 */         }
/* 172 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 173 */         agg_value45 = 42;
/* 174 */
/* 175 */         if (!inputadapter_isNull) {
/* 176 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value45);
/* 177 */         }
/* 178 */
/* 179 */         if (!inputadapter_isNull1) {
/* 180 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value45);
/* 181 */         }
/* 182 */
/* 183 */         if (!inputadapter_isNull2) {
/* 184 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value45);
/* 185 */         }
/* 186 */
/* 187 */         if (!inputadapter_isNull3) {
/* 188 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value45);
/* 189 */         }
/* 190 */
/* 191 */         if (!inputadapter_isNull4) {
/* 192 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value45);
/* 193 */         }
/* 194 */
/* 195 */         if (!inputadapter_isNull5) {
/* 196 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value5, agg_value45);
/* 197 */         }
/* 198 */         if (true) {
/* 199 */           // try to get the buffer from hash map
/* 200 */           agg_unsafeRowAggBuffer =
/* 201 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value45);
/* 202 */         }
/* 203 */         if (agg_unsafeRowAggBuffer == null) {
/* 204 */           if (agg_sorter == null) {
/* 205 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 206 */           } else {
/* 207 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 208 */           }
/* 209 */
/* 210 */           // the hash map had be spilled, it should have enough memory now,
/* 211 */           // try  to allocate buffer again.
/* 212 */           agg_unsafeRowAggBuffer =
/* 213 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value45);
/* 214 */           if (agg_unsafeRowAggBuffer == null) {
/* 215 */             // failed to allocate the first page
/* 216 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 217 */           }
/* 218 */         }
/* 219 */       }
/* 220 */
/* 221 */       if (agg_fastAggBuffer != null) {
/* 222 */         // update fast row
/* 223 */
/* 224 */       } else {
/* 225 */         // update unsafe row
/* 226 */
/* 227 */         // common sub-expressions
/* 228 */
/* 229 */         // evaluate aggregate function
/* 230 */         boolean agg_isNull37 = false;
/* 231 */
/* 232 */         long agg_value53 = agg_unsafeRowAggBuffer.getLong(0);
/* 233 */
/* 234 */         long agg_value52 = -1L;
/* 235 */         agg_value52 = agg_value53 + inputadapter_value6;
/* 236 */         boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 237 */         int agg_value56 = agg_isNull41 ? -1 : (agg_unsafeRowAggBuffer.getInt(1));
/* 238 */         boolean agg_isNull40 = agg_isNull41;
/* 239 */         int agg_value55 = agg_value56;
/* 240 */
/* 241 */         if (!inputadapter_isNull7 && (agg_isNull40 ||
/* 242 */             agg_value55 > inputadapter_value7)) {
/* 243 */           agg_isNull40 = false;
/* 244 */           agg_value55 = inputadapter_value7;
/* 245 */         }
/* 246 */         boolean agg_isNull44 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 247 */         int agg_value59 = agg_isNull44 ? -1 : (agg_unsafeRowAggBuffer.getInt(2));
/* 248 */         boolean agg_isNull43 = agg_isNull44;
/* 249 */         int agg_value58 = agg_value59;
/* 250 */
/* 251 */         if (!inputadapter_isNull8 && (agg_isNull43 ||
/* 252 */             inputadapter_value8 > agg_value58)) {
/* 253 */           agg_isNull43 = false;
/* 254 */           agg_value58 = inputadapter_value8;
/* 255 */         }
/* 256 */         boolean agg_isNull46 = true;
/* 257 */         double agg_value61 = -1.0;
/* 258 */
/* 259 */         boolean agg_isNull47 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 260 */         double agg_value62 = agg_isNull47 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 261 */         if (!agg_isNull47) {
/* 262 */           if (!inputadapter_isNull9) {
/* 263 */             agg_isNull46 = false; // resultCode could change nullability.
/* 264 */             agg_value61 = agg_value62 + inputadapter_value9;
/* 265 */
/* 266 */           }
/* 267 */
/* 268 */         }
/* 269 */         boolean agg_isNull49 = true;
/* 270 */         long agg_value64 = -1L;
/* 271 */
/* 272 */         boolean agg_isNull50 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 273 */         long agg_value65 = agg_isNull50 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 274 */         if (!agg_isNull50) {
/* 275 */           if (!inputadapter_isNull10) {
/* 276 */             agg_isNull49 = false; // resultCode could change nullability.
/* 277 */             agg_value64 = agg_value65 + inputadapter_value10;
/* 278 */
/* 279 */           }
/* 280 */
/* 281 */         }
/* 282 */         boolean agg_isNull52 = false;
/* 283 */
/* 284 */         long agg_value68 = agg_unsafeRowAggBuffer.getLong(5);
/* 285 */
/* 286 */         long agg_value67 = -1L;
/* 287 */         agg_value67 = agg_value68 + inputadapter_value11;
/* 288 */         boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 289 */         int agg_value71 = agg_isNull56 ? -1 : (agg_unsafeRowAggBuffer.getInt(6));
/* 290 */         boolean agg_isNull55 = agg_isNull56;
/* 291 */         int agg_value70 = agg_value71;
/* 292 */
/* 293 */         if (!inputadapter_isNull12 && (agg_isNull55 ||
/* 294 */             agg_value70 > inputadapter_value12)) {
/* 295 */           agg_isNull55 = false;
/* 296 */           agg_value70 = inputadapter_value12;
/* 297 */         }
/* 298 */         boolean agg_isNull59 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 299 */         int agg_value74 = agg_isNull59 ? -1 : (agg_unsafeRowAggBuffer.getInt(7));
/* 300 */         boolean agg_isNull58 = agg_isNull59;
/* 301 */         int agg_value73 = agg_value74;
/* 302 */
/* 303 */         if (!inputadapter_isNull13 && (agg_isNull58 ||
/* 304 */             inputadapter_value13 > agg_value73)) {
/* 305 */           agg_isNull58 = false;
/* 306 */           agg_value73 = inputadapter_value13;
/* 307 */         }
/* 308 */         boolean agg_isNull61 = true;
/* 309 */         double agg_value76 = -1.0;
/* 310 */
/* 311 */         boolean agg_isNull62 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 312 */         double agg_value77 = agg_isNull62 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 313 */         if (!agg_isNull62) {
/* 314 */           if (!inputadapter_isNull14) {
/* 315 */             agg_isNull61 = false; // resultCode could change nullability.
/* 316 */             agg_value76 = agg_value77 + inputadapter_value14;
/* 317 */
/* 318 */           }
/* 319 */
/* 320 */         }
/* 321 */         boolean agg_isNull64 = true;
/* 322 */         long agg_value79 = -1L;
/* 323 */
/* 324 */         boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 325 */         long agg_value80 = agg_isNull65 ? -1L : (agg_unsafeRowAggBuffer.getLong(9));
/* 326 */         if (!agg_isNull65) {
/* 327 */           if (!inputadapter_isNull15) {
/* 328 */             agg_isNull64 = false; // resultCode could change nullability.
/* 329 */             agg_value79 = agg_value80 + inputadapter_value15;
/* 330 */
/* 331 */           }
/* 332 */
/* 333 */         }
/* 334 */         boolean agg_isNull67 = false;
/* 335 */
/* 336 */         long agg_value83 = agg_unsafeRowAggBuffer.getLong(10);
/* 337 */
/* 338 */         long agg_value82 = -1L;
/* 339 */         agg_value82 = agg_value83 + inputadapter_value16;
/* 340 */         boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 341 */         int agg_value86 = agg_isNull71 ? -1 : (agg_unsafeRowAggBuffer.getInt(11));
/* 342 */         boolean agg_isNull70 = agg_isNull71;
/* 343 */         int agg_value85 = agg_value86;
/* 344 */
/* 345 */         if (!inputadapter_isNull17 && (agg_isNull70 ||
/* 346 */             agg_value85 > inputadapter_value17)) {
/* 347 */           agg_isNull70 = false;
/* 348 */           agg_value85 = inputadapter_value17;
/* 349 */         }
/* 350 */         boolean agg_isNull74 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 351 */         int agg_value89 = agg_isNull74 ? -1 : (agg_unsafeRowAggBuffer.getInt(12));
/* 352 */         boolean agg_isNull73 = agg_isNull74;
/* 353 */         int agg_value88 = agg_value89;
/* 354 */
/* 355 */         if (!inputadapter_isNull18 && (agg_isNull73 ||
/* 356 */             inputadapter_value18 > agg_value88)) {
/* 357 */           agg_isNull73 = false;
/* 358 */           agg_value88 = inputadapter_value18;
/* 359 */         }
/* 360 */         boolean agg_isNull76 = true;
/* 361 */         double agg_value91 = -1.0;
/* 362 */
/* 363 */         boolean agg_isNull77 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 364 */         double agg_value92 = agg_isNull77 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 365 */         if (!agg_isNull77) {
/* 366 */           if (!inputadapter_isNull19) {
/* 367 */             agg_isNull76 = false; // resultCode could change nullability.
/* 368 */             agg_value91 = agg_value92 + inputadapter_value19;
/* 369 */
/* 370 */           }
/* 371 */
/* 372 */         }
/* 373 */         boolean agg_isNull79 = true;
/* 374 */         long agg_value94 = -1L;
/* 375 */
/* 376 */         boolean agg_isNull80 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 377 */         long agg_value95 = agg_isNull80 ? -1L : (agg_unsafeRowAggBuffer.getLong(14));
/* 378 */         if (!agg_isNull80) {
/* 379 */           if (!inputadapter_isNull20) {
/* 380 */             agg_isNull79 = false; // resultCode could change nullability.
/* 381 */             agg_value94 = agg_value95 + inputadapter_value20;
/* 382 */
/* 383 */           }
/* 384 */
/* 385 */         }
/* 386 */         // update unsafe row buffer
/* 387 */         agg_unsafeRowAggBuffer.setLong(0, agg_value52);
/* 388 */
/* 389 */         if (!agg_isNull40) {
/* 390 */           agg_unsafeRowAggBuffer.setInt(1, agg_value55);
/* 391 */         } else {
/* 392 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 393 */         }
/* 394 */
/* 395 */         if (!agg_isNull43) {
/* 396 */           agg_unsafeRowAggBuffer.setInt(2, agg_value58);
/* 397 */         } else {
/* 398 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 399 */         }
/* 400 */
/* 401 */         if (!agg_isNull46) {
/* 402 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value61);
/* 403 */         } else {
/* 404 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 405 */         }
/* 406 */
/* 407 */         if (!agg_isNull49) {
/* 408 */           agg_unsafeRowAggBuffer.setLong(4, agg_value64);
/* 409 */         } else {
/* 410 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 411 */         }
/* 412 */
/* 413 */         agg_unsafeRowAggBuffer.setLong(5, agg_value67);
/* 414 */
/* 415 */         if (!agg_isNull55) {
/* 416 */           agg_unsafeRowAggBuffer.setInt(6, agg_value70);
/* 417 */         } else {
/* 418 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 419 */         }
/* 420 */
/* 421 */         if (!agg_isNull58) {
/* 422 */           agg_unsafeRowAggBuffer.setInt(7, agg_value73);
/* 423 */         } else {
/* 424 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 425 */         }
/* 426 */
/* 427 */         if (!agg_isNull61) {
/* 428 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value76);
/* 429 */         } else {
/* 430 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 431 */         }
/* 432 */
/* 433 */         if (!agg_isNull64) {
/* 434 */           agg_unsafeRowAggBuffer.setLong(9, agg_value79);
/* 435 */         } else {
/* 436 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 437 */         }
/* 438 */
/* 439 */         agg_unsafeRowAggBuffer.setLong(10, agg_value82);
/* 440 */
/* 441 */         if (!agg_isNull70) {
/* 442 */           agg_unsafeRowAggBuffer.setInt(11, agg_value85);
/* 443 */         } else {
/* 444 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 445 */         }
/* 446 */
/* 447 */         if (!agg_isNull73) {
/* 448 */           agg_unsafeRowAggBuffer.setInt(12, agg_value88);
/* 449 */         } else {
/* 450 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 451 */         }
/* 452 */
/* 453 */         if (!agg_isNull76) {
/* 454 */           agg_unsafeRowAggBuffer.setDouble(13, agg_value91);
/* 455 */         } else {
/* 456 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 457 */         }
/* 458 */
/* 459 */         if (!agg_isNull79) {
/* 460 */           agg_unsafeRowAggBuffer.setLong(14, agg_value94);
/* 461 */         } else {
/* 462 */           agg_unsafeRowAggBuffer.setNullAt(14);
/* 463 */         }
/* 464 */
/* 465 */       }
/* 466 */       if (shouldStop()) return;
/* 467 */     }
/* 468 */
/* 469 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 470 */   }
/* 471 */
/* 472 */   protected void processNext() throws java.io.IOException {
/* 473 */     if (!agg_initAgg) {
/* 474 */       agg_initAgg = true;
/* 475 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 476 */       agg_doAggregateWithKeys();
/* 477 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 478 */     }
/* 479 */
/* 480 */     // output the result
/* 481 */
/* 482 */     while (agg_mapIter.next()) {
/* 483 */       wholestagecodegen_numOutputRows.add(1);
/* 484 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 485 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 486 */
/* 487 */       boolean agg_isNull82 = agg_aggKey.isNullAt(0);
/* 488 */       UTF8String agg_value97 = agg_isNull82 ? null : (agg_aggKey.getUTF8String(0));
/* 489 */       boolean agg_isNull83 = agg_aggKey.isNullAt(1);
/* 490 */       UTF8String agg_value98 = agg_isNull83 ? null : (agg_aggKey.getUTF8String(1));
/* 491 */       boolean agg_isNull84 = agg_aggKey.isNullAt(2);
/* 492 */       UTF8String agg_value99 = agg_isNull84 ? null : (agg_aggKey.getUTF8String(2));
/* 493 */       boolean agg_isNull85 = agg_aggKey.isNullAt(3);
/* 494 */       int agg_value100 = agg_isNull85 ? -1 : (agg_aggKey.getInt(3));
/* 495 */       boolean agg_isNull86 = agg_aggKey.isNullAt(4);
/* 496 */       int agg_value101 = agg_isNull86 ? -1 : (agg_aggKey.getInt(4));
/* 497 */       boolean agg_isNull87 = agg_aggKey.isNullAt(5);
/* 498 */       int agg_value102 = agg_isNull87 ? -1 : (agg_aggKey.getInt(5));
/* 499 */       long agg_value103 = agg_aggBuffer.getLong(0);
/* 500 */       boolean agg_isNull89 = agg_aggBuffer.isNullAt(1);
/* 501 */       int agg_value104 = agg_isNull89 ? -1 : (agg_aggBuffer.getInt(1));
/* 502 */       boolean agg_isNull90 = agg_aggBuffer.isNullAt(2);
/* 503 */       int agg_value105 = agg_isNull90 ? -1 : (agg_aggBuffer.getInt(2));
/* 504 */       boolean agg_isNull91 = agg_aggBuffer.isNullAt(3);
/* 505 */       double agg_value106 = agg_isNull91 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 506 */       boolean agg_isNull92 = agg_aggBuffer.isNullAt(4);
/* 507 */       long agg_value107 = agg_isNull92 ? -1L : (agg_aggBuffer.getLong(4));
/* 508 */       long agg_value108 = agg_aggBuffer.getLong(5);
/* 509 */       boolean agg_isNull94 = agg_aggBuffer.isNullAt(6);
/* 510 */       int agg_value109 = agg_isNull94 ? -1 : (agg_aggBuffer.getInt(6));
/* 511 */       boolean agg_isNull95 = agg_aggBuffer.isNullAt(7);
/* 512 */       int agg_value110 = agg_isNull95 ? -1 : (agg_aggBuffer.getInt(7));
/* 513 */       boolean agg_isNull96 = agg_aggBuffer.isNullAt(8);
/* 514 */       double agg_value111 = agg_isNull96 ? -1.0 : (agg_aggBuffer.getDouble(8));
/* 515 */       boolean agg_isNull97 = agg_aggBuffer.isNullAt(9);
/* 516 */       long agg_value112 = agg_isNull97 ? -1L : (agg_aggBuffer.getLong(9));
/* 517 */       long agg_value113 = agg_aggBuffer.getLong(10);
/* 518 */       boolean agg_isNull99 = agg_aggBuffer.isNullAt(11);
/* 519 */       int agg_value114 = agg_isNull99 ? -1 : (agg_aggBuffer.getInt(11));
/* 520 */       boolean agg_isNull100 = agg_aggBuffer.isNullAt(12);
/* 521 */       int agg_value115 = agg_isNull100 ? -1 : (agg_aggBuffer.getInt(12));
/* 522 */       boolean agg_isNull101 = agg_aggBuffer.isNullAt(13);
/* 523 */       double agg_value116 = agg_isNull101 ? -1.0 : (agg_aggBuffer.getDouble(13));
/* 524 */       boolean agg_isNull102 = agg_aggBuffer.isNullAt(14);
/* 525 */       long agg_value117 = agg_isNull102 ? -1L : (agg_aggBuffer.getLong(14));
/* 526 */       boolean agg_isNull108 = agg_isNull92;
/* 527 */       double agg_value123 = -1.0;
/* 528 */       if (!agg_isNull92) {
/* 529 */         agg_value123 = (double) agg_value107;
/* 530 */       }
/* 531 */       boolean agg_isNull106 = false;
/* 532 */       double agg_value121 = -1.0;
/* 533 */       if (agg_isNull108 || agg_value123 == 0) {
/* 534 */         agg_isNull106 = true;
/* 535 */       } else {
/* 536 */         if (agg_isNull91) {
/* 537 */           agg_isNull106 = true;
/* 538 */         } else {
/* 539 */           agg_value121 = (double)(agg_value106 / agg_value123);
/* 540 */         }
/* 541 */       }
/* 542 */       boolean agg_isNull115 = agg_isNull97;
/* 543 */       double agg_value130 = -1.0;
/* 544 */       if (!agg_isNull97) {
/* 545 */         agg_value130 = (double) agg_value112;
/* 546 */       }
/* 547 */       boolean agg_isNull113 = false;
/* 548 */       double agg_value128 = -1.0;
/* 549 */       if (agg_isNull115 || agg_value130 == 0) {
/* 550 */         agg_isNull113 = true;
/* 551 */       } else {
/* 552 */         if (agg_isNull96) {
/* 553 */           agg_isNull113 = true;
/* 554 */         } else {
/* 555 */           agg_value128 = (double)(agg_value111 / agg_value130);
/* 556 */         }
/* 557 */       }
/* 558 */       boolean agg_isNull122 = agg_isNull102;
/* 559 */       double agg_value137 = -1.0;
/* 560 */       if (!agg_isNull102) {
/* 561 */         agg_value137 = (double) agg_value117;
/* 562 */       }
/* 563 */       boolean agg_isNull120 = false;
/* 564 */       double agg_value135 = -1.0;
/* 565 */       if (agg_isNull122 || agg_value137 == 0) {
/* 566 */         agg_isNull120 = true;
/* 567 */       } else {
/* 568 */         if (agg_isNull101) {
/* 569 */           agg_isNull120 = true;
/* 570 */         } else {
/* 571 */           agg_value135 = (double)(agg_value116 / agg_value137);
/* 572 */         }
/* 573 */       }
/* 574 */
/* 575 */       agg_holder1.reset();
/* 576 */
/* 577 */       agg_rowWriter1.zeroOutNullBytes();
/* 578 */
/* 579 */       if (agg_isNull82) {
/* 580 */         agg_rowWriter1.setNullAt(0);
/* 581 */       } else {
/* 582 */         agg_rowWriter1.write(0, agg_value97);
/* 583 */       }
/* 584 */
/* 585 */       if (agg_isNull83) {
/* 586 */         agg_rowWriter1.setNullAt(1);
/* 587 */       } else {
/* 588 */         agg_rowWriter1.write(1, agg_value98);
/* 589 */       }
/* 590 */
/* 591 */       if (agg_isNull84) {
/* 592 */         agg_rowWriter1.setNullAt(2);
/* 593 */       } else {
/* 594 */         agg_rowWriter1.write(2, agg_value99);
/* 595 */       }
/* 596 */
/* 597 */       agg_rowWriter1.write(3, agg_value103);
/* 598 */
/* 599 */       if (agg_isNull89) {
/* 600 */         agg_rowWriter1.setNullAt(4);
/* 601 */       } else {
/* 602 */         agg_rowWriter1.write(4, agg_value104);
/* 603 */       }
/* 604 */
/* 605 */       if (agg_isNull90) {
/* 606 */         agg_rowWriter1.setNullAt(5);
/* 607 */       } else {
/* 608 */         agg_rowWriter1.write(5, agg_value105);
/* 609 */       }
/* 610 */
/* 611 */       if (agg_isNull106) {
/* 612 */         agg_rowWriter1.setNullAt(6);
/* 613 */       } else {
/* 614 */         agg_rowWriter1.write(6, agg_value121);
/* 615 */       }
/* 616 */
/* 617 */       if (agg_isNull86) {
/* 618 */         agg_rowWriter1.setNullAt(7);
/* 619 */       } else {
/* 620 */         agg_rowWriter1.write(7, agg_value101);
/* 621 */       }
/* 622 */
/* 623 */       agg_rowWriter1.write(8, agg_value108);
/* 624 */
/* 625 */       if (agg_isNull94) {
/* 626 */         agg_rowWriter1.setNullAt(9);
/* 627 */       } else {
/* 628 */         agg_rowWriter1.write(9, agg_value109);
/* 629 */       }
/* 630 */
/* 631 */       if (agg_isNull95) {
/* 632 */         agg_rowWriter1.setNullAt(10);
/* 633 */       } else {
/* 634 */         agg_rowWriter1.write(10, agg_value110);
/* 635 */       }
/* 636 */
/* 637 */       if (agg_isNull113) {
/* 638 */         agg_rowWriter1.setNullAt(11);
/* 639 */       } else {
/* 640 */         agg_rowWriter1.write(11, agg_value128);
/* 641 */       }
/* 642 */
/* 643 */       if (agg_isNull87) {
/* 644 */         agg_rowWriter1.setNullAt(12);
/* 645 */       } else {
/* 646 */         agg_rowWriter1.write(12, agg_value102);
/* 647 */       }
/* 648 */
/* 649 */       agg_rowWriter1.write(13, agg_value113);
/* 650 */
/* 651 */       if (agg_isNull99) {
/* 652 */         agg_rowWriter1.setNullAt(14);
/* 653 */       } else {
/* 654 */         agg_rowWriter1.write(14, agg_value114);
/* 655 */       }
/* 656 */
/* 657 */       if (agg_isNull100) {
/* 658 */         agg_rowWriter1.setNullAt(15);
/* 659 */       } else {
/* 660 */         agg_rowWriter1.write(15, agg_value115);
/* 661 */       }
/* 662 */
/* 663 */       if (agg_isNull120) {
/* 664 */         agg_rowWriter1.setNullAt(16);
/* 665 */       } else {
/* 666 */         agg_rowWriter1.write(16, agg_value135);
/* 667 */       }
/* 668 */
/* 669 */       if (agg_isNull85) {
/* 670 */         agg_rowWriter1.setNullAt(17);
/* 671 */       } else {
/* 672 */         agg_rowWriter1.write(17, agg_value100);
/* 673 */       }
/* 674 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 675 */       append(agg_result1);
/* 676 */
/* 677 */       if (shouldStop()) return;
/* 678 */     }
/* 679 */
/* 680 */     agg_mapIter.close();
/* 681 */     if (agg_sorter == null) {
/* 682 */       agg_hashMap.free();
/* 683 */     }
/* 684 */   }
/* 685 */ }
