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
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private int agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private int agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private int agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private int agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private int agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private int agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private int agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private int agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private int agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private long agg_bufValue11;
/* 033 */   private boolean agg_initAgg1;
/* 034 */   private boolean agg_bufIsNull12;
/* 035 */   private long agg_bufValue12;
/* 036 */   private boolean agg_bufIsNull13;
/* 037 */   private long agg_bufValue13;
/* 038 */   private boolean agg_bufIsNull14;
/* 039 */   private int agg_bufValue14;
/* 040 */   private boolean agg_bufIsNull15;
/* 041 */   private int agg_bufValue15;
/* 042 */   private boolean agg_bufIsNull16;
/* 043 */   private int agg_bufValue16;
/* 044 */   private boolean agg_bufIsNull17;
/* 045 */   private int agg_bufValue17;
/* 046 */   private boolean agg_bufIsNull18;
/* 047 */   private int agg_bufValue18;
/* 048 */   private boolean agg_bufIsNull19;
/* 049 */   private int agg_bufValue19;
/* 050 */   private boolean agg_bufIsNull20;
/* 051 */   private int agg_bufValue20;
/* 052 */   private boolean agg_bufIsNull21;
/* 053 */   private int agg_bufValue21;
/* 054 */   private boolean agg_bufIsNull22;
/* 055 */   private int agg_bufValue22;
/* 056 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 057 */   private agg_FastHashMap agg_fastHashMap;
/* 058 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 059 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 060 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 061 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 062 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 064 */   private scala.collection.Iterator inputadapter_input;
/* 065 */   private UnsafeRow agg_result1;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 068 */   private int agg_value36;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 070 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows1;
/* 073 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime1;
/* 074 */   private UnsafeRow agg_result2;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 077 */
/* 078 */   public GeneratedIterator(Object[] references) {
/* 079 */     this.references = references;
/* 080 */   }
/* 081 */
/* 082 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 083 */     partitionIndex = index;
/* 084 */     this.inputs = inputs;
/* 085 */     wholestagecodegen_init_0();
/* 086 */     wholestagecodegen_init_1();
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */   private void wholestagecodegen_init_0() {
/* 091 */     agg_initAgg = false;
/* 092 */
/* 093 */     agg_initAgg1 = false;
/* 094 */
/* 095 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 096 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 097 */
/* 098 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 099 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 100 */     inputadapter_input = inputs[0];
/* 101 */     agg_result1 = new UnsafeRow(1);
/* 102 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 103 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 104 */
/* 105 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 106 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 107 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 108 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 109 */
/* 110 */   }
/* 111 */
/* 112 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 113 */     // initialize aggregation buffer
/* 114 */     agg_bufIsNull = false;
/* 115 */     agg_bufValue = 0L;
/* 116 */     agg_bufIsNull1 = false;
/* 117 */     agg_bufValue1 = 0L;
/* 118 */     final int agg_value2 = -1;
/* 119 */     agg_bufIsNull2 = true;
/* 120 */     agg_bufValue2 = agg_value2;
/* 121 */     final int agg_value3 = -1;
/* 122 */     agg_bufIsNull3 = true;
/* 123 */     agg_bufValue3 = agg_value3;
/* 124 */     final int agg_value4 = -1;
/* 125 */     agg_bufIsNull4 = true;
/* 126 */     agg_bufValue4 = agg_value4;
/* 127 */     final int agg_value5 = -1;
/* 128 */     agg_bufIsNull5 = true;
/* 129 */     agg_bufValue5 = agg_value5;
/* 130 */     final int agg_value6 = -1;
/* 131 */     agg_bufIsNull6 = true;
/* 132 */     agg_bufValue6 = agg_value6;
/* 133 */     final int agg_value7 = -1;
/* 134 */     agg_bufIsNull7 = true;
/* 135 */     agg_bufValue7 = agg_value7;
/* 136 */     final int agg_value8 = -1;
/* 137 */     agg_bufIsNull8 = true;
/* 138 */     agg_bufValue8 = agg_value8;
/* 139 */     final int agg_value9 = -1;
/* 140 */     agg_bufIsNull9 = true;
/* 141 */     agg_bufValue9 = agg_value9;
/* 142 */     final int agg_value10 = -1;
/* 143 */     agg_bufIsNull10 = true;
/* 144 */     agg_bufValue10 = agg_value10;
/* 145 */     agg_bufIsNull11 = false;
/* 146 */     agg_bufValue11 = 0L;
/* 147 */
/* 148 */     if (!agg_initAgg1) {
/* 149 */       agg_initAgg1 = true;
/* 150 */       long agg_beforeAgg = System.nanoTime();
/* 151 */       agg_doAggregateWithKeys();
/* 152 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 153 */     }
/* 154 */
/* 155 */     // output the result
/* 156 */
/* 157 */     while (agg_fastHashMapIter.next()) {
/* 158 */       agg_numOutputRows.add(1);
/* 159 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 160 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 161 */
/* 162 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 163 */
/* 164 */       boolean agg_isNull93 = agg_resultRow.isNullAt(0);
/* 165 */       int agg_value104 = agg_isNull93 ? -1 : (agg_resultRow.getInt(0));
/* 166 */       long agg_value105 = agg_resultRow.getLong(1);
/* 167 */       long agg_value106 = agg_resultRow.getLong(2);
/* 168 */       boolean agg_isNull96 = agg_resultRow.isNullAt(3);
/* 169 */       int agg_value107 = agg_isNull96 ? -1 : (agg_resultRow.getInt(3));
/* 170 */       boolean agg_isNull97 = agg_resultRow.isNullAt(4);
/* 171 */       int agg_value108 = agg_isNull97 ? -1 : (agg_resultRow.getInt(4));
/* 172 */       boolean agg_isNull98 = agg_resultRow.isNullAt(5);
/* 173 */       int agg_value109 = agg_isNull98 ? -1 : (agg_resultRow.getInt(5));
/* 174 */       boolean agg_isNull99 = agg_resultRow.isNullAt(6);
/* 175 */       int agg_value110 = agg_isNull99 ? -1 : (agg_resultRow.getInt(6));
/* 176 */       boolean agg_isNull100 = agg_resultRow.isNullAt(7);
/* 177 */       int agg_value111 = agg_isNull100 ? -1 : (agg_resultRow.getInt(7));
/* 178 */       boolean agg_isNull101 = agg_resultRow.isNullAt(8);
/* 179 */       int agg_value112 = agg_isNull101 ? -1 : (agg_resultRow.getInt(8));
/* 180 */       boolean agg_isNull102 = agg_resultRow.isNullAt(9);
/* 181 */       int agg_value113 = agg_isNull102 ? -1 : (agg_resultRow.getInt(9));
/* 182 */       boolean agg_isNull103 = agg_resultRow.isNullAt(10);
/* 183 */       int agg_value114 = agg_isNull103 ? -1 : (agg_resultRow.getInt(10));
/* 184 */       boolean agg_isNull104 = agg_resultRow.isNullAt(11);
/* 185 */       int agg_value115 = agg_isNull104 ? -1 : (agg_resultRow.getInt(11));
/* 186 */
/* 187 */       // do aggregate
/* 188 */       // common sub-expressions
/* 189 */
/* 190 */       // evaluate aggregate function
/* 191 */       boolean agg_isNull105 = false;
/* 192 */
/* 193 */       long agg_value116 = -1L;
/* 194 */       agg_value116 = agg_bufValue + agg_value105;
/* 195 */       boolean agg_isNull108 = false;
/* 196 */
/* 197 */       long agg_value119 = -1L;
/* 198 */       agg_value119 = agg_bufValue1 + agg_value106;
/* 199 */       boolean agg_isNull111 = agg_bufIsNull2;
/* 200 */       int agg_value122 = agg_bufValue2;
/* 201 */
/* 202 */       if (!agg_isNull96 && (agg_isNull111 ||
/* 203 */           agg_value107 > agg_value122)) {
/* 204 */         agg_isNull111 = false;
/* 205 */         agg_value122 = agg_value107;
/* 206 */       }
/* 207 */       boolean agg_isNull114 = agg_bufIsNull3;
/* 208 */       int agg_value125 = agg_bufValue3;
/* 209 */
/* 210 */       if (!agg_isNull97 && (agg_isNull114 ||
/* 211 */           agg_value108 > agg_value125)) {
/* 212 */         agg_isNull114 = false;
/* 213 */         agg_value125 = agg_value108;
/* 214 */       }
/* 215 */       boolean agg_isNull117 = agg_bufIsNull4;
/* 216 */       int agg_value128 = agg_bufValue4;
/* 217 */
/* 218 */       if (!agg_isNull98 && (agg_isNull117 ||
/* 219 */           agg_value109 > agg_value128)) {
/* 220 */         agg_isNull117 = false;
/* 221 */         agg_value128 = agg_value109;
/* 222 */       }
/* 223 */       boolean agg_isNull120 = agg_bufIsNull5;
/* 224 */       int agg_value131 = agg_bufValue5;
/* 225 */
/* 226 */       if (!agg_isNull99 && (agg_isNull120 ||
/* 227 */           agg_value110 > agg_value131)) {
/* 228 */         agg_isNull120 = false;
/* 229 */         agg_value131 = agg_value110;
/* 230 */       }
/* 231 */       boolean agg_isNull123 = agg_bufIsNull6;
/* 232 */       int agg_value134 = agg_bufValue6;
/* 233 */
/* 234 */       if (!agg_isNull100 && (agg_isNull123 ||
/* 235 */           agg_value111 > agg_value134)) {
/* 236 */         agg_isNull123 = false;
/* 237 */         agg_value134 = agg_value111;
/* 238 */       }
/* 239 */       boolean agg_isNull126 = agg_bufIsNull7;
/* 240 */       int agg_value137 = agg_bufValue7;
/* 241 */
/* 242 */       if (!agg_isNull101 && (agg_isNull126 ||
/* 243 */           agg_value112 > agg_value137)) {
/* 244 */         agg_isNull126 = false;
/* 245 */         agg_value137 = agg_value112;
/* 246 */       }
/* 247 */       boolean agg_isNull129 = agg_bufIsNull8;
/* 248 */       int agg_value140 = agg_bufValue8;
/* 249 */
/* 250 */       if (!agg_isNull102 && (agg_isNull129 ||
/* 251 */           agg_value113 > agg_value140)) {
/* 252 */         agg_isNull129 = false;
/* 253 */         agg_value140 = agg_value113;
/* 254 */       }
/* 255 */       boolean agg_isNull132 = agg_bufIsNull9;
/* 256 */       int agg_value143 = agg_bufValue9;
/* 257 */
/* 258 */       if (!agg_isNull103 && (agg_isNull132 ||
/* 259 */           agg_value114 > agg_value143)) {
/* 260 */         agg_isNull132 = false;
/* 261 */         agg_value143 = agg_value114;
/* 262 */       }
/* 263 */       boolean agg_isNull135 = agg_bufIsNull10;
/* 264 */       int agg_value146 = agg_bufValue10;
/* 265 */
/* 266 */       if (!agg_isNull104 && (agg_isNull135 ||
/* 267 */           agg_value115 > agg_value146)) {
/* 268 */         agg_isNull135 = false;
/* 269 */         agg_value146 = agg_value115;
/* 270 */       }
/* 271 */       boolean agg_isNull138 = false;
/* 272 */       long agg_value149 = -1L;
/* 273 */       if (!false && agg_isNull93) {
/* 274 */         agg_isNull138 = agg_bufIsNull11;
/* 275 */         agg_value149 = agg_bufValue11;
/* 276 */       } else {
/* 277 */         boolean agg_isNull142 = false;
/* 278 */
/* 279 */         long agg_value153 = -1L;
/* 280 */         agg_value153 = agg_bufValue11 + 1L;
/* 281 */         agg_isNull138 = false;
/* 282 */         agg_value149 = agg_value153;
/* 283 */       }
/* 284 */       // update aggregation buffer
/* 285 */       agg_bufIsNull = false;
/* 286 */       agg_bufValue = agg_value116;
/* 287 */
/* 288 */       agg_bufIsNull1 = false;
/* 289 */       agg_bufValue1 = agg_value119;
/* 290 */
/* 291 */       agg_bufIsNull2 = agg_isNull111;
/* 292 */       agg_bufValue2 = agg_value122;
/* 293 */
/* 294 */       agg_bufIsNull3 = agg_isNull114;
/* 295 */       agg_bufValue3 = agg_value125;
/* 296 */
/* 297 */       agg_bufIsNull4 = agg_isNull117;
/* 298 */       agg_bufValue4 = agg_value128;
/* 299 */
/* 300 */       agg_bufIsNull5 = agg_isNull120;
/* 301 */       agg_bufValue5 = agg_value131;
/* 302 */
/* 303 */       agg_bufIsNull6 = agg_isNull123;
/* 304 */       agg_bufValue6 = agg_value134;
/* 305 */
/* 306 */       agg_bufIsNull7 = agg_isNull126;
/* 307 */       agg_bufValue7 = agg_value137;
/* 308 */
/* 309 */       agg_bufIsNull8 = agg_isNull129;
/* 310 */       agg_bufValue8 = agg_value140;
/* 311 */
/* 312 */       agg_bufIsNull9 = agg_isNull132;
/* 313 */       agg_bufValue9 = agg_value143;
/* 314 */
/* 315 */       agg_bufIsNull10 = agg_isNull135;
/* 316 */       agg_bufValue10 = agg_value146;
/* 317 */
/* 318 */       agg_bufIsNull11 = agg_isNull138;
/* 319 */       agg_bufValue11 = agg_value149;
/* 320 */
/* 321 */       if (shouldStop()) return;
/* 322 */     }
/* 323 */     agg_fastHashMap.close();
/* 324 */
/* 325 */     while (agg_mapIter.next()) {
/* 326 */       agg_numOutputRows.add(1);
/* 327 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 328 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 329 */
/* 330 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 331 */
/* 332 */       boolean agg_isNull93 = agg_resultRow.isNullAt(0);
/* 333 */       int agg_value104 = agg_isNull93 ? -1 : (agg_resultRow.getInt(0));
/* 334 */       long agg_value105 = agg_resultRow.getLong(1);
/* 335 */       long agg_value106 = agg_resultRow.getLong(2);
/* 336 */       boolean agg_isNull96 = agg_resultRow.isNullAt(3);
/* 337 */       int agg_value107 = agg_isNull96 ? -1 : (agg_resultRow.getInt(3));
/* 338 */       boolean agg_isNull97 = agg_resultRow.isNullAt(4);
/* 339 */       int agg_value108 = agg_isNull97 ? -1 : (agg_resultRow.getInt(4));
/* 340 */       boolean agg_isNull98 = agg_resultRow.isNullAt(5);
/* 341 */       int agg_value109 = agg_isNull98 ? -1 : (agg_resultRow.getInt(5));
/* 342 */       boolean agg_isNull99 = agg_resultRow.isNullAt(6);
/* 343 */       int agg_value110 = agg_isNull99 ? -1 : (agg_resultRow.getInt(6));
/* 344 */       boolean agg_isNull100 = agg_resultRow.isNullAt(7);
/* 345 */       int agg_value111 = agg_isNull100 ? -1 : (agg_resultRow.getInt(7));
/* 346 */       boolean agg_isNull101 = agg_resultRow.isNullAt(8);
/* 347 */       int agg_value112 = agg_isNull101 ? -1 : (agg_resultRow.getInt(8));
/* 348 */       boolean agg_isNull102 = agg_resultRow.isNullAt(9);
/* 349 */       int agg_value113 = agg_isNull102 ? -1 : (agg_resultRow.getInt(9));
/* 350 */       boolean agg_isNull103 = agg_resultRow.isNullAt(10);
/* 351 */       int agg_value114 = agg_isNull103 ? -1 : (agg_resultRow.getInt(10));
/* 352 */       boolean agg_isNull104 = agg_resultRow.isNullAt(11);
/* 353 */       int agg_value115 = agg_isNull104 ? -1 : (agg_resultRow.getInt(11));
/* 354 */
/* 355 */       // do aggregate
/* 356 */       // common sub-expressions
/* 357 */
/* 358 */       // evaluate aggregate function
/* 359 */       boolean agg_isNull105 = false;
/* 360 */
/* 361 */       long agg_value116 = -1L;
/* 362 */       agg_value116 = agg_bufValue + agg_value105;
/* 363 */       boolean agg_isNull108 = false;
/* 364 */
/* 365 */       long agg_value119 = -1L;
/* 366 */       agg_value119 = agg_bufValue1 + agg_value106;
/* 367 */       boolean agg_isNull111 = agg_bufIsNull2;
/* 368 */       int agg_value122 = agg_bufValue2;
/* 369 */
/* 370 */       if (!agg_isNull96 && (agg_isNull111 ||
/* 371 */           agg_value107 > agg_value122)) {
/* 372 */         agg_isNull111 = false;
/* 373 */         agg_value122 = agg_value107;
/* 374 */       }
/* 375 */       boolean agg_isNull114 = agg_bufIsNull3;
/* 376 */       int agg_value125 = agg_bufValue3;
/* 377 */
/* 378 */       if (!agg_isNull97 && (agg_isNull114 ||
/* 379 */           agg_value108 > agg_value125)) {
/* 380 */         agg_isNull114 = false;
/* 381 */         agg_value125 = agg_value108;
/* 382 */       }
/* 383 */       boolean agg_isNull117 = agg_bufIsNull4;
/* 384 */       int agg_value128 = agg_bufValue4;
/* 385 */
/* 386 */       if (!agg_isNull98 && (agg_isNull117 ||
/* 387 */           agg_value109 > agg_value128)) {
/* 388 */         agg_isNull117 = false;
/* 389 */         agg_value128 = agg_value109;
/* 390 */       }
/* 391 */       boolean agg_isNull120 = agg_bufIsNull5;
/* 392 */       int agg_value131 = agg_bufValue5;
/* 393 */
/* 394 */       if (!agg_isNull99 && (agg_isNull120 ||
/* 395 */           agg_value110 > agg_value131)) {
/* 396 */         agg_isNull120 = false;
/* 397 */         agg_value131 = agg_value110;
/* 398 */       }
/* 399 */       boolean agg_isNull123 = agg_bufIsNull6;
/* 400 */       int agg_value134 = agg_bufValue6;
/* 401 */
/* 402 */       if (!agg_isNull100 && (agg_isNull123 ||
/* 403 */           agg_value111 > agg_value134)) {
/* 404 */         agg_isNull123 = false;
/* 405 */         agg_value134 = agg_value111;
/* 406 */       }
/* 407 */       boolean agg_isNull126 = agg_bufIsNull7;
/* 408 */       int agg_value137 = agg_bufValue7;
/* 409 */
/* 410 */       if (!agg_isNull101 && (agg_isNull126 ||
/* 411 */           agg_value112 > agg_value137)) {
/* 412 */         agg_isNull126 = false;
/* 413 */         agg_value137 = agg_value112;
/* 414 */       }
/* 415 */       boolean agg_isNull129 = agg_bufIsNull8;
/* 416 */       int agg_value140 = agg_bufValue8;
/* 417 */
/* 418 */       if (!agg_isNull102 && (agg_isNull129 ||
/* 419 */           agg_value113 > agg_value140)) {
/* 420 */         agg_isNull129 = false;
/* 421 */         agg_value140 = agg_value113;
/* 422 */       }
/* 423 */       boolean agg_isNull132 = agg_bufIsNull9;
/* 424 */       int agg_value143 = agg_bufValue9;
/* 425 */
/* 426 */       if (!agg_isNull103 && (agg_isNull132 ||
/* 427 */           agg_value114 > agg_value143)) {
/* 428 */         agg_isNull132 = false;
/* 429 */         agg_value143 = agg_value114;
/* 430 */       }
/* 431 */       boolean agg_isNull135 = agg_bufIsNull10;
/* 432 */       int agg_value146 = agg_bufValue10;
/* 433 */
/* 434 */       if (!agg_isNull104 && (agg_isNull135 ||
/* 435 */           agg_value115 > agg_value146)) {
/* 436 */         agg_isNull135 = false;
/* 437 */         agg_value146 = agg_value115;
/* 438 */       }
/* 439 */       boolean agg_isNull138 = false;
/* 440 */       long agg_value149 = -1L;
/* 441 */       if (!false && agg_isNull93) {
/* 442 */         agg_isNull138 = agg_bufIsNull11;
/* 443 */         agg_value149 = agg_bufValue11;
/* 444 */       } else {
/* 445 */         boolean agg_isNull142 = false;
/* 446 */
/* 447 */         long agg_value153 = -1L;
/* 448 */         agg_value153 = agg_bufValue11 + 1L;
/* 449 */         agg_isNull138 = false;
/* 450 */         agg_value149 = agg_value153;
/* 451 */       }
/* 452 */       // update aggregation buffer
/* 453 */       agg_bufIsNull = false;
/* 454 */       agg_bufValue = agg_value116;
/* 455 */
/* 456 */       agg_bufIsNull1 = false;
/* 457 */       agg_bufValue1 = agg_value119;
/* 458 */
/* 459 */       agg_bufIsNull2 = agg_isNull111;
/* 460 */       agg_bufValue2 = agg_value122;
/* 461 */
/* 462 */       agg_bufIsNull3 = agg_isNull114;
/* 463 */       agg_bufValue3 = agg_value125;
/* 464 */
/* 465 */       agg_bufIsNull4 = agg_isNull117;
/* 466 */       agg_bufValue4 = agg_value128;
/* 467 */
/* 468 */       agg_bufIsNull5 = agg_isNull120;
/* 469 */       agg_bufValue5 = agg_value131;
/* 470 */
/* 471 */       agg_bufIsNull6 = agg_isNull123;
/* 472 */       agg_bufValue6 = agg_value134;
/* 473 */
/* 474 */       agg_bufIsNull7 = agg_isNull126;
/* 475 */       agg_bufValue7 = agg_value137;
/* 476 */
/* 477 */       agg_bufIsNull8 = agg_isNull129;
/* 478 */       agg_bufValue8 = agg_value140;
/* 479 */
/* 480 */       agg_bufIsNull9 = agg_isNull132;
/* 481 */       agg_bufValue9 = agg_value143;
/* 482 */
/* 483 */       agg_bufIsNull10 = agg_isNull135;
/* 484 */       agg_bufValue10 = agg_value146;
/* 485 */
/* 486 */       agg_bufIsNull11 = agg_isNull138;
/* 487 */       agg_bufValue11 = agg_value149;
/* 488 */
/* 489 */       if (shouldStop()) return;
/* 490 */     }
/* 491 */
/* 492 */     agg_mapIter.close();
/* 493 */     if (agg_sorter == null) {
/* 494 */       agg_hashMap.free();
/* 495 */     }
/* 496 */
/* 497 */   }
/* 498 */
/* 499 */   public class agg_FastHashMap {
/* 500 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 501 */     private int[] buckets;
/* 502 */     private int capacity = 1 << 16;
/* 503 */     private double loadFactor = 0.5;
/* 504 */     private int numBuckets = (int) (capacity / loadFactor);
/* 505 */     private int maxSteps = 2;
/* 506 */     private int numRows = 0;
/* 507 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 508 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.LongType)
/* 509 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType)
/* 510 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 511 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 512 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 513 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 514 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 515 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 516 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 517 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 518 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 519 */     private Object emptyVBase;
/* 520 */     private long emptyVOff;
/* 521 */     private int emptyVLen;
/* 522 */     private boolean isBatchFull = false;
/* 523 */
/* 524 */     public agg_FastHashMap(
/* 525 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 526 */       InternalRow emptyAggregationBuffer) {
/* 527 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 528 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 529 */
/* 530 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 531 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 532 */
/* 533 */       emptyVBase = emptyBuffer;
/* 534 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 535 */       emptyVLen = emptyBuffer.length;
/* 536 */
/* 537 */       buckets = new int[numBuckets];
/* 538 */       java.util.Arrays.fill(buckets, -1);
/* 539 */     }
/* 540 */
/* 541 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 542 */       long h = hash(agg_key);
/* 543 */       int step = 0;
/* 544 */       int idx = (int) h & (numBuckets - 1);
/* 545 */       while (step < maxSteps) {
/* 546 */         // Return bucket index if it's either an empty slot or already contains the key
/* 547 */         if (buckets[idx] == -1) {
/* 548 */           if (numRows < capacity && !isBatchFull) {
/* 549 */             // creating the unsafe for new entry
/* 550 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 551 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 552 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 553 */               0);
/* 554 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 555 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 556 */               agg_holder,
/* 557 */               1);
/* 558 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 559 */             agg_rowWriter.zeroOutNullBytes();
/* 560 */             agg_rowWriter.write(0, agg_key);
/* 561 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 562 */             Object kbase = agg_result.getBaseObject();
/* 563 */             long koff = agg_result.getBaseOffset();
/* 564 */             int klen = agg_result.getSizeInBytes();
/* 565 */
/* 566 */             UnsafeRow vRow
/* 567 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 568 */             if (vRow == null) {
/* 569 */               isBatchFull = true;
/* 570 */             } else {
/* 571 */               buckets[idx] = numRows++;
/* 572 */             }
/* 573 */             return vRow;
/* 574 */           } else {
/* 575 */             // No more space
/* 576 */             return null;
/* 577 */           }
/* 578 */         } else if (equals(idx, agg_key)) {
/* 579 */           return batch.getValueRow(buckets[idx]);
/* 580 */         }
/* 581 */         idx = (idx + 1) & (numBuckets - 1);
/* 582 */         step++;
/* 583 */       }
/* 584 */       // Didn't find it
/* 585 */       return null;
/* 586 */     }
/* 587 */
/* 588 */     private boolean equals(int idx, int agg_key) {
/* 589 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 590 */       return (row.getInt(0) == agg_key);
/* 591 */     }
/* 592 */
/* 593 */     private long hash(int agg_key) {
/* 594 */       long agg_hash = 0;
/* 595 */
/* 596 */       int agg_result = agg_key;
/* 597 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 598 */
/* 599 */       return agg_hash;
/* 600 */     }
/* 601 */
/* 602 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 603 */       return batch.rowIterator();
/* 604 */     }
/* 605 */
/* 606 */     public void close() {
/* 607 */       batch.close();
/* 608 */     }
/* 609 */
/* 610 */   }
/* 611 */
/* 612 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 613 */     agg_hashMap = agg_plan.createHashMap();
/* 614 */
/* 615 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 616 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 617 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 618 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 619 */       long inputadapter_value1 = inputadapter_row.getLong(1);
/* 620 */       long inputadapter_value2 = inputadapter_row.getLong(2);
/* 621 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 622 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 623 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 624 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 625 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 626 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 627 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 628 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 629 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 630 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 631 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 632 */       int inputadapter_value8 = inputadapter_isNull8 ? -1 : (inputadapter_row.getInt(8));
/* 633 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 634 */       int inputadapter_value9 = inputadapter_isNull9 ? -1 : (inputadapter_row.getInt(9));
/* 635 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 636 */       int inputadapter_value10 = inputadapter_isNull10 ? -1 : (inputadapter_row.getInt(10));
/* 637 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 638 */       int inputadapter_value11 = inputadapter_isNull11 ? -1 : (inputadapter_row.getInt(11));
/* 639 */
/* 640 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 641 */
/* 642 */       UnsafeRow agg_fastAggBuffer = null;
/* 643 */
/* 644 */       if (true) {
/* 645 */         if (!inputadapter_isNull) {
/* 646 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 647 */             inputadapter_value);
/* 648 */         }
/* 649 */       }
/* 650 */
/* 651 */       if (agg_fastAggBuffer == null) {
/* 652 */         // generate grouping key
/* 653 */         agg_rowWriter.zeroOutNullBytes();
/* 654 */
/* 655 */         if (inputadapter_isNull) {
/* 656 */           agg_rowWriter.setNullAt(0);
/* 657 */         } else {
/* 658 */           agg_rowWriter.write(0, inputadapter_value);
/* 659 */         }
/* 660 */         agg_value36 = 42;
/* 661 */
/* 662 */         if (!inputadapter_isNull) {
/* 663 */           agg_value36 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value36);
/* 664 */         }
/* 665 */         if (true) {
/* 666 */           // try to get the buffer from hash map
/* 667 */           agg_unsafeRowAggBuffer =
/* 668 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value36);
/* 669 */         }
/* 670 */         if (agg_unsafeRowAggBuffer == null) {
/* 671 */           if (agg_sorter == null) {
/* 672 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 673 */           } else {
/* 674 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 675 */           }
/* 676 */
/* 677 */           // the hash map had be spilled, it should have enough memory now,
/* 678 */           // try  to allocate buffer again.
/* 679 */           agg_unsafeRowAggBuffer =
/* 680 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value36);
/* 681 */           if (agg_unsafeRowAggBuffer == null) {
/* 682 */             // failed to allocate the first page
/* 683 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 684 */           }
/* 685 */         }
/* 686 */       }
/* 687 */
/* 688 */       if (agg_fastAggBuffer != null) {
/* 689 */         // update fast row
/* 690 */
/* 691 */         // common sub-expressions
/* 692 */
/* 693 */         // evaluate aggregate function
/* 694 */         boolean agg_isNull60 = false;
/* 695 */
/* 696 */         long agg_value72 = agg_fastAggBuffer.getLong(0);
/* 697 */
/* 698 */         long agg_value71 = -1L;
/* 699 */         agg_value71 = agg_value72 + inputadapter_value1;
/* 700 */         boolean agg_isNull63 = false;
/* 701 */
/* 702 */         long agg_value75 = agg_fastAggBuffer.getLong(1);
/* 703 */
/* 704 */         long agg_value74 = -1L;
/* 705 */         agg_value74 = agg_value75 + inputadapter_value2;
/* 706 */         boolean agg_isNull67 = agg_fastAggBuffer.isNullAt(2);
/* 707 */         int agg_value78 = agg_isNull67 ? -1 : (agg_fastAggBuffer.getInt(2));
/* 708 */         boolean agg_isNull66 = agg_isNull67;
/* 709 */         int agg_value77 = agg_value78;
/* 710 */
/* 711 */         if (!inputadapter_isNull3 && (agg_isNull66 ||
/* 712 */             inputadapter_value3 > agg_value77)) {
/* 713 */           agg_isNull66 = false;
/* 714 */           agg_value77 = inputadapter_value3;
/* 715 */         }
/* 716 */         boolean agg_isNull70 = agg_fastAggBuffer.isNullAt(3);
/* 717 */         int agg_value81 = agg_isNull70 ? -1 : (agg_fastAggBuffer.getInt(3));
/* 718 */         boolean agg_isNull69 = agg_isNull70;
/* 719 */         int agg_value80 = agg_value81;
/* 720 */
/* 721 */         if (!inputadapter_isNull4 && (agg_isNull69 ||
/* 722 */             inputadapter_value4 > agg_value80)) {
/* 723 */           agg_isNull69 = false;
/* 724 */           agg_value80 = inputadapter_value4;
/* 725 */         }
/* 726 */         boolean agg_isNull73 = agg_fastAggBuffer.isNullAt(4);
/* 727 */         int agg_value84 = agg_isNull73 ? -1 : (agg_fastAggBuffer.getInt(4));
/* 728 */         boolean agg_isNull72 = agg_isNull73;
/* 729 */         int agg_value83 = agg_value84;
/* 730 */
/* 731 */         if (!inputadapter_isNull5 && (agg_isNull72 ||
/* 732 */             inputadapter_value5 > agg_value83)) {
/* 733 */           agg_isNull72 = false;
/* 734 */           agg_value83 = inputadapter_value5;
/* 735 */         }
/* 736 */         boolean agg_isNull76 = agg_fastAggBuffer.isNullAt(5);
/* 737 */         int agg_value87 = agg_isNull76 ? -1 : (agg_fastAggBuffer.getInt(5));
/* 738 */         boolean agg_isNull75 = agg_isNull76;
/* 739 */         int agg_value86 = agg_value87;
/* 740 */
/* 741 */         if (!inputadapter_isNull6 && (agg_isNull75 ||
/* 742 */             inputadapter_value6 > agg_value86)) {
/* 743 */           agg_isNull75 = false;
/* 744 */           agg_value86 = inputadapter_value6;
/* 745 */         }
/* 746 */         boolean agg_isNull79 = agg_fastAggBuffer.isNullAt(6);
/* 747 */         int agg_value90 = agg_isNull79 ? -1 : (agg_fastAggBuffer.getInt(6));
/* 748 */         boolean agg_isNull78 = agg_isNull79;
/* 749 */         int agg_value89 = agg_value90;
/* 750 */
/* 751 */         if (!inputadapter_isNull7 && (agg_isNull78 ||
/* 752 */             inputadapter_value7 > agg_value89)) {
/* 753 */           agg_isNull78 = false;
/* 754 */           agg_value89 = inputadapter_value7;
/* 755 */         }
/* 756 */         boolean agg_isNull82 = agg_fastAggBuffer.isNullAt(7);
/* 757 */         int agg_value93 = agg_isNull82 ? -1 : (agg_fastAggBuffer.getInt(7));
/* 758 */         boolean agg_isNull81 = agg_isNull82;
/* 759 */         int agg_value92 = agg_value93;
/* 760 */
/* 761 */         if (!inputadapter_isNull8 && (agg_isNull81 ||
/* 762 */             inputadapter_value8 > agg_value92)) {
/* 763 */           agg_isNull81 = false;
/* 764 */           agg_value92 = inputadapter_value8;
/* 765 */         }
/* 766 */         boolean agg_isNull85 = agg_fastAggBuffer.isNullAt(8);
/* 767 */         int agg_value96 = agg_isNull85 ? -1 : (agg_fastAggBuffer.getInt(8));
/* 768 */         boolean agg_isNull84 = agg_isNull85;
/* 769 */         int agg_value95 = agg_value96;
/* 770 */
/* 771 */         if (!inputadapter_isNull9 && (agg_isNull84 ||
/* 772 */             inputadapter_value9 > agg_value95)) {
/* 773 */           agg_isNull84 = false;
/* 774 */           agg_value95 = inputadapter_value9;
/* 775 */         }
/* 776 */         boolean agg_isNull88 = agg_fastAggBuffer.isNullAt(9);
/* 777 */         int agg_value99 = agg_isNull88 ? -1 : (agg_fastAggBuffer.getInt(9));
/* 778 */         boolean agg_isNull87 = agg_isNull88;
/* 779 */         int agg_value98 = agg_value99;
/* 780 */
/* 781 */         if (!inputadapter_isNull10 && (agg_isNull87 ||
/* 782 */             inputadapter_value10 > agg_value98)) {
/* 783 */           agg_isNull87 = false;
/* 784 */           agg_value98 = inputadapter_value10;
/* 785 */         }
/* 786 */         boolean agg_isNull91 = agg_fastAggBuffer.isNullAt(10);
/* 787 */         int agg_value102 = agg_isNull91 ? -1 : (agg_fastAggBuffer.getInt(10));
/* 788 */         boolean agg_isNull90 = agg_isNull91;
/* 789 */         int agg_value101 = agg_value102;
/* 790 */
/* 791 */         if (!inputadapter_isNull11 && (agg_isNull90 ||
/* 792 */             inputadapter_value11 > agg_value101)) {
/* 793 */           agg_isNull90 = false;
/* 794 */           agg_value101 = inputadapter_value11;
/* 795 */         }
/* 796 */         // update fast row
/* 797 */         agg_fastAggBuffer.setLong(0, agg_value71);
/* 798 */         agg_fastAggBuffer.setLong(1, agg_value74);
/* 799 */
/* 800 */         if (!agg_isNull66) {
/* 801 */           agg_fastAggBuffer.setInt(2, agg_value77);
/* 802 */         } else {
/* 803 */           agg_fastAggBuffer.setNullAt(2);
/* 804 */         }
/* 805 */
/* 806 */         if (!agg_isNull69) {
/* 807 */           agg_fastAggBuffer.setInt(3, agg_value80);
/* 808 */         } else {
/* 809 */           agg_fastAggBuffer.setNullAt(3);
/* 810 */         }
/* 811 */
/* 812 */         if (!agg_isNull72) {
/* 813 */           agg_fastAggBuffer.setInt(4, agg_value83);
/* 814 */         } else {
/* 815 */           agg_fastAggBuffer.setNullAt(4);
/* 816 */         }
/* 817 */
/* 818 */         if (!agg_isNull75) {
/* 819 */           agg_fastAggBuffer.setInt(5, agg_value86);
/* 820 */         } else {
/* 821 */           agg_fastAggBuffer.setNullAt(5);
/* 822 */         }
/* 823 */
/* 824 */         if (!agg_isNull78) {
/* 825 */           agg_fastAggBuffer.setInt(6, agg_value89);
/* 826 */         } else {
/* 827 */           agg_fastAggBuffer.setNullAt(6);
/* 828 */         }
/* 829 */
/* 830 */         if (!agg_isNull81) {
/* 831 */           agg_fastAggBuffer.setInt(7, agg_value92);
/* 832 */         } else {
/* 833 */           agg_fastAggBuffer.setNullAt(7);
/* 834 */         }
/* 835 */
/* 836 */         if (!agg_isNull84) {
/* 837 */           agg_fastAggBuffer.setInt(8, agg_value95);
/* 838 */         } else {
/* 839 */           agg_fastAggBuffer.setNullAt(8);
/* 840 */         }
/* 841 */
/* 842 */         if (!agg_isNull87) {
/* 843 */           agg_fastAggBuffer.setInt(9, agg_value98);
/* 844 */         } else {
/* 845 */           agg_fastAggBuffer.setNullAt(9);
/* 846 */         }
/* 847 */
/* 848 */         if (!agg_isNull90) {
/* 849 */           agg_fastAggBuffer.setInt(10, agg_value101);
/* 850 */         } else {
/* 851 */           agg_fastAggBuffer.setNullAt(10);
/* 852 */         }
/* 853 */
/* 854 */       } else {
/* 855 */         // update unsafe row
/* 856 */
/* 857 */         // common sub-expressions
/* 858 */
/* 859 */         // evaluate aggregate function
/* 860 */         boolean agg_isNull27 = false;
/* 861 */
/* 862 */         long agg_value39 = agg_unsafeRowAggBuffer.getLong(0);
/* 863 */
/* 864 */         long agg_value38 = -1L;
/* 865 */         agg_value38 = agg_value39 + inputadapter_value1;
/* 866 */         boolean agg_isNull30 = false;
/* 867 */
/* 868 */         long agg_value42 = agg_unsafeRowAggBuffer.getLong(1);
/* 869 */
/* 870 */         long agg_value41 = -1L;
/* 871 */         agg_value41 = agg_value42 + inputadapter_value2;
/* 872 */         boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 873 */         int agg_value45 = agg_isNull34 ? -1 : (agg_unsafeRowAggBuffer.getInt(2));
/* 874 */         boolean agg_isNull33 = agg_isNull34;
/* 875 */         int agg_value44 = agg_value45;
/* 876 */
/* 877 */         if (!inputadapter_isNull3 && (agg_isNull33 ||
/* 878 */             inputadapter_value3 > agg_value44)) {
/* 879 */           agg_isNull33 = false;
/* 880 */           agg_value44 = inputadapter_value3;
/* 881 */         }
/* 882 */         boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 883 */         int agg_value48 = agg_isNull37 ? -1 : (agg_unsafeRowAggBuffer.getInt(3));
/* 884 */         boolean agg_isNull36 = agg_isNull37;
/* 885 */         int agg_value47 = agg_value48;
/* 886 */
/* 887 */         if (!inputadapter_isNull4 && (agg_isNull36 ||
/* 888 */             inputadapter_value4 > agg_value47)) {
/* 889 */           agg_isNull36 = false;
/* 890 */           agg_value47 = inputadapter_value4;
/* 891 */         }
/* 892 */         boolean agg_isNull40 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 893 */         int agg_value51 = agg_isNull40 ? -1 : (agg_unsafeRowAggBuffer.getInt(4));
/* 894 */         boolean agg_isNull39 = agg_isNull40;
/* 895 */         int agg_value50 = agg_value51;
/* 896 */
/* 897 */         if (!inputadapter_isNull5 && (agg_isNull39 ||
/* 898 */             inputadapter_value5 > agg_value50)) {
/* 899 */           agg_isNull39 = false;
/* 900 */           agg_value50 = inputadapter_value5;
/* 901 */         }
/* 902 */         boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 903 */         int agg_value54 = agg_isNull43 ? -1 : (agg_unsafeRowAggBuffer.getInt(5));
/* 904 */         boolean agg_isNull42 = agg_isNull43;
/* 905 */         int agg_value53 = agg_value54;
/* 906 */
/* 907 */         if (!inputadapter_isNull6 && (agg_isNull42 ||
/* 908 */             inputadapter_value6 > agg_value53)) {
/* 909 */           agg_isNull42 = false;
/* 910 */           agg_value53 = inputadapter_value6;
/* 911 */         }
/* 912 */         boolean agg_isNull46 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 913 */         int agg_value57 = agg_isNull46 ? -1 : (agg_unsafeRowAggBuffer.getInt(6));
/* 914 */         boolean agg_isNull45 = agg_isNull46;
/* 915 */         int agg_value56 = agg_value57;
/* 916 */
/* 917 */         if (!inputadapter_isNull7 && (agg_isNull45 ||
/* 918 */             inputadapter_value7 > agg_value56)) {
/* 919 */           agg_isNull45 = false;
/* 920 */           agg_value56 = inputadapter_value7;
/* 921 */         }
/* 922 */         boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 923 */         int agg_value60 = agg_isNull49 ? -1 : (agg_unsafeRowAggBuffer.getInt(7));
/* 924 */         boolean agg_isNull48 = agg_isNull49;
/* 925 */         int agg_value59 = agg_value60;
/* 926 */
/* 927 */         if (!inputadapter_isNull8 && (agg_isNull48 ||
/* 928 */             inputadapter_value8 > agg_value59)) {
/* 929 */           agg_isNull48 = false;
/* 930 */           agg_value59 = inputadapter_value8;
/* 931 */         }
/* 932 */         boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 933 */         int agg_value63 = agg_isNull52 ? -1 : (agg_unsafeRowAggBuffer.getInt(8));
/* 934 */         boolean agg_isNull51 = agg_isNull52;
/* 935 */         int agg_value62 = agg_value63;
/* 936 */
/* 937 */         if (!inputadapter_isNull9 && (agg_isNull51 ||
/* 938 */             inputadapter_value9 > agg_value62)) {
/* 939 */           agg_isNull51 = false;
/* 940 */           agg_value62 = inputadapter_value9;
/* 941 */         }
/* 942 */         boolean agg_isNull55 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 943 */         int agg_value66 = agg_isNull55 ? -1 : (agg_unsafeRowAggBuffer.getInt(9));
/* 944 */         boolean agg_isNull54 = agg_isNull55;
/* 945 */         int agg_value65 = agg_value66;
/* 946 */
/* 947 */         if (!inputadapter_isNull10 && (agg_isNull54 ||
/* 948 */             inputadapter_value10 > agg_value65)) {
/* 949 */           agg_isNull54 = false;
/* 950 */           agg_value65 = inputadapter_value10;
/* 951 */         }
/* 952 */         boolean agg_isNull58 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 953 */         int agg_value69 = agg_isNull58 ? -1 : (agg_unsafeRowAggBuffer.getInt(10));
/* 954 */         boolean agg_isNull57 = agg_isNull58;
/* 955 */         int agg_value68 = agg_value69;
/* 956 */
/* 957 */         if (!inputadapter_isNull11 && (agg_isNull57 ||
/* 958 */             inputadapter_value11 > agg_value68)) {
/* 959 */           agg_isNull57 = false;
/* 960 */           agg_value68 = inputadapter_value11;
/* 961 */         }
/* 962 */         // update unsafe row buffer
/* 963 */         agg_unsafeRowAggBuffer.setLong(0, agg_value38);
/* 964 */         agg_unsafeRowAggBuffer.setLong(1, agg_value41);
/* 965 */
/* 966 */         if (!agg_isNull33) {
/* 967 */           agg_unsafeRowAggBuffer.setInt(2, agg_value44);
/* 968 */         } else {
/* 969 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 970 */         }
/* 971 */
/* 972 */         if (!agg_isNull36) {
/* 973 */           agg_unsafeRowAggBuffer.setInt(3, agg_value47);
/* 974 */         } else {
/* 975 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 976 */         }
/* 977 */
/* 978 */         if (!agg_isNull39) {
/* 979 */           agg_unsafeRowAggBuffer.setInt(4, agg_value50);
/* 980 */         } else {
/* 981 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 982 */         }
/* 983 */
/* 984 */         if (!agg_isNull42) {
/* 985 */           agg_unsafeRowAggBuffer.setInt(5, agg_value53);
/* 986 */         } else {
/* 987 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 988 */         }
/* 989 */
/* 990 */         if (!agg_isNull45) {
/* 991 */           agg_unsafeRowAggBuffer.setInt(6, agg_value56);
/* 992 */         } else {
/* 993 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 994 */         }
/* 995 */
/* 996 */         if (!agg_isNull48) {
/* 997 */           agg_unsafeRowAggBuffer.setInt(7, agg_value59);
/* 998 */         } else {
/* 999 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 1000 */         }
/* 1001 */
/* 1002 */         if (!agg_isNull51) {
/* 1003 */           agg_unsafeRowAggBuffer.setInt(8, agg_value62);
/* 1004 */         } else {
/* 1005 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 1006 */         }
/* 1007 */
/* 1008 */         if (!agg_isNull54) {
/* 1009 */           agg_unsafeRowAggBuffer.setInt(9, agg_value65);
/* 1010 */         } else {
/* 1011 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 1012 */         }
/* 1013 */
/* 1014 */         if (!agg_isNull57) {
/* 1015 */           agg_unsafeRowAggBuffer.setInt(10, agg_value68);
/* 1016 */         } else {
/* 1017 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 1018 */         }
/* 1019 */
/* 1020 */       }
/* 1021 */       if (shouldStop()) return;
/* 1022 */     }
/* 1023 */
/* 1024 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1025 */
/* 1026 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1027 */   }
/* 1028 */
/* 1029 */   private void wholestagecodegen_init_1() {
/* 1030 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 1031 */     agg_result2 = new UnsafeRow(12);
/* 1032 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 1033 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 12);
/* 1034 */
/* 1035 */   }
/* 1036 */
/* 1037 */   protected void processNext() throws java.io.IOException {
/* 1038 */     while (!agg_initAgg) {
/* 1039 */       agg_initAgg = true;
/* 1040 */       long agg_beforeAgg1 = System.nanoTime();
/* 1041 */       agg_doAggregateWithoutKey();
/* 1042 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 1043 */
/* 1044 */       // output the result
/* 1045 */
/* 1046 */       agg_numOutputRows1.add(1);
/* 1047 */       agg_rowWriter1.zeroOutNullBytes();
/* 1048 */
/* 1049 */       if (agg_bufIsNull) {
/* 1050 */         agg_rowWriter1.setNullAt(0);
/* 1051 */       } else {
/* 1052 */         agg_rowWriter1.write(0, agg_bufValue);
/* 1053 */       }
/* 1054 */
/* 1055 */       if (agg_bufIsNull1) {
/* 1056 */         agg_rowWriter1.setNullAt(1);
/* 1057 */       } else {
/* 1058 */         agg_rowWriter1.write(1, agg_bufValue1);
/* 1059 */       }
/* 1060 */
/* 1061 */       if (agg_bufIsNull2) {
/* 1062 */         agg_rowWriter1.setNullAt(2);
/* 1063 */       } else {
/* 1064 */         agg_rowWriter1.write(2, agg_bufValue2);
/* 1065 */       }
/* 1066 */
/* 1067 */       if (agg_bufIsNull3) {
/* 1068 */         agg_rowWriter1.setNullAt(3);
/* 1069 */       } else {
/* 1070 */         agg_rowWriter1.write(3, agg_bufValue3);
/* 1071 */       }
/* 1072 */
/* 1073 */       if (agg_bufIsNull4) {
/* 1074 */         agg_rowWriter1.setNullAt(4);
/* 1075 */       } else {
/* 1076 */         agg_rowWriter1.write(4, agg_bufValue4);
/* 1077 */       }
/* 1078 */
/* 1079 */       if (agg_bufIsNull5) {
/* 1080 */         agg_rowWriter1.setNullAt(5);
/* 1081 */       } else {
/* 1082 */         agg_rowWriter1.write(5, agg_bufValue5);
/* 1083 */       }
/* 1084 */
/* 1085 */       if (agg_bufIsNull6) {
/* 1086 */         agg_rowWriter1.setNullAt(6);
/* 1087 */       } else {
/* 1088 */         agg_rowWriter1.write(6, agg_bufValue6);
/* 1089 */       }
/* 1090 */
/* 1091 */       if (agg_bufIsNull7) {
/* 1092 */         agg_rowWriter1.setNullAt(7);
/* 1093 */       } else {
/* 1094 */         agg_rowWriter1.write(7, agg_bufValue7);
/* 1095 */       }
/* 1096 */
/* 1097 */       if (agg_bufIsNull8) {
/* 1098 */         agg_rowWriter1.setNullAt(8);
/* 1099 */       } else {
/* 1100 */         agg_rowWriter1.write(8, agg_bufValue8);
/* 1101 */       }
/* 1102 */
/* 1103 */       if (agg_bufIsNull9) {
/* 1104 */         agg_rowWriter1.setNullAt(9);
/* 1105 */       } else {
/* 1106 */         agg_rowWriter1.write(9, agg_bufValue9);
/* 1107 */       }
/* 1108 */
/* 1109 */       if (agg_bufIsNull10) {
/* 1110 */         agg_rowWriter1.setNullAt(10);
/* 1111 */       } else {
/* 1112 */         agg_rowWriter1.write(10, agg_bufValue10);
/* 1113 */       }
/* 1114 */
/* 1115 */       if (agg_bufIsNull11) {
/* 1116 */         agg_rowWriter1.setNullAt(11);
/* 1117 */       } else {
/* 1118 */         agg_rowWriter1.write(11, agg_bufValue11);
/* 1119 */       }
/* 1120 */       append(agg_result2);
/* 1121 */     }
/* 1122 */   }
/* 1123 */ }
