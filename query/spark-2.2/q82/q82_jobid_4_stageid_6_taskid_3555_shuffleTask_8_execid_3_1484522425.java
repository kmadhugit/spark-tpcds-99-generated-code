/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator smj_leftInput;
/* 016 */   private scala.collection.Iterator smj_rightInput;
/* 017 */   private InternalRow smj_leftRow;
/* 018 */   private InternalRow smj_rightRow;
/* 019 */   private int smj_value2;
/* 020 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 021 */   private int smj_value3;
/* 022 */   private int smj_value4;
/* 023 */   private boolean smj_isNull2;
/* 024 */   private UTF8String smj_value5;
/* 025 */   private boolean smj_isNull3;
/* 026 */   private UTF8String smj_value6;
/* 027 */   private boolean smj_isNull4;
/* 028 */   private double smj_value7;
/* 029 */   private boolean smj_isNull5;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 031 */   private UnsafeRow smj_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 034 */   private UnsafeRow project_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 037 */   private UnsafeRow agg_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 040 */   private int agg_value6;
/* 041 */   private UnsafeRow agg_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 046 */
/* 047 */   public GeneratedIterator(Object[] references) {
/* 048 */     this.references = references;
/* 049 */   }
/* 050 */
/* 051 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 052 */     partitionIndex = index;
/* 053 */     this.inputs = inputs;
/* 054 */     wholestagecodegen_init_0();
/* 055 */     wholestagecodegen_init_1();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     agg_initAgg = false;
/* 061 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 062 */
/* 063 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 064 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 065 */     smj_leftInput = inputs[0];
/* 066 */     smj_rightInput = inputs[1];
/* 067 */
/* 068 */     smj_rightRow = null;
/* 069 */
/* 070 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 071 */
/* 072 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 073 */     smj_result = new UnsafeRow(5);
/* 074 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 075 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 076 */     project_result = new UnsafeRow(3);
/* 077 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 078 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 083 */     agg_hashMap = agg_plan.createHashMap();
/* 084 */
/* 085 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 086 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 087 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 088 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 089 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 090 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 091 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 092 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 093 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 094 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 095 */       while (smj_iterator.hasNext()) {
/* 096 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 097 */
/* 098 */         smj_numOutputRows.add(1);
/* 099 */
/* 100 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 101 */
/* 102 */         UnsafeRow agg_fastAggBuffer = null;
/* 103 */
/* 104 */         if (agg_fastAggBuffer == null) {
/* 105 */           // generate grouping key
/* 106 */           agg_holder.reset();
/* 107 */
/* 108 */           agg_rowWriter.zeroOutNullBytes();
/* 109 */
/* 110 */           if (smj_isNull3) {
/* 111 */             agg_rowWriter.setNullAt(0);
/* 112 */           } else {
/* 113 */             agg_rowWriter.write(0, smj_value5);
/* 114 */           }
/* 115 */
/* 116 */           if (smj_isNull4) {
/* 117 */             agg_rowWriter.setNullAt(1);
/* 118 */           } else {
/* 119 */             agg_rowWriter.write(1, smj_value6);
/* 120 */           }
/* 121 */
/* 122 */           if (smj_isNull5) {
/* 123 */             agg_rowWriter.setNullAt(2);
/* 124 */           } else {
/* 125 */             agg_rowWriter.write(2, smj_value7);
/* 126 */           }
/* 127 */           agg_result.setTotalSize(agg_holder.totalSize());
/* 128 */           agg_value6 = 42;
/* 129 */
/* 130 */           if (!smj_isNull3) {
/* 131 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value5.getBaseObject(), smj_value5.getBaseOffset(), smj_value5.numBytes(), agg_value6);
/* 132 */           }
/* 133 */
/* 134 */           if (!smj_isNull4) {
/* 135 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value6.getBaseObject(), smj_value6.getBaseOffset(), smj_value6.numBytes(), agg_value6);
/* 136 */           }
/* 137 */
/* 138 */           if (!smj_isNull5) {
/* 139 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(smj_value7), agg_value6);
/* 140 */           }
/* 141 */           if (true) {
/* 142 */             // try to get the buffer from hash map
/* 143 */             agg_unsafeRowAggBuffer =
/* 144 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 145 */           }
/* 146 */           if (agg_unsafeRowAggBuffer == null) {
/* 147 */             if (agg_sorter == null) {
/* 148 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 149 */             } else {
/* 150 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 151 */             }
/* 152 */
/* 153 */             // the hash map had be spilled, it should have enough memory now,
/* 154 */             // try  to allocate buffer again.
/* 155 */             agg_unsafeRowAggBuffer =
/* 156 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 157 */             if (agg_unsafeRowAggBuffer == null) {
/* 158 */               // failed to allocate the first page
/* 159 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 160 */             }
/* 161 */           }
/* 162 */         }
/* 163 */
/* 164 */         if (agg_fastAggBuffer != null) {
/* 165 */           // update fast row
/* 166 */
/* 167 */         } else {
/* 168 */           // update unsafe row
/* 169 */
/* 170 */           // common sub-expressions
/* 171 */
/* 172 */           // evaluate aggregate function
/* 173 */
/* 174 */           // update unsafe row buffer
/* 175 */
/* 176 */         }
/* 177 */
/* 178 */       }
/* 179 */       if (shouldStop()) return;
/* 180 */     }
/* 181 */
/* 182 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 183 */   }
/* 184 */
/* 185 */   private boolean findNextInnerJoinRows(
/* 186 */     scala.collection.Iterator leftIter,
/* 187 */     scala.collection.Iterator rightIter) {
/* 188 */     smj_leftRow = null;
/* 189 */     int comp = 0;
/* 190 */     while (smj_leftRow == null) {
/* 191 */       if (!leftIter.hasNext()) return false;
/* 192 */       smj_leftRow = (InternalRow) leftIter.next();
/* 193 */
/* 194 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 195 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 196 */       if (smj_isNull) {
/* 197 */         smj_leftRow = null;
/* 198 */         continue;
/* 199 */       }
/* 200 */       if (!smj_matches.isEmpty()) {
/* 201 */         comp = 0;
/* 202 */         if (comp == 0) {
/* 203 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 204 */         }
/* 205 */
/* 206 */         if (comp == 0) {
/* 207 */           return true;
/* 208 */         }
/* 209 */         smj_matches.clear();
/* 210 */       }
/* 211 */
/* 212 */       do {
/* 213 */         if (smj_rightRow == null) {
/* 214 */           if (!rightIter.hasNext()) {
/* 215 */             smj_value3 = smj_value;
/* 216 */             return !smj_matches.isEmpty();
/* 217 */           }
/* 218 */           smj_rightRow = (InternalRow) rightIter.next();
/* 219 */
/* 220 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 221 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 222 */           if (smj_isNull1) {
/* 223 */             smj_rightRow = null;
/* 224 */             continue;
/* 225 */           }
/* 226 */           smj_value2 = smj_value1;
/* 227 */         }
/* 228 */
/* 229 */         comp = 0;
/* 230 */         if (comp == 0) {
/* 231 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 232 */         }
/* 233 */
/* 234 */         if (comp > 0) {
/* 235 */           smj_rightRow = null;
/* 236 */         } else if (comp < 0) {
/* 237 */           if (!smj_matches.isEmpty()) {
/* 238 */             smj_value3 = smj_value;
/* 239 */             return true;
/* 240 */           }
/* 241 */           smj_leftRow = null;
/* 242 */         } else {
/* 243 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 244 */           smj_rightRow = null;;
/* 245 */         }
/* 246 */       } while (smj_leftRow != null);
/* 247 */     }
/* 248 */     return false; // unreachable
/* 249 */   }
/* 250 */
/* 251 */   private void wholestagecodegen_init_1() {
/* 252 */     agg_result = new UnsafeRow(3);
/* 253 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 254 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 255 */
/* 256 */     agg_result1 = new UnsafeRow(3);
/* 257 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 258 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 259 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 260 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 261 */
/* 262 */   }
/* 263 */
/* 264 */   protected void processNext() throws java.io.IOException {
/* 265 */     if (!agg_initAgg) {
/* 266 */       agg_initAgg = true;
/* 267 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 268 */       agg_doAggregateWithKeys();
/* 269 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 270 */     }
/* 271 */
/* 272 */     // output the result
/* 273 */
/* 274 */     while (agg_mapIter.next()) {
/* 275 */       wholestagecodegen_numOutputRows.add(1);
/* 276 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 277 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 278 */
/* 279 */       boolean agg_isNull10 = agg_aggKey.isNullAt(0);
/* 280 */       UTF8String agg_value10 = agg_isNull10 ? null : (agg_aggKey.getUTF8String(0));
/* 281 */       boolean agg_isNull11 = agg_aggKey.isNullAt(1);
/* 282 */       UTF8String agg_value11 = agg_isNull11 ? null : (agg_aggKey.getUTF8String(1));
/* 283 */       boolean agg_isNull12 = agg_aggKey.isNullAt(2);
/* 284 */       double agg_value12 = agg_isNull12 ? -1.0 : (agg_aggKey.getDouble(2));
/* 285 */       agg_holder1.reset();
/* 286 */
/* 287 */       agg_rowWriter1.zeroOutNullBytes();
/* 288 */
/* 289 */       if (agg_isNull10) {
/* 290 */         agg_rowWriter1.setNullAt(0);
/* 291 */       } else {
/* 292 */         agg_rowWriter1.write(0, agg_value10);
/* 293 */       }
/* 294 */
/* 295 */       if (agg_isNull11) {
/* 296 */         agg_rowWriter1.setNullAt(1);
/* 297 */       } else {
/* 298 */         agg_rowWriter1.write(1, agg_value11);
/* 299 */       }
/* 300 */
/* 301 */       if (agg_isNull12) {
/* 302 */         agg_rowWriter1.setNullAt(2);
/* 303 */       } else {
/* 304 */         agg_rowWriter1.write(2, agg_value12);
/* 305 */       }
/* 306 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 307 */       append(agg_result1.copy());
/* 308 */
/* 309 */       if (shouldStop()) return;
/* 310 */     }
/* 311 */
/* 312 */     agg_mapIter.close();
/* 313 */     if (agg_sorter == null) {
/* 314 */       agg_hashMap.free();
/* 315 */     }
/* 316 */   }
/* 317 */ }
