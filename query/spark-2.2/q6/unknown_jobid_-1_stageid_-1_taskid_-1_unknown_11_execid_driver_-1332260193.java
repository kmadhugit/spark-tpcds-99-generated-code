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
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private UTF8String smj_value4;
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
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     wholestagecodegen_init_0();
/* 044 */     wholestagecodegen_init_1();
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void wholestagecodegen_init_0() {
/* 049 */     smj_leftInput = inputs[0];
/* 050 */     smj_rightInput = inputs[1];
/* 051 */
/* 052 */     smj_rightRow = null;
/* 053 */
/* 054 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 055 */
/* 056 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 057 */     smj_result = new UnsafeRow(5);
/* 058 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 32);
/* 059 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 060 */     project_result = new UnsafeRow(3);
/* 061 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 062 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 063 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 064 */
/* 065 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 066 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 067 */
/* 068 */   }
/* 069 */
/* 070 */   private boolean findNextInnerJoinRows(
/* 071 */     scala.collection.Iterator leftIter,
/* 072 */     scala.collection.Iterator rightIter) {
/* 073 */     smj_leftRow = null;
/* 074 */     int comp = 0;
/* 075 */     while (smj_leftRow == null) {
/* 076 */       if (!leftIter.hasNext()) return false;
/* 077 */       smj_leftRow = (InternalRow) leftIter.next();
/* 078 */
/* 079 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 080 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 081 */       if (smj_isNull) {
/* 082 */         smj_leftRow = null;
/* 083 */         continue;
/* 084 */       }
/* 085 */       if (!smj_matches.isEmpty()) {
/* 086 */         comp = 0;
/* 087 */         if (comp == 0) {
/* 088 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 089 */         }
/* 090 */
/* 091 */         if (comp == 0) {
/* 092 */           return true;
/* 093 */         }
/* 094 */         smj_matches.clear();
/* 095 */       }
/* 096 */
/* 097 */       do {
/* 098 */         if (smj_rightRow == null) {
/* 099 */           if (!rightIter.hasNext()) {
/* 100 */             smj_value3 = smj_value;
/* 101 */             return !smj_matches.isEmpty();
/* 102 */           }
/* 103 */           smj_rightRow = (InternalRow) rightIter.next();
/* 104 */
/* 105 */           boolean smj_isNull1 = smj_rightRow.isNullAt(1);
/* 106 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(1));
/* 107 */           if (smj_isNull1) {
/* 108 */             smj_rightRow = null;
/* 109 */             continue;
/* 110 */           }
/* 111 */           smj_value2 = smj_value1;
/* 112 */         }
/* 113 */
/* 114 */         comp = 0;
/* 115 */         if (comp == 0) {
/* 116 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 117 */         }
/* 118 */
/* 119 */         if (comp > 0) {
/* 120 */           smj_rightRow = null;
/* 121 */         } else if (comp < 0) {
/* 122 */           if (!smj_matches.isEmpty()) {
/* 123 */             smj_value3 = smj_value;
/* 124 */             return true;
/* 125 */           }
/* 126 */           smj_leftRow = null;
/* 127 */         } else {
/* 128 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 129 */           smj_rightRow = null;;
/* 130 */         }
/* 131 */       } while (smj_leftRow != null);
/* 132 */     }
/* 133 */     return false; // unreachable
/* 134 */   }
/* 135 */
/* 136 */   private void wholestagecodegen_init_1() {
/* 137 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 138 */     bhj_result = new UnsafeRow(4);
/* 139 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 140 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 141 */     project_result1 = new UnsafeRow(2);
/* 142 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 143 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 144 */
/* 145 */   }
/* 146 */
/* 147 */   protected void processNext() throws java.io.IOException {
/* 148 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 149 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 150 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 151 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 152 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 153 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 154 */       while (smj_iterator.hasNext()) {
/* 155 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 156 */
/* 157 */         smj_numOutputRows.add(1);
/* 158 */
/* 159 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(2);
/* 160 */         int smj_value8 = smj_isNull6 ? -1 : (smj_rightRow1.getInt(2));
/* 161 */
/* 162 */         // generate join key for stream side
/* 163 */
/* 164 */         boolean bhj_isNull = smj_isNull6;
/* 165 */         long bhj_value = -1L;
/* 166 */         if (!smj_isNull6) {
/* 167 */           bhj_value = (long) smj_value8;
/* 168 */         }
/* 169 */         // find matches from HashedRelation
/* 170 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 171 */         if (bhj_matched == null) continue;
/* 172 */
/* 173 */         bhj_numOutputRows.add(1);
/* 174 */
/* 175 */         boolean smj_isNull4 = smj_rightRow1.isNullAt(0);
/* 176 */         int smj_value6 = smj_isNull4 ? -1 : (smj_rightRow1.getInt(0));
/* 177 */         project_holder1.reset();
/* 178 */
/* 179 */         project_rowWriter1.zeroOutNullBytes();
/* 180 */
/* 181 */         if (smj_isNull2) {
/* 182 */           project_rowWriter1.setNullAt(0);
/* 183 */         } else {
/* 184 */           project_rowWriter1.write(0, smj_value4);
/* 185 */         }
/* 186 */
/* 187 */         if (smj_isNull4) {
/* 188 */           project_rowWriter1.setNullAt(1);
/* 189 */         } else {
/* 190 */           project_rowWriter1.write(1, smj_value6);
/* 191 */         }
/* 192 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 193 */         append(project_result1.copy());
/* 194 */
/* 195 */       }
/* 196 */       if (shouldStop()) return;
/* 197 */     }
/* 198 */   }
/* 199 */ }
