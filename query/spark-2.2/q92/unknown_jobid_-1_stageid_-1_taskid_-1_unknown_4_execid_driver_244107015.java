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
/* 011 */   private scala.collection.Iterator smj_leftInput;
/* 012 */   private scala.collection.Iterator smj_rightInput;
/* 013 */   private InternalRow smj_leftRow;
/* 014 */   private InternalRow smj_rightRow;
/* 015 */   private int smj_value2;
/* 016 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 017 */   private int smj_value3;
/* 018 */   private double smj_value4;
/* 019 */   private boolean smj_isNull2;
/* 020 */   private int smj_value5;
/* 021 */   private boolean smj_isNull3;
/* 022 */   private int smj_value6;
/* 023 */   private boolean smj_isNull4;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 025 */   private UnsafeRow smj_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 028 */   private UnsafeRow project_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 031 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 032 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 034 */   private UnsafeRow bhj_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 037 */   private UnsafeRow project_result1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 042 */   private UnsafeRow agg_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 045 */
/* 046 */   public GeneratedIterator(Object[] references) {
/* 047 */     this.references = references;
/* 048 */   }
/* 049 */
/* 050 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 051 */     partitionIndex = index;
/* 052 */     this.inputs = inputs;
/* 053 */     wholestagecodegen_init_0();
/* 054 */     wholestagecodegen_init_1();
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void wholestagecodegen_init_0() {
/* 059 */     agg_initAgg = false;
/* 060 */
/* 061 */     smj_leftInput = inputs[0];
/* 062 */     smj_rightInput = inputs[1];
/* 063 */
/* 064 */     smj_rightRow = null;
/* 065 */
/* 066 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 067 */
/* 068 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 069 */     smj_result = new UnsafeRow(5);
/* 070 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 071 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 072 */     project_result = new UnsafeRow(2);
/* 073 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 074 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 075 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 076 */
/* 077 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 078 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 083 */     // initialize aggregation buffer
/* 084 */     final double agg_value = -1.0;
/* 085 */     agg_bufIsNull = true;
/* 086 */     agg_bufValue = agg_value;
/* 087 */
/* 088 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 089 */       boolean smj_loaded = false;
/* 090 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 091 */       smj_value4 = smj_isNull2 ? -1.0 : (smj_leftRow.getDouble(0));
/* 092 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 093 */       while (smj_iterator.hasNext()) {
/* 094 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 095 */         double smj_value7 = smj_rightRow1.getDouble(0);
/* 096 */
/* 097 */         boolean smj_isNull7 = true;
/* 098 */         boolean smj_value9 = false;
/* 099 */
/* 100 */         if (!smj_isNull2) {
/* 101 */           smj_isNull7 = false; // resultCode could change nullability.
/* 102 */           smj_value9 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value4, smj_value7) > 0;
/* 103 */
/* 104 */         }
/* 105 */         if (smj_isNull7 || !smj_value9) continue;
/* 106 */         if (!smj_loaded) {
/* 107 */           smj_loaded = true;
/* 108 */           smj_isNull3 = smj_leftRow.isNullAt(1);
/* 109 */           smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 110 */           smj_isNull4 = smj_leftRow.isNullAt(2);
/* 111 */           smj_value6 = smj_isNull4 ? -1 : (smj_leftRow.getInt(2));
/* 112 */         }
/* 113 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(1);
/* 114 */         int smj_value8 = smj_isNull6 ? -1 : (smj_rightRow1.getInt(1));
/* 115 */         smj_numOutputRows.add(1);
/* 116 */
/* 117 */         // generate join key for stream side
/* 118 */
/* 119 */         boolean bhj_isNull = smj_isNull3;
/* 120 */         long bhj_value = -1L;
/* 121 */         if (!smj_isNull3) {
/* 122 */           bhj_value = (long) smj_value5;
/* 123 */         }
/* 124 */         // find matches from HashedRelation
/* 125 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 126 */         if (bhj_matched == null) continue;
/* 127 */
/* 128 */         bhj_numOutputRows.add(1);
/* 129 */
/* 130 */         // do aggregate
/* 131 */         // common sub-expressions
/* 132 */
/* 133 */         // evaluate aggregate function
/* 134 */         boolean agg_isNull2 = true;
/* 135 */         double agg_value2 = -1.0;
/* 136 */
/* 137 */         boolean agg_isNull3 = agg_bufIsNull;
/* 138 */         double agg_value3 = agg_bufValue;
/* 139 */         if (agg_isNull3) {
/* 140 */           boolean agg_isNull5 = false;
/* 141 */           double agg_value5 = -1.0;
/* 142 */           if (!false) {
/* 143 */             agg_value5 = (double) 0;
/* 144 */           }
/* 145 */           if (!agg_isNull5) {
/* 146 */             agg_isNull3 = false;
/* 147 */             agg_value3 = agg_value5;
/* 148 */           }
/* 149 */         }
/* 150 */
/* 151 */         if (!smj_isNull2) {
/* 152 */           agg_isNull2 = false; // resultCode could change nullability.
/* 153 */           agg_value2 = agg_value3 + smj_value4;
/* 154 */
/* 155 */         }
/* 156 */         boolean agg_isNull1 = agg_isNull2;
/* 157 */         double agg_value1 = agg_value2;
/* 158 */         if (agg_isNull1) {
/* 159 */           if (!agg_bufIsNull) {
/* 160 */             agg_isNull1 = false;
/* 161 */             agg_value1 = agg_bufValue;
/* 162 */           }
/* 163 */         }
/* 164 */         // update aggregation buffer
/* 165 */         agg_bufIsNull = agg_isNull1;
/* 166 */         agg_bufValue = agg_value1;
/* 167 */
/* 168 */       }
/* 169 */       if (shouldStop()) return;
/* 170 */     }
/* 171 */
/* 172 */   }
/* 173 */
/* 174 */   private boolean findNextInnerJoinRows(
/* 175 */     scala.collection.Iterator leftIter,
/* 176 */     scala.collection.Iterator rightIter) {
/* 177 */     smj_leftRow = null;
/* 178 */     int comp = 0;
/* 179 */     while (smj_leftRow == null) {
/* 180 */       if (!leftIter.hasNext()) return false;
/* 181 */       smj_leftRow = (InternalRow) leftIter.next();
/* 182 */
/* 183 */       boolean smj_isNull = smj_leftRow.isNullAt(2);
/* 184 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(2));
/* 185 */       if (smj_isNull) {
/* 186 */         smj_leftRow = null;
/* 187 */         continue;
/* 188 */       }
/* 189 */       if (!smj_matches.isEmpty()) {
/* 190 */         comp = 0;
/* 191 */         if (comp == 0) {
/* 192 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 193 */         }
/* 194 */
/* 195 */         if (comp == 0) {
/* 196 */           return true;
/* 197 */         }
/* 198 */         smj_matches.clear();
/* 199 */       }
/* 200 */
/* 201 */       do {
/* 202 */         if (smj_rightRow == null) {
/* 203 */           if (!rightIter.hasNext()) {
/* 204 */             smj_value3 = smj_value;
/* 205 */             return !smj_matches.isEmpty();
/* 206 */           }
/* 207 */           smj_rightRow = (InternalRow) rightIter.next();
/* 208 */
/* 209 */           boolean smj_isNull1 = smj_rightRow.isNullAt(1);
/* 210 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(1));
/* 211 */           if (smj_isNull1) {
/* 212 */             smj_rightRow = null;
/* 213 */             continue;
/* 214 */           }
/* 215 */           smj_value2 = smj_value1;
/* 216 */         }
/* 217 */
/* 218 */         comp = 0;
/* 219 */         if (comp == 0) {
/* 220 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 221 */         }
/* 222 */
/* 223 */         if (comp > 0) {
/* 224 */           smj_rightRow = null;
/* 225 */         } else if (comp < 0) {
/* 226 */           if (!smj_matches.isEmpty()) {
/* 227 */             smj_value3 = smj_value;
/* 228 */             return true;
/* 229 */           }
/* 230 */           smj_leftRow = null;
/* 231 */         } else {
/* 232 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 233 */           smj_rightRow = null;;
/* 234 */         }
/* 235 */       } while (smj_leftRow != null);
/* 236 */     }
/* 237 */     return false; // unreachable
/* 238 */   }
/* 239 */
/* 240 */   private void wholestagecodegen_init_1() {
/* 241 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 242 */     bhj_result = new UnsafeRow(3);
/* 243 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 244 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 3);
/* 245 */     project_result1 = new UnsafeRow(1);
/* 246 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 247 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 248 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 249 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 250 */     agg_result = new UnsafeRow(1);
/* 251 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 252 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 253 */
/* 254 */   }
/* 255 */
/* 256 */   protected void processNext() throws java.io.IOException {
/* 257 */     while (!agg_initAgg) {
/* 258 */       agg_initAgg = true;
/* 259 */       long agg_beforeAgg = System.nanoTime();
/* 260 */       agg_doAggregateWithoutKey();
/* 261 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 262 */
/* 263 */       // output the result
/* 264 */
/* 265 */       agg_numOutputRows.add(1);
/* 266 */       agg_rowWriter.zeroOutNullBytes();
/* 267 */
/* 268 */       if (agg_bufIsNull) {
/* 269 */         agg_rowWriter.setNullAt(0);
/* 270 */       } else {
/* 271 */         agg_rowWriter.write(0, agg_bufValue);
/* 272 */       }
/* 273 */       append(agg_result.copy());
/* 274 */     }
/* 275 */   }
/* 276 */ }
