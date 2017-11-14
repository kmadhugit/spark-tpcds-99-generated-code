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
/* 014 */   private long agg_bufValue2;
/* 015 */   private boolean agg_initAgg1;
/* 016 */   private boolean agg_bufIsNull3;
/* 017 */   private double agg_bufValue3;
/* 018 */   private boolean agg_bufIsNull4;
/* 019 */   private double agg_bufValue4;
/* 020 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 021 */   private agg_FastHashMap agg_fastHashMap;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 023 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 024 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 025 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 028 */   private boolean agg_initAgg2;
/* 029 */   private boolean agg_bufIsNull5;
/* 030 */   private double agg_bufValue5;
/* 031 */   private boolean agg_bufIsNull6;
/* 032 */   private double agg_bufValue6;
/* 033 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan1;
/* 034 */   private agg_FastHashMap1 agg_fastHashMap1;
/* 035 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter1;
/* 036 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap1;
/* 037 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter1;
/* 038 */   private org.apache.spark.unsafe.KVIterator agg_mapIter1;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory1;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize1;
/* 041 */   private scala.collection.Iterator inputadapter_input;
/* 042 */   private UnsafeRow project_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 045 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 046 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 048 */   private UnsafeRow bhj_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 051 */   private UnsafeRow project_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 054 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 055 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 057 */   private UnsafeRow bhj_result1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 060 */   private UnsafeRow project_result2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 066 */   private UnsafeRow bhj_result2;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 069 */   private UnsafeRow project_result3;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 072 */   private UnsafeRow agg_result2;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 075 */   private int agg_value13;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 077 */   private UnsafeRow agg_result3;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 080 */   private int agg_value52;
/* 081 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 082 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner1;
/* 084 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows1;
/* 085 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime1;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows2;
/* 087 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime2;
/* 088 */   private UnsafeRow agg_result4;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 090 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 091 */
/* 092 */   public GeneratedIterator(Object[] references) {
/* 093 */     this.references = references;
/* 094 */   }
/* 095 */
/* 096 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 097 */     partitionIndex = index;
/* 098 */     this.inputs = inputs;
/* 099 */     wholestagecodegen_init_0();
/* 100 */     wholestagecodegen_init_1();
/* 101 */     wholestagecodegen_init_2();
/* 102 */     wholestagecodegen_init_3();
/* 103 */     wholestagecodegen_init_4();
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */   private void wholestagecodegen_init_0() {
/* 108 */     agg_initAgg = false;
/* 109 */
/* 110 */     agg_initAgg1 = false;
/* 111 */
/* 112 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 113 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 114 */
/* 115 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 116 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 117 */     agg_initAgg2 = false;
/* 118 */
/* 119 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[3];
/* 120 */     agg_fastHashMap1 = new agg_FastHashMap1(agg_plan1.getTaskMemoryManager(), agg_plan1.getEmptyAggregationBuffer());
/* 121 */
/* 122 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 123 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 124 */     inputadapter_input = inputs[0];
/* 125 */     project_result = new UnsafeRow(6);
/* 126 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 127 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 132 */     // initialize aggregation buffer
/* 133 */     final double agg_value = -1.0;
/* 134 */     agg_bufIsNull = true;
/* 135 */     agg_bufValue = agg_value;
/* 136 */     final double agg_value1 = -1.0;
/* 137 */     agg_bufIsNull1 = true;
/* 138 */     agg_bufValue1 = agg_value1;
/* 139 */     agg_bufIsNull2 = false;
/* 140 */     agg_bufValue2 = 0L;
/* 141 */
/* 142 */     if (!agg_initAgg1) {
/* 143 */       agg_initAgg1 = true;
/* 144 */       long agg_beforeAgg1 = System.nanoTime();
/* 145 */       agg_doAggregateWithKeys();
/* 146 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 147 */     }
/* 148 */
/* 149 */     // output the result
/* 150 */
/* 151 */     while (agg_fastHashMapIter.next()) {
/* 152 */       agg_numOutputRows1.add(1);
/* 153 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 154 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 155 */
/* 156 */       UnsafeRow agg_resultRow1 = agg_unsafeRowJoiner1.join(agg_aggKey1, agg_aggBuffer1);
/* 157 */
/* 158 */       boolean agg_isNull78 = agg_resultRow1.isNullAt(0);
/* 159 */       int agg_value82 = agg_isNull78 ? -1 : (agg_resultRow1.getInt(0));
/* 160 */       boolean agg_isNull79 = agg_resultRow1.isNullAt(1);
/* 161 */       double agg_value83 = agg_isNull79 ? -1.0 : (agg_resultRow1.getDouble(1));
/* 162 */       boolean agg_isNull80 = agg_resultRow1.isNullAt(2);
/* 163 */       double agg_value84 = agg_isNull80 ? -1.0 : (agg_resultRow1.getDouble(2));
/* 164 */
/* 165 */       // do aggregate
/* 166 */       // common sub-expressions
/* 167 */       boolean agg_isNull81 = false;
/* 168 */       double agg_value85 = -1.0;
/* 169 */       if (!false) {
/* 170 */         agg_value85 = (double) 0;
/* 171 */       }
/* 172 */       // evaluate aggregate function
/* 173 */       boolean agg_isNull84 = true;
/* 174 */       double agg_value88 = -1.0;
/* 175 */
/* 176 */       boolean agg_isNull85 = agg_bufIsNull;
/* 177 */       double agg_value89 = agg_bufValue;
/* 178 */       if (agg_isNull85) {
/* 179 */         if (!agg_isNull81) {
/* 180 */           agg_isNull85 = false;
/* 181 */           agg_value89 = agg_value85;
/* 182 */         }
/* 183 */       }
/* 184 */
/* 185 */       if (!agg_isNull79) {
/* 186 */         agg_isNull84 = false; // resultCode could change nullability.
/* 187 */         agg_value88 = agg_value89 + agg_value83;
/* 188 */
/* 189 */       }
/* 190 */       boolean agg_isNull83 = agg_isNull84;
/* 191 */       double agg_value87 = agg_value88;
/* 192 */       if (agg_isNull83) {
/* 193 */         if (!agg_bufIsNull) {
/* 194 */           agg_isNull83 = false;
/* 195 */           agg_value87 = agg_bufValue;
/* 196 */         }
/* 197 */       }
/* 198 */       boolean agg_isNull90 = true;
/* 199 */       double agg_value94 = -1.0;
/* 200 */
/* 201 */       boolean agg_isNull91 = agg_bufIsNull1;
/* 202 */       double agg_value95 = agg_bufValue1;
/* 203 */       if (agg_isNull91) {
/* 204 */         if (!agg_isNull81) {
/* 205 */           agg_isNull91 = false;
/* 206 */           agg_value95 = agg_value85;
/* 207 */         }
/* 208 */       }
/* 209 */
/* 210 */       if (!agg_isNull80) {
/* 211 */         agg_isNull90 = false; // resultCode could change nullability.
/* 212 */         agg_value94 = agg_value95 + agg_value84;
/* 213 */
/* 214 */       }
/* 215 */       boolean agg_isNull89 = agg_isNull90;
/* 216 */       double agg_value93 = agg_value94;
/* 217 */       if (agg_isNull89) {
/* 218 */         if (!agg_bufIsNull1) {
/* 219 */           agg_isNull89 = false;
/* 220 */           agg_value93 = agg_bufValue1;
/* 221 */         }
/* 222 */       }
/* 223 */       boolean agg_isNull95 = false;
/* 224 */       long agg_value99 = -1L;
/* 225 */       if (!false && agg_isNull78) {
/* 226 */         agg_isNull95 = agg_bufIsNull2;
/* 227 */         agg_value99 = agg_bufValue2;
/* 228 */       } else {
/* 229 */         boolean agg_isNull99 = false;
/* 230 */
/* 231 */         long agg_value103 = -1L;
/* 232 */         agg_value103 = agg_bufValue2 + 1L;
/* 233 */         agg_isNull95 = false;
/* 234 */         agg_value99 = agg_value103;
/* 235 */       }
/* 236 */       // update aggregation buffer
/* 237 */       agg_bufIsNull = agg_isNull83;
/* 238 */       agg_bufValue = agg_value87;
/* 239 */
/* 240 */       agg_bufIsNull1 = agg_isNull89;
/* 241 */       agg_bufValue1 = agg_value93;
/* 242 */
/* 243 */       agg_bufIsNull2 = agg_isNull95;
/* 244 */       agg_bufValue2 = agg_value99;
/* 245 */
/* 246 */       if (shouldStop()) return;
/* 247 */     }
/* 248 */     agg_fastHashMap.close();
/* 249 */
/* 250 */     while (agg_mapIter.next()) {
/* 251 */       agg_numOutputRows1.add(1);
/* 252 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 253 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 254 */
/* 255 */       UnsafeRow agg_resultRow1 = agg_unsafeRowJoiner1.join(agg_aggKey1, agg_aggBuffer1);
/* 256 */
/* 257 */       boolean agg_isNull78 = agg_resultRow1.isNullAt(0);
/* 258 */       int agg_value82 = agg_isNull78 ? -1 : (agg_resultRow1.getInt(0));
/* 259 */       boolean agg_isNull79 = agg_resultRow1.isNullAt(1);
/* 260 */       double agg_value83 = agg_isNull79 ? -1.0 : (agg_resultRow1.getDouble(1));
/* 261 */       boolean agg_isNull80 = agg_resultRow1.isNullAt(2);
/* 262 */       double agg_value84 = agg_isNull80 ? -1.0 : (agg_resultRow1.getDouble(2));
/* 263 */
/* 264 */       // do aggregate
/* 265 */       // common sub-expressions
/* 266 */       boolean agg_isNull81 = false;
/* 267 */       double agg_value85 = -1.0;
/* 268 */       if (!false) {
/* 269 */         agg_value85 = (double) 0;
/* 270 */       }
/* 271 */       // evaluate aggregate function
/* 272 */       boolean agg_isNull84 = true;
/* 273 */       double agg_value88 = -1.0;
/* 274 */
/* 275 */       boolean agg_isNull85 = agg_bufIsNull;
/* 276 */       double agg_value89 = agg_bufValue;
/* 277 */       if (agg_isNull85) {
/* 278 */         if (!agg_isNull81) {
/* 279 */           agg_isNull85 = false;
/* 280 */           agg_value89 = agg_value85;
/* 281 */         }
/* 282 */       }
/* 283 */
/* 284 */       if (!agg_isNull79) {
/* 285 */         agg_isNull84 = false; // resultCode could change nullability.
/* 286 */         agg_value88 = agg_value89 + agg_value83;
/* 287 */
/* 288 */       }
/* 289 */       boolean agg_isNull83 = agg_isNull84;
/* 290 */       double agg_value87 = agg_value88;
/* 291 */       if (agg_isNull83) {
/* 292 */         if (!agg_bufIsNull) {
/* 293 */           agg_isNull83 = false;
/* 294 */           agg_value87 = agg_bufValue;
/* 295 */         }
/* 296 */       }
/* 297 */       boolean agg_isNull90 = true;
/* 298 */       double agg_value94 = -1.0;
/* 299 */
/* 300 */       boolean agg_isNull91 = agg_bufIsNull1;
/* 301 */       double agg_value95 = agg_bufValue1;
/* 302 */       if (agg_isNull91) {
/* 303 */         if (!agg_isNull81) {
/* 304 */           agg_isNull91 = false;
/* 305 */           agg_value95 = agg_value85;
/* 306 */         }
/* 307 */       }
/* 308 */
/* 309 */       if (!agg_isNull80) {
/* 310 */         agg_isNull90 = false; // resultCode could change nullability.
/* 311 */         agg_value94 = agg_value95 + agg_value84;
/* 312 */
/* 313 */       }
/* 314 */       boolean agg_isNull89 = agg_isNull90;
/* 315 */       double agg_value93 = agg_value94;
/* 316 */       if (agg_isNull89) {
/* 317 */         if (!agg_bufIsNull1) {
/* 318 */           agg_isNull89 = false;
/* 319 */           agg_value93 = agg_bufValue1;
/* 320 */         }
/* 321 */       }
/* 322 */       boolean agg_isNull95 = false;
/* 323 */       long agg_value99 = -1L;
/* 324 */       if (!false && agg_isNull78) {
/* 325 */         agg_isNull95 = agg_bufIsNull2;
/* 326 */         agg_value99 = agg_bufValue2;
/* 327 */       } else {
/* 328 */         boolean agg_isNull99 = false;
/* 329 */
/* 330 */         long agg_value103 = -1L;
/* 331 */         agg_value103 = agg_bufValue2 + 1L;
/* 332 */         agg_isNull95 = false;
/* 333 */         agg_value99 = agg_value103;
/* 334 */       }
/* 335 */       // update aggregation buffer
/* 336 */       agg_bufIsNull = agg_isNull83;
/* 337 */       agg_bufValue = agg_value87;
/* 338 */
/* 339 */       agg_bufIsNull1 = agg_isNull89;
/* 340 */       agg_bufValue1 = agg_value93;
/* 341 */
/* 342 */       agg_bufIsNull2 = agg_isNull95;
/* 343 */       agg_bufValue2 = agg_value99;
/* 344 */
/* 345 */       if (shouldStop()) return;
/* 346 */     }
/* 347 */
/* 348 */     agg_mapIter.close();
/* 349 */     if (agg_sorter == null) {
/* 350 */       agg_hashMap.free();
/* 351 */     }
/* 352 */
/* 353 */   }
/* 354 */
/* 355 */   private void wholestagecodegen_init_3() {
/* 356 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 5);
/* 357 */     project_result3 = new UnsafeRow(3);
/* 358 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 359 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 3);
/* 360 */     agg_result2 = new UnsafeRow(1);
/* 361 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 362 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 363 */
/* 364 */     agg_unsafeRowJoiner = agg_plan1.createUnsafeJoiner();
/* 365 */     agg_result3 = new UnsafeRow(1);
/* 366 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 367 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 368 */
/* 369 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 370 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 371 */
/* 372 */   }
/* 373 */
/* 374 */   public class agg_FastHashMap {
/* 375 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 376 */     private int[] buckets;
/* 377 */     private int capacity = 1 << 16;
/* 378 */     private double loadFactor = 0.5;
/* 379 */     private int numBuckets = (int) (capacity / loadFactor);
/* 380 */     private int maxSteps = 2;
/* 381 */     private int numRows = 0;
/* 382 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("cs_order_number", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 383 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 384 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 385 */     private Object emptyVBase;
/* 386 */     private long emptyVOff;
/* 387 */     private int emptyVLen;
/* 388 */     private boolean isBatchFull = false;
/* 389 */
/* 390 */     public agg_FastHashMap(
/* 391 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 392 */       InternalRow emptyAggregationBuffer) {
/* 393 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 394 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 395 */
/* 396 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 397 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 398 */
/* 399 */       emptyVBase = emptyBuffer;
/* 400 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 401 */       emptyVLen = emptyBuffer.length;
/* 402 */
/* 403 */       buckets = new int[numBuckets];
/* 404 */       java.util.Arrays.fill(buckets, -1);
/* 405 */     }
/* 406 */
/* 407 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 408 */       long h = hash(agg_key);
/* 409 */       int step = 0;
/* 410 */       int idx = (int) h & (numBuckets - 1);
/* 411 */       while (step < maxSteps) {
/* 412 */         // Return bucket index if it's either an empty slot or already contains the key
/* 413 */         if (buckets[idx] == -1) {
/* 414 */           if (numRows < capacity && !isBatchFull) {
/* 415 */             // creating the unsafe for new entry
/* 416 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 417 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 418 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 419 */               0);
/* 420 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 421 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 422 */               agg_holder,
/* 423 */               1);
/* 424 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 425 */             agg_rowWriter.zeroOutNullBytes();
/* 426 */             agg_rowWriter.write(0, agg_key);
/* 427 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 428 */             Object kbase = agg_result.getBaseObject();
/* 429 */             long koff = agg_result.getBaseOffset();
/* 430 */             int klen = agg_result.getSizeInBytes();
/* 431 */
/* 432 */             UnsafeRow vRow
/* 433 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 434 */             if (vRow == null) {
/* 435 */               isBatchFull = true;
/* 436 */             } else {
/* 437 */               buckets[idx] = numRows++;
/* 438 */             }
/* 439 */             return vRow;
/* 440 */           } else {
/* 441 */             // No more space
/* 442 */             return null;
/* 443 */           }
/* 444 */         } else if (equals(idx, agg_key)) {
/* 445 */           return batch.getValueRow(buckets[idx]);
/* 446 */         }
/* 447 */         idx = (idx + 1) & (numBuckets - 1);
/* 448 */         step++;
/* 449 */       }
/* 450 */       // Didn't find it
/* 451 */       return null;
/* 452 */     }
/* 453 */
/* 454 */     private boolean equals(int idx, int agg_key) {
/* 455 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 456 */       return (row.getInt(0) == agg_key);
/* 457 */     }
/* 458 */
/* 459 */     private long hash(int agg_key) {
/* 460 */       long agg_hash = 0;
/* 461 */
/* 462 */       int agg_result = agg_key;
/* 463 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 464 */
/* 465 */       return agg_hash;
/* 466 */     }
/* 467 */
/* 468 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 469 */       return batch.rowIterator();
/* 470 */     }
/* 471 */
/* 472 */     public void close() {
/* 473 */       batch.close();
/* 474 */     }
/* 475 */
/* 476 */   }
/* 477 */
/* 478 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 479 */     agg_hashMap = agg_plan.createHashMap();
/* 480 */
/* 481 */     if (!agg_initAgg2) {
/* 482 */       agg_initAgg2 = true;
/* 483 */       long agg_beforeAgg = System.nanoTime();
/* 484 */       agg_doAggregateWithKeys1();
/* 485 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 486 */     }
/* 487 */
/* 488 */     // output the result
/* 489 */
/* 490 */     while (agg_fastHashMapIter1.next()) {
/* 491 */       agg_numOutputRows.add(1);
/* 492 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter1.getKey();
/* 493 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter1.getValue();
/* 494 */
/* 495 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 496 */
/* 497 */       boolean agg_isNull43 = agg_resultRow.isNullAt(0);
/* 498 */       int agg_value47 = agg_isNull43 ? -1 : (agg_resultRow.getInt(0));
/* 499 */       boolean agg_isNull44 = agg_resultRow.isNullAt(1);
/* 500 */       double agg_value48 = agg_isNull44 ? -1.0 : (agg_resultRow.getDouble(1));
/* 501 */       boolean agg_isNull45 = agg_resultRow.isNullAt(2);
/* 502 */       double agg_value49 = agg_isNull45 ? -1.0 : (agg_resultRow.getDouble(2));
/* 503 */
/* 504 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 505 */
/* 506 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 507 */
/* 508 */       if (true) {
/* 509 */         if (!agg_isNull43) {
/* 510 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 511 */             agg_value47);
/* 512 */         }
/* 513 */       }
/* 514 */
/* 515 */       if (agg_fastAggBuffer1 == null) {
/* 516 */         // generate grouping key
/* 517 */         agg_rowWriter1.zeroOutNullBytes();
/* 518 */
/* 519 */         if (agg_isNull43) {
/* 520 */           agg_rowWriter1.setNullAt(0);
/* 521 */         } else {
/* 522 */           agg_rowWriter1.write(0, agg_value47);
/* 523 */         }
/* 524 */         agg_value52 = 42;
/* 525 */
/* 526 */         if (!agg_isNull43) {
/* 527 */           agg_value52 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value47, agg_value52);
/* 528 */         }
/* 529 */         if (true) {
/* 530 */           // try to get the buffer from hash map
/* 531 */           agg_unsafeRowAggBuffer1 =
/* 532 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value52);
/* 533 */         }
/* 534 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 535 */           if (agg_sorter == null) {
/* 536 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 537 */           } else {
/* 538 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 539 */           }
/* 540 */
/* 541 */           // the hash map had be spilled, it should have enough memory now,
/* 542 */           // try  to allocate buffer again.
/* 543 */           agg_unsafeRowAggBuffer1 =
/* 544 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value52);
/* 545 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 546 */             // failed to allocate the first page
/* 547 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 548 */           }
/* 549 */         }
/* 550 */       }
/* 551 */
/* 552 */       if (agg_fastAggBuffer1 != null) {
/* 553 */         // update fast row
/* 554 */
/* 555 */         // common sub-expressions
/* 556 */         boolean agg_isNull64 = false;
/* 557 */         double agg_value68 = -1.0;
/* 558 */         if (!false) {
/* 559 */           agg_value68 = (double) 0;
/* 560 */         }
/* 561 */         // evaluate aggregate function
/* 562 */         boolean agg_isNull67 = true;
/* 563 */         double agg_value71 = -1.0;
/* 564 */
/* 565 */         boolean agg_isNull69 = agg_fastAggBuffer1.isNullAt(0);
/* 566 */         double agg_value73 = agg_isNull69 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 567 */         boolean agg_isNull68 = agg_isNull69;
/* 568 */         double agg_value72 = agg_value73;
/* 569 */         if (agg_isNull68) {
/* 570 */           if (!agg_isNull64) {
/* 571 */             agg_isNull68 = false;
/* 572 */             agg_value72 = agg_value68;
/* 573 */           }
/* 574 */         }
/* 575 */
/* 576 */         if (!agg_isNull44) {
/* 577 */           agg_isNull67 = false; // resultCode could change nullability.
/* 578 */           agg_value71 = agg_value72 + agg_value48;
/* 579 */
/* 580 */         }
/* 581 */         boolean agg_isNull66 = agg_isNull67;
/* 582 */         double agg_value70 = agg_value71;
/* 583 */         if (agg_isNull66) {
/* 584 */           boolean agg_isNull71 = agg_fastAggBuffer1.isNullAt(0);
/* 585 */           double agg_value75 = agg_isNull71 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 586 */           if (!agg_isNull71) {
/* 587 */             agg_isNull66 = false;
/* 588 */             agg_value70 = agg_value75;
/* 589 */           }
/* 590 */         }
/* 591 */         boolean agg_isNull73 = true;
/* 592 */         double agg_value77 = -1.0;
/* 593 */
/* 594 */         boolean agg_isNull75 = agg_fastAggBuffer1.isNullAt(1);
/* 595 */         double agg_value79 = agg_isNull75 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 596 */         boolean agg_isNull74 = agg_isNull75;
/* 597 */         double agg_value78 = agg_value79;
/* 598 */         if (agg_isNull74) {
/* 599 */           if (!agg_isNull64) {
/* 600 */             agg_isNull74 = false;
/* 601 */             agg_value78 = agg_value68;
/* 602 */           }
/* 603 */         }
/* 604 */
/* 605 */         if (!agg_isNull45) {
/* 606 */           agg_isNull73 = false; // resultCode could change nullability.
/* 607 */           agg_value77 = agg_value78 + agg_value49;
/* 608 */
/* 609 */         }
/* 610 */         boolean agg_isNull72 = agg_isNull73;
/* 611 */         double agg_value76 = agg_value77;
/* 612 */         if (agg_isNull72) {
/* 613 */           boolean agg_isNull77 = agg_fastAggBuffer1.isNullAt(1);
/* 614 */           double agg_value81 = agg_isNull77 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 615 */           if (!agg_isNull77) {
/* 616 */             agg_isNull72 = false;
/* 617 */             agg_value76 = agg_value81;
/* 618 */           }
/* 619 */         }
/* 620 */         // update fast row
/* 621 */         if (!agg_isNull66) {
/* 622 */           agg_fastAggBuffer1.setDouble(0, agg_value70);
/* 623 */         } else {
/* 624 */           agg_fastAggBuffer1.setNullAt(0);
/* 625 */         }
/* 626 */
/* 627 */         if (!agg_isNull72) {
/* 628 */           agg_fastAggBuffer1.setDouble(1, agg_value76);
/* 629 */         } else {
/* 630 */           agg_fastAggBuffer1.setNullAt(1);
/* 631 */         }
/* 632 */
/* 633 */       } else {
/* 634 */         // update unsafe row
/* 635 */
/* 636 */         // common sub-expressions
/* 637 */         boolean agg_isNull50 = false;
/* 638 */         double agg_value54 = -1.0;
/* 639 */         if (!false) {
/* 640 */           agg_value54 = (double) 0;
/* 641 */         }
/* 642 */         // evaluate aggregate function
/* 643 */         boolean agg_isNull53 = true;
/* 644 */         double agg_value57 = -1.0;
/* 645 */
/* 646 */         boolean agg_isNull55 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 647 */         double agg_value59 = agg_isNull55 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 648 */         boolean agg_isNull54 = agg_isNull55;
/* 649 */         double agg_value58 = agg_value59;
/* 650 */         if (agg_isNull54) {
/* 651 */           if (!agg_isNull50) {
/* 652 */             agg_isNull54 = false;
/* 653 */             agg_value58 = agg_value54;
/* 654 */           }
/* 655 */         }
/* 656 */
/* 657 */         if (!agg_isNull44) {
/* 658 */           agg_isNull53 = false; // resultCode could change nullability.
/* 659 */           agg_value57 = agg_value58 + agg_value48;
/* 660 */
/* 661 */         }
/* 662 */         boolean agg_isNull52 = agg_isNull53;
/* 663 */         double agg_value56 = agg_value57;
/* 664 */         if (agg_isNull52) {
/* 665 */           boolean agg_isNull57 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 666 */           double agg_value61 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 667 */           if (!agg_isNull57) {
/* 668 */             agg_isNull52 = false;
/* 669 */             agg_value56 = agg_value61;
/* 670 */           }
/* 671 */         }
/* 672 */         boolean agg_isNull59 = true;
/* 673 */         double agg_value63 = -1.0;
/* 674 */
/* 675 */         boolean agg_isNull61 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 676 */         double agg_value65 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 677 */         boolean agg_isNull60 = agg_isNull61;
/* 678 */         double agg_value64 = agg_value65;
/* 679 */         if (agg_isNull60) {
/* 680 */           if (!agg_isNull50) {
/* 681 */             agg_isNull60 = false;
/* 682 */             agg_value64 = agg_value54;
/* 683 */           }
/* 684 */         }
/* 685 */
/* 686 */         if (!agg_isNull45) {
/* 687 */           agg_isNull59 = false; // resultCode could change nullability.
/* 688 */           agg_value63 = agg_value64 + agg_value49;
/* 689 */
/* 690 */         }
/* 691 */         boolean agg_isNull58 = agg_isNull59;
/* 692 */         double agg_value62 = agg_value63;
/* 693 */         if (agg_isNull58) {
/* 694 */           boolean agg_isNull63 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 695 */           double agg_value67 = agg_isNull63 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 696 */           if (!agg_isNull63) {
/* 697 */             agg_isNull58 = false;
/* 698 */             agg_value62 = agg_value67;
/* 699 */           }
/* 700 */         }
/* 701 */         // update unsafe row buffer
/* 702 */         if (!agg_isNull52) {
/* 703 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value56);
/* 704 */         } else {
/* 705 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 706 */         }
/* 707 */
/* 708 */         if (!agg_isNull58) {
/* 709 */           agg_unsafeRowAggBuffer1.setDouble(1, agg_value62);
/* 710 */         } else {
/* 711 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 712 */         }
/* 713 */
/* 714 */       }
/* 715 */
/* 716 */       if (shouldStop()) return;
/* 717 */     }
/* 718 */     agg_fastHashMap1.close();
/* 719 */
/* 720 */     while (agg_mapIter1.next()) {
/* 721 */       agg_numOutputRows.add(1);
/* 722 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter1.getKey();
/* 723 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter1.getValue();
/* 724 */
/* 725 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 726 */
/* 727 */       boolean agg_isNull43 = agg_resultRow.isNullAt(0);
/* 728 */       int agg_value47 = agg_isNull43 ? -1 : (agg_resultRow.getInt(0));
/* 729 */       boolean agg_isNull44 = agg_resultRow.isNullAt(1);
/* 730 */       double agg_value48 = agg_isNull44 ? -1.0 : (agg_resultRow.getDouble(1));
/* 731 */       boolean agg_isNull45 = agg_resultRow.isNullAt(2);
/* 732 */       double agg_value49 = agg_isNull45 ? -1.0 : (agg_resultRow.getDouble(2));
/* 733 */
/* 734 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 735 */
/* 736 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 737 */
/* 738 */       if (true) {
/* 739 */         if (!agg_isNull43) {
/* 740 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 741 */             agg_value47);
/* 742 */         }
/* 743 */       }
/* 744 */
/* 745 */       if (agg_fastAggBuffer1 == null) {
/* 746 */         // generate grouping key
/* 747 */         agg_rowWriter1.zeroOutNullBytes();
/* 748 */
/* 749 */         if (agg_isNull43) {
/* 750 */           agg_rowWriter1.setNullAt(0);
/* 751 */         } else {
/* 752 */           agg_rowWriter1.write(0, agg_value47);
/* 753 */         }
/* 754 */         agg_value52 = 42;
/* 755 */
/* 756 */         if (!agg_isNull43) {
/* 757 */           agg_value52 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value47, agg_value52);
/* 758 */         }
/* 759 */         if (true) {
/* 760 */           // try to get the buffer from hash map
/* 761 */           agg_unsafeRowAggBuffer1 =
/* 762 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value52);
/* 763 */         }
/* 764 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 765 */           if (agg_sorter == null) {
/* 766 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 767 */           } else {
/* 768 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 769 */           }
/* 770 */
/* 771 */           // the hash map had be spilled, it should have enough memory now,
/* 772 */           // try  to allocate buffer again.
/* 773 */           agg_unsafeRowAggBuffer1 =
/* 774 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value52);
/* 775 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 776 */             // failed to allocate the first page
/* 777 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 778 */           }
/* 779 */         }
/* 780 */       }
/* 781 */
/* 782 */       if (agg_fastAggBuffer1 != null) {
/* 783 */         // update fast row
/* 784 */
/* 785 */         // common sub-expressions
/* 786 */         boolean agg_isNull64 = false;
/* 787 */         double agg_value68 = -1.0;
/* 788 */         if (!false) {
/* 789 */           agg_value68 = (double) 0;
/* 790 */         }
/* 791 */         // evaluate aggregate function
/* 792 */         boolean agg_isNull67 = true;
/* 793 */         double agg_value71 = -1.0;
/* 794 */
/* 795 */         boolean agg_isNull69 = agg_fastAggBuffer1.isNullAt(0);
/* 796 */         double agg_value73 = agg_isNull69 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 797 */         boolean agg_isNull68 = agg_isNull69;
/* 798 */         double agg_value72 = agg_value73;
/* 799 */         if (agg_isNull68) {
/* 800 */           if (!agg_isNull64) {
/* 801 */             agg_isNull68 = false;
/* 802 */             agg_value72 = agg_value68;
/* 803 */           }
/* 804 */         }
/* 805 */
/* 806 */         if (!agg_isNull44) {
/* 807 */           agg_isNull67 = false; // resultCode could change nullability.
/* 808 */           agg_value71 = agg_value72 + agg_value48;
/* 809 */
/* 810 */         }
/* 811 */         boolean agg_isNull66 = agg_isNull67;
/* 812 */         double agg_value70 = agg_value71;
/* 813 */         if (agg_isNull66) {
/* 814 */           boolean agg_isNull71 = agg_fastAggBuffer1.isNullAt(0);
/* 815 */           double agg_value75 = agg_isNull71 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 816 */           if (!agg_isNull71) {
/* 817 */             agg_isNull66 = false;
/* 818 */             agg_value70 = agg_value75;
/* 819 */           }
/* 820 */         }
/* 821 */         boolean agg_isNull73 = true;
/* 822 */         double agg_value77 = -1.0;
/* 823 */
/* 824 */         boolean agg_isNull75 = agg_fastAggBuffer1.isNullAt(1);
/* 825 */         double agg_value79 = agg_isNull75 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 826 */         boolean agg_isNull74 = agg_isNull75;
/* 827 */         double agg_value78 = agg_value79;
/* 828 */         if (agg_isNull74) {
/* 829 */           if (!agg_isNull64) {
/* 830 */             agg_isNull74 = false;
/* 831 */             agg_value78 = agg_value68;
/* 832 */           }
/* 833 */         }
/* 834 */
/* 835 */         if (!agg_isNull45) {
/* 836 */           agg_isNull73 = false; // resultCode could change nullability.
/* 837 */           agg_value77 = agg_value78 + agg_value49;
/* 838 */
/* 839 */         }
/* 840 */         boolean agg_isNull72 = agg_isNull73;
/* 841 */         double agg_value76 = agg_value77;
/* 842 */         if (agg_isNull72) {
/* 843 */           boolean agg_isNull77 = agg_fastAggBuffer1.isNullAt(1);
/* 844 */           double agg_value81 = agg_isNull77 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 845 */           if (!agg_isNull77) {
/* 846 */             agg_isNull72 = false;
/* 847 */             agg_value76 = agg_value81;
/* 848 */           }
/* 849 */         }
/* 850 */         // update fast row
/* 851 */         if (!agg_isNull66) {
/* 852 */           agg_fastAggBuffer1.setDouble(0, agg_value70);
/* 853 */         } else {
/* 854 */           agg_fastAggBuffer1.setNullAt(0);
/* 855 */         }
/* 856 */
/* 857 */         if (!agg_isNull72) {
/* 858 */           agg_fastAggBuffer1.setDouble(1, agg_value76);
/* 859 */         } else {
/* 860 */           agg_fastAggBuffer1.setNullAt(1);
/* 861 */         }
/* 862 */
/* 863 */       } else {
/* 864 */         // update unsafe row
/* 865 */
/* 866 */         // common sub-expressions
/* 867 */         boolean agg_isNull50 = false;
/* 868 */         double agg_value54 = -1.0;
/* 869 */         if (!false) {
/* 870 */           agg_value54 = (double) 0;
/* 871 */         }
/* 872 */         // evaluate aggregate function
/* 873 */         boolean agg_isNull53 = true;
/* 874 */         double agg_value57 = -1.0;
/* 875 */
/* 876 */         boolean agg_isNull55 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 877 */         double agg_value59 = agg_isNull55 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 878 */         boolean agg_isNull54 = agg_isNull55;
/* 879 */         double agg_value58 = agg_value59;
/* 880 */         if (agg_isNull54) {
/* 881 */           if (!agg_isNull50) {
/* 882 */             agg_isNull54 = false;
/* 883 */             agg_value58 = agg_value54;
/* 884 */           }
/* 885 */         }
/* 886 */
/* 887 */         if (!agg_isNull44) {
/* 888 */           agg_isNull53 = false; // resultCode could change nullability.
/* 889 */           agg_value57 = agg_value58 + agg_value48;
/* 890 */
/* 891 */         }
/* 892 */         boolean agg_isNull52 = agg_isNull53;
/* 893 */         double agg_value56 = agg_value57;
/* 894 */         if (agg_isNull52) {
/* 895 */           boolean agg_isNull57 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 896 */           double agg_value61 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 897 */           if (!agg_isNull57) {
/* 898 */             agg_isNull52 = false;
/* 899 */             agg_value56 = agg_value61;
/* 900 */           }
/* 901 */         }
/* 902 */         boolean agg_isNull59 = true;
/* 903 */         double agg_value63 = -1.0;
/* 904 */
/* 905 */         boolean agg_isNull61 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 906 */         double agg_value65 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 907 */         boolean agg_isNull60 = agg_isNull61;
/* 908 */         double agg_value64 = agg_value65;
/* 909 */         if (agg_isNull60) {
/* 910 */           if (!agg_isNull50) {
/* 911 */             agg_isNull60 = false;
/* 912 */             agg_value64 = agg_value54;
/* 913 */           }
/* 914 */         }
/* 915 */
/* 916 */         if (!agg_isNull45) {
/* 917 */           agg_isNull59 = false; // resultCode could change nullability.
/* 918 */           agg_value63 = agg_value64 + agg_value49;
/* 919 */
/* 920 */         }
/* 921 */         boolean agg_isNull58 = agg_isNull59;
/* 922 */         double agg_value62 = agg_value63;
/* 923 */         if (agg_isNull58) {
/* 924 */           boolean agg_isNull63 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 925 */           double agg_value67 = agg_isNull63 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 926 */           if (!agg_isNull63) {
/* 927 */             agg_isNull58 = false;
/* 928 */             agg_value62 = agg_value67;
/* 929 */           }
/* 930 */         }
/* 931 */         // update unsafe row buffer
/* 932 */         if (!agg_isNull52) {
/* 933 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value56);
/* 934 */         } else {
/* 935 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 936 */         }
/* 937 */
/* 938 */         if (!agg_isNull58) {
/* 939 */           agg_unsafeRowAggBuffer1.setDouble(1, agg_value62);
/* 940 */         } else {
/* 941 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 942 */         }
/* 943 */
/* 944 */       }
/* 945 */
/* 946 */       if (shouldStop()) return;
/* 947 */     }
/* 948 */
/* 949 */     agg_mapIter1.close();
/* 950 */     if (agg_sorter1 == null) {
/* 951 */       agg_hashMap1.free();
/* 952 */     }
/* 953 */
/* 954 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 955 */
/* 956 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 957 */   }
/* 958 */
/* 959 */   public class agg_FastHashMap1 {
/* 960 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 961 */     private int[] buckets;
/* 962 */     private int capacity = 1 << 16;
/* 963 */     private double loadFactor = 0.5;
/* 964 */     private int numBuckets = (int) (capacity / loadFactor);
/* 965 */     private int maxSteps = 2;
/* 966 */     private int numRows = 0;
/* 967 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("cs_order_number", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 968 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 969 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 970 */     private Object emptyVBase;
/* 971 */     private long emptyVOff;
/* 972 */     private int emptyVLen;
/* 973 */     private boolean isBatchFull = false;
/* 974 */
/* 975 */     public agg_FastHashMap1(
/* 976 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 977 */       InternalRow emptyAggregationBuffer) {
/* 978 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 979 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 980 */
/* 981 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 982 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 983 */
/* 984 */       emptyVBase = emptyBuffer;
/* 985 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 986 */       emptyVLen = emptyBuffer.length;
/* 987 */
/* 988 */       buckets = new int[numBuckets];
/* 989 */       java.util.Arrays.fill(buckets, -1);
/* 990 */     }
/* 991 */
/* 992 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key1) {
/* 993 */       long h = hash(agg_key1);
/* 994 */       int step = 0;
/* 995 */       int idx = (int) h & (numBuckets - 1);
/* 996 */       while (step < maxSteps) {
/* 997 */         // Return bucket index if it's either an empty slot or already contains the key
/* 998 */         if (buckets[idx] == -1) {
/* 999 */           if (numRows < capacity && !isBatchFull) {
/* 1000 */             // creating the unsafe for new entry
/* 1001 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 1002 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 1003 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 1004 */               0);
/* 1005 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 1006 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 1007 */               agg_holder,
/* 1008 */               1);
/* 1009 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 1010 */             agg_rowWriter.zeroOutNullBytes();
/* 1011 */             agg_rowWriter.write(0, agg_key1);
/* 1012 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 1013 */             Object kbase = agg_result.getBaseObject();
/* 1014 */             long koff = agg_result.getBaseOffset();
/* 1015 */             int klen = agg_result.getSizeInBytes();
/* 1016 */
/* 1017 */             UnsafeRow vRow
/* 1018 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 1019 */             if (vRow == null) {
/* 1020 */               isBatchFull = true;
/* 1021 */             } else {
/* 1022 */               buckets[idx] = numRows++;
/* 1023 */             }
/* 1024 */             return vRow;
/* 1025 */           } else {
/* 1026 */             // No more space
/* 1027 */             return null;
/* 1028 */           }
/* 1029 */         } else if (equals(idx, agg_key1)) {
/* 1030 */           return batch.getValueRow(buckets[idx]);
/* 1031 */         }
/* 1032 */         idx = (idx + 1) & (numBuckets - 1);
/* 1033 */         step++;
/* 1034 */       }
/* 1035 */       // Didn't find it
/* 1036 */       return null;
/* 1037 */     }
/* 1038 */
/* 1039 */     private boolean equals(int idx, int agg_key1) {
/* 1040 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 1041 */       return (row.getInt(0) == agg_key1);
/* 1042 */     }
/* 1043 */
/* 1044 */     private long hash(int agg_key1) {
/* 1045 */       long agg_hash1 = 0;
/* 1046 */
/* 1047 */       int agg_result1 = agg_key1;
/* 1048 */       agg_hash1 = (agg_hash1 ^ (0x9e3779b9)) + agg_result1 + (agg_hash1 << 6) + (agg_hash1 >>> 2);
/* 1049 */
/* 1050 */       return agg_hash1;
/* 1051 */     }
/* 1052 */
/* 1053 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 1054 */       return batch.rowIterator();
/* 1055 */     }
/* 1056 */
/* 1057 */     public void close() {
/* 1058 */       batch.close();
/* 1059 */     }
/* 1060 */
/* 1061 */   }
/* 1062 */
/* 1063 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 1064 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 1065 */
/* 1066 */     while (inputadapter_input.hasNext()) {
/* 1067 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 1068 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 1069 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 1070 */
/* 1071 */       // generate join key for stream side
/* 1072 */
/* 1073 */       boolean bhj_isNull = inputadapter_isNull1;
/* 1074 */       long bhj_value = -1L;
/* 1075 */       if (!inputadapter_isNull1) {
/* 1076 */         bhj_value = (long) inputadapter_value1;
/* 1077 */       }
/* 1078 */       // find matches from HashedRelation
/* 1079 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 1080 */       if (bhj_matched == null) continue;
/* 1081 */
/* 1082 */       bhj_numOutputRows.add(1);
/* 1083 */
/* 1084 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 1085 */       int inputadapter_value9 = inputadapter_isNull9 ? -1 : (inputadapter_row.getInt(9));
/* 1086 */
/* 1087 */       // generate join key for stream side
/* 1088 */
/* 1089 */       boolean bhj_isNull10 = inputadapter_isNull9;
/* 1090 */       long bhj_value10 = -1L;
/* 1091 */       if (!inputadapter_isNull9) {
/* 1092 */         bhj_value10 = (long) inputadapter_value9;
/* 1093 */       }
/* 1094 */       // find matches from HashedRelation
/* 1095 */       UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 1096 */       if (bhj_matched1 == null) continue;
/* 1097 */
/* 1098 */       bhj_numOutputRows1.add(1);
/* 1099 */
/* 1100 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 1101 */       int inputadapter_value10 = inputadapter_isNull10 ? -1 : (inputadapter_row.getInt(10));
/* 1102 */
/* 1103 */       // generate join key for stream side
/* 1104 */
/* 1105 */       boolean bhj_isNull19 = inputadapter_isNull10;
/* 1106 */       long bhj_value19 = -1L;
/* 1107 */       if (!inputadapter_isNull10) {
/* 1108 */         bhj_value19 = (long) inputadapter_value10;
/* 1109 */       }
/* 1110 */       // find matches from HashedRelation
/* 1111 */       UnsafeRow bhj_matched2 = bhj_isNull19 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value19);
/* 1112 */       if (bhj_matched2 == null) continue;
/* 1113 */
/* 1114 */       bhj_numOutputRows2.add(1);
/* 1115 */
/* 1116 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 1117 */       int inputadapter_value16 = inputadapter_isNull16 ? -1 : (inputadapter_row.getInt(16));
/* 1118 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 1119 */       double inputadapter_value27 = inputadapter_isNull27 ? -1.0 : (inputadapter_row.getDouble(27));
/* 1120 */       boolean inputadapter_isNull32 = inputadapter_row.isNullAt(32);
/* 1121 */       double inputadapter_value32 = inputadapter_isNull32 ? -1.0 : (inputadapter_row.getDouble(32));
/* 1122 */
/* 1123 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 1124 */
/* 1125 */       UnsafeRow agg_fastAggBuffer = null;
/* 1126 */
/* 1127 */       if (true) {
/* 1128 */         if (!inputadapter_isNull16) {
/* 1129 */           agg_fastAggBuffer = agg_fastHashMap1.findOrInsert(
/* 1130 */             inputadapter_value16);
/* 1131 */         }
/* 1132 */       }
/* 1133 */
/* 1134 */       if (agg_fastAggBuffer == null) {
/* 1135 */         // generate grouping key
/* 1136 */         agg_rowWriter.zeroOutNullBytes();
/* 1137 */
/* 1138 */         if (inputadapter_isNull16) {
/* 1139 */           agg_rowWriter.setNullAt(0);
/* 1140 */         } else {
/* 1141 */           agg_rowWriter.write(0, inputadapter_value16);
/* 1142 */         }
/* 1143 */         agg_value13 = 42;
/* 1144 */
/* 1145 */         if (!inputadapter_isNull16) {
/* 1146 */           agg_value13 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value16, agg_value13);
/* 1147 */         }
/* 1148 */         if (true) {
/* 1149 */           // try to get the buffer from hash map
/* 1150 */           agg_unsafeRowAggBuffer =
/* 1151 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result2, agg_value13);
/* 1152 */         }
/* 1153 */         if (agg_unsafeRowAggBuffer == null) {
/* 1154 */           if (agg_sorter1 == null) {
/* 1155 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 1156 */           } else {
/* 1157 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 1158 */           }
/* 1159 */
/* 1160 */           // the hash map had be spilled, it should have enough memory now,
/* 1161 */           // try  to allocate buffer again.
/* 1162 */           agg_unsafeRowAggBuffer =
/* 1163 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result2, agg_value13);
/* 1164 */           if (agg_unsafeRowAggBuffer == null) {
/* 1165 */             // failed to allocate the first page
/* 1166 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 1167 */           }
/* 1168 */         }
/* 1169 */       }
/* 1170 */
/* 1171 */       if (agg_fastAggBuffer != null) {
/* 1172 */         // update fast row
/* 1173 */
/* 1174 */         // common sub-expressions
/* 1175 */         boolean agg_isNull27 = false;
/* 1176 */         double agg_value31 = -1.0;
/* 1177 */         if (!false) {
/* 1178 */           agg_value31 = (double) 0;
/* 1179 */         }
/* 1180 */         // evaluate aggregate function
/* 1181 */         boolean agg_isNull30 = true;
/* 1182 */         double agg_value34 = -1.0;
/* 1183 */
/* 1184 */         boolean agg_isNull32 = agg_fastAggBuffer.isNullAt(0);
/* 1185 */         double agg_value36 = agg_isNull32 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 1186 */         boolean agg_isNull31 = agg_isNull32;
/* 1187 */         double agg_value35 = agg_value36;
/* 1188 */         if (agg_isNull31) {
/* 1189 */           if (!agg_isNull27) {
/* 1190 */             agg_isNull31 = false;
/* 1191 */             agg_value35 = agg_value31;
/* 1192 */           }
/* 1193 */         }
/* 1194 */
/* 1195 */         boolean agg_isNull33 = inputadapter_isNull27;
/* 1196 */         double agg_value37 = -1.0;
/* 1197 */         if (!inputadapter_isNull27) {
/* 1198 */           agg_value37 = inputadapter_value27;
/* 1199 */         }
/* 1200 */         if (!agg_isNull33) {
/* 1201 */           agg_isNull30 = false; // resultCode could change nullability.
/* 1202 */           agg_value34 = agg_value35 + agg_value37;
/* 1203 */
/* 1204 */         }
/* 1205 */         boolean agg_isNull29 = agg_isNull30;
/* 1206 */         double agg_value33 = agg_value34;
/* 1207 */         if (agg_isNull29) {
/* 1208 */           boolean agg_isNull35 = agg_fastAggBuffer.isNullAt(0);
/* 1209 */           double agg_value39 = agg_isNull35 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 1210 */           if (!agg_isNull35) {
/* 1211 */             agg_isNull29 = false;
/* 1212 */             agg_value33 = agg_value39;
/* 1213 */           }
/* 1214 */         }
/* 1215 */         boolean agg_isNull37 = true;
/* 1216 */         double agg_value41 = -1.0;
/* 1217 */
/* 1218 */         boolean agg_isNull39 = agg_fastAggBuffer.isNullAt(1);
/* 1219 */         double agg_value43 = agg_isNull39 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 1220 */         boolean agg_isNull38 = agg_isNull39;
/* 1221 */         double agg_value42 = agg_value43;
/* 1222 */         if (agg_isNull38) {
/* 1223 */           if (!agg_isNull27) {
/* 1224 */             agg_isNull38 = false;
/* 1225 */             agg_value42 = agg_value31;
/* 1226 */           }
/* 1227 */         }
/* 1228 */
/* 1229 */         boolean agg_isNull40 = inputadapter_isNull32;
/* 1230 */         double agg_value44 = -1.0;
/* 1231 */         if (!inputadapter_isNull32) {
/* 1232 */           agg_value44 = inputadapter_value32;
/* 1233 */         }
/* 1234 */         if (!agg_isNull40) {
/* 1235 */           agg_isNull37 = false; // resultCode could change nullability.
/* 1236 */           agg_value41 = agg_value42 + agg_value44;
/* 1237 */
/* 1238 */         }
/* 1239 */         boolean agg_isNull36 = agg_isNull37;
/* 1240 */         double agg_value40 = agg_value41;
/* 1241 */         if (agg_isNull36) {
/* 1242 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(1);
/* 1243 */           double agg_value46 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 1244 */           if (!agg_isNull42) {
/* 1245 */             agg_isNull36 = false;
/* 1246 */             agg_value40 = agg_value46;
/* 1247 */           }
/* 1248 */         }
/* 1249 */         // update fast row
/* 1250 */         if (!agg_isNull29) {
/* 1251 */           agg_fastAggBuffer.setDouble(0, agg_value33);
/* 1252 */         } else {
/* 1253 */           agg_fastAggBuffer.setNullAt(0);
/* 1254 */         }
/* 1255 */
/* 1256 */         if (!agg_isNull36) {
/* 1257 */           agg_fastAggBuffer.setDouble(1, agg_value40);
/* 1258 */         } else {
/* 1259 */           agg_fastAggBuffer.setNullAt(1);
/* 1260 */         }
/* 1261 */
/* 1262 */       } else {
/* 1263 */         // update unsafe row
/* 1264 */
/* 1265 */         // common sub-expressions
/* 1266 */         boolean agg_isNull11 = false;
/* 1267 */         double agg_value15 = -1.0;
/* 1268 */         if (!false) {
/* 1269 */           agg_value15 = (double) 0;
/* 1270 */         }
/* 1271 */         // evaluate aggregate function
/* 1272 */         boolean agg_isNull14 = true;
/* 1273 */         double agg_value18 = -1.0;
/* 1274 */
/* 1275 */         boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 1276 */         double agg_value20 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 1277 */         boolean agg_isNull15 = agg_isNull16;
/* 1278 */         double agg_value19 = agg_value20;
/* 1279 */         if (agg_isNull15) {
/* 1280 */           if (!agg_isNull11) {
/* 1281 */             agg_isNull15 = false;
/* 1282 */             agg_value19 = agg_value15;
/* 1283 */           }
/* 1284 */         }
/* 1285 */
/* 1286 */         boolean agg_isNull17 = inputadapter_isNull27;
/* 1287 */         double agg_value21 = -1.0;
/* 1288 */         if (!inputadapter_isNull27) {
/* 1289 */           agg_value21 = inputadapter_value27;
/* 1290 */         }
/* 1291 */         if (!agg_isNull17) {
/* 1292 */           agg_isNull14 = false; // resultCode could change nullability.
/* 1293 */           agg_value18 = agg_value19 + agg_value21;
/* 1294 */
/* 1295 */         }
/* 1296 */         boolean agg_isNull13 = agg_isNull14;
/* 1297 */         double agg_value17 = agg_value18;
/* 1298 */         if (agg_isNull13) {
/* 1299 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 1300 */           double agg_value23 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 1301 */           if (!agg_isNull19) {
/* 1302 */             agg_isNull13 = false;
/* 1303 */             agg_value17 = agg_value23;
/* 1304 */           }
/* 1305 */         }
/* 1306 */         boolean agg_isNull21 = true;
/* 1307 */         double agg_value25 = -1.0;
/* 1308 */
/* 1309 */         boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1310 */         double agg_value27 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 1311 */         boolean agg_isNull22 = agg_isNull23;
/* 1312 */         double agg_value26 = agg_value27;
/* 1313 */         if (agg_isNull22) {
/* 1314 */           if (!agg_isNull11) {
/* 1315 */             agg_isNull22 = false;
/* 1316 */             agg_value26 = agg_value15;
/* 1317 */           }
/* 1318 */         }
/* 1319 */
/* 1320 */         boolean agg_isNull24 = inputadapter_isNull32;
/* 1321 */         double agg_value28 = -1.0;
/* 1322 */         if (!inputadapter_isNull32) {
/* 1323 */           agg_value28 = inputadapter_value32;
/* 1324 */         }
/* 1325 */         if (!agg_isNull24) {
/* 1326 */           agg_isNull21 = false; // resultCode could change nullability.
/* 1327 */           agg_value25 = agg_value26 + agg_value28;
/* 1328 */
/* 1329 */         }
/* 1330 */         boolean agg_isNull20 = agg_isNull21;
/* 1331 */         double agg_value24 = agg_value25;
/* 1332 */         if (agg_isNull20) {
/* 1333 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1334 */           double agg_value30 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 1335 */           if (!agg_isNull26) {
/* 1336 */             agg_isNull20 = false;
/* 1337 */             agg_value24 = agg_value30;
/* 1338 */           }
/* 1339 */         }
/* 1340 */         // update unsafe row buffer
/* 1341 */         if (!agg_isNull13) {
/* 1342 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value17);
/* 1343 */         } else {
/* 1344 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 1345 */         }
/* 1346 */
/* 1347 */         if (!agg_isNull20) {
/* 1348 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value24);
/* 1349 */         } else {
/* 1350 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1351 */         }
/* 1352 */
/* 1353 */       }
/* 1354 */       if (shouldStop()) return;
/* 1355 */     }
/* 1356 */
/* 1357 */     agg_fastHashMapIter1 = agg_fastHashMap1.rowIterator();
/* 1358 */
/* 1359 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 1360 */   }
/* 1361 */
/* 1362 */   private void wholestagecodegen_init_2() {
/* 1363 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 1364 */     bhj_result1 = new UnsafeRow(6);
/* 1365 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 1366 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 1367 */     project_result2 = new UnsafeRow(4);
/* 1368 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 1369 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 1370 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 1371 */
/* 1372 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 1373 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 1374 */
/* 1375 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 1376 */     bhj_result2 = new UnsafeRow(5);
/* 1377 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 1378 */
/* 1379 */   }
/* 1380 */
/* 1381 */   private void wholestagecodegen_init_1() {
/* 1382 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 1383 */
/* 1384 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1385 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1386 */
/* 1387 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 1388 */     bhj_result = new UnsafeRow(7);
/* 1389 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1390 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 1391 */     project_result1 = new UnsafeRow(5);
/* 1392 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 1393 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 1394 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 1395 */
/* 1396 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1397 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1398 */
/* 1399 */   }
/* 1400 */
/* 1401 */   private void wholestagecodegen_init_4() {
/* 1402 */     agg_unsafeRowJoiner1 = agg_plan.createUnsafeJoiner();
/* 1403 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 1404 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 1405 */     this.agg_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 1406 */     this.agg_aggTime2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 1407 */     agg_result4 = new UnsafeRow(3);
/* 1408 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 0);
/* 1409 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 3);
/* 1410 */
/* 1411 */   }
/* 1412 */
/* 1413 */   protected void processNext() throws java.io.IOException {
/* 1414 */     while (!agg_initAgg) {
/* 1415 */       agg_initAgg = true;
/* 1416 */       long agg_beforeAgg2 = System.nanoTime();
/* 1417 */       agg_doAggregateWithoutKey();
/* 1418 */       agg_aggTime2.add((System.nanoTime() - agg_beforeAgg2) / 1000000);
/* 1419 */
/* 1420 */       // output the result
/* 1421 */
/* 1422 */       agg_numOutputRows2.add(1);
/* 1423 */       agg_rowWriter2.zeroOutNullBytes();
/* 1424 */
/* 1425 */       if (agg_bufIsNull) {
/* 1426 */         agg_rowWriter2.setNullAt(0);
/* 1427 */       } else {
/* 1428 */         agg_rowWriter2.write(0, agg_bufValue);
/* 1429 */       }
/* 1430 */
/* 1431 */       if (agg_bufIsNull1) {
/* 1432 */         agg_rowWriter2.setNullAt(1);
/* 1433 */       } else {
/* 1434 */         agg_rowWriter2.write(1, agg_bufValue1);
/* 1435 */       }
/* 1436 */
/* 1437 */       if (agg_bufIsNull2) {
/* 1438 */         agg_rowWriter2.setNullAt(2);
/* 1439 */       } else {
/* 1440 */         agg_rowWriter2.write(2, agg_bufValue2);
/* 1441 */       }
/* 1442 */       append(agg_result4);
/* 1443 */     }
/* 1444 */   }
/* 1445 */ }
