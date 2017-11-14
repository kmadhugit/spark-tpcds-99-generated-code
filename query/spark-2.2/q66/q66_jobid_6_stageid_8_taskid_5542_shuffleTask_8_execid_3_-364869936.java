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
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private double agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private double agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private double agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private double agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private double agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private double agg_bufValue13;
/* 037 */   private boolean agg_bufIsNull14;
/* 038 */   private double agg_bufValue14;
/* 039 */   private boolean agg_bufIsNull15;
/* 040 */   private double agg_bufValue15;
/* 041 */   private boolean agg_bufIsNull16;
/* 042 */   private double agg_bufValue16;
/* 043 */   private boolean agg_bufIsNull17;
/* 044 */   private double agg_bufValue17;
/* 045 */   private boolean agg_bufIsNull18;
/* 046 */   private double agg_bufValue18;
/* 047 */   private boolean agg_bufIsNull19;
/* 048 */   private double agg_bufValue19;
/* 049 */   private boolean agg_bufIsNull20;
/* 050 */   private double agg_bufValue20;
/* 051 */   private boolean agg_bufIsNull21;
/* 052 */   private double agg_bufValue21;
/* 053 */   private boolean agg_bufIsNull22;
/* 054 */   private double agg_bufValue22;
/* 055 */   private boolean agg_bufIsNull23;
/* 056 */   private double agg_bufValue23;
/* 057 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 058 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 059 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 060 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 062 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 063 */   private scala.collection.Iterator inputadapter_input;
/* 064 */   private UnsafeRow agg_result;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 067 */   private int agg_value62;
/* 068 */   private UnsafeRow agg_result1;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 073 */
/* 074 */   public GeneratedIterator(Object[] references) {
/* 075 */     this.references = references;
/* 076 */   }
/* 077 */
/* 078 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 079 */     partitionIndex = index;
/* 080 */     this.inputs = inputs;
/* 081 */     agg_initAgg = false;
/* 082 */
/* 083 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 084 */
/* 085 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 086 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 087 */     inputadapter_input = inputs[0];
/* 088 */     agg_result = new UnsafeRow(7);
/* 089 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 160);
/* 090 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 7);
/* 091 */
/* 092 */     agg_result1 = new UnsafeRow(32);
/* 093 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 192);
/* 094 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 32);
/* 095 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 096 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 101 */     agg_hashMap = agg_plan.createHashMap();
/* 102 */
/* 103 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 104 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 105 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 106 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 107 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 108 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 109 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 110 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 111 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 112 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 113 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 114 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 115 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 116 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 117 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 118 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 119 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 120 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 121 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 122 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 123 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 124 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 125 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 126 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 127 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 128 */       double inputadapter_value11 = inputadapter_isNull11 ? -1.0 : (inputadapter_row.getDouble(11));
/* 129 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 130 */       double inputadapter_value12 = inputadapter_isNull12 ? -1.0 : (inputadapter_row.getDouble(12));
/* 131 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 132 */       double inputadapter_value13 = inputadapter_isNull13 ? -1.0 : (inputadapter_row.getDouble(13));
/* 133 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 134 */       double inputadapter_value14 = inputadapter_isNull14 ? -1.0 : (inputadapter_row.getDouble(14));
/* 135 */       boolean inputadapter_isNull15 = inputadapter_row.isNullAt(15);
/* 136 */       double inputadapter_value15 = inputadapter_isNull15 ? -1.0 : (inputadapter_row.getDouble(15));
/* 137 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 138 */       double inputadapter_value16 = inputadapter_isNull16 ? -1.0 : (inputadapter_row.getDouble(16));
/* 139 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 140 */       double inputadapter_value17 = inputadapter_isNull17 ? -1.0 : (inputadapter_row.getDouble(17));
/* 141 */       boolean inputadapter_isNull18 = inputadapter_row.isNullAt(18);
/* 142 */       double inputadapter_value18 = inputadapter_isNull18 ? -1.0 : (inputadapter_row.getDouble(18));
/* 143 */       boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 144 */       double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 145 */       boolean inputadapter_isNull20 = inputadapter_row.isNullAt(20);
/* 146 */       double inputadapter_value20 = inputadapter_isNull20 ? -1.0 : (inputadapter_row.getDouble(20));
/* 147 */       boolean inputadapter_isNull21 = inputadapter_row.isNullAt(21);
/* 148 */       double inputadapter_value21 = inputadapter_isNull21 ? -1.0 : (inputadapter_row.getDouble(21));
/* 149 */       boolean inputadapter_isNull22 = inputadapter_row.isNullAt(22);
/* 150 */       double inputadapter_value22 = inputadapter_isNull22 ? -1.0 : (inputadapter_row.getDouble(22));
/* 151 */       boolean inputadapter_isNull23 = inputadapter_row.isNullAt(23);
/* 152 */       double inputadapter_value23 = inputadapter_isNull23 ? -1.0 : (inputadapter_row.getDouble(23));
/* 153 */       boolean inputadapter_isNull24 = inputadapter_row.isNullAt(24);
/* 154 */       double inputadapter_value24 = inputadapter_isNull24 ? -1.0 : (inputadapter_row.getDouble(24));
/* 155 */       boolean inputadapter_isNull25 = inputadapter_row.isNullAt(25);
/* 156 */       double inputadapter_value25 = inputadapter_isNull25 ? -1.0 : (inputadapter_row.getDouble(25));
/* 157 */       boolean inputadapter_isNull26 = inputadapter_row.isNullAt(26);
/* 158 */       double inputadapter_value26 = inputadapter_isNull26 ? -1.0 : (inputadapter_row.getDouble(26));
/* 159 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 160 */       double inputadapter_value27 = inputadapter_isNull27 ? -1.0 : (inputadapter_row.getDouble(27));
/* 161 */       boolean inputadapter_isNull28 = inputadapter_row.isNullAt(28);
/* 162 */       double inputadapter_value28 = inputadapter_isNull28 ? -1.0 : (inputadapter_row.getDouble(28));
/* 163 */       boolean inputadapter_isNull29 = inputadapter_row.isNullAt(29);
/* 164 */       double inputadapter_value29 = inputadapter_isNull29 ? -1.0 : (inputadapter_row.getDouble(29));
/* 165 */       boolean inputadapter_isNull30 = inputadapter_row.isNullAt(30);
/* 166 */       double inputadapter_value30 = inputadapter_isNull30 ? -1.0 : (inputadapter_row.getDouble(30));
/* 167 */
/* 168 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 169 */
/* 170 */       UnsafeRow agg_fastAggBuffer = null;
/* 171 */
/* 172 */       if (agg_fastAggBuffer == null) {
/* 173 */         // generate grouping key
/* 174 */         agg_holder.reset();
/* 175 */
/* 176 */         agg_rowWriter.zeroOutNullBytes();
/* 177 */
/* 178 */         if (inputadapter_isNull) {
/* 179 */           agg_rowWriter.setNullAt(0);
/* 180 */         } else {
/* 181 */           agg_rowWriter.write(0, inputadapter_value);
/* 182 */         }
/* 183 */
/* 184 */         if (inputadapter_isNull1) {
/* 185 */           agg_rowWriter.setNullAt(1);
/* 186 */         } else {
/* 187 */           agg_rowWriter.write(1, inputadapter_value1);
/* 188 */         }
/* 189 */
/* 190 */         if (inputadapter_isNull2) {
/* 191 */           agg_rowWriter.setNullAt(2);
/* 192 */         } else {
/* 193 */           agg_rowWriter.write(2, inputadapter_value2);
/* 194 */         }
/* 195 */
/* 196 */         if (inputadapter_isNull3) {
/* 197 */           agg_rowWriter.setNullAt(3);
/* 198 */         } else {
/* 199 */           agg_rowWriter.write(3, inputadapter_value3);
/* 200 */         }
/* 201 */
/* 202 */         if (inputadapter_isNull4) {
/* 203 */           agg_rowWriter.setNullAt(4);
/* 204 */         } else {
/* 205 */           agg_rowWriter.write(4, inputadapter_value4);
/* 206 */         }
/* 207 */
/* 208 */         if (inputadapter_isNull5) {
/* 209 */           agg_rowWriter.setNullAt(5);
/* 210 */         } else {
/* 211 */           agg_rowWriter.write(5, inputadapter_value5);
/* 212 */         }
/* 213 */
/* 214 */         if (inputadapter_isNull6) {
/* 215 */           agg_rowWriter.setNullAt(6);
/* 216 */         } else {
/* 217 */           agg_rowWriter.write(6, inputadapter_value6);
/* 218 */         }
/* 219 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 220 */         agg_value62 = 42;
/* 221 */
/* 222 */         if (!inputadapter_isNull) {
/* 223 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value62);
/* 224 */         }
/* 225 */
/* 226 */         if (!inputadapter_isNull1) {
/* 227 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value62);
/* 228 */         }
/* 229 */
/* 230 */         if (!inputadapter_isNull2) {
/* 231 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value62);
/* 232 */         }
/* 233 */
/* 234 */         if (!inputadapter_isNull3) {
/* 235 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value62);
/* 236 */         }
/* 237 */
/* 238 */         if (!inputadapter_isNull4) {
/* 239 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value62);
/* 240 */         }
/* 241 */
/* 242 */         if (!inputadapter_isNull5) {
/* 243 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value62);
/* 244 */         }
/* 245 */
/* 246 */         if (!inputadapter_isNull6) {
/* 247 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value6, agg_value62);
/* 248 */         }
/* 249 */         if (true) {
/* 250 */           // try to get the buffer from hash map
/* 251 */           agg_unsafeRowAggBuffer =
/* 252 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value62);
/* 253 */         }
/* 254 */         if (agg_unsafeRowAggBuffer == null) {
/* 255 */           if (agg_sorter == null) {
/* 256 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 257 */           } else {
/* 258 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 259 */           }
/* 260 */
/* 261 */           // the hash map had be spilled, it should have enough memory now,
/* 262 */           // try  to allocate buffer again.
/* 263 */           agg_unsafeRowAggBuffer =
/* 264 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value62);
/* 265 */           if (agg_unsafeRowAggBuffer == null) {
/* 266 */             // failed to allocate the first page
/* 267 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 268 */           }
/* 269 */         }
/* 270 */       }
/* 271 */
/* 272 */       if (agg_fastAggBuffer != null) {
/* 273 */         // update fast row
/* 274 */
/* 275 */       } else {
/* 276 */         // update unsafe row
/* 277 */
/* 278 */         // common sub-expressions
/* 279 */
/* 280 */         // evaluate aggregate function
/* 281 */         boolean agg_isNull47 = true;
/* 282 */         double agg_value71 = -1.0;
/* 283 */
/* 284 */         boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 285 */         double agg_value73 = agg_isNull49 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 286 */         boolean agg_isNull48 = agg_isNull49;
/* 287 */         double agg_value72 = agg_value73;
/* 288 */         if (agg_isNull48) {
/* 289 */           boolean agg_isNull50 = false;
/* 290 */           double agg_value74 = -1.0;
/* 291 */           if (!false) {
/* 292 */             agg_value74 = (double) 0;
/* 293 */           }
/* 294 */           if (!agg_isNull50) {
/* 295 */             agg_isNull48 = false;
/* 296 */             agg_value72 = agg_value74;
/* 297 */           }
/* 298 */         }
/* 299 */
/* 300 */         if (!inputadapter_isNull7) {
/* 301 */           agg_isNull47 = false; // resultCode could change nullability.
/* 302 */           agg_value71 = agg_value72 + inputadapter_value7;
/* 303 */
/* 304 */         }
/* 305 */         boolean agg_isNull46 = agg_isNull47;
/* 306 */         double agg_value70 = agg_value71;
/* 307 */         if (agg_isNull46) {
/* 308 */           boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 309 */           double agg_value77 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 310 */           if (!agg_isNull53) {
/* 311 */             agg_isNull46 = false;
/* 312 */             agg_value70 = agg_value77;
/* 313 */           }
/* 314 */         }
/* 315 */         boolean agg_isNull55 = true;
/* 316 */         double agg_value79 = -1.0;
/* 317 */
/* 318 */         boolean agg_isNull57 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 319 */         double agg_value81 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 320 */         boolean agg_isNull56 = agg_isNull57;
/* 321 */         double agg_value80 = agg_value81;
/* 322 */         if (agg_isNull56) {
/* 323 */           boolean agg_isNull58 = false;
/* 324 */           double agg_value82 = -1.0;
/* 325 */           if (!false) {
/* 326 */             agg_value82 = (double) 0;
/* 327 */           }
/* 328 */           if (!agg_isNull58) {
/* 329 */             agg_isNull56 = false;
/* 330 */             agg_value80 = agg_value82;
/* 331 */           }
/* 332 */         }
/* 333 */
/* 334 */         if (!inputadapter_isNull8) {
/* 335 */           agg_isNull55 = false; // resultCode could change nullability.
/* 336 */           agg_value79 = agg_value80 + inputadapter_value8;
/* 337 */
/* 338 */         }
/* 339 */         boolean agg_isNull54 = agg_isNull55;
/* 340 */         double agg_value78 = agg_value79;
/* 341 */         if (agg_isNull54) {
/* 342 */           boolean agg_isNull61 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 343 */           double agg_value85 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 344 */           if (!agg_isNull61) {
/* 345 */             agg_isNull54 = false;
/* 346 */             agg_value78 = agg_value85;
/* 347 */           }
/* 348 */         }
/* 349 */         boolean agg_isNull63 = true;
/* 350 */         double agg_value87 = -1.0;
/* 351 */
/* 352 */         boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 353 */         double agg_value89 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 354 */         boolean agg_isNull64 = agg_isNull65;
/* 355 */         double agg_value88 = agg_value89;
/* 356 */         if (agg_isNull64) {
/* 357 */           boolean agg_isNull66 = false;
/* 358 */           double agg_value90 = -1.0;
/* 359 */           if (!false) {
/* 360 */             agg_value90 = (double) 0;
/* 361 */           }
/* 362 */           if (!agg_isNull66) {
/* 363 */             agg_isNull64 = false;
/* 364 */             agg_value88 = agg_value90;
/* 365 */           }
/* 366 */         }
/* 367 */
/* 368 */         if (!inputadapter_isNull9) {
/* 369 */           agg_isNull63 = false; // resultCode could change nullability.
/* 370 */           agg_value87 = agg_value88 + inputadapter_value9;
/* 371 */
/* 372 */         }
/* 373 */         boolean agg_isNull62 = agg_isNull63;
/* 374 */         double agg_value86 = agg_value87;
/* 375 */         if (agg_isNull62) {
/* 376 */           boolean agg_isNull69 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 377 */           double agg_value93 = agg_isNull69 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 378 */           if (!agg_isNull69) {
/* 379 */             agg_isNull62 = false;
/* 380 */             agg_value86 = agg_value93;
/* 381 */           }
/* 382 */         }
/* 383 */         boolean agg_isNull71 = true;
/* 384 */         double agg_value95 = -1.0;
/* 385 */
/* 386 */         boolean agg_isNull73 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 387 */         double agg_value97 = agg_isNull73 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 388 */         boolean agg_isNull72 = agg_isNull73;
/* 389 */         double agg_value96 = agg_value97;
/* 390 */         if (agg_isNull72) {
/* 391 */           boolean agg_isNull74 = false;
/* 392 */           double agg_value98 = -1.0;
/* 393 */           if (!false) {
/* 394 */             agg_value98 = (double) 0;
/* 395 */           }
/* 396 */           if (!agg_isNull74) {
/* 397 */             agg_isNull72 = false;
/* 398 */             agg_value96 = agg_value98;
/* 399 */           }
/* 400 */         }
/* 401 */
/* 402 */         if (!inputadapter_isNull10) {
/* 403 */           agg_isNull71 = false; // resultCode could change nullability.
/* 404 */           agg_value95 = agg_value96 + inputadapter_value10;
/* 405 */
/* 406 */         }
/* 407 */         boolean agg_isNull70 = agg_isNull71;
/* 408 */         double agg_value94 = agg_value95;
/* 409 */         if (agg_isNull70) {
/* 410 */           boolean agg_isNull77 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 411 */           double agg_value101 = agg_isNull77 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 412 */           if (!agg_isNull77) {
/* 413 */             agg_isNull70 = false;
/* 414 */             agg_value94 = agg_value101;
/* 415 */           }
/* 416 */         }
/* 417 */         boolean agg_isNull79 = true;
/* 418 */         double agg_value103 = -1.0;
/* 419 */
/* 420 */         boolean agg_isNull81 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 421 */         double agg_value105 = agg_isNull81 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 422 */         boolean agg_isNull80 = agg_isNull81;
/* 423 */         double agg_value104 = agg_value105;
/* 424 */         if (agg_isNull80) {
/* 425 */           boolean agg_isNull82 = false;
/* 426 */           double agg_value106 = -1.0;
/* 427 */           if (!false) {
/* 428 */             agg_value106 = (double) 0;
/* 429 */           }
/* 430 */           if (!agg_isNull82) {
/* 431 */             agg_isNull80 = false;
/* 432 */             agg_value104 = agg_value106;
/* 433 */           }
/* 434 */         }
/* 435 */
/* 436 */         if (!inputadapter_isNull11) {
/* 437 */           agg_isNull79 = false; // resultCode could change nullability.
/* 438 */           agg_value103 = agg_value104 + inputadapter_value11;
/* 439 */
/* 440 */         }
/* 441 */         boolean agg_isNull78 = agg_isNull79;
/* 442 */         double agg_value102 = agg_value103;
/* 443 */         if (agg_isNull78) {
/* 444 */           boolean agg_isNull85 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 445 */           double agg_value109 = agg_isNull85 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 446 */           if (!agg_isNull85) {
/* 447 */             agg_isNull78 = false;
/* 448 */             agg_value102 = agg_value109;
/* 449 */           }
/* 450 */         }
/* 451 */         boolean agg_isNull87 = true;
/* 452 */         double agg_value111 = -1.0;
/* 453 */
/* 454 */         boolean agg_isNull89 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 455 */         double agg_value113 = agg_isNull89 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 456 */         boolean agg_isNull88 = agg_isNull89;
/* 457 */         double agg_value112 = agg_value113;
/* 458 */         if (agg_isNull88) {
/* 459 */           boolean agg_isNull90 = false;
/* 460 */           double agg_value114 = -1.0;
/* 461 */           if (!false) {
/* 462 */             agg_value114 = (double) 0;
/* 463 */           }
/* 464 */           if (!agg_isNull90) {
/* 465 */             agg_isNull88 = false;
/* 466 */             agg_value112 = agg_value114;
/* 467 */           }
/* 468 */         }
/* 469 */
/* 470 */         if (!inputadapter_isNull12) {
/* 471 */           agg_isNull87 = false; // resultCode could change nullability.
/* 472 */           agg_value111 = agg_value112 + inputadapter_value12;
/* 473 */
/* 474 */         }
/* 475 */         boolean agg_isNull86 = agg_isNull87;
/* 476 */         double agg_value110 = agg_value111;
/* 477 */         if (agg_isNull86) {
/* 478 */           boolean agg_isNull93 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 479 */           double agg_value117 = agg_isNull93 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 480 */           if (!agg_isNull93) {
/* 481 */             agg_isNull86 = false;
/* 482 */             agg_value110 = agg_value117;
/* 483 */           }
/* 484 */         }
/* 485 */         boolean agg_isNull95 = true;
/* 486 */         double agg_value119 = -1.0;
/* 487 */
/* 488 */         boolean agg_isNull97 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 489 */         double agg_value121 = agg_isNull97 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 490 */         boolean agg_isNull96 = agg_isNull97;
/* 491 */         double agg_value120 = agg_value121;
/* 492 */         if (agg_isNull96) {
/* 493 */           boolean agg_isNull98 = false;
/* 494 */           double agg_value122 = -1.0;
/* 495 */           if (!false) {
/* 496 */             agg_value122 = (double) 0;
/* 497 */           }
/* 498 */           if (!agg_isNull98) {
/* 499 */             agg_isNull96 = false;
/* 500 */             agg_value120 = agg_value122;
/* 501 */           }
/* 502 */         }
/* 503 */
/* 504 */         if (!inputadapter_isNull13) {
/* 505 */           agg_isNull95 = false; // resultCode could change nullability.
/* 506 */           agg_value119 = agg_value120 + inputadapter_value13;
/* 507 */
/* 508 */         }
/* 509 */         boolean agg_isNull94 = agg_isNull95;
/* 510 */         double agg_value118 = agg_value119;
/* 511 */         if (agg_isNull94) {
/* 512 */           boolean agg_isNull101 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 513 */           double agg_value125 = agg_isNull101 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 514 */           if (!agg_isNull101) {
/* 515 */             agg_isNull94 = false;
/* 516 */             agg_value118 = agg_value125;
/* 517 */           }
/* 518 */         }
/* 519 */         boolean agg_isNull103 = true;
/* 520 */         double agg_value127 = -1.0;
/* 521 */
/* 522 */         boolean agg_isNull105 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 523 */         double agg_value129 = agg_isNull105 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 524 */         boolean agg_isNull104 = agg_isNull105;
/* 525 */         double agg_value128 = agg_value129;
/* 526 */         if (agg_isNull104) {
/* 527 */           boolean agg_isNull106 = false;
/* 528 */           double agg_value130 = -1.0;
/* 529 */           if (!false) {
/* 530 */             agg_value130 = (double) 0;
/* 531 */           }
/* 532 */           if (!agg_isNull106) {
/* 533 */             agg_isNull104 = false;
/* 534 */             agg_value128 = agg_value130;
/* 535 */           }
/* 536 */         }
/* 537 */
/* 538 */         if (!inputadapter_isNull14) {
/* 539 */           agg_isNull103 = false; // resultCode could change nullability.
/* 540 */           agg_value127 = agg_value128 + inputadapter_value14;
/* 541 */
/* 542 */         }
/* 543 */         boolean agg_isNull102 = agg_isNull103;
/* 544 */         double agg_value126 = agg_value127;
/* 545 */         if (agg_isNull102) {
/* 546 */           boolean agg_isNull109 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 547 */           double agg_value133 = agg_isNull109 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 548 */           if (!agg_isNull109) {
/* 549 */             agg_isNull102 = false;
/* 550 */             agg_value126 = agg_value133;
/* 551 */           }
/* 552 */         }
/* 553 */         boolean agg_isNull111 = true;
/* 554 */         double agg_value135 = -1.0;
/* 555 */
/* 556 */         boolean agg_isNull113 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 557 */         double agg_value137 = agg_isNull113 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 558 */         boolean agg_isNull112 = agg_isNull113;
/* 559 */         double agg_value136 = agg_value137;
/* 560 */         if (agg_isNull112) {
/* 561 */           boolean agg_isNull114 = false;
/* 562 */           double agg_value138 = -1.0;
/* 563 */           if (!false) {
/* 564 */             agg_value138 = (double) 0;
/* 565 */           }
/* 566 */           if (!agg_isNull114) {
/* 567 */             agg_isNull112 = false;
/* 568 */             agg_value136 = agg_value138;
/* 569 */           }
/* 570 */         }
/* 571 */
/* 572 */         if (!inputadapter_isNull15) {
/* 573 */           agg_isNull111 = false; // resultCode could change nullability.
/* 574 */           agg_value135 = agg_value136 + inputadapter_value15;
/* 575 */
/* 576 */         }
/* 577 */         boolean agg_isNull110 = agg_isNull111;
/* 578 */         double agg_value134 = agg_value135;
/* 579 */         if (agg_isNull110) {
/* 580 */           boolean agg_isNull117 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 581 */           double agg_value141 = agg_isNull117 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 582 */           if (!agg_isNull117) {
/* 583 */             agg_isNull110 = false;
/* 584 */             agg_value134 = agg_value141;
/* 585 */           }
/* 586 */         }
/* 587 */         boolean agg_isNull119 = true;
/* 588 */         double agg_value143 = -1.0;
/* 589 */
/* 590 */         boolean agg_isNull121 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 591 */         double agg_value145 = agg_isNull121 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 592 */         boolean agg_isNull120 = agg_isNull121;
/* 593 */         double agg_value144 = agg_value145;
/* 594 */         if (agg_isNull120) {
/* 595 */           boolean agg_isNull122 = false;
/* 596 */           double agg_value146 = -1.0;
/* 597 */           if (!false) {
/* 598 */             agg_value146 = (double) 0;
/* 599 */           }
/* 600 */           if (!agg_isNull122) {
/* 601 */             agg_isNull120 = false;
/* 602 */             agg_value144 = agg_value146;
/* 603 */           }
/* 604 */         }
/* 605 */
/* 606 */         if (!inputadapter_isNull16) {
/* 607 */           agg_isNull119 = false; // resultCode could change nullability.
/* 608 */           agg_value143 = agg_value144 + inputadapter_value16;
/* 609 */
/* 610 */         }
/* 611 */         boolean agg_isNull118 = agg_isNull119;
/* 612 */         double agg_value142 = agg_value143;
/* 613 */         if (agg_isNull118) {
/* 614 */           boolean agg_isNull125 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 615 */           double agg_value149 = agg_isNull125 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 616 */           if (!agg_isNull125) {
/* 617 */             agg_isNull118 = false;
/* 618 */             agg_value142 = agg_value149;
/* 619 */           }
/* 620 */         }
/* 621 */         boolean agg_isNull127 = true;
/* 622 */         double agg_value151 = -1.0;
/* 623 */
/* 624 */         boolean agg_isNull129 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 625 */         double agg_value153 = agg_isNull129 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 626 */         boolean agg_isNull128 = agg_isNull129;
/* 627 */         double agg_value152 = agg_value153;
/* 628 */         if (agg_isNull128) {
/* 629 */           boolean agg_isNull130 = false;
/* 630 */           double agg_value154 = -1.0;
/* 631 */           if (!false) {
/* 632 */             agg_value154 = (double) 0;
/* 633 */           }
/* 634 */           if (!agg_isNull130) {
/* 635 */             agg_isNull128 = false;
/* 636 */             agg_value152 = agg_value154;
/* 637 */           }
/* 638 */         }
/* 639 */
/* 640 */         if (!inputadapter_isNull17) {
/* 641 */           agg_isNull127 = false; // resultCode could change nullability.
/* 642 */           agg_value151 = agg_value152 + inputadapter_value17;
/* 643 */
/* 644 */         }
/* 645 */         boolean agg_isNull126 = agg_isNull127;
/* 646 */         double agg_value150 = agg_value151;
/* 647 */         if (agg_isNull126) {
/* 648 */           boolean agg_isNull133 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 649 */           double agg_value157 = agg_isNull133 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 650 */           if (!agg_isNull133) {
/* 651 */             agg_isNull126 = false;
/* 652 */             agg_value150 = agg_value157;
/* 653 */           }
/* 654 */         }
/* 655 */         boolean agg_isNull135 = true;
/* 656 */         double agg_value159 = -1.0;
/* 657 */
/* 658 */         boolean agg_isNull137 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 659 */         double agg_value161 = agg_isNull137 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 660 */         boolean agg_isNull136 = agg_isNull137;
/* 661 */         double agg_value160 = agg_value161;
/* 662 */         if (agg_isNull136) {
/* 663 */           boolean agg_isNull138 = false;
/* 664 */           double agg_value162 = -1.0;
/* 665 */           if (!false) {
/* 666 */             agg_value162 = (double) 0;
/* 667 */           }
/* 668 */           if (!agg_isNull138) {
/* 669 */             agg_isNull136 = false;
/* 670 */             agg_value160 = agg_value162;
/* 671 */           }
/* 672 */         }
/* 673 */
/* 674 */         if (!inputadapter_isNull18) {
/* 675 */           agg_isNull135 = false; // resultCode could change nullability.
/* 676 */           agg_value159 = agg_value160 + inputadapter_value18;
/* 677 */
/* 678 */         }
/* 679 */         boolean agg_isNull134 = agg_isNull135;
/* 680 */         double agg_value158 = agg_value159;
/* 681 */         if (agg_isNull134) {
/* 682 */           boolean agg_isNull141 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 683 */           double agg_value165 = agg_isNull141 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 684 */           if (!agg_isNull141) {
/* 685 */             agg_isNull134 = false;
/* 686 */             agg_value158 = agg_value165;
/* 687 */           }
/* 688 */         }
/* 689 */         boolean agg_isNull143 = true;
/* 690 */         double agg_value167 = -1.0;
/* 691 */
/* 692 */         boolean agg_isNull145 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 693 */         double agg_value169 = agg_isNull145 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 694 */         boolean agg_isNull144 = agg_isNull145;
/* 695 */         double agg_value168 = agg_value169;
/* 696 */         if (agg_isNull144) {
/* 697 */           boolean agg_isNull146 = false;
/* 698 */           double agg_value170 = -1.0;
/* 699 */           if (!false) {
/* 700 */             agg_value170 = (double) 0;
/* 701 */           }
/* 702 */           if (!agg_isNull146) {
/* 703 */             agg_isNull144 = false;
/* 704 */             agg_value168 = agg_value170;
/* 705 */           }
/* 706 */         }
/* 707 */
/* 708 */         if (!inputadapter_isNull19) {
/* 709 */           agg_isNull143 = false; // resultCode could change nullability.
/* 710 */           agg_value167 = agg_value168 + inputadapter_value19;
/* 711 */
/* 712 */         }
/* 713 */         boolean agg_isNull142 = agg_isNull143;
/* 714 */         double agg_value166 = agg_value167;
/* 715 */         if (agg_isNull142) {
/* 716 */           boolean agg_isNull149 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 717 */           double agg_value173 = agg_isNull149 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 718 */           if (!agg_isNull149) {
/* 719 */             agg_isNull142 = false;
/* 720 */             agg_value166 = agg_value173;
/* 721 */           }
/* 722 */         }
/* 723 */         boolean agg_isNull151 = true;
/* 724 */         double agg_value175 = -1.0;
/* 725 */
/* 726 */         boolean agg_isNull153 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 727 */         double agg_value177 = agg_isNull153 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 728 */         boolean agg_isNull152 = agg_isNull153;
/* 729 */         double agg_value176 = agg_value177;
/* 730 */         if (agg_isNull152) {
/* 731 */           boolean agg_isNull154 = false;
/* 732 */           double agg_value178 = -1.0;
/* 733 */           if (!false) {
/* 734 */             agg_value178 = (double) 0;
/* 735 */           }
/* 736 */           if (!agg_isNull154) {
/* 737 */             agg_isNull152 = false;
/* 738 */             agg_value176 = agg_value178;
/* 739 */           }
/* 740 */         }
/* 741 */
/* 742 */         if (!inputadapter_isNull20) {
/* 743 */           agg_isNull151 = false; // resultCode could change nullability.
/* 744 */           agg_value175 = agg_value176 + inputadapter_value20;
/* 745 */
/* 746 */         }
/* 747 */         boolean agg_isNull150 = agg_isNull151;
/* 748 */         double agg_value174 = agg_value175;
/* 749 */         if (agg_isNull150) {
/* 750 */           boolean agg_isNull157 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 751 */           double agg_value181 = agg_isNull157 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 752 */           if (!agg_isNull157) {
/* 753 */             agg_isNull150 = false;
/* 754 */             agg_value174 = agg_value181;
/* 755 */           }
/* 756 */         }
/* 757 */         boolean agg_isNull159 = true;
/* 758 */         double agg_value183 = -1.0;
/* 759 */
/* 760 */         boolean agg_isNull161 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 761 */         double agg_value185 = agg_isNull161 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 762 */         boolean agg_isNull160 = agg_isNull161;
/* 763 */         double agg_value184 = agg_value185;
/* 764 */         if (agg_isNull160) {
/* 765 */           boolean agg_isNull162 = false;
/* 766 */           double agg_value186 = -1.0;
/* 767 */           if (!false) {
/* 768 */             agg_value186 = (double) 0;
/* 769 */           }
/* 770 */           if (!agg_isNull162) {
/* 771 */             agg_isNull160 = false;
/* 772 */             agg_value184 = agg_value186;
/* 773 */           }
/* 774 */         }
/* 775 */
/* 776 */         if (!inputadapter_isNull21) {
/* 777 */           agg_isNull159 = false; // resultCode could change nullability.
/* 778 */           agg_value183 = agg_value184 + inputadapter_value21;
/* 779 */
/* 780 */         }
/* 781 */         boolean agg_isNull158 = agg_isNull159;
/* 782 */         double agg_value182 = agg_value183;
/* 783 */         if (agg_isNull158) {
/* 784 */           boolean agg_isNull165 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 785 */           double agg_value189 = agg_isNull165 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 786 */           if (!agg_isNull165) {
/* 787 */             agg_isNull158 = false;
/* 788 */             agg_value182 = agg_value189;
/* 789 */           }
/* 790 */         }
/* 791 */         boolean agg_isNull167 = true;
/* 792 */         double agg_value191 = -1.0;
/* 793 */
/* 794 */         boolean agg_isNull169 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 795 */         double agg_value193 = agg_isNull169 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 796 */         boolean agg_isNull168 = agg_isNull169;
/* 797 */         double agg_value192 = agg_value193;
/* 798 */         if (agg_isNull168) {
/* 799 */           boolean agg_isNull170 = false;
/* 800 */           double agg_value194 = -1.0;
/* 801 */           if (!false) {
/* 802 */             agg_value194 = (double) 0;
/* 803 */           }
/* 804 */           if (!agg_isNull170) {
/* 805 */             agg_isNull168 = false;
/* 806 */             agg_value192 = agg_value194;
/* 807 */           }
/* 808 */         }
/* 809 */
/* 810 */         if (!inputadapter_isNull22) {
/* 811 */           agg_isNull167 = false; // resultCode could change nullability.
/* 812 */           agg_value191 = agg_value192 + inputadapter_value22;
/* 813 */
/* 814 */         }
/* 815 */         boolean agg_isNull166 = agg_isNull167;
/* 816 */         double agg_value190 = agg_value191;
/* 817 */         if (agg_isNull166) {
/* 818 */           boolean agg_isNull173 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 819 */           double agg_value197 = agg_isNull173 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 820 */           if (!agg_isNull173) {
/* 821 */             agg_isNull166 = false;
/* 822 */             agg_value190 = agg_value197;
/* 823 */           }
/* 824 */         }
/* 825 */         boolean agg_isNull175 = true;
/* 826 */         double agg_value199 = -1.0;
/* 827 */
/* 828 */         boolean agg_isNull177 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 829 */         double agg_value201 = agg_isNull177 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 830 */         boolean agg_isNull176 = agg_isNull177;
/* 831 */         double agg_value200 = agg_value201;
/* 832 */         if (agg_isNull176) {
/* 833 */           boolean agg_isNull178 = false;
/* 834 */           double agg_value202 = -1.0;
/* 835 */           if (!false) {
/* 836 */             agg_value202 = (double) 0;
/* 837 */           }
/* 838 */           if (!agg_isNull178) {
/* 839 */             agg_isNull176 = false;
/* 840 */             agg_value200 = agg_value202;
/* 841 */           }
/* 842 */         }
/* 843 */
/* 844 */         if (!inputadapter_isNull23) {
/* 845 */           agg_isNull175 = false; // resultCode could change nullability.
/* 846 */           agg_value199 = agg_value200 + inputadapter_value23;
/* 847 */
/* 848 */         }
/* 849 */         boolean agg_isNull174 = agg_isNull175;
/* 850 */         double agg_value198 = agg_value199;
/* 851 */         if (agg_isNull174) {
/* 852 */           boolean agg_isNull181 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 853 */           double agg_value205 = agg_isNull181 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 854 */           if (!agg_isNull181) {
/* 855 */             agg_isNull174 = false;
/* 856 */             agg_value198 = agg_value205;
/* 857 */           }
/* 858 */         }
/* 859 */         boolean agg_isNull183 = true;
/* 860 */         double agg_value207 = -1.0;
/* 861 */
/* 862 */         boolean agg_isNull185 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 863 */         double agg_value209 = agg_isNull185 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 864 */         boolean agg_isNull184 = agg_isNull185;
/* 865 */         double agg_value208 = agg_value209;
/* 866 */         if (agg_isNull184) {
/* 867 */           boolean agg_isNull186 = false;
/* 868 */           double agg_value210 = -1.0;
/* 869 */           if (!false) {
/* 870 */             agg_value210 = (double) 0;
/* 871 */           }
/* 872 */           if (!agg_isNull186) {
/* 873 */             agg_isNull184 = false;
/* 874 */             agg_value208 = agg_value210;
/* 875 */           }
/* 876 */         }
/* 877 */
/* 878 */         if (!inputadapter_isNull24) {
/* 879 */           agg_isNull183 = false; // resultCode could change nullability.
/* 880 */           agg_value207 = agg_value208 + inputadapter_value24;
/* 881 */
/* 882 */         }
/* 883 */         boolean agg_isNull182 = agg_isNull183;
/* 884 */         double agg_value206 = agg_value207;
/* 885 */         if (agg_isNull182) {
/* 886 */           boolean agg_isNull189 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 887 */           double agg_value213 = agg_isNull189 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 888 */           if (!agg_isNull189) {
/* 889 */             agg_isNull182 = false;
/* 890 */             agg_value206 = agg_value213;
/* 891 */           }
/* 892 */         }
/* 893 */         boolean agg_isNull191 = true;
/* 894 */         double agg_value215 = -1.0;
/* 895 */
/* 896 */         boolean agg_isNull193 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 897 */         double agg_value217 = agg_isNull193 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 898 */         boolean agg_isNull192 = agg_isNull193;
/* 899 */         double agg_value216 = agg_value217;
/* 900 */         if (agg_isNull192) {
/* 901 */           boolean agg_isNull194 = false;
/* 902 */           double agg_value218 = -1.0;
/* 903 */           if (!false) {
/* 904 */             agg_value218 = (double) 0;
/* 905 */           }
/* 906 */           if (!agg_isNull194) {
/* 907 */             agg_isNull192 = false;
/* 908 */             agg_value216 = agg_value218;
/* 909 */           }
/* 910 */         }
/* 911 */
/* 912 */         if (!inputadapter_isNull25) {
/* 913 */           agg_isNull191 = false; // resultCode could change nullability.
/* 914 */           agg_value215 = agg_value216 + inputadapter_value25;
/* 915 */
/* 916 */         }
/* 917 */         boolean agg_isNull190 = agg_isNull191;
/* 918 */         double agg_value214 = agg_value215;
/* 919 */         if (agg_isNull190) {
/* 920 */           boolean agg_isNull197 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 921 */           double agg_value221 = agg_isNull197 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 922 */           if (!agg_isNull197) {
/* 923 */             agg_isNull190 = false;
/* 924 */             agg_value214 = agg_value221;
/* 925 */           }
/* 926 */         }
/* 927 */         boolean agg_isNull199 = true;
/* 928 */         double agg_value223 = -1.0;
/* 929 */
/* 930 */         boolean agg_isNull201 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 931 */         double agg_value225 = agg_isNull201 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 932 */         boolean agg_isNull200 = agg_isNull201;
/* 933 */         double agg_value224 = agg_value225;
/* 934 */         if (agg_isNull200) {
/* 935 */           boolean agg_isNull202 = false;
/* 936 */           double agg_value226 = -1.0;
/* 937 */           if (!false) {
/* 938 */             agg_value226 = (double) 0;
/* 939 */           }
/* 940 */           if (!agg_isNull202) {
/* 941 */             agg_isNull200 = false;
/* 942 */             agg_value224 = agg_value226;
/* 943 */           }
/* 944 */         }
/* 945 */
/* 946 */         if (!inputadapter_isNull26) {
/* 947 */           agg_isNull199 = false; // resultCode could change nullability.
/* 948 */           agg_value223 = agg_value224 + inputadapter_value26;
/* 949 */
/* 950 */         }
/* 951 */         boolean agg_isNull198 = agg_isNull199;
/* 952 */         double agg_value222 = agg_value223;
/* 953 */         if (agg_isNull198) {
/* 954 */           boolean agg_isNull205 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 955 */           double agg_value229 = agg_isNull205 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 956 */           if (!agg_isNull205) {
/* 957 */             agg_isNull198 = false;
/* 958 */             agg_value222 = agg_value229;
/* 959 */           }
/* 960 */         }
/* 961 */         boolean agg_isNull207 = true;
/* 962 */         double agg_value231 = -1.0;
/* 963 */
/* 964 */         boolean agg_isNull209 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 965 */         double agg_value233 = agg_isNull209 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 966 */         boolean agg_isNull208 = agg_isNull209;
/* 967 */         double agg_value232 = agg_value233;
/* 968 */         if (agg_isNull208) {
/* 969 */           boolean agg_isNull210 = false;
/* 970 */           double agg_value234 = -1.0;
/* 971 */           if (!false) {
/* 972 */             agg_value234 = (double) 0;
/* 973 */           }
/* 974 */           if (!agg_isNull210) {
/* 975 */             agg_isNull208 = false;
/* 976 */             agg_value232 = agg_value234;
/* 977 */           }
/* 978 */         }
/* 979 */
/* 980 */         if (!inputadapter_isNull27) {
/* 981 */           agg_isNull207 = false; // resultCode could change nullability.
/* 982 */           agg_value231 = agg_value232 + inputadapter_value27;
/* 983 */
/* 984 */         }
/* 985 */         boolean agg_isNull206 = agg_isNull207;
/* 986 */         double agg_value230 = agg_value231;
/* 987 */         if (agg_isNull206) {
/* 988 */           boolean agg_isNull213 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 989 */           double agg_value237 = agg_isNull213 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 990 */           if (!agg_isNull213) {
/* 991 */             agg_isNull206 = false;
/* 992 */             agg_value230 = agg_value237;
/* 993 */           }
/* 994 */         }
/* 995 */         boolean agg_isNull215 = true;
/* 996 */         double agg_value239 = -1.0;
/* 997 */
/* 998 */         boolean agg_isNull217 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 999 */         double agg_value241 = agg_isNull217 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 1000 */         boolean agg_isNull216 = agg_isNull217;
/* 1001 */         double agg_value240 = agg_value241;
/* 1002 */         if (agg_isNull216) {
/* 1003 */           boolean agg_isNull218 = false;
/* 1004 */           double agg_value242 = -1.0;
/* 1005 */           if (!false) {
/* 1006 */             agg_value242 = (double) 0;
/* 1007 */           }
/* 1008 */           if (!agg_isNull218) {
/* 1009 */             agg_isNull216 = false;
/* 1010 */             agg_value240 = agg_value242;
/* 1011 */           }
/* 1012 */         }
/* 1013 */
/* 1014 */         if (!inputadapter_isNull28) {
/* 1015 */           agg_isNull215 = false; // resultCode could change nullability.
/* 1016 */           agg_value239 = agg_value240 + inputadapter_value28;
/* 1017 */
/* 1018 */         }
/* 1019 */         boolean agg_isNull214 = agg_isNull215;
/* 1020 */         double agg_value238 = agg_value239;
/* 1021 */         if (agg_isNull214) {
/* 1022 */           boolean agg_isNull221 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 1023 */           double agg_value245 = agg_isNull221 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 1024 */           if (!agg_isNull221) {
/* 1025 */             agg_isNull214 = false;
/* 1026 */             agg_value238 = agg_value245;
/* 1027 */           }
/* 1028 */         }
/* 1029 */         boolean agg_isNull223 = true;
/* 1030 */         double agg_value247 = -1.0;
/* 1031 */
/* 1032 */         boolean agg_isNull225 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 1033 */         double agg_value249 = agg_isNull225 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 1034 */         boolean agg_isNull224 = agg_isNull225;
/* 1035 */         double agg_value248 = agg_value249;
/* 1036 */         if (agg_isNull224) {
/* 1037 */           boolean agg_isNull226 = false;
/* 1038 */           double agg_value250 = -1.0;
/* 1039 */           if (!false) {
/* 1040 */             agg_value250 = (double) 0;
/* 1041 */           }
/* 1042 */           if (!agg_isNull226) {
/* 1043 */             agg_isNull224 = false;
/* 1044 */             agg_value248 = agg_value250;
/* 1045 */           }
/* 1046 */         }
/* 1047 */
/* 1048 */         if (!inputadapter_isNull29) {
/* 1049 */           agg_isNull223 = false; // resultCode could change nullability.
/* 1050 */           agg_value247 = agg_value248 + inputadapter_value29;
/* 1051 */
/* 1052 */         }
/* 1053 */         boolean agg_isNull222 = agg_isNull223;
/* 1054 */         double agg_value246 = agg_value247;
/* 1055 */         if (agg_isNull222) {
/* 1056 */           boolean agg_isNull229 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 1057 */           double agg_value253 = agg_isNull229 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 1058 */           if (!agg_isNull229) {
/* 1059 */             agg_isNull222 = false;
/* 1060 */             agg_value246 = agg_value253;
/* 1061 */           }
/* 1062 */         }
/* 1063 */         boolean agg_isNull231 = true;
/* 1064 */         double agg_value255 = -1.0;
/* 1065 */
/* 1066 */         boolean agg_isNull233 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 1067 */         double agg_value257 = agg_isNull233 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 1068 */         boolean agg_isNull232 = agg_isNull233;
/* 1069 */         double agg_value256 = agg_value257;
/* 1070 */         if (agg_isNull232) {
/* 1071 */           boolean agg_isNull234 = false;
/* 1072 */           double agg_value258 = -1.0;
/* 1073 */           if (!false) {
/* 1074 */             agg_value258 = (double) 0;
/* 1075 */           }
/* 1076 */           if (!agg_isNull234) {
/* 1077 */             agg_isNull232 = false;
/* 1078 */             agg_value256 = agg_value258;
/* 1079 */           }
/* 1080 */         }
/* 1081 */
/* 1082 */         if (!inputadapter_isNull30) {
/* 1083 */           agg_isNull231 = false; // resultCode could change nullability.
/* 1084 */           agg_value255 = agg_value256 + inputadapter_value30;
/* 1085 */
/* 1086 */         }
/* 1087 */         boolean agg_isNull230 = agg_isNull231;
/* 1088 */         double agg_value254 = agg_value255;
/* 1089 */         if (agg_isNull230) {
/* 1090 */           boolean agg_isNull237 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 1091 */           double agg_value261 = agg_isNull237 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 1092 */           if (!agg_isNull237) {
/* 1093 */             agg_isNull230 = false;
/* 1094 */             agg_value254 = agg_value261;
/* 1095 */           }
/* 1096 */         }
/* 1097 */         // update unsafe row buffer
/* 1098 */         if (!agg_isNull46) {
/* 1099 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value70);
/* 1100 */         } else {
/* 1101 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 1102 */         }
/* 1103 */
/* 1104 */         if (!agg_isNull54) {
/* 1105 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value78);
/* 1106 */         } else {
/* 1107 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1108 */         }
/* 1109 */
/* 1110 */         if (!agg_isNull62) {
/* 1111 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value86);
/* 1112 */         } else {
/* 1113 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 1114 */         }
/* 1115 */
/* 1116 */         if (!agg_isNull70) {
/* 1117 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value94);
/* 1118 */         } else {
/* 1119 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 1120 */         }
/* 1121 */
/* 1122 */         if (!agg_isNull78) {
/* 1123 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value102);
/* 1124 */         } else {
/* 1125 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 1126 */         }
/* 1127 */
/* 1128 */         if (!agg_isNull86) {
/* 1129 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value110);
/* 1130 */         } else {
/* 1131 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 1132 */         }
/* 1133 */
/* 1134 */         if (!agg_isNull94) {
/* 1135 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value118);
/* 1136 */         } else {
/* 1137 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 1138 */         }
/* 1139 */
/* 1140 */         if (!agg_isNull102) {
/* 1141 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value126);
/* 1142 */         } else {
/* 1143 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 1144 */         }
/* 1145 */
/* 1146 */         if (!agg_isNull110) {
/* 1147 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value134);
/* 1148 */         } else {
/* 1149 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 1150 */         }
/* 1151 */
/* 1152 */         if (!agg_isNull118) {
/* 1153 */           agg_unsafeRowAggBuffer.setDouble(9, agg_value142);
/* 1154 */         } else {
/* 1155 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 1156 */         }
/* 1157 */
/* 1158 */         if (!agg_isNull126) {
/* 1159 */           agg_unsafeRowAggBuffer.setDouble(10, agg_value150);
/* 1160 */         } else {
/* 1161 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 1162 */         }
/* 1163 */
/* 1164 */         if (!agg_isNull134) {
/* 1165 */           agg_unsafeRowAggBuffer.setDouble(11, agg_value158);
/* 1166 */         } else {
/* 1167 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 1168 */         }
/* 1169 */
/* 1170 */         if (!agg_isNull142) {
/* 1171 */           agg_unsafeRowAggBuffer.setDouble(12, agg_value166);
/* 1172 */         } else {
/* 1173 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 1174 */         }
/* 1175 */
/* 1176 */         if (!agg_isNull150) {
/* 1177 */           agg_unsafeRowAggBuffer.setDouble(13, agg_value174);
/* 1178 */         } else {
/* 1179 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 1180 */         }
/* 1181 */
/* 1182 */         if (!agg_isNull158) {
/* 1183 */           agg_unsafeRowAggBuffer.setDouble(14, agg_value182);
/* 1184 */         } else {
/* 1185 */           agg_unsafeRowAggBuffer.setNullAt(14);
/* 1186 */         }
/* 1187 */
/* 1188 */         if (!agg_isNull166) {
/* 1189 */           agg_unsafeRowAggBuffer.setDouble(15, agg_value190);
/* 1190 */         } else {
/* 1191 */           agg_unsafeRowAggBuffer.setNullAt(15);
/* 1192 */         }
/* 1193 */
/* 1194 */         if (!agg_isNull174) {
/* 1195 */           agg_unsafeRowAggBuffer.setDouble(16, agg_value198);
/* 1196 */         } else {
/* 1197 */           agg_unsafeRowAggBuffer.setNullAt(16);
/* 1198 */         }
/* 1199 */
/* 1200 */         if (!agg_isNull182) {
/* 1201 */           agg_unsafeRowAggBuffer.setDouble(17, agg_value206);
/* 1202 */         } else {
/* 1203 */           agg_unsafeRowAggBuffer.setNullAt(17);
/* 1204 */         }
/* 1205 */
/* 1206 */         if (!agg_isNull190) {
/* 1207 */           agg_unsafeRowAggBuffer.setDouble(18, agg_value214);
/* 1208 */         } else {
/* 1209 */           agg_unsafeRowAggBuffer.setNullAt(18);
/* 1210 */         }
/* 1211 */
/* 1212 */         if (!agg_isNull198) {
/* 1213 */           agg_unsafeRowAggBuffer.setDouble(19, agg_value222);
/* 1214 */         } else {
/* 1215 */           agg_unsafeRowAggBuffer.setNullAt(19);
/* 1216 */         }
/* 1217 */
/* 1218 */         if (!agg_isNull206) {
/* 1219 */           agg_unsafeRowAggBuffer.setDouble(20, agg_value230);
/* 1220 */         } else {
/* 1221 */           agg_unsafeRowAggBuffer.setNullAt(20);
/* 1222 */         }
/* 1223 */
/* 1224 */         if (!agg_isNull214) {
/* 1225 */           agg_unsafeRowAggBuffer.setDouble(21, agg_value238);
/* 1226 */         } else {
/* 1227 */           agg_unsafeRowAggBuffer.setNullAt(21);
/* 1228 */         }
/* 1229 */
/* 1230 */         if (!agg_isNull222) {
/* 1231 */           agg_unsafeRowAggBuffer.setDouble(22, agg_value246);
/* 1232 */         } else {
/* 1233 */           agg_unsafeRowAggBuffer.setNullAt(22);
/* 1234 */         }
/* 1235 */
/* 1236 */         if (!agg_isNull230) {
/* 1237 */           agg_unsafeRowAggBuffer.setDouble(23, agg_value254);
/* 1238 */         } else {
/* 1239 */           agg_unsafeRowAggBuffer.setNullAt(23);
/* 1240 */         }
/* 1241 */
/* 1242 */       }
/* 1243 */       if (shouldStop()) return;
/* 1244 */     }
/* 1245 */
/* 1246 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1247 */   }
/* 1248 */
/* 1249 */   protected void processNext() throws java.io.IOException {
/* 1250 */     if (!agg_initAgg) {
/* 1251 */       agg_initAgg = true;
/* 1252 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1253 */       agg_doAggregateWithKeys();
/* 1254 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1255 */     }
/* 1256 */
/* 1257 */     // output the result
/* 1258 */
/* 1259 */     while (agg_mapIter.next()) {
/* 1260 */       wholestagecodegen_numOutputRows.add(1);
/* 1261 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1262 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1263 */
/* 1264 */       boolean agg_isNull238 = agg_aggKey.isNullAt(0);
/* 1265 */       UTF8String agg_value262 = agg_isNull238 ? null : (agg_aggKey.getUTF8String(0));
/* 1266 */       boolean agg_isNull239 = agg_aggKey.isNullAt(1);
/* 1267 */       int agg_value263 = agg_isNull239 ? -1 : (agg_aggKey.getInt(1));
/* 1268 */       boolean agg_isNull240 = agg_aggKey.isNullAt(2);
/* 1269 */       UTF8String agg_value264 = agg_isNull240 ? null : (agg_aggKey.getUTF8String(2));
/* 1270 */       boolean agg_isNull241 = agg_aggKey.isNullAt(3);
/* 1271 */       UTF8String agg_value265 = agg_isNull241 ? null : (agg_aggKey.getUTF8String(3));
/* 1272 */       boolean agg_isNull242 = agg_aggKey.isNullAt(4);
/* 1273 */       UTF8String agg_value266 = agg_isNull242 ? null : (agg_aggKey.getUTF8String(4));
/* 1274 */       boolean agg_isNull243 = agg_aggKey.isNullAt(5);
/* 1275 */       UTF8String agg_value267 = agg_isNull243 ? null : (agg_aggKey.getUTF8String(5));
/* 1276 */       boolean agg_isNull244 = agg_aggKey.isNullAt(6);
/* 1277 */       int agg_value268 = agg_isNull244 ? -1 : (agg_aggKey.getInt(6));
/* 1278 */       boolean agg_isNull245 = agg_aggBuffer.isNullAt(0);
/* 1279 */       double agg_value269 = agg_isNull245 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 1280 */       boolean agg_isNull246 = agg_aggBuffer.isNullAt(1);
/* 1281 */       double agg_value270 = agg_isNull246 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 1282 */       boolean agg_isNull247 = agg_aggBuffer.isNullAt(2);
/* 1283 */       double agg_value271 = agg_isNull247 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 1284 */       boolean agg_isNull248 = agg_aggBuffer.isNullAt(3);
/* 1285 */       double agg_value272 = agg_isNull248 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 1286 */       boolean agg_isNull249 = agg_aggBuffer.isNullAt(4);
/* 1287 */       double agg_value273 = agg_isNull249 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 1288 */       boolean agg_isNull250 = agg_aggBuffer.isNullAt(5);
/* 1289 */       double agg_value274 = agg_isNull250 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 1290 */       boolean agg_isNull251 = agg_aggBuffer.isNullAt(6);
/* 1291 */       double agg_value275 = agg_isNull251 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 1292 */       boolean agg_isNull252 = agg_aggBuffer.isNullAt(7);
/* 1293 */       double agg_value276 = agg_isNull252 ? -1.0 : (agg_aggBuffer.getDouble(7));
/* 1294 */       boolean agg_isNull253 = agg_aggBuffer.isNullAt(8);
/* 1295 */       double agg_value277 = agg_isNull253 ? -1.0 : (agg_aggBuffer.getDouble(8));
/* 1296 */       boolean agg_isNull254 = agg_aggBuffer.isNullAt(9);
/* 1297 */       double agg_value278 = agg_isNull254 ? -1.0 : (agg_aggBuffer.getDouble(9));
/* 1298 */       boolean agg_isNull255 = agg_aggBuffer.isNullAt(10);
/* 1299 */       double agg_value279 = agg_isNull255 ? -1.0 : (agg_aggBuffer.getDouble(10));
/* 1300 */       boolean agg_isNull256 = agg_aggBuffer.isNullAt(11);
/* 1301 */       double agg_value280 = agg_isNull256 ? -1.0 : (agg_aggBuffer.getDouble(11));
/* 1302 */       boolean agg_isNull257 = agg_aggBuffer.isNullAt(12);
/* 1303 */       double agg_value281 = agg_isNull257 ? -1.0 : (agg_aggBuffer.getDouble(12));
/* 1304 */       boolean agg_isNull258 = agg_aggBuffer.isNullAt(13);
/* 1305 */       double agg_value282 = agg_isNull258 ? -1.0 : (agg_aggBuffer.getDouble(13));
/* 1306 */       boolean agg_isNull259 = agg_aggBuffer.isNullAt(14);
/* 1307 */       double agg_value283 = agg_isNull259 ? -1.0 : (agg_aggBuffer.getDouble(14));
/* 1308 */       boolean agg_isNull260 = agg_aggBuffer.isNullAt(15);
/* 1309 */       double agg_value284 = agg_isNull260 ? -1.0 : (agg_aggBuffer.getDouble(15));
/* 1310 */       boolean agg_isNull261 = agg_aggBuffer.isNullAt(16);
/* 1311 */       double agg_value285 = agg_isNull261 ? -1.0 : (agg_aggBuffer.getDouble(16));
/* 1312 */       boolean agg_isNull262 = agg_aggBuffer.isNullAt(17);
/* 1313 */       double agg_value286 = agg_isNull262 ? -1.0 : (agg_aggBuffer.getDouble(17));
/* 1314 */       boolean agg_isNull263 = agg_aggBuffer.isNullAt(18);
/* 1315 */       double agg_value287 = agg_isNull263 ? -1.0 : (agg_aggBuffer.getDouble(18));
/* 1316 */       boolean agg_isNull264 = agg_aggBuffer.isNullAt(19);
/* 1317 */       double agg_value288 = agg_isNull264 ? -1.0 : (agg_aggBuffer.getDouble(19));
/* 1318 */       boolean agg_isNull265 = agg_aggBuffer.isNullAt(20);
/* 1319 */       double agg_value289 = agg_isNull265 ? -1.0 : (agg_aggBuffer.getDouble(20));
/* 1320 */       boolean agg_isNull266 = agg_aggBuffer.isNullAt(21);
/* 1321 */       double agg_value290 = agg_isNull266 ? -1.0 : (agg_aggBuffer.getDouble(21));
/* 1322 */       boolean agg_isNull267 = agg_aggBuffer.isNullAt(22);
/* 1323 */       double agg_value291 = agg_isNull267 ? -1.0 : (agg_aggBuffer.getDouble(22));
/* 1324 */       boolean agg_isNull268 = agg_aggBuffer.isNullAt(23);
/* 1325 */       double agg_value292 = agg_isNull268 ? -1.0 : (agg_aggBuffer.getDouble(23));
/* 1326 */
/* 1327 */       agg_holder1.reset();
/* 1328 */
/* 1329 */       agg_rowWriter1.zeroOutNullBytes();
/* 1330 */
/* 1331 */       if (agg_isNull238) {
/* 1332 */         agg_rowWriter1.setNullAt(0);
/* 1333 */       } else {
/* 1334 */         agg_rowWriter1.write(0, agg_value262);
/* 1335 */       }
/* 1336 */
/* 1337 */       if (agg_isNull239) {
/* 1338 */         agg_rowWriter1.setNullAt(1);
/* 1339 */       } else {
/* 1340 */         agg_rowWriter1.write(1, agg_value263);
/* 1341 */       }
/* 1342 */
/* 1343 */       if (agg_isNull240) {
/* 1344 */         agg_rowWriter1.setNullAt(2);
/* 1345 */       } else {
/* 1346 */         agg_rowWriter1.write(2, agg_value264);
/* 1347 */       }
/* 1348 */
/* 1349 */       if (agg_isNull241) {
/* 1350 */         agg_rowWriter1.setNullAt(3);
/* 1351 */       } else {
/* 1352 */         agg_rowWriter1.write(3, agg_value265);
/* 1353 */       }
/* 1354 */
/* 1355 */       if (agg_isNull242) {
/* 1356 */         agg_rowWriter1.setNullAt(4);
/* 1357 */       } else {
/* 1358 */         agg_rowWriter1.write(4, agg_value266);
/* 1359 */       }
/* 1360 */
/* 1361 */       if (agg_isNull243) {
/* 1362 */         agg_rowWriter1.setNullAt(5);
/* 1363 */       } else {
/* 1364 */         agg_rowWriter1.write(5, agg_value267);
/* 1365 */       }
/* 1366 */
/* 1367 */       agg_rowWriter1.write(6, ((UTF8String) references[3]));
/* 1368 */
/* 1369 */       if (agg_isNull244) {
/* 1370 */         agg_rowWriter1.setNullAt(7);
/* 1371 */       } else {
/* 1372 */         agg_rowWriter1.write(7, agg_value268);
/* 1373 */       }
/* 1374 */
/* 1375 */       if (agg_isNull245) {
/* 1376 */         agg_rowWriter1.setNullAt(8);
/* 1377 */       } else {
/* 1378 */         agg_rowWriter1.write(8, agg_value269);
/* 1379 */       }
/* 1380 */
/* 1381 */       if (agg_isNull246) {
/* 1382 */         agg_rowWriter1.setNullAt(9);
/* 1383 */       } else {
/* 1384 */         agg_rowWriter1.write(9, agg_value270);
/* 1385 */       }
/* 1386 */
/* 1387 */       if (agg_isNull247) {
/* 1388 */         agg_rowWriter1.setNullAt(10);
/* 1389 */       } else {
/* 1390 */         agg_rowWriter1.write(10, agg_value271);
/* 1391 */       }
/* 1392 */
/* 1393 */       if (agg_isNull248) {
/* 1394 */         agg_rowWriter1.setNullAt(11);
/* 1395 */       } else {
/* 1396 */         agg_rowWriter1.write(11, agg_value272);
/* 1397 */       }
/* 1398 */
/* 1399 */       if (agg_isNull249) {
/* 1400 */         agg_rowWriter1.setNullAt(12);
/* 1401 */       } else {
/* 1402 */         agg_rowWriter1.write(12, agg_value273);
/* 1403 */       }
/* 1404 */
/* 1405 */       if (agg_isNull250) {
/* 1406 */         agg_rowWriter1.setNullAt(13);
/* 1407 */       } else {
/* 1408 */         agg_rowWriter1.write(13, agg_value274);
/* 1409 */       }
/* 1410 */
/* 1411 */       if (agg_isNull251) {
/* 1412 */         agg_rowWriter1.setNullAt(14);
/* 1413 */       } else {
/* 1414 */         agg_rowWriter1.write(14, agg_value275);
/* 1415 */       }
/* 1416 */
/* 1417 */       if (agg_isNull252) {
/* 1418 */         agg_rowWriter1.setNullAt(15);
/* 1419 */       } else {
/* 1420 */         agg_rowWriter1.write(15, agg_value276);
/* 1421 */       }
/* 1422 */
/* 1423 */       if (agg_isNull253) {
/* 1424 */         agg_rowWriter1.setNullAt(16);
/* 1425 */       } else {
/* 1426 */         agg_rowWriter1.write(16, agg_value277);
/* 1427 */       }
/* 1428 */
/* 1429 */       if (agg_isNull254) {
/* 1430 */         agg_rowWriter1.setNullAt(17);
/* 1431 */       } else {
/* 1432 */         agg_rowWriter1.write(17, agg_value278);
/* 1433 */       }
/* 1434 */
/* 1435 */       if (agg_isNull255) {
/* 1436 */         agg_rowWriter1.setNullAt(18);
/* 1437 */       } else {
/* 1438 */         agg_rowWriter1.write(18, agg_value279);
/* 1439 */       }
/* 1440 */
/* 1441 */       if (agg_isNull256) {
/* 1442 */         agg_rowWriter1.setNullAt(19);
/* 1443 */       } else {
/* 1444 */         agg_rowWriter1.write(19, agg_value280);
/* 1445 */       }
/* 1446 */
/* 1447 */       if (agg_isNull257) {
/* 1448 */         agg_rowWriter1.setNullAt(20);
/* 1449 */       } else {
/* 1450 */         agg_rowWriter1.write(20, agg_value281);
/* 1451 */       }
/* 1452 */
/* 1453 */       if (agg_isNull258) {
/* 1454 */         agg_rowWriter1.setNullAt(21);
/* 1455 */       } else {
/* 1456 */         agg_rowWriter1.write(21, agg_value282);
/* 1457 */       }
/* 1458 */
/* 1459 */       if (agg_isNull259) {
/* 1460 */         agg_rowWriter1.setNullAt(22);
/* 1461 */       } else {
/* 1462 */         agg_rowWriter1.write(22, agg_value283);
/* 1463 */       }
/* 1464 */
/* 1465 */       if (agg_isNull260) {
/* 1466 */         agg_rowWriter1.setNullAt(23);
/* 1467 */       } else {
/* 1468 */         agg_rowWriter1.write(23, agg_value284);
/* 1469 */       }
/* 1470 */
/* 1471 */       if (agg_isNull261) {
/* 1472 */         agg_rowWriter1.setNullAt(24);
/* 1473 */       } else {
/* 1474 */         agg_rowWriter1.write(24, agg_value285);
/* 1475 */       }
/* 1476 */
/* 1477 */       if (agg_isNull262) {
/* 1478 */         agg_rowWriter1.setNullAt(25);
/* 1479 */       } else {
/* 1480 */         agg_rowWriter1.write(25, agg_value286);
/* 1481 */       }
/* 1482 */
/* 1483 */       if (agg_isNull263) {
/* 1484 */         agg_rowWriter1.setNullAt(26);
/* 1485 */       } else {
/* 1486 */         agg_rowWriter1.write(26, agg_value287);
/* 1487 */       }
/* 1488 */
/* 1489 */       if (agg_isNull264) {
/* 1490 */         agg_rowWriter1.setNullAt(27);
/* 1491 */       } else {
/* 1492 */         agg_rowWriter1.write(27, agg_value288);
/* 1493 */       }
/* 1494 */
/* 1495 */       if (agg_isNull265) {
/* 1496 */         agg_rowWriter1.setNullAt(28);
/* 1497 */       } else {
/* 1498 */         agg_rowWriter1.write(28, agg_value289);
/* 1499 */       }
/* 1500 */
/* 1501 */       if (agg_isNull266) {
/* 1502 */         agg_rowWriter1.setNullAt(29);
/* 1503 */       } else {
/* 1504 */         agg_rowWriter1.write(29, agg_value290);
/* 1505 */       }
/* 1506 */
/* 1507 */       if (agg_isNull267) {
/* 1508 */         agg_rowWriter1.setNullAt(30);
/* 1509 */       } else {
/* 1510 */         agg_rowWriter1.write(30, agg_value291);
/* 1511 */       }
/* 1512 */
/* 1513 */       if (agg_isNull268) {
/* 1514 */         agg_rowWriter1.setNullAt(31);
/* 1515 */       } else {
/* 1516 */         agg_rowWriter1.write(31, agg_value292);
/* 1517 */       }
/* 1518 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 1519 */       append(agg_result1);
/* 1520 */
/* 1521 */       if (shouldStop()) return;
/* 1522 */     }
/* 1523 */
/* 1524 */     agg_mapIter.close();
/* 1525 */     if (agg_sorter == null) {
/* 1526 */       agg_hashMap.free();
/* 1527 */     }
/* 1528 */   }
/* 1529 */ }
