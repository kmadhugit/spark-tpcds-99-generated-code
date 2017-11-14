/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private int smj_value2;
/* 013 */   private java.util.ArrayList smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private int smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 020 */   private UnsafeRow smj_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 027 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 029 */   private UnsafeRow bhj_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 032 */   private UnsafeRow project_result1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 035 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 036 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 038 */   private UnsafeRow bhj_result1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 041 */   private UnsafeRow project_result2;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 044 */
/* 045 */   public GeneratedIterator(Object[] references) {
/* 046 */     this.references = references;
/* 047 */   }
/* 048 */
/* 049 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 050 */     partitionIndex = index;
/* 051 */     this.inputs = inputs;
/* 052 */     wholestagecodegen_init_0();
/* 053 */     wholestagecodegen_init_1();
/* 054 */     wholestagecodegen_init_2();
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void wholestagecodegen_init_0() {
/* 059 */     smj_leftInput = inputs[0];
/* 060 */     smj_rightInput = inputs[1];
/* 061 */
/* 062 */     smj_rightRow = null;
/* 063 */
/* 064 */     smj_matches = new java.util.ArrayList();
/* 065 */
/* 066 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 067 */     smj_result = new UnsafeRow(4);
/* 068 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 069 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 4);
/* 070 */     project_result = new UnsafeRow(3);
/* 071 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 072 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 073 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 074 */
/* 075 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 076 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 077 */
/* 078 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   private boolean findNextInnerJoinRows(
/* 083 */     scala.collection.Iterator leftIter,
/* 084 */     scala.collection.Iterator rightIter) {
/* 085 */     smj_leftRow = null;
/* 086 */     int comp = 0;
/* 087 */     while (smj_leftRow == null) {
/* 088 */       if (!leftIter.hasNext()) return false;
/* 089 */       smj_leftRow = (InternalRow) leftIter.next();
/* 090 */
/* 091 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 092 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 093 */       if (smj_isNull) {
/* 094 */         smj_leftRow = null;
/* 095 */         continue;
/* 096 */       }
/* 097 */       if (!smj_matches.isEmpty()) {
/* 098 */         comp = 0;
/* 099 */         if (comp == 0) {
/* 100 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 101 */         }
/* 102 */
/* 103 */         if (comp == 0) {
/* 104 */           return true;
/* 105 */         }
/* 106 */         smj_matches.clear();
/* 107 */       }
/* 108 */
/* 109 */       do {
/* 110 */         if (smj_rightRow == null) {
/* 111 */           if (!rightIter.hasNext()) {
/* 112 */             smj_value3 = smj_value;
/* 113 */             return !smj_matches.isEmpty();
/* 114 */           }
/* 115 */           smj_rightRow = (InternalRow) rightIter.next();
/* 116 */
/* 117 */           boolean smj_isNull1 = smj_rightRow.isNullAt(1);
/* 118 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(1));
/* 119 */           if (smj_isNull1) {
/* 120 */             smj_rightRow = null;
/* 121 */             continue;
/* 122 */           }
/* 123 */           smj_value2 = smj_value1;
/* 124 */         }
/* 125 */
/* 126 */         comp = 0;
/* 127 */         if (comp == 0) {
/* 128 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 129 */         }
/* 130 */
/* 131 */         if (comp > 0) {
/* 132 */           smj_rightRow = null;
/* 133 */         } else if (comp < 0) {
/* 134 */           if (!smj_matches.isEmpty()) {
/* 135 */             smj_value3 = smj_value;
/* 136 */             return true;
/* 137 */           }
/* 138 */           smj_leftRow = null;
/* 139 */         } else {
/* 140 */           smj_matches.add(smj_rightRow.copy());
/* 141 */           smj_rightRow = null;;
/* 142 */         }
/* 143 */       } while (smj_leftRow != null);
/* 144 */     }
/* 145 */     return false; // unreachable
/* 146 */   }
/* 147 */
/* 148 */   private void wholestagecodegen_init_2() {
/* 149 */     project_result2 = new UnsafeRow(3);
/* 150 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 151 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 152 */
/* 153 */   }
/* 154 */
/* 155 */   private void wholestagecodegen_init_1() {
/* 156 */     bhj_result = new UnsafeRow(5);
/* 157 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 158 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 159 */     project_result1 = new UnsafeRow(3);
/* 160 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 161 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 162 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 163 */
/* 164 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 165 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 166 */
/* 167 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 168 */     bhj_result1 = new UnsafeRow(5);
/* 169 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 170 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 171 */
/* 172 */   }
/* 173 */
/* 174 */   protected void processNext() throws java.io.IOException {
/* 175 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 176 */       int smj_size = smj_matches.size();
/* 177 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 178 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 179 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 180 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 181 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 182 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 183 */
/* 184 */         smj_numOutputRows.add(1);
/* 185 */
/* 186 */         // generate join key for stream side
/* 187 */
/* 188 */         boolean bhj_isNull = smj_isNull2;
/* 189 */         long bhj_value = -1L;
/* 190 */         if (!smj_isNull2) {
/* 191 */           bhj_value = (long) smj_value4;
/* 192 */         }
/* 193 */         // find matches from HashedRelation
/* 194 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 195 */         if (bhj_matched == null) continue;
/* 196 */
/* 197 */         bhj_numOutputRows.add(1);
/* 198 */
/* 199 */         boolean smj_isNull4 = smj_rightRow1.isNullAt(0);
/* 200 */         int smj_value6 = smj_isNull4 ? -1 : (smj_rightRow1.getInt(0));
/* 201 */
/* 202 */         // generate join key for stream side
/* 203 */
/* 204 */         boolean bhj_isNull9 = smj_isNull4;
/* 205 */         long bhj_value9 = -1L;
/* 206 */         if (!smj_isNull4) {
/* 207 */           bhj_value9 = (long) smj_value6;
/* 208 */         }
/* 209 */         // find matches from HashedRelation
/* 210 */         UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 211 */         if (bhj_matched1 == null) continue;
/* 212 */
/* 213 */         bhj_numOutputRows1.add(1);
/* 214 */
/* 215 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 216 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 217 */         boolean bhj_isNull12 = bhj_matched1.isNullAt(1);
/* 218 */         UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(1));
/* 219 */         project_holder2.reset();
/* 220 */
/* 221 */         project_rowWriter2.zeroOutNullBytes();
/* 222 */
/* 223 */         if (smj_isNull3) {
/* 224 */           project_rowWriter2.setNullAt(0);
/* 225 */         } else {
/* 226 */           project_rowWriter2.write(0, smj_value5);
/* 227 */         }
/* 228 */
/* 229 */         if (bhj_isNull3) {
/* 230 */           project_rowWriter2.setNullAt(1);
/* 231 */         } else {
/* 232 */           project_rowWriter2.write(1, bhj_value3);
/* 233 */         }
/* 234 */
/* 235 */         if (bhj_isNull12) {
/* 236 */           project_rowWriter2.setNullAt(2);
/* 237 */         } else {
/* 238 */           project_rowWriter2.write(2, bhj_value12);
/* 239 */         }
/* 240 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 241 */         append(project_result2.copy());
/* 242 */
/* 243 */       }
/* 244 */       if (shouldStop()) return;
/* 245 */     }
/* 246 */   }
/* 247 */ }
