/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private Decimal agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private Decimal agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private Decimal agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private Decimal agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private long agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private Decimal agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private long agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private Decimal agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private long agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private Decimal agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private long agg_bufValue13;
/* 037 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 038 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 039 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 040 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 043 */   private scala.collection.Iterator smj_leftInput;
/* 044 */   private scala.collection.Iterator smj_rightInput;
/* 045 */   private InternalRow smj_leftRow;
/* 046 */   private InternalRow smj_rightRow;
/* 047 */   private int smj_value2;
/* 048 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 049 */   private int smj_value3;
/* 050 */   private int smj_value4;
/* 051 */   private boolean smj_isNull2;
/* 052 */   private int smj_value5;
/* 053 */   private boolean smj_isNull3;
/* 054 */   private int smj_value6;
/* 055 */   private boolean smj_isNull4;
/* 056 */   private double smj_value7;
/* 057 */   private boolean smj_isNull5;
/* 058 */   private double smj_value8;
/* 059 */   private boolean smj_isNull6;
/* 060 */   private double smj_value9;
/* 061 */   private boolean smj_isNull7;
/* 062 */   private double smj_value10;
/* 063 */   private boolean smj_isNull8;
/* 064 */   private int smj_value11;
/* 065 */   private boolean smj_isNull9;
/* 066 */   private int smj_value12;
/* 067 */   private boolean smj_isNull10;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 069 */   private UnsafeRow smj_result;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 072 */   private UnsafeRow project_result;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 075 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 076 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 078 */   private UnsafeRow bhj_result;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 081 */   private UnsafeRow project_result1;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 084 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 085 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 087 */   private UnsafeRow bhj_result1;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 090 */   private UnsafeRow project_result2;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 093 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 094 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 095 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 096 */   private UnsafeRow bhj_result2;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 099 */   private UnsafeRow project_result3;
/* 100 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 102 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 103 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 104 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 105 */   private UnsafeRow bhj_result3;
/* 106 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 107 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 108 */   private UnsafeRow project_result4;
/* 109 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 110 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 111 */   private org.apache.spark.sql.execution.metric.SQLMetric expand_numOutputRows;
/* 112 */   private UnsafeRow expand_result;
/* 113 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder expand_holder;
/* 114 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter expand_rowWriter;
/* 115 */   private UnsafeRow agg_result;
/* 116 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 117 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 118 */   private int agg_value45;
/* 119 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 120 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 121 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 122 */
/* 123 */   public GeneratedIterator(Object[] references) {
/* 124 */     this.references = references;
/* 125 */   }
/* 126 */
/* 127 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 128 */     partitionIndex = index;
/* 129 */     this.inputs = inputs;
/* 130 */     wholestagecodegen_init_0();
/* 131 */     wholestagecodegen_init_1();
/* 132 */     wholestagecodegen_init_2();
/* 133 */     wholestagecodegen_init_3();
/* 134 */     wholestagecodegen_init_4();
/* 135 */
/* 136 */   }
/* 137 */
/* 138 */   private void wholestagecodegen_init_0() {
/* 139 */     agg_initAgg = false;
/* 140 */
/* 141 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 142 */
/* 143 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 144 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 145 */     smj_leftInput = inputs[0];
/* 146 */     smj_rightInput = inputs[1];
/* 147 */
/* 148 */     smj_rightRow = null;
/* 149 */
/* 150 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 151 */
/* 152 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 153 */     smj_result = new UnsafeRow(13);
/* 154 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 155 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 13);
/* 156 */     project_result = new UnsafeRow(11);
/* 157 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 158 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 159 */
/* 160 */   }
/* 161 */
/* 162 */   private void wholestagecodegen_init_3() {
/* 163 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 13);
/* 164 */     project_result3 = new UnsafeRow(11);
/* 165 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 166 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 11);
/* 167 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 168 */
/* 169 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 170 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 171 */
/* 172 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 173 */     bhj_result3 = new UnsafeRow(13);
/* 174 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 128);
/* 175 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 13);
/* 176 */     project_result4 = new UnsafeRow(11);
/* 177 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 128);
/* 178 */
/* 179 */   }
/* 180 */
/* 181 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 182 */     agg_hashMap = agg_plan.createHashMap();
/* 183 */
/* 184 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 185 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 186 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 187 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 188 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 189 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 190 */       smj_value6 = smj_isNull4 ? -1 : (smj_leftRow.getInt(2));
/* 191 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 192 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 193 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 194 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 195 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 196 */       smj_value9 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(5));
/* 197 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 198 */       smj_value10 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(6));
/* 199 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 200 */       smj_value11 = smj_isNull9 ? -1 : (smj_leftRow.getInt(7));
/* 201 */       smj_isNull10 = smj_leftRow.isNullAt(8);
/* 202 */       smj_value12 = smj_isNull10 ? -1 : (smj_leftRow.getInt(8));
/* 203 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 204 */       while (smj_iterator.hasNext()) {
/* 205 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 206 */
/* 207 */         smj_numOutputRows.add(1);
/* 208 */
/* 209 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(1);
/* 210 */         int smj_value14 = smj_isNull12 ? -1 : (smj_rightRow1.getInt(1));
/* 211 */
/* 212 */         // generate join key for stream side
/* 213 */
/* 214 */         boolean bhj_isNull = smj_isNull12;
/* 215 */         long bhj_value = -1L;
/* 216 */         if (!smj_isNull12) {
/* 217 */           bhj_value = (long) smj_value14;
/* 218 */         }
/* 219 */         // find matches from HashedRelation
/* 220 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 221 */         if (bhj_matched == null) continue;
/* 222 */
/* 223 */         bhj_numOutputRows.add(1);
/* 224 */
/* 225 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(2);
/* 226 */         int smj_value15 = smj_isNull13 ? -1 : (smj_rightRow1.getInt(2));
/* 227 */
/* 228 */         // generate join key for stream side
/* 229 */
/* 230 */         boolean bhj_isNull15 = smj_isNull13;
/* 231 */         long bhj_value15 = -1L;
/* 232 */         if (!smj_isNull13) {
/* 233 */           bhj_value15 = (long) smj_value15;
/* 234 */         }
/* 235 */         // find matches from HashedRelation
/* 236 */         UnsafeRow bhj_matched1 = bhj_isNull15 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value15);
/* 237 */         if (bhj_matched1 == null) continue;
/* 238 */
/* 239 */         bhj_numOutputRows1.add(1);
/* 240 */
/* 241 */         // generate join key for stream side
/* 242 */
/* 243 */         boolean bhj_isNull35 = smj_isNull9;
/* 244 */         long bhj_value35 = -1L;
/* 245 */         if (!smj_isNull9) {
/* 246 */           bhj_value35 = (long) smj_value11;
/* 247 */         }
/* 248 */         // find matches from HashedRelation
/* 249 */         UnsafeRow bhj_matched2 = bhj_isNull35 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value35);
/* 250 */         if (bhj_matched2 == null) continue;
/* 251 */
/* 252 */         bhj_numOutputRows2.add(1);
/* 253 */
/* 254 */         // generate join key for stream side
/* 255 */
/* 256 */         boolean bhj_isNull51 = smj_isNull3;
/* 257 */         long bhj_value51 = -1L;
/* 258 */         if (!smj_isNull3) {
/* 259 */           bhj_value51 = (long) smj_value5;
/* 260 */         }
/* 261 */         // find matches from HashedRelation
/* 262 */         UnsafeRow bhj_matched3 = bhj_isNull51 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value51);
/* 263 */         if (bhj_matched3 == null) continue;
/* 264 */
/* 265 */         bhj_numOutputRows3.add(1);
/* 266 */
/* 267 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(3);
/* 268 */         int smj_value16 = smj_isNull14 ? -1 : (smj_rightRow1.getInt(3));
/* 269 */         boolean bhj_isNull54 = bhj_matched3.isNullAt(1);
/* 270 */         UTF8String bhj_value54 = bhj_isNull54 ? null : (bhj_matched3.getUTF8String(1));
/* 271 */         boolean bhj_isNull20 = bhj_matched1.isNullAt(3);
/* 272 */         UTF8String bhj_value20 = bhj_isNull20 ? null : (bhj_matched1.getUTF8String(3));
/* 273 */         boolean bhj_isNull19 = bhj_matched1.isNullAt(2);
/* 274 */         UTF8String bhj_value19 = bhj_isNull19 ? null : (bhj_matched1.getUTF8String(2));
/* 275 */         boolean bhj_isNull18 = bhj_matched1.isNullAt(1);
/* 276 */         UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched1.getUTF8String(1));
/* 277 */
/* 278 */         boolean expand_isNull7 = true;
/* 279 */         UTF8String expand_value7 = null;
/* 280 */         boolean expand_isNull8 = true;
/* 281 */         UTF8String expand_value8 = null;
/* 282 */         boolean expand_isNull9 = true;
/* 283 */         UTF8String expand_value9 = null;
/* 284 */         boolean expand_isNull10 = true;
/* 285 */         UTF8String expand_value10 = null;
/* 286 */         boolean expand_isNull11 = true;
/* 287 */         int expand_value11 = -1;
/* 288 */         for (int expand_i = 0; expand_i < 5; expand_i ++) {
/* 289 */           switch (expand_i) {
/* 290 */           case 0:
/* 291 */             expand_isNull7 = bhj_isNull54;
/* 292 */             expand_value7 = bhj_value54;
/* 293 */
/* 294 */             expand_isNull8 = bhj_isNull20;
/* 295 */             expand_value8 = bhj_value20;
/* 296 */
/* 297 */             expand_isNull9 = bhj_isNull19;
/* 298 */             expand_value9 = bhj_value19;
/* 299 */
/* 300 */             expand_isNull10 = bhj_isNull18;
/* 301 */             expand_value10 = bhj_value18;
/* 302 */
/* 303 */             expand_isNull11 = false;
/* 304 */             expand_value11 = 0;
/* 305 */             break;
/* 306 */
/* 307 */           case 1:
/* 308 */             expand_isNull7 = bhj_isNull54;
/* 309 */             expand_value7 = bhj_value54;
/* 310 */
/* 311 */             expand_isNull8 = bhj_isNull20;
/* 312 */             expand_value8 = bhj_value20;
/* 313 */
/* 314 */             expand_isNull9 = bhj_isNull19;
/* 315 */             expand_value9 = bhj_value19;
/* 316 */
/* 317 */             final UTF8String expand_value20 = null;
/* 318 */             expand_isNull10 = true;
/* 319 */             expand_value10 = expand_value20;
/* 320 */
/* 321 */             expand_isNull11 = false;
/* 322 */             expand_value11 = 1;
/* 323 */             break;
/* 324 */
/* 325 */           case 2:
/* 326 */             expand_isNull7 = bhj_isNull54;
/* 327 */             expand_value7 = bhj_value54;
/* 328 */
/* 329 */             expand_isNull8 = bhj_isNull20;
/* 330 */             expand_value8 = bhj_value20;
/* 331 */
/* 332 */             final UTF8String expand_value24 = null;
/* 333 */             expand_isNull9 = true;
/* 334 */             expand_value9 = expand_value24;
/* 335 */
/* 336 */             final UTF8String expand_value25 = null;
/* 337 */             expand_isNull10 = true;
/* 338 */             expand_value10 = expand_value25;
/* 339 */
/* 340 */             expand_isNull11 = false;
/* 341 */             expand_value11 = 3;
/* 342 */             break;
/* 343 */
/* 344 */           case 3:
/* 345 */             expand_isNull7 = bhj_isNull54;
/* 346 */             expand_value7 = bhj_value54;
/* 347 */
/* 348 */             final UTF8String expand_value28 = null;
/* 349 */             expand_isNull8 = true;
/* 350 */             expand_value8 = expand_value28;
/* 351 */
/* 352 */             final UTF8String expand_value29 = null;
/* 353 */             expand_isNull9 = true;
/* 354 */             expand_value9 = expand_value29;
/* 355 */
/* 356 */             final UTF8String expand_value30 = null;
/* 357 */             expand_isNull10 = true;
/* 358 */             expand_value10 = expand_value30;
/* 359 */
/* 360 */             expand_isNull11 = false;
/* 361 */             expand_value11 = 7;
/* 362 */             break;
/* 363 */
/* 364 */           case 4:
/* 365 */             final UTF8String expand_value32 = null;
/* 366 */             expand_isNull7 = true;
/* 367 */             expand_value7 = expand_value32;
/* 368 */
/* 369 */             final UTF8String expand_value33 = null;
/* 370 */             expand_isNull8 = true;
/* 371 */             expand_value8 = expand_value33;
/* 372 */
/* 373 */             final UTF8String expand_value34 = null;
/* 374 */             expand_isNull9 = true;
/* 375 */             expand_value9 = expand_value34;
/* 376 */
/* 377 */             final UTF8String expand_value35 = null;
/* 378 */             expand_isNull10 = true;
/* 379 */             expand_value10 = expand_value35;
/* 380 */
/* 381 */             expand_isNull11 = false;
/* 382 */             expand_value11 = 15;
/* 383 */             break;
/* 384 */           }
/* 385 */           expand_numOutputRows.add(1);
/* 386 */
/* 387 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 388 */
/* 389 */           UnsafeRow agg_fastAggBuffer = null;
/* 390 */
/* 391 */           if (agg_fastAggBuffer == null) {
/* 392 */             // generate grouping key
/* 393 */             agg_holder.reset();
/* 394 */
/* 395 */             agg_rowWriter.zeroOutNullBytes();
/* 396 */
/* 397 */             if (expand_isNull7) {
/* 398 */               agg_rowWriter.setNullAt(0);
/* 399 */             } else {
/* 400 */               agg_rowWriter.write(0, expand_value7);
/* 401 */             }
/* 402 */
/* 403 */             if (expand_isNull8) {
/* 404 */               agg_rowWriter.setNullAt(1);
/* 405 */             } else {
/* 406 */               agg_rowWriter.write(1, expand_value8);
/* 407 */             }
/* 408 */
/* 409 */             if (expand_isNull9) {
/* 410 */               agg_rowWriter.setNullAt(2);
/* 411 */             } else {
/* 412 */               agg_rowWriter.write(2, expand_value9);
/* 413 */             }
/* 414 */
/* 415 */             if (expand_isNull10) {
/* 416 */               agg_rowWriter.setNullAt(3);
/* 417 */             } else {
/* 418 */               agg_rowWriter.write(3, expand_value10);
/* 419 */             }
/* 420 */
/* 421 */             if (expand_isNull11) {
/* 422 */               agg_rowWriter.setNullAt(4);
/* 423 */             } else {
/* 424 */               agg_rowWriter.write(4, expand_value11);
/* 425 */             }
/* 426 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 427 */             agg_value45 = 42;
/* 428 */
/* 429 */             if (!expand_isNull7) {
/* 430 */               agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value7.getBaseObject(), expand_value7.getBaseOffset(), expand_value7.numBytes(), agg_value45);
/* 431 */             }
/* 432 */
/* 433 */             if (!expand_isNull8) {
/* 434 */               agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value8.getBaseObject(), expand_value8.getBaseOffset(), expand_value8.numBytes(), agg_value45);
/* 435 */             }
/* 436 */
/* 437 */             if (!expand_isNull9) {
/* 438 */               agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value9.getBaseObject(), expand_value9.getBaseOffset(), expand_value9.numBytes(), agg_value45);
/* 439 */             }
/* 440 */
/* 441 */             if (!expand_isNull10) {
/* 442 */               agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value10.getBaseObject(), expand_value10.getBaseOffset(), expand_value10.numBytes(), agg_value45);
/* 443 */             }
/* 444 */
/* 445 */             agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value11, agg_value45);
/* 446 */             if (true) {
/* 447 */               // try to get the buffer from hash map
/* 448 */               agg_unsafeRowAggBuffer =
/* 449 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value45);
/* 450 */             }
/* 451 */             if (agg_unsafeRowAggBuffer == null) {
/* 452 */               if (agg_sorter == null) {
/* 453 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 454 */               } else {
/* 455 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 456 */               }
/* 457 */
/* 458 */               // the hash map had be spilled, it should have enough memory now,
/* 459 */               // try  to allocate buffer again.
/* 460 */               agg_unsafeRowAggBuffer =
/* 461 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value45);
/* 462 */               if (agg_unsafeRowAggBuffer == null) {
/* 463 */                 // failed to allocate the first page
/* 464 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 465 */               }
/* 466 */             }
/* 467 */           }
/* 468 */
/* 469 */           if (agg_fastAggBuffer != null) {
/* 470 */             // update fast row
/* 471 */
/* 472 */           } else {
/* 473 */             // update unsafe row
/* 474 */
/* 475 */             // common sub-expressions
/* 476 */             boolean agg_isNull37 = smj_isNull14;
/* 477 */             Decimal agg_value51 = null;
/* 478 */             if (!smj_isNull14) {
/* 479 */               Decimal agg_tmpDecimal7 = Decimal.apply((long) smj_value16);
/* 480 */
/* 481 */               if (agg_tmpDecimal7.changePrecision(12, 2)) {
/* 482 */                 agg_value51 = agg_tmpDecimal7;
/* 483 */               } else {
/* 484 */                 agg_isNull37 = true;
/* 485 */               }
/* 486 */
/* 487 */             }
/* 488 */             boolean agg_isNull39 = smj_isNull8;
/* 489 */             Decimal agg_value53 = null;
/* 490 */             if (!smj_isNull8) {
/* 491 */               try {
/* 492 */                 Decimal agg_tmpDecimal8 = Decimal.apply(scala.math.BigDecimal.valueOf((double) smj_value10));
/* 493 */
/* 494 */                 if (agg_tmpDecimal8.changePrecision(12, 2)) {
/* 495 */                   agg_value53 = agg_tmpDecimal8;
/* 496 */                 } else {
/* 497 */                   agg_isNull39 = true;
/* 498 */                 }
/* 499 */
/* 500 */               } catch (java.lang.NumberFormatException e) {
/* 501 */                 agg_isNull39 = true;
/* 502 */               }
/* 503 */
/* 504 */             }
/* 505 */             boolean agg_isNull41 = smj_isNull10;
/* 506 */             Decimal agg_value55 = null;
/* 507 */             if (!smj_isNull10) {
/* 508 */               Decimal agg_tmpDecimal9 = Decimal.apply((long) smj_value12);
/* 509 */
/* 510 */               if (agg_tmpDecimal9.changePrecision(12, 2)) {
/* 511 */                 agg_value55 = agg_tmpDecimal9;
/* 512 */               } else {
/* 513 */                 agg_isNull41 = true;
/* 514 */               }
/* 515 */
/* 516 */             }
/* 517 */             boolean agg_isNull43 = smj_isNull6;
/* 518 */             Decimal agg_value57 = null;
/* 519 */             if (!smj_isNull6) {
/* 520 */               try {
/* 521 */                 Decimal agg_tmpDecimal10 = Decimal.apply(scala.math.BigDecimal.valueOf((double) smj_value8));
/* 522 */
/* 523 */                 if (agg_tmpDecimal10.changePrecision(12, 2)) {
/* 524 */                   agg_value57 = agg_tmpDecimal10;
/* 525 */                 } else {
/* 526 */                   agg_isNull43 = true;
/* 527 */                 }
/* 528 */
/* 529 */               } catch (java.lang.NumberFormatException e) {
/* 530 */                 agg_isNull43 = true;
/* 531 */               }
/* 532 */
/* 533 */             }
/* 534 */             boolean agg_isNull45 = smj_isNull5;
/* 535 */             Decimal agg_value59 = null;
/* 536 */             if (!smj_isNull5) {
/* 537 */               try {
/* 538 */                 Decimal agg_tmpDecimal11 = Decimal.apply(scala.math.BigDecimal.valueOf((double) smj_value7));
/* 539 */
/* 540 */                 if (agg_tmpDecimal11.changePrecision(12, 2)) {
/* 541 */                   agg_value59 = agg_tmpDecimal11;
/* 542 */                 } else {
/* 543 */                   agg_isNull45 = true;
/* 544 */                 }
/* 545 */
/* 546 */               } catch (java.lang.NumberFormatException e) {
/* 547 */                 agg_isNull45 = true;
/* 548 */               }
/* 549 */
/* 550 */             }
/* 551 */             boolean agg_isNull47 = smj_isNull7;
/* 552 */             Decimal agg_value61 = null;
/* 553 */             if (!smj_isNull7) {
/* 554 */               try {
/* 555 */                 Decimal agg_tmpDecimal12 = Decimal.apply(scala.math.BigDecimal.valueOf((double) smj_value9));
/* 556 */
/* 557 */                 if (agg_tmpDecimal12.changePrecision(12, 2)) {
/* 558 */                   agg_value61 = agg_tmpDecimal12;
/* 559 */                 } else {
/* 560 */                   agg_isNull47 = true;
/* 561 */                 }
/* 562 */
/* 563 */               } catch (java.lang.NumberFormatException e) {
/* 564 */                 agg_isNull47 = true;
/* 565 */               }
/* 566 */
/* 567 */             }
/* 568 */             boolean agg_isNull49 = smj_isNull4;
/* 569 */             Decimal agg_value63 = null;
/* 570 */             if (!smj_isNull4) {
/* 571 */               Decimal agg_tmpDecimal13 = Decimal.apply((long) smj_value6);
/* 572 */
/* 573 */               if (agg_tmpDecimal13.changePrecision(12, 2)) {
/* 574 */                 agg_value63 = agg_tmpDecimal13;
/* 575 */               } else {
/* 576 */                 agg_isNull49 = true;
/* 577 */               }
/* 578 */
/* 579 */             }
/* 580 */             // evaluate aggregate function
/* 581 */             boolean agg_isNull51 = true;
/* 582 */             Decimal agg_value65 = null;
/* 583 */
/* 584 */             boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 585 */             Decimal agg_value66 = agg_isNull52 ? null : (agg_unsafeRowAggBuffer.getDecimal(0, 22, 2));
/* 586 */             if (!agg_isNull52) {
/* 587 */               boolean agg_isNull54 = agg_isNull49;
/* 588 */               Decimal agg_value68 = null;
/* 589 */               if (!agg_isNull49) {
/* 590 */                 Decimal agg_tmpDecimal14 = agg_value63.clone();
/* 591 */
/* 592 */                 if (agg_tmpDecimal14.changePrecision(22, 2)) {
/* 593 */                   agg_value68 = agg_tmpDecimal14;
/* 594 */                 } else {
/* 595 */                   agg_isNull54 = true;
/* 596 */                 }
/* 597 */
/* 598 */               }
/* 599 */               boolean agg_isNull53 = agg_isNull54;
/* 600 */               Decimal agg_value67 = agg_value68;
/* 601 */               if (agg_isNull53) {
/* 602 */                 boolean agg_isNull55 = false;
/* 603 */                 Decimal agg_value69 = null;
/* 604 */                 if (!false) {
/* 605 */                   Decimal agg_tmpDecimal15 = Decimal.apply((long) 0);
/* 606 */
/* 607 */                   if (agg_tmpDecimal15.changePrecision(22, 2)) {
/* 608 */                     agg_value69 = agg_tmpDecimal15;
/* 609 */                   } else {
/* 610 */                     agg_isNull55 = true;
/* 611 */                   }
/* 612 */
/* 613 */                 }
/* 614 */                 if (!agg_isNull55) {
/* 615 */                   agg_isNull53 = false;
/* 616 */                   agg_value67 = agg_value69;
/* 617 */                 }
/* 618 */               }
/* 619 */               if (!agg_isNull53) {
/* 620 */                 agg_isNull51 = false; // resultCode could change nullability.
/* 621 */                 agg_value65 = agg_value66.$plus(agg_value67);
/* 622 */
/* 623 */               }
/* 624 */
/* 625 */             }
/* 626 */             boolean agg_isNull57 = false;
/* 627 */             long agg_value71 = -1L;
/* 628 */             if (!false && agg_isNull49) {
/* 629 */               boolean agg_isNull59 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 630 */               long agg_value73 = agg_isNull59 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 631 */               agg_isNull57 = agg_isNull59;
/* 632 */               agg_value71 = agg_value73;
/* 633 */             } else {
/* 634 */               boolean agg_isNull60 = true;
/* 635 */               long agg_value74 = -1L;
/* 636 */
/* 637 */               boolean agg_isNull61 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 638 */               long agg_value75 = agg_isNull61 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 639 */               if (!agg_isNull61) {
/* 640 */                 agg_isNull60 = false; // resultCode could change nullability.
/* 641 */                 agg_value74 = agg_value75 + 1L;
/* 642 */
/* 643 */               }
/* 644 */               agg_isNull57 = agg_isNull60;
/* 645 */               agg_value71 = agg_value74;
/* 646 */             }
/* 647 */             boolean agg_isNull63 = true;
/* 648 */             Decimal agg_value77 = null;
/* 649 */
/* 650 */             boolean agg_isNull64 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 651 */             Decimal agg_value78 = agg_isNull64 ? null : (agg_unsafeRowAggBuffer.getDecimal(2, 22, 2));
/* 652 */             if (!agg_isNull64) {
/* 653 */               boolean agg_isNull66 = agg_isNull45;
/* 654 */               Decimal agg_value80 = null;
/* 655 */               if (!agg_isNull45) {
/* 656 */                 Decimal agg_tmpDecimal16 = agg_value59.clone();
/* 657 */
/* 658 */                 if (agg_tmpDecimal16.changePrecision(22, 2)) {
/* 659 */                   agg_value80 = agg_tmpDecimal16;
/* 660 */                 } else {
/* 661 */                   agg_isNull66 = true;
/* 662 */                 }
/* 663 */
/* 664 */               }
/* 665 */               boolean agg_isNull65 = agg_isNull66;
/* 666 */               Decimal agg_value79 = agg_value80;
/* 667 */               if (agg_isNull65) {
/* 668 */                 boolean agg_isNull67 = false;
/* 669 */                 Decimal agg_value81 = null;
/* 670 */                 if (!false) {
/* 671 */                   Decimal agg_tmpDecimal17 = Decimal.apply((long) 0);
/* 672 */
/* 673 */                   if (agg_tmpDecimal17.changePrecision(22, 2)) {
/* 674 */                     agg_value81 = agg_tmpDecimal17;
/* 675 */                   } else {
/* 676 */                     agg_isNull67 = true;
/* 677 */                   }
/* 678 */
/* 679 */                 }
/* 680 */                 if (!agg_isNull67) {
/* 681 */                   agg_isNull65 = false;
/* 682 */                   agg_value79 = agg_value81;
/* 683 */                 }
/* 684 */               }
/* 685 */               if (!agg_isNull65) {
/* 686 */                 agg_isNull63 = false; // resultCode could change nullability.
/* 687 */                 agg_value77 = agg_value78.$plus(agg_value79);
/* 688 */
/* 689 */               }
/* 690 */
/* 691 */             }
/* 692 */             boolean agg_isNull69 = false;
/* 693 */             long agg_value83 = -1L;
/* 694 */             if (!false && agg_isNull45) {
/* 695 */               boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 696 */               long agg_value85 = agg_isNull71 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 697 */               agg_isNull69 = agg_isNull71;
/* 698 */               agg_value83 = agg_value85;
/* 699 */             } else {
/* 700 */               boolean agg_isNull72 = true;
/* 701 */               long agg_value86 = -1L;
/* 702 */
/* 703 */               boolean agg_isNull73 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 704 */               long agg_value87 = agg_isNull73 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 705 */               if (!agg_isNull73) {
/* 706 */                 agg_isNull72 = false; // resultCode could change nullability.
/* 707 */                 agg_value86 = agg_value87 + 1L;
/* 708 */
/* 709 */               }
/* 710 */               agg_isNull69 = agg_isNull72;
/* 711 */               agg_value83 = agg_value86;
/* 712 */             }
/* 713 */             boolean agg_isNull75 = true;
/* 714 */             Decimal agg_value89 = null;
/* 715 */
/* 716 */             boolean agg_isNull76 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 717 */             Decimal agg_value90 = agg_isNull76 ? null : (agg_unsafeRowAggBuffer.getDecimal(4, 22, 2));
/* 718 */             if (!agg_isNull76) {
/* 719 */               boolean agg_isNull78 = agg_isNull47;
/* 720 */               Decimal agg_value92 = null;
/* 721 */               if (!agg_isNull47) {
/* 722 */                 Decimal agg_tmpDecimal18 = agg_value61.clone();
/* 723 */
/* 724 */                 if (agg_tmpDecimal18.changePrecision(22, 2)) {
/* 725 */                   agg_value92 = agg_tmpDecimal18;
/* 726 */                 } else {
/* 727 */                   agg_isNull78 = true;
/* 728 */                 }
/* 729 */
/* 730 */               }
/* 731 */               boolean agg_isNull77 = agg_isNull78;
/* 732 */               Decimal agg_value91 = agg_value92;
/* 733 */               if (agg_isNull77) {
/* 734 */                 boolean agg_isNull79 = false;
/* 735 */                 Decimal agg_value93 = null;
/* 736 */                 if (!false) {
/* 737 */                   Decimal agg_tmpDecimal19 = Decimal.apply((long) 0);
/* 738 */
/* 739 */                   if (agg_tmpDecimal19.changePrecision(22, 2)) {
/* 740 */                     agg_value93 = agg_tmpDecimal19;
/* 741 */                   } else {
/* 742 */                     agg_isNull79 = true;
/* 743 */                   }
/* 744 */
/* 745 */                 }
/* 746 */                 if (!agg_isNull79) {
/* 747 */                   agg_isNull77 = false;
/* 748 */                   agg_value91 = agg_value93;
/* 749 */                 }
/* 750 */               }
/* 751 */               if (!agg_isNull77) {
/* 752 */                 agg_isNull75 = false; // resultCode could change nullability.
/* 753 */                 agg_value89 = agg_value90.$plus(agg_value91);
/* 754 */
/* 755 */               }
/* 756 */
/* 757 */             }
/* 758 */             boolean agg_isNull81 = false;
/* 759 */             long agg_value95 = -1L;
/* 760 */             if (!false && agg_isNull47) {
/* 761 */               boolean agg_isNull83 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 762 */               long agg_value97 = agg_isNull83 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 763 */               agg_isNull81 = agg_isNull83;
/* 764 */               agg_value95 = agg_value97;
/* 765 */             } else {
/* 766 */               boolean agg_isNull84 = true;
/* 767 */               long agg_value98 = -1L;
/* 768 */
/* 769 */               boolean agg_isNull85 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 770 */               long agg_value99 = agg_isNull85 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 771 */               if (!agg_isNull85) {
/* 772 */                 agg_isNull84 = false; // resultCode could change nullability.
/* 773 */                 agg_value98 = agg_value99 + 1L;
/* 774 */
/* 775 */               }
/* 776 */               agg_isNull81 = agg_isNull84;
/* 777 */               agg_value95 = agg_value98;
/* 778 */             }
/* 779 */             boolean agg_isNull87 = true;
/* 780 */             Decimal agg_value101 = null;
/* 781 */
/* 782 */             boolean agg_isNull88 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 783 */             Decimal agg_value102 = agg_isNull88 ? null : (agg_unsafeRowAggBuffer.getDecimal(6, 22, 2));
/* 784 */             if (!agg_isNull88) {
/* 785 */               boolean agg_isNull90 = agg_isNull43;
/* 786 */               Decimal agg_value104 = null;
/* 787 */               if (!agg_isNull43) {
/* 788 */                 Decimal agg_tmpDecimal20 = agg_value57.clone();
/* 789 */
/* 790 */                 if (agg_tmpDecimal20.changePrecision(22, 2)) {
/* 791 */                   agg_value104 = agg_tmpDecimal20;
/* 792 */                 } else {
/* 793 */                   agg_isNull90 = true;
/* 794 */                 }
/* 795 */
/* 796 */               }
/* 797 */               boolean agg_isNull89 = agg_isNull90;
/* 798 */               Decimal agg_value103 = agg_value104;
/* 799 */               if (agg_isNull89) {
/* 800 */                 boolean agg_isNull91 = false;
/* 801 */                 Decimal agg_value105 = null;
/* 802 */                 if (!false) {
/* 803 */                   Decimal agg_tmpDecimal21 = Decimal.apply((long) 0);
/* 804 */
/* 805 */                   if (agg_tmpDecimal21.changePrecision(22, 2)) {
/* 806 */                     agg_value105 = agg_tmpDecimal21;
/* 807 */                   } else {
/* 808 */                     agg_isNull91 = true;
/* 809 */                   }
/* 810 */
/* 811 */                 }
/* 812 */                 if (!agg_isNull91) {
/* 813 */                   agg_isNull89 = false;
/* 814 */                   agg_value103 = agg_value105;
/* 815 */                 }
/* 816 */               }
/* 817 */               if (!agg_isNull89) {
/* 818 */                 agg_isNull87 = false; // resultCode could change nullability.
/* 819 */                 agg_value101 = agg_value102.$plus(agg_value103);
/* 820 */
/* 821 */               }
/* 822 */
/* 823 */             }
/* 824 */             boolean agg_isNull93 = false;
/* 825 */             long agg_value107 = -1L;
/* 826 */             if (!false && agg_isNull43) {
/* 827 */               boolean agg_isNull95 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 828 */               long agg_value109 = agg_isNull95 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 829 */               agg_isNull93 = agg_isNull95;
/* 830 */               agg_value107 = agg_value109;
/* 831 */             } else {
/* 832 */               boolean agg_isNull96 = true;
/* 833 */               long agg_value110 = -1L;
/* 834 */
/* 835 */               boolean agg_isNull97 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 836 */               long agg_value111 = agg_isNull97 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 837 */               if (!agg_isNull97) {
/* 838 */                 agg_isNull96 = false; // resultCode could change nullability.
/* 839 */                 agg_value110 = agg_value111 + 1L;
/* 840 */
/* 841 */               }
/* 842 */               agg_isNull93 = agg_isNull96;
/* 843 */               agg_value107 = agg_value110;
/* 844 */             }
/* 845 */             boolean agg_isNull99 = true;
/* 846 */             Decimal agg_value113 = null;
/* 847 */
/* 848 */             boolean agg_isNull100 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 849 */             Decimal agg_value114 = agg_isNull100 ? null : (agg_unsafeRowAggBuffer.getDecimal(8, 22, 2));
/* 850 */             if (!agg_isNull100) {
/* 851 */               boolean agg_isNull102 = agg_isNull39;
/* 852 */               Decimal agg_value116 = null;
/* 853 */               if (!agg_isNull39) {
/* 854 */                 Decimal agg_tmpDecimal22 = agg_value53.clone();
/* 855 */
/* 856 */                 if (agg_tmpDecimal22.changePrecision(22, 2)) {
/* 857 */                   agg_value116 = agg_tmpDecimal22;
/* 858 */                 } else {
/* 859 */                   agg_isNull102 = true;
/* 860 */                 }
/* 861 */
/* 862 */               }
/* 863 */               boolean agg_isNull101 = agg_isNull102;
/* 864 */               Decimal agg_value115 = agg_value116;
/* 865 */               if (agg_isNull101) {
/* 866 */                 boolean agg_isNull103 = false;
/* 867 */                 Decimal agg_value117 = null;
/* 868 */                 if (!false) {
/* 869 */                   Decimal agg_tmpDecimal23 = Decimal.apply((long) 0);
/* 870 */
/* 871 */                   if (agg_tmpDecimal23.changePrecision(22, 2)) {
/* 872 */                     agg_value117 = agg_tmpDecimal23;
/* 873 */                   } else {
/* 874 */                     agg_isNull103 = true;
/* 875 */                   }
/* 876 */
/* 877 */                 }
/* 878 */                 if (!agg_isNull103) {
/* 879 */                   agg_isNull101 = false;
/* 880 */                   agg_value115 = agg_value117;
/* 881 */                 }
/* 882 */               }
/* 883 */               if (!agg_isNull101) {
/* 884 */                 agg_isNull99 = false; // resultCode could change nullability.
/* 885 */                 agg_value113 = agg_value114.$plus(agg_value115);
/* 886 */
/* 887 */               }
/* 888 */
/* 889 */             }
/* 890 */             boolean agg_isNull105 = false;
/* 891 */             long agg_value119 = -1L;
/* 892 */             if (!false && agg_isNull39) {
/* 893 */               boolean agg_isNull107 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 894 */               long agg_value121 = agg_isNull107 ? -1L : (agg_unsafeRowAggBuffer.getLong(9));
/* 895 */               agg_isNull105 = agg_isNull107;
/* 896 */               agg_value119 = agg_value121;
/* 897 */             } else {
/* 898 */               boolean agg_isNull108 = true;
/* 899 */               long agg_value122 = -1L;
/* 900 */
/* 901 */               boolean agg_isNull109 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 902 */               long agg_value123 = agg_isNull109 ? -1L : (agg_unsafeRowAggBuffer.getLong(9));
/* 903 */               if (!agg_isNull109) {
/* 904 */                 agg_isNull108 = false; // resultCode could change nullability.
/* 905 */                 agg_value122 = agg_value123 + 1L;
/* 906 */
/* 907 */               }
/* 908 */               agg_isNull105 = agg_isNull108;
/* 909 */               agg_value119 = agg_value122;
/* 910 */             }
/* 911 */             boolean agg_isNull111 = true;
/* 912 */             Decimal agg_value125 = null;
/* 913 */
/* 914 */             boolean agg_isNull112 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 915 */             Decimal agg_value126 = agg_isNull112 ? null : (agg_unsafeRowAggBuffer.getDecimal(10, 22, 2));
/* 916 */             if (!agg_isNull112) {
/* 917 */               boolean agg_isNull114 = agg_isNull37;
/* 918 */               Decimal agg_value128 = null;
/* 919 */               if (!agg_isNull37) {
/* 920 */                 Decimal agg_tmpDecimal24 = agg_value51.clone();
/* 921 */
/* 922 */                 if (agg_tmpDecimal24.changePrecision(22, 2)) {
/* 923 */                   agg_value128 = agg_tmpDecimal24;
/* 924 */                 } else {
/* 925 */                   agg_isNull114 = true;
/* 926 */                 }
/* 927 */
/* 928 */               }
/* 929 */               boolean agg_isNull113 = agg_isNull114;
/* 930 */               Decimal agg_value127 = agg_value128;
/* 931 */               if (agg_isNull113) {
/* 932 */                 boolean agg_isNull115 = false;
/* 933 */                 Decimal agg_value129 = null;
/* 934 */                 if (!false) {
/* 935 */                   Decimal agg_tmpDecimal25 = Decimal.apply((long) 0);
/* 936 */
/* 937 */                   if (agg_tmpDecimal25.changePrecision(22, 2)) {
/* 938 */                     agg_value129 = agg_tmpDecimal25;
/* 939 */                   } else {
/* 940 */                     agg_isNull115 = true;
/* 941 */                   }
/* 942 */
/* 943 */                 }
/* 944 */                 if (!agg_isNull115) {
/* 945 */                   agg_isNull113 = false;
/* 946 */                   agg_value127 = agg_value129;
/* 947 */                 }
/* 948 */               }
/* 949 */               if (!agg_isNull113) {
/* 950 */                 agg_isNull111 = false; // resultCode could change nullability.
/* 951 */                 agg_value125 = agg_value126.$plus(agg_value127);
/* 952 */
/* 953 */               }
/* 954 */
/* 955 */             }
/* 956 */             boolean agg_isNull117 = false;
/* 957 */             long agg_value131 = -1L;
/* 958 */             if (!false && agg_isNull37) {
/* 959 */               boolean agg_isNull119 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 960 */               long agg_value133 = agg_isNull119 ? -1L : (agg_unsafeRowAggBuffer.getLong(11));
/* 961 */               agg_isNull117 = agg_isNull119;
/* 962 */               agg_value131 = agg_value133;
/* 963 */             } else {
/* 964 */               boolean agg_isNull120 = true;
/* 965 */               long agg_value134 = -1L;
/* 966 */
/* 967 */               boolean agg_isNull121 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 968 */               long agg_value135 = agg_isNull121 ? -1L : (agg_unsafeRowAggBuffer.getLong(11));
/* 969 */               if (!agg_isNull121) {
/* 970 */                 agg_isNull120 = false; // resultCode could change nullability.
/* 971 */                 agg_value134 = agg_value135 + 1L;
/* 972 */
/* 973 */               }
/* 974 */               agg_isNull117 = agg_isNull120;
/* 975 */               agg_value131 = agg_value134;
/* 976 */             }
/* 977 */             boolean agg_isNull123 = true;
/* 978 */             Decimal agg_value137 = null;
/* 979 */
/* 980 */             boolean agg_isNull124 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 981 */             Decimal agg_value138 = agg_isNull124 ? null : (agg_unsafeRowAggBuffer.getDecimal(12, 22, 2));
/* 982 */             if (!agg_isNull124) {
/* 983 */               boolean agg_isNull126 = agg_isNull41;
/* 984 */               Decimal agg_value140 = null;
/* 985 */               if (!agg_isNull41) {
/* 986 */                 Decimal agg_tmpDecimal26 = agg_value55.clone();
/* 987 */
/* 988 */                 if (agg_tmpDecimal26.changePrecision(22, 2)) {
/* 989 */                   agg_value140 = agg_tmpDecimal26;
/* 990 */                 } else {
/* 991 */                   agg_isNull126 = true;
/* 992 */                 }
/* 993 */
/* 994 */               }
/* 995 */               boolean agg_isNull125 = agg_isNull126;
/* 996 */               Decimal agg_value139 = agg_value140;
/* 997 */               if (agg_isNull125) {
/* 998 */                 boolean agg_isNull127 = false;
/* 999 */                 Decimal agg_value141 = null;
/* 1000 */                 if (!false) {
/* 1001 */                   Decimal agg_tmpDecimal27 = Decimal.apply((long) 0);
/* 1002 */
/* 1003 */                   if (agg_tmpDecimal27.changePrecision(22, 2)) {
/* 1004 */                     agg_value141 = agg_tmpDecimal27;
/* 1005 */                   } else {
/* 1006 */                     agg_isNull127 = true;
/* 1007 */                   }
/* 1008 */
/* 1009 */                 }
/* 1010 */                 if (!agg_isNull127) {
/* 1011 */                   agg_isNull125 = false;
/* 1012 */                   agg_value139 = agg_value141;
/* 1013 */                 }
/* 1014 */               }
/* 1015 */               if (!agg_isNull125) {
/* 1016 */                 agg_isNull123 = false; // resultCode could change nullability.
/* 1017 */                 agg_value137 = agg_value138.$plus(agg_value139);
/* 1018 */
/* 1019 */               }
/* 1020 */
/* 1021 */             }
/* 1022 */             boolean agg_isNull129 = false;
/* 1023 */             long agg_value143 = -1L;
/* 1024 */             if (!false && agg_isNull41) {
/* 1025 */               boolean agg_isNull131 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 1026 */               long agg_value145 = agg_isNull131 ? -1L : (agg_unsafeRowAggBuffer.getLong(13));
/* 1027 */               agg_isNull129 = agg_isNull131;
/* 1028 */               agg_value143 = agg_value145;
/* 1029 */             } else {
/* 1030 */               boolean agg_isNull132 = true;
/* 1031 */               long agg_value146 = -1L;
/* 1032 */
/* 1033 */               boolean agg_isNull133 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 1034 */               long agg_value147 = agg_isNull133 ? -1L : (agg_unsafeRowAggBuffer.getLong(13));
/* 1035 */               if (!agg_isNull133) {
/* 1036 */                 agg_isNull132 = false; // resultCode could change nullability.
/* 1037 */                 agg_value146 = agg_value147 + 1L;
/* 1038 */
/* 1039 */               }
/* 1040 */               agg_isNull129 = agg_isNull132;
/* 1041 */               agg_value143 = agg_value146;
/* 1042 */             }
/* 1043 */             // update unsafe row buffer
/* 1044 */             if (!agg_isNull51) {
/* 1045 */               agg_unsafeRowAggBuffer.setDecimal(0, agg_value65, 22);
/* 1046 */             } else {
/* 1047 */               agg_unsafeRowAggBuffer.setDecimal(0, null, 22);
/* 1048 */             }
/* 1049 */
/* 1050 */             if (!agg_isNull57) {
/* 1051 */               agg_unsafeRowAggBuffer.setLong(1, agg_value71);
/* 1052 */             } else {
/* 1053 */               agg_unsafeRowAggBuffer.setNullAt(1);
/* 1054 */             }
/* 1055 */
/* 1056 */             if (!agg_isNull63) {
/* 1057 */               agg_unsafeRowAggBuffer.setDecimal(2, agg_value77, 22);
/* 1058 */             } else {
/* 1059 */               agg_unsafeRowAggBuffer.setDecimal(2, null, 22);
/* 1060 */             }
/* 1061 */
/* 1062 */             if (!agg_isNull69) {
/* 1063 */               agg_unsafeRowAggBuffer.setLong(3, agg_value83);
/* 1064 */             } else {
/* 1065 */               agg_unsafeRowAggBuffer.setNullAt(3);
/* 1066 */             }
/* 1067 */
/* 1068 */             if (!agg_isNull75) {
/* 1069 */               agg_unsafeRowAggBuffer.setDecimal(4, agg_value89, 22);
/* 1070 */             } else {
/* 1071 */               agg_unsafeRowAggBuffer.setDecimal(4, null, 22);
/* 1072 */             }
/* 1073 */
/* 1074 */             if (!agg_isNull81) {
/* 1075 */               agg_unsafeRowAggBuffer.setLong(5, agg_value95);
/* 1076 */             } else {
/* 1077 */               agg_unsafeRowAggBuffer.setNullAt(5);
/* 1078 */             }
/* 1079 */
/* 1080 */             if (!agg_isNull87) {
/* 1081 */               agg_unsafeRowAggBuffer.setDecimal(6, agg_value101, 22);
/* 1082 */             } else {
/* 1083 */               agg_unsafeRowAggBuffer.setDecimal(6, null, 22);
/* 1084 */             }
/* 1085 */
/* 1086 */             if (!agg_isNull93) {
/* 1087 */               agg_unsafeRowAggBuffer.setLong(7, agg_value107);
/* 1088 */             } else {
/* 1089 */               agg_unsafeRowAggBuffer.setNullAt(7);
/* 1090 */             }
/* 1091 */
/* 1092 */             if (!agg_isNull99) {
/* 1093 */               agg_unsafeRowAggBuffer.setDecimal(8, agg_value113, 22);
/* 1094 */             } else {
/* 1095 */               agg_unsafeRowAggBuffer.setDecimal(8, null, 22);
/* 1096 */             }
/* 1097 */
/* 1098 */             if (!agg_isNull105) {
/* 1099 */               agg_unsafeRowAggBuffer.setLong(9, agg_value119);
/* 1100 */             } else {
/* 1101 */               agg_unsafeRowAggBuffer.setNullAt(9);
/* 1102 */             }
/* 1103 */
/* 1104 */             if (!agg_isNull111) {
/* 1105 */               agg_unsafeRowAggBuffer.setDecimal(10, agg_value125, 22);
/* 1106 */             } else {
/* 1107 */               agg_unsafeRowAggBuffer.setDecimal(10, null, 22);
/* 1108 */             }
/* 1109 */
/* 1110 */             if (!agg_isNull117) {
/* 1111 */               agg_unsafeRowAggBuffer.setLong(11, agg_value131);
/* 1112 */             } else {
/* 1113 */               agg_unsafeRowAggBuffer.setNullAt(11);
/* 1114 */             }
/* 1115 */
/* 1116 */             if (!agg_isNull123) {
/* 1117 */               agg_unsafeRowAggBuffer.setDecimal(12, agg_value137, 22);
/* 1118 */             } else {
/* 1119 */               agg_unsafeRowAggBuffer.setDecimal(12, null, 22);
/* 1120 */             }
/* 1121 */
/* 1122 */             if (!agg_isNull129) {
/* 1123 */               agg_unsafeRowAggBuffer.setLong(13, agg_value143);
/* 1124 */             } else {
/* 1125 */               agg_unsafeRowAggBuffer.setNullAt(13);
/* 1126 */             }
/* 1127 */
/* 1128 */           }
/* 1129 */
/* 1130 */         }
/* 1131 */
/* 1132 */       }
/* 1133 */       if (shouldStop()) return;
/* 1134 */     }
/* 1135 */
/* 1136 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1137 */   }
/* 1138 */
/* 1139 */   private boolean findNextInnerJoinRows(
/* 1140 */     scala.collection.Iterator leftIter,
/* 1141 */     scala.collection.Iterator rightIter) {
/* 1142 */     smj_leftRow = null;
/* 1143 */     int comp = 0;
/* 1144 */     while (smj_leftRow == null) {
/* 1145 */       if (!leftIter.hasNext()) return false;
/* 1146 */       smj_leftRow = (InternalRow) leftIter.next();
/* 1147 */
/* 1148 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 1149 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 1150 */       if (smj_isNull) {
/* 1151 */         smj_leftRow = null;
/* 1152 */         continue;
/* 1153 */       }
/* 1154 */       if (!smj_matches.isEmpty()) {
/* 1155 */         comp = 0;
/* 1156 */         if (comp == 0) {
/* 1157 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 1158 */         }
/* 1159 */
/* 1160 */         if (comp == 0) {
/* 1161 */           return true;
/* 1162 */         }
/* 1163 */         smj_matches.clear();
/* 1164 */       }
/* 1165 */
/* 1166 */       do {
/* 1167 */         if (smj_rightRow == null) {
/* 1168 */           if (!rightIter.hasNext()) {
/* 1169 */             smj_value3 = smj_value;
/* 1170 */             return !smj_matches.isEmpty();
/* 1171 */           }
/* 1172 */           smj_rightRow = (InternalRow) rightIter.next();
/* 1173 */
/* 1174 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 1175 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 1176 */           if (smj_isNull1) {
/* 1177 */             smj_rightRow = null;
/* 1178 */             continue;
/* 1179 */           }
/* 1180 */           smj_value2 = smj_value1;
/* 1181 */         }
/* 1182 */
/* 1183 */         comp = 0;
/* 1184 */         if (comp == 0) {
/* 1185 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 1186 */         }
/* 1187 */
/* 1188 */         if (comp > 0) {
/* 1189 */           smj_rightRow = null;
/* 1190 */         } else if (comp < 0) {
/* 1191 */           if (!smj_matches.isEmpty()) {
/* 1192 */             smj_value3 = smj_value;
/* 1193 */             return true;
/* 1194 */           }
/* 1195 */           smj_leftRow = null;
/* 1196 */         } else {
/* 1197 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 1198 */           smj_rightRow = null;;
/* 1199 */         }
/* 1200 */       } while (smj_leftRow != null);
/* 1201 */     }
/* 1202 */     return false; // unreachable
/* 1203 */   }
/* 1204 */
/* 1205 */   private void wholestagecodegen_init_2() {
/* 1206 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 1207 */     bhj_result1 = new UnsafeRow(14);
/* 1208 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 1209 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 14);
/* 1210 */     project_result2 = new UnsafeRow(12);
/* 1211 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 96);
/* 1212 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 12);
/* 1213 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 1214 */
/* 1215 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 1216 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 1217 */
/* 1218 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 1219 */     bhj_result2 = new UnsafeRow(13);
/* 1220 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 1221 */
/* 1222 */   }
/* 1223 */
/* 1224 */   private void wholestagecodegen_init_1() {
/* 1225 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[4];
/* 1226 */
/* 1227 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1228 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1229 */
/* 1230 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 1231 */     bhj_result = new UnsafeRow(12);
/* 1232 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1233 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 12);
/* 1234 */     project_result1 = new UnsafeRow(10);
/* 1235 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 1236 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 10);
/* 1237 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 1238 */
/* 1239 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1240 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1241 */
/* 1242 */   }
/* 1243 */
/* 1244 */   private void wholestagecodegen_init_4() {
/* 1245 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 11);
/* 1246 */     this.expand_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 1247 */     expand_result = new UnsafeRow(12);
/* 1248 */     this.expand_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(expand_result, 128);
/* 1249 */     this.expand_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(expand_holder, 12);
/* 1250 */     agg_result = new UnsafeRow(5);
/* 1251 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 1252 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 1253 */
/* 1254 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1255 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 1256 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 1257 */
/* 1258 */   }
/* 1259 */
/* 1260 */   protected void processNext() throws java.io.IOException {
/* 1261 */     if (!agg_initAgg) {
/* 1262 */       agg_initAgg = true;
/* 1263 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1264 */       agg_doAggregateWithKeys();
/* 1265 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1266 */     }
/* 1267 */
/* 1268 */     // output the result
/* 1269 */
/* 1270 */     while (agg_mapIter.next()) {
/* 1271 */       wholestagecodegen_numOutputRows.add(1);
/* 1272 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1273 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1274 */
/* 1275 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1276 */
/* 1277 */       append(agg_resultRow.copy());
/* 1278 */
/* 1279 */       if (shouldStop()) return;
/* 1280 */     }
/* 1281 */
/* 1282 */     agg_mapIter.close();
/* 1283 */     if (agg_sorter == null) {
/* 1284 */       agg_hashMap.free();
/* 1285 */     }
/* 1286 */   }
/* 1287 */ }
