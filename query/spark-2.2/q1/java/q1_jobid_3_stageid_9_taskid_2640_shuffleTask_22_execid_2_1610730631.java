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
/* 012 */   private long smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private long smj_value3;
/* 015 */   private long smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private long smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private double smj_value6;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 021 */   private UnsafeRow smj_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 030 */   private UnsafeRow bhj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 033 */   private UnsafeRow project_result1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 036 */
/* 037 */   public GeneratedIterator(Object[] references) {
/* 038 */     this.references = references;
/* 039 */   }
/* 040 */
/* 041 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 042 */     partitionIndex = index;
/* 043 */     this.inputs = inputs;
/* 044 */     wholestagecodegen_init_0();
/* 045 */     wholestagecodegen_init_1();
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private void wholestagecodegen_init_0() {
/* 050 */     smj_leftInput = inputs[0];
/* 051 */     smj_rightInput = inputs[1];
/* 052 */
/* 053 */     smj_rightRow = null;
/* 054 */
/* 055 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 056 */
/* 057 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 058 */     smj_result = new UnsafeRow(5);
/* 059 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 060 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 061 */     project_result = new UnsafeRow(2);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 063 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 064 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 065 */
/* 066 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 067 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */   private boolean findNextInnerJoinRows(
/* 072 */     scala.collection.Iterator leftIter,
/* 073 */     scala.collection.Iterator rightIter) {
/* 074 */     smj_leftRow = null;
/* 075 */     int comp = 0;
/* 076 */     while (smj_leftRow == null) {
/* 077 */       if (!leftIter.hasNext()) return false;
/* 078 */       smj_leftRow = (InternalRow) leftIter.next();
/* 079 */
/* 080 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 081 */       long smj_value = smj_isNull ? -1L : (smj_leftRow.getLong(1));
/* 082 */       if (smj_isNull) {
/* 083 */         smj_leftRow = null;
/* 084 */         continue;
/* 085 */       }
/* 086 */       if (!smj_matches.isEmpty()) {
/* 087 */         comp = 0;
/* 088 */         if (comp == 0) {
/* 089 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 090 */         }
/* 091 */
/* 092 */         if (comp == 0) {
/* 093 */           return true;
/* 094 */         }
/* 095 */         smj_matches.clear();
/* 096 */       }
/* 097 */
/* 098 */       do {
/* 099 */         if (smj_rightRow == null) {
/* 100 */           if (!rightIter.hasNext()) {
/* 101 */             smj_value3 = smj_value;
/* 102 */             return !smj_matches.isEmpty();
/* 103 */           }
/* 104 */           smj_rightRow = (InternalRow) rightIter.next();
/* 105 */
/* 106 */           boolean smj_isNull1 = smj_rightRow.isNullAt(1);
/* 107 */           long smj_value1 = smj_isNull1 ? -1L : (smj_rightRow.getLong(1));
/* 108 */           if (smj_isNull1) {
/* 109 */             smj_rightRow = null;
/* 110 */             continue;
/* 111 */           }
/* 112 */           smj_value2 = smj_value1;
/* 113 */         }
/* 114 */
/* 115 */         comp = 0;
/* 116 */         if (comp == 0) {
/* 117 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 118 */         }
/* 119 */
/* 120 */         if (comp > 0) {
/* 121 */           smj_rightRow = null;
/* 122 */         } else if (comp < 0) {
/* 123 */           if (!smj_matches.isEmpty()) {
/* 124 */             smj_value3 = smj_value;
/* 125 */             return true;
/* 126 */           }
/* 127 */           smj_leftRow = null;
/* 128 */         } else {
/* 129 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 130 */           smj_rightRow = null;;
/* 131 */         }
/* 132 */       } while (smj_leftRow != null);
/* 133 */     }
/* 134 */     return false; // unreachable
/* 135 */   }
/* 136 */
/* 137 */   private void wholestagecodegen_init_1() {
/* 138 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 139 */     bhj_result = new UnsafeRow(3);
/* 140 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 141 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 3);
/* 142 */     project_result1 = new UnsafeRow(1);
/* 143 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 144 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 145 */
/* 146 */   }
/* 147 */
/* 148 */   protected void processNext() throws java.io.IOException {
/* 149 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 150 */       boolean smj_loaded = false;
/* 151 */       smj_value6 = smj_leftRow.getDouble(2);
/* 152 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 153 */       while (smj_iterator.hasNext()) {
/* 154 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 155 */         double smj_value7 = smj_rightRow1.getDouble(0);
/* 156 */
/* 157 */         boolean smj_isNull6 = false;
/* 158 */
/* 159 */         boolean smj_value9 = false;
/* 160 */         smj_value9 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value6, smj_value7) > 0;
/* 161 */         if (false || !smj_value9) continue;
/* 162 */         if (!smj_loaded) {
/* 163 */           smj_loaded = true;
/* 164 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 165 */           smj_value4 = smj_isNull2 ? -1L : (smj_leftRow.getLong(0));
/* 166 */           smj_isNull3 = smj_leftRow.isNullAt(1);
/* 167 */           smj_value5 = smj_isNull3 ? -1L : (smj_leftRow.getLong(1));
/* 168 */         }
/* 169 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 170 */         long smj_value8 = smj_isNull5 ? -1L : (smj_rightRow1.getLong(1));
/* 171 */         smj_numOutputRows.add(1);
/* 172 */
/* 173 */         // generate join key for stream side
/* 174 */
/* 175 */         // find matches from HashedRelation
/* 176 */         UnsafeRow bhj_matched = smj_isNull3 ? null: (UnsafeRow)bhj_relation.getValue(smj_value5);
/* 177 */         if (bhj_matched == null) continue;
/* 178 */
/* 179 */         bhj_numOutputRows.add(1);
/* 180 */
/* 181 */         project_rowWriter1.zeroOutNullBytes();
/* 182 */
/* 183 */         if (smj_isNull2) {
/* 184 */           project_rowWriter1.setNullAt(0);
/* 185 */         } else {
/* 186 */           project_rowWriter1.write(0, smj_value4);
/* 187 */         }
/* 188 */         append(project_result1.copy());
/* 189 */
/* 190 */       }
/* 191 */       if (shouldStop()) return;
/* 192 */     }
/* 193 */   }
/* 194 */ }
