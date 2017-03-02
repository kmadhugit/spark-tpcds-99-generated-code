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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value6;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 030 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 032 */   private UnsafeRow bhj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 040 */
/* 041 */   public GeneratedIterator(Object[] references) {
/* 042 */     this.references = references;
/* 043 */   }
/* 044 */
/* 045 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 046 */     partitionIndex = index;
/* 047 */     this.inputs = inputs;
/* 048 */     wholestagecodegen_init_0();
/* 049 */     wholestagecodegen_init_1();
/* 050 */     wholestagecodegen_init_2();
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void wholestagecodegen_init_0() {
/* 055 */     agg_initAgg = false;
/* 056 */
/* 057 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 058 */
/* 059 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 060 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 061 */     inputadapter_input = inputs[0];
/* 062 */     agg_result = new UnsafeRow(2);
/* 063 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 064 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 065 */
/* 066 */     agg_result1 = new UnsafeRow(3);
/* 067 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 068 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 069 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 070 */     filter_result = new UnsafeRow(3);
/* 071 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 072 */
/* 073 */   }
/* 074 */
/* 075 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 076 */     agg_hashMap = agg_plan.createHashMap();
/* 077 */
/* 078 */     while (inputadapter_input.hasNext()) {
/* 079 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 080 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 081 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 082 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 083 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 084 */       long inputadapter_value2 = inputadapter_row.getLong(2);
/* 085 */
/* 086 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 087 */
/* 088 */       UnsafeRow agg_fastAggBuffer = null;
/* 089 */
/* 090 */       if (agg_fastAggBuffer == null) {
/* 091 */         // generate grouping key
/* 092 */         agg_rowWriter.zeroOutNullBytes();
/* 093 */
/* 094 */         if (inputadapter_isNull) {
/* 095 */           agg_rowWriter.setNullAt(0);
/* 096 */         } else {
/* 097 */           agg_rowWriter.write(0, inputadapter_value);
/* 098 */         }
/* 099 */
/* 100 */         if (inputadapter_isNull1) {
/* 101 */           agg_rowWriter.setNullAt(1);
/* 102 */         } else {
/* 103 */           agg_rowWriter.write(1, inputadapter_value1);
/* 104 */         }
/* 105 */         agg_value6 = 42;
/* 106 */
/* 107 */         if (!inputadapter_isNull) {
/* 108 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value6);
/* 109 */         }
/* 110 */
/* 111 */         if (!inputadapter_isNull1) {
/* 112 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value6);
/* 113 */         }
/* 114 */         if (true) {
/* 115 */           // try to get the buffer from hash map
/* 116 */           agg_unsafeRowAggBuffer =
/* 117 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 118 */         }
/* 119 */         if (agg_unsafeRowAggBuffer == null) {
/* 120 */           if (agg_sorter == null) {
/* 121 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 122 */           } else {
/* 123 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 124 */           }
/* 125 */
/* 126 */           // the hash map had be spilled, it should have enough memory now,
/* 127 */           // try  to allocate buffer again.
/* 128 */           agg_unsafeRowAggBuffer =
/* 129 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 130 */           if (agg_unsafeRowAggBuffer == null) {
/* 131 */             // failed to allocate the first page
/* 132 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 133 */           }
/* 134 */         }
/* 135 */       }
/* 136 */
/* 137 */       if (agg_fastAggBuffer != null) {
/* 138 */         // update fast row
/* 139 */
/* 140 */       } else {
/* 141 */         // update unsafe row
/* 142 */
/* 143 */         // common sub-expressions
/* 144 */
/* 145 */         // evaluate aggregate function
/* 146 */         boolean agg_isNull8 = false;
/* 147 */
/* 148 */         long agg_value10 = agg_unsafeRowAggBuffer.getLong(0);
/* 149 */
/* 150 */         long agg_value9 = -1L;
/* 151 */         agg_value9 = agg_value10 + inputadapter_value2;
/* 152 */         // update unsafe row buffer
/* 153 */         agg_unsafeRowAggBuffer.setLong(0, agg_value9);
/* 154 */
/* 155 */       }
/* 156 */       if (shouldStop()) return;
/* 157 */     }
/* 158 */
/* 159 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 160 */   }
/* 161 */
/* 162 */   private void wholestagecodegen_init_2() {
/* 163 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 164 */
/* 165 */   }
/* 166 */
/* 167 */   private void wholestagecodegen_init_1() {
/* 168 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 169 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[4];
/* 170 */
/* 171 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 172 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 173 */
/* 174 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 175 */     bhj_result = new UnsafeRow(8);
/* 176 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 128);
/* 177 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 178 */     project_result = new UnsafeRow(6);
/* 179 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 180 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 181 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 182 */
/* 183 */   }
/* 184 */
/* 185 */   protected void processNext() throws java.io.IOException {
/* 186 */     if (!agg_initAgg) {
/* 187 */       agg_initAgg = true;
/* 188 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 189 */       agg_doAggregateWithKeys();
/* 190 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 191 */     }
/* 192 */
/* 193 */     // output the result
/* 194 */
/* 195 */     while (agg_mapIter.next()) {
/* 196 */       wholestagecodegen_numOutputRows.add(1);
/* 197 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 198 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 199 */
/* 200 */       boolean agg_isNull11 = agg_aggKey.isNullAt(0);
/* 201 */       int agg_value12 = agg_isNull11 ? -1 : (agg_aggKey.getInt(0));
/* 202 */       boolean agg_isNull12 = agg_aggKey.isNullAt(1);
/* 203 */       int agg_value13 = agg_isNull12 ? -1 : (agg_aggKey.getInt(1));
/* 204 */       long agg_value14 = agg_aggBuffer.getLong(0);
/* 205 */
/* 206 */       boolean filter_isNull = false;
/* 207 */
/* 208 */       boolean filter_value = false;
/* 209 */       filter_value = agg_value14 >= 15L;
/* 210 */       if (!filter_value) continue;
/* 211 */       boolean filter_isNull3 = false;
/* 212 */
/* 213 */       boolean filter_value3 = false;
/* 214 */       filter_value3 = agg_value14 <= 20L;
/* 215 */       if (!filter_value3) continue;
/* 216 */
/* 217 */       filter_numOutputRows.add(1);
/* 218 */
/* 219 */       // generate join key for stream side
/* 220 */
/* 221 */       boolean bhj_isNull = agg_isNull12;
/* 222 */       long bhj_value = -1L;
/* 223 */       if (!agg_isNull12) {
/* 224 */         bhj_value = (long) agg_value13;
/* 225 */       }
/* 226 */       // find matches from HashedRelation
/* 227 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 228 */       if (bhj_matched == null) continue;
/* 229 */
/* 230 */       bhj_numOutputRows.add(1);
/* 231 */
/* 232 */       boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 233 */       UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 234 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 235 */       UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 236 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 237 */       UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 238 */       boolean bhj_isNull6 = bhj_matched.isNullAt(4);
/* 239 */       UTF8String bhj_value6 = bhj_isNull6 ? null : (bhj_matched.getUTF8String(4));
/* 240 */       project_holder.reset();
/* 241 */
/* 242 */       project_rowWriter.zeroOutNullBytes();
/* 243 */
/* 244 */       if (bhj_isNull5) {
/* 245 */         project_rowWriter.setNullAt(0);
/* 246 */       } else {
/* 247 */         project_rowWriter.write(0, bhj_value5);
/* 248 */       }
/* 249 */
/* 250 */       if (bhj_isNull4) {
/* 251 */         project_rowWriter.setNullAt(1);
/* 252 */       } else {
/* 253 */         project_rowWriter.write(1, bhj_value4);
/* 254 */       }
/* 255 */
/* 256 */       if (bhj_isNull3) {
/* 257 */         project_rowWriter.setNullAt(2);
/* 258 */       } else {
/* 259 */         project_rowWriter.write(2, bhj_value3);
/* 260 */       }
/* 261 */
/* 262 */       if (bhj_isNull6) {
/* 263 */         project_rowWriter.setNullAt(3);
/* 264 */       } else {
/* 265 */         project_rowWriter.write(3, bhj_value6);
/* 266 */       }
/* 267 */
/* 268 */       if (agg_isNull11) {
/* 269 */         project_rowWriter.setNullAt(4);
/* 270 */       } else {
/* 271 */         project_rowWriter.write(4, agg_value12);
/* 272 */       }
/* 273 */
/* 274 */       project_rowWriter.write(5, agg_value14);
/* 275 */       project_result.setTotalSize(project_holder.totalSize());
/* 276 */       append(project_result);
/* 277 */
/* 278 */       if (shouldStop()) return;
/* 279 */     }
/* 280 */
/* 281 */     agg_mapIter.close();
/* 282 */     if (agg_sorter == null) {
/* 283 */       agg_hashMap.free();
/* 284 */     }
/* 285 */   }
/* 286 */ }
